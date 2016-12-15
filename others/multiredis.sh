#!/bin/sh

redis_server=//anaconda/bin/redis-server

for i in `seq 0 9`; do
    port=`echo 6379 + $i | bc`
    workdir=redis_$i
    mkdir -p $workdir
    (cd $workdir && $redis_server --port $port --daemonize yes)
done

