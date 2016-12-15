#!/bin/bash

LIST=""

#过滤出协议，尝试连接主机的ip
LIST=$(cat /var/log/secure | grep "authentication failure" | awk '{print$14}' | sed -e 's/rhost=//g' -e 's/ /_/g' | uniq)

#Trusted Hosts
excludeList=( "192.168.1.101", "192.168.1.102", "192.168.1.103", "192.168.1.104", "192.168.1.105" )

function chkExcludeList()
{
for j in "${excludeList[@]}"; do
    if [[ "$1" == $j ]]; then
        return 10
    fi
done
return 11
}

#检查并追加到hosts.deny文件中
for i in $LIST; do
    chkExcludeList "$i"
        if [ $? != "10" ]; then
            if [ "$(grep $i /etc/hosts.deny)" = "" ]; then
                echo "ALL: $i : DENY" >> /etc/hosts.deny
            fi
        fi
done
