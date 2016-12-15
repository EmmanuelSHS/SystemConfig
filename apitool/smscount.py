# HW0 for COMS 4111 Introduction to Database
# Author: Mengqi Wang
# Date: 2015-09-12
# Description: import the iowa-liquor-sample.csv and count records (# of lines) that
# 	contain the captain-insensitive string 'single malt scotch'
# In this hw, two methods are used
# the first is to use regular expression to count the lines
# the second one is to use orm database

# method 1
# using regular expression & csv reader to perform search by line
import csv
import re

print "method 1 START."
iowa_open = open("iowa-liquor-sample.csv")
iowa_reader = csv.reader(iowa_open)

global pattern 
global count

pattern = re.compile(r'single malt scotch', re.I)
count = 0

for line in iowa_reader:
	for i in range(0, len(line)):
		buff = line[i]
		match = re.match(pattern, buff)
		if match:
			count += 1
			break

print count
print "method 1 END."

# method 2
# using sql package to conduct search
import csv
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, Numeric, String
from sqlalchemy.orm import sessionmaker

print "method 2 START."
## register the environment
engine = create_engine('sqlite:///:memory:', echo=True)
Session = sessionmaker(bind=engine)
session = Session()
Base = declarative_base()

class Record(Base):
	__tablename__ = 'records'

### in this problem, we need to search record (i.e. line) that contains captain-insensitive string 'single malt scotch'
### so we only need to search CATEGORY_NAME since only those that fall into the category_name -- single malt scotch
### may have the 'single malt scotch' string in DESCRIPTION

	id = Column(Integer, primary_key = True)
	date = Column(String)
	cconv_store = Column(String)
	store = Column(String)
	name = Column(String)
	address = Column(String)
	city = Column(String)
	zipcode = Column(Integer)
	store_loc = Column(String)
	county_num = Column(Integer)
	county = Column(String)
	category = Column(String)
        category_name = Column(String)
	vendor_no = Column(Integer)
	vendor = Column(String)
	item = Column(String)
	description = Column(String)
	pack = Column(Integer)
	liter_size = Column(Integer)
	state_btl_cost = Column(Numeric)
	btl_price = Column(Numeric)
	bottle_qty = Column(Integer)
	total = Column(Numeric)
	
	def __repr__(self):
		return "<records(id = '%d', date='%s', category_name='%s')" % (self.id, self.date, self.category_name)

Base.metadata.create_all(engine)

## import data from csv, and commit changes
iowa_open = open("iowa-liquor-sample.csv")
iowa_reader = csv.reader(iowa_open)

i = 0
for line in iowa_reader:
	if i == 0: 
		i += 1
		continue 
	rc = Record(id = i, date = line[0], cconv_store = line[1], store = line[2],
		name = line[3], address = line[4], city = line[5], zipcode = line[6], 
		store_loc = line[7], county_num = line[8], county = line[9], category = line[10],
        	category_name = line[11], vendor_no = line[12], vendor = line[13], item = line[14], 
		description = line[15], pack = line[16], liter_size = line[17], state_btl_cost = line[18], 
		btl_price = line[19], bottle_qty = line[20], total = line[21])
	session.add(rc)
	i += 1
session.commit()
print 'records imported'

## searching 'single malt scotch'
count = session.query(Record).filter(Record.category_name.like('single malt scotch')).count()
print count

print "method 2 END."

