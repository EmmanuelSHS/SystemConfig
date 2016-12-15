#!/usr/bin/env python
# coding=utf-8

import pandas as pd


def get_statistics(filename, outname):
    pd.read_csv(filename).describe().to_csv(outname)


if __name__ == '__main__':
    filename = './merged.csv'
    outname = 'merged_statistics.csv'
    try:
        filename = sys.argv[1]
        outname = sys.argv[2]
    except:
        print 'use default'

    get_statistics(filename, outname)
