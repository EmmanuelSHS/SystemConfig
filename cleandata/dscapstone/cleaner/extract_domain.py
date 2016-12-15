#!/usr/bin/env python
# coding=utf-8


def extract_domain(filename):
    '''
    @ url csv file
    @ return: lower lettered domain
    '''
    with open(filename) as f:
        i = 0
        counts = {}
        for line in f:
            line = line.rstrip('\r\n')
            splitted = line.split('.')
            ns = len(splitted)
            counts[ns] = counts.get(ns, 0) + 1
            if ns == 20:
                # the very special case, wapbrasil
                print 'wapbrasil' + ',' + line
            else:
                # special cases
                if splitted[-2] == 'amazonaws':
                    print splitted[0].lower()+ ',' +line
                elif splitted[-1] == 'htm':
                    print splitted[-4].lower()+ ',' +line
                elif splitted[-3] == 'wwwtim':
                    print 'tim'+ ',' +line
                # normal range, 2~6
                else:
                    print splitted[-3].lower()+ ',' +line 

            #i += 1
            #if i > 100:
            #    break
            

if __name__ == '__main__':
    extract_domain('./url.csv')
