#!/bin/bash
# 2015 spring
# data cleaning script for undergrad thesis

sort -k 2 hist_0.dat > sort0.dat.tmp
sort -k 2 hist_501.dat > sortf.dat.tmp

awk '{print $2 " " $3 " " $4}' sort0.dat.tmp > 0.dat.tmp
awk '{print $2 " " $3 " " $4}' sortf.dat.tmp > f.dat.tmp

join 0.dat.tmp f.dat.tmp > join0.dat.tmp

awk '{$6=$4-$2; $7=($4-$2)/$2; $8=$5-$3} {print}' join0.dat.tmp > join1.dat.tmp

tail -n +2 join1.dat.tmp > dvoro_0.dat.tmp

awk '{if ($3~/^[0-9.]+$/ || $5~/^[0-9.]+$/) print}' dvoro_0.dat.tmp > dvoro_1.dat.tmp
awk '{if (0.03>$3>0.0014 || 0.03>$5>0.0014) print}' dvoro_1.dat.tmp > dvoro_2.dat.tmp
awk '{if ($2>20 && $4>20 && $6>20) print}' dvoro_2.dat.tmp > dvoro_3.dat.tmp
awk '{if ($7>0.0099999 && $8<0.0300001) $3=$3*100; $5=$5*100; $7=$7*100; $8=$8*100; print }' dvoro_3.dat.tmp > dvoro_4.dat.tmp

sort -r -n -k 7 dvoro_4.dat.tmp > dvoro_5.dat.tmp
head -n 10 dvoro_5.dat.tmp > dvoro.txt

# rm -f *.dat.tmp
sort -r -n -k 7 dvoro_3.dat.tmp > try.dat.tmp

gnuplot allfms.scr
