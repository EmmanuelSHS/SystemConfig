#!/usr/bin/env python
# coding=utf-8

# zipcodedatabase not useful
#from pyzipcode import ZipCodeDatabase
import pandas as pd
import urllib2
import requests
import json


'''
def zipToCoo(infile, outfile):
    zcdb = ZipCodeDatabase()
    zipdata = pd.read_csv(infile)
    zipdict = {}

    headers = ['month', 'lon', 'lat'] 
    contents = []
    
    for each in zipdata.iterrows():
        try:
            zipcode = each[1]['zip']
            
            coordinates = None
            if zipcode in zipdict:
                coordinates = zipdict[zipcode]
            else:
                try:
                    zipobj = zcdb[zipcode]
                except IndexError as ie:
                    print ie, each[1]['month'], each[1]['zip']
                    continue
                coordinates = (zipobj.longitude, zipobj.latitude)
                zipdict[zipcode] = coordinates
                
            try:
                contents.append([each[1]['month']] + list(coordinates))
            except KeyError as ke:
                print ke, each[1]['month'], each[1]['zip']
                continue

        # in case other not catched
        except Exception as e:
            print e, each[1]['month'], each[1]['zip']
            continue

    df = pd.DataFrame(contents, columns=headers)
    df.to_csv(outfile, index=False)
'''

def zipToCoo(infile, outcoofile, outjsonfile):
    url = 'https://api.zippopotam.us/BR/'
    zipdata = pd.read_csv(infile)
    coodict = {}
    jsondict = {}
    cooheaders = ['month', 'lat', 'lon'] 
    coocontents = []
    jsonres = []
    
    for each in zipdata.iterrows():
        coordinates = None
        jsonstring = None

        try:
            zipcode = each[1]['zip']
            if zipcode in coodict and zipcode in jsondict:
                jsonstring = jsondict[zipcode]
                coordinates = coodict[zipcode]
            else:
                jsonfile = requests.get(url+zipcode).json()
                try:
                    coordinates = list(jsonfile['places'][0]['latitude'], jsonfile['places'][0]['longitude'])
                except KeyError as ke:
                    print 'zipcode not exists', each[1]['month'], each[1]['zip']

                jsonstring = json.dumps(jsonfile, separators=(',',':'))
                jsondict[zipcode] = jsonstring
                coodict[zipcode] = coordinates

            if coordinates:
                coocontents.append([each[1]['month']] + coordinates)
                jsonres.append(jsonstring)

        # in case other not catched
        except Exception as e:
            print e, each[1]['month'], each[1]['zip']
            continue


    zdf = pd.DataFrame(coocontents, columns=cooheaders)
    zdf.to_csv(outcoofile, index=False)
    
    jdf = pd.DataFrame(jsonres)
    jdf.to_csv(outjsonfile, index=False)
    

if __name__ == '__main__':
    zipToCoo('./detailzipcounts_cleaned.csv', './coo_cleaned.csv', './coo_json_cleaned.csv')
