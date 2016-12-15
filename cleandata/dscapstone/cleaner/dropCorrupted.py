#!/usr/bin/env python
# coding=utf-8
import sys

def dropCorrupted(fname, ncols):
    with open(fname, 'r') as file:
        for line in file:
            n = len(line.split(','))
            if n == ncols:
                print line.rstrip('\n')


if __name__ == '__main__':
    fname = str(sys.argv[1])
    ncols = int(sys.argv[2])
    dropCorrupted(fname, ncols)
