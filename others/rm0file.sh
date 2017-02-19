#!/bin/bash

repo="/home/ftp/ipcamera/*"

for file in $repo
do
    if [ ! -s $file ]
    then 
        rm $file
    fi
done
