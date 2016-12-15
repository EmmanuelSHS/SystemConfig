#!/bin/bash

name=$1
cat $name | uniq -c | awk -v OFS=',' '{print $2, $1}' > `basename -s .csv $name`'_cleaned.csv'
