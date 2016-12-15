#!/bin/bash

june='./june.csv'
july='./july.csv'
aug='./aug.csv'
array=($june $july $aug)

echo 'month,' `head -n 1 $june` > merged.csv

tail -n+2 $june | awk -F ',' 'IF ($6 > 0) {print $0}' | awk '{print "6,"$0}' >> merged.csv
tail -n+2 $july | awk -F ',' 'IF ($6 > 0) {print $0}' | awk '{print "7,"$0}' >> merged.csv
tail -n+2 $aug | awk -F ',' 'IF ($6 > 0) {print $0}' | awk '{print "8,"$0}' >> merged.csv
