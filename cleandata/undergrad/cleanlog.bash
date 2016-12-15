#!/bin/bash
# 2015 spring
# data cleaning script for undergrad thesis

awk '{if($1~/^[1-9]/ && $2~/^[1-9]/) print }' log.lammps > log.cleaned
awk 'BEGIN {print "# 1 2 3 4 5 6 7 8"; print "# time(ps) cir tmp pe tote vol pz(true/GPa) lz(non-revised)"}''{$1=($1-15500000)*0.002; $7=-$7*0.0001}{print}' log.cleaned > log.tmp
mv log.tmp log.cleaned

for ((i = 10; i <= 100; i = $i + 10))
do
  awk '{if($1~/^[1-9]/ && $2=="'$i'") print }' log.lammps > $(printf log.cleaned.%02d $i)
done

for i in log.cleaned.*
do
  awk 'BEGIN {print "# 1 2 3 4 5 6 7 8"; print "# time(ps) cir tmp pe tote vol pz(eng/GPa) ez(revised/e-3)"}''{l0=246.1455};{$1=($1-15500000)*0.002; $7=-$7; $8=1000*($8-l0)/l0}{print}' $i > log.tmp
mv log.tmp $i
done

