
# coding: utf-8

# In[1]:

'''
Preparation Script for batch insertion on instabase
Token removed for sake of safety
'''
import requests
import json
import time
import pandas as pd

table_api = 'https://www.instabase.com/api/v1/databases/'
root = 'ewu/w4111-public/databases'

## replace this with your token
token = None

def _link(path):
  s = 'https://www.instabase.com/' + path
  return s.replace(' ', '%20')

def _pretty_print(d):
  try:
    d = json.loads(d)
  except:
    pass
  return json.dumps(d, sort_keys=True, indent=4, separators=(',', ': '))


# In[2]:


def bulk_insert(df):
    headers = {'Authorization': 'Bearer {0}'.format(token)}
    data = dict(
        values=df.values.tolist()
    )
    #print data
    r = requests.post(
        table_api + root + '/w4111/iowa_sample', data=json.dumps(data), headers=headers)

    resp = json.loads(r.content)
    isOK = resp.get('status') == 'OK'
    time.sleep(1)
    print _pretty_print(resp)
    
    return isOK


# In[13]:

import subprocess

#fname = '/ewu/w4111-staff/fs/Instabase%20Drive/HW3/iowa.csv'
fname = './iowa_sample.csv'
table_name = 'iowa_sample' # name for the SQLite database table
chunksize = 10000 # number of lines to process at each iteration

# Get number of lines in the CSV file
#nlines = subprocess.check_output('wc -l %s' % fname, shell=True)
#nlines = int(nlines.split()[0]) 
nlines = 11023367

def insert_all(fname, nlines, chunksize):
    # scenario 1: second insertion will fail
    # solution 1: f to inner loop
    # scenario 2: 25% insertion failure rate, every 4th insertion
    print 'start'
    #for i in range(0, nlines, chunksize):
        # f have to be here
    f = fname
        #df = pd.read_csv(f, nrows=chunksize, delimiter=':', skiprows = i, error_bad_lines=False)
    df = pd.read_csv(f, error_bad_lines=False)

    ok = bulk_insert(df)
        #if not ok:
        #    print "Failed", i

        #print 'Done', i, ok
    return True


# In[14]:

insert_all(fname, nlines, chunksize)
# till 770000


# In[ ]:



