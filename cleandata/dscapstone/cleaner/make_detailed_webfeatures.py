#!/usr/bin/env python
# coding=utf-8
from collections import defaultdict
import pandas as pd


def add_features(ofname, ffname, odname, outname):
    '''
    :
    '''
    web_by_user_month = {}
    with open(ffname) as ff:
        i = 0
        for line in ff:
            i += 1
            if i == 1:
                # get rid of headline
                continue
            month, id, host, count = line.rstrip('\r\n').split(',')
            d = web_by_user_month
            d = d.setdefault(id, {})
            d = d.setdefault(month, {})
            d = d.setdefault(host, int(count))

    with open(odname) as orderfile:
        order = []
        for line in orderfile:
            # no header
            order.append(line.rstrip('\r\n'))

    res = []
    header = []
    with open(ofname) as of:
        i = 0
        for line in of:
            i += 1
            line = line.rstrip('\r\n')
            if i == 1:
                # deal with header
                header = line.split(',')
                continue

            ofvals = line.split(',')
            month, id = ofvals[0], ofvals[-2]

            visits = web_by_user_month.get(id, {}).get(month, {})
            stvals = []

            for site in order:
                stvals.append(int(visits.get(site, 0)))
            res.append(ofvals + stvals)
            
    df = pd.DataFrame(res, columns=header+order)
    df.to_csv(outname, index=False)


if __name__ == '__main__':
    #add_features('./merged_id_total_traffic.csv', './traffic_id_url_bymonth.csv', './site_count_order.txt', 'merged_id_complete_traffic.csv')
    add_features('./merged_id_total_traffic.csv', './traffic_id_url_bymonth.csv', './site_count_order_truncated.txt', 'merged_id_truncated_traffic.csv')
