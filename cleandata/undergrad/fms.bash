#!/bin/bash
# 2015 spring
# data cleaning script for undergrad thesis

sufix=".dat"
name=0
rm -f vir_*.dat

for i in "0,0,12,0" "0,2,8,2" "0,2,8,1" "0,1,10,4" "0,1,10,2" "0,2,8,0" "0,3,6,3" "0,3,6,1" "0,1,10,5" "0,2,8,5"
do
  step=0
  for j in hist_*.dat
  do
   awk '{if ($2 == "'$i'") print $4*100} ' $j > tmp
   awk '{$2=$1; $1="'$step'" }{print}' tmp >>  $(printf vir_%1d.dat $name)
   step=$(($step+20))
   rm -f tmp
  done
name=$(($name+1))
done

gnuplot fms.scr

