#!/bin/bash

name=$1
# area code
#cat $name | awk -F ',' '{if ($2 == 1) print $1","$3}' | sort | uniq -c | awk -v OFS=',' '{print $2","$1}' > 'area_cleaned.csv'
# zipcode
#cat $name | awk -F ',' '{if ($2 == 1) print $1","$35}' | awk -F '-' '{print $1}'  | sort | uniq -c | awk -v OFS=',' '{print $2","$1}' > 'zip_cleaned.csv'
# zipcode all records
# detailed
#cat $name | awk -F ',' '{if ($2 == 1) print $1","$35}' | awk -F ',' '{if (length($2) == 9 ) print $1","$2}' | sort > 'detailedzipcounts_cleaned.csv'
# no detail
cat $name | awk -F ',' '{if ($2 == 1) print $1","$35}' | awk -F '-' '{print $1}' | awk -F ',' '{if (length($2) == 5 ) print $1","$2}' | sort > 'zipcounts_cleaned.csv'
