#!/usr/bin/env python
# coding=utf-8
import json
import pandas as pd
from dateutil.parser import parse


def yield_grades(ofname, gfname, outname):
    order = []
    of = open(ofname)
    for line in of:
        order.append([line.rstrip('\n\r')])
    of.close()

    with open(gfname) as gf:
        grades = json.load(gf)
        answers = grades
        grades = {d.get('uni'): [d.get('grade'), d.get('msg', '')] for d in grades.values()}

    for i, record in enumerate(order):
        name = record[0]
        info = grades.get(name, [0, 'Not submission found'])
        order[i] += info
        print name, json.dumps(answers.get(name), indent=2)


    # print 
    for record in order:
        print record

    df = pd.DataFrame(order)
    df.to_csv(outname)

def yield_late_days(gfname, logname, due, outname):
    count = 0
    late_days = []
    due_date = parse(due)

    with open(gfname) as gf:
        grades = json.load(gf)
        transformer = {str(k): v.get('uni') for k, v in grades.items()}

    with open(logname) as log:
        for line in log:
            if 'Late Submission' in line:
                count += 1
                timestamp = parse('T'.join(line.split(' ')[-2:]))
                name = ' '.join(line.split(' ')[2:-2])
                late_day = timestamp - due_date
                late_days.append([name, transformer.get(name, ''), late_day])

    df = pd.DataFrame(late_days)
    df.to_csv(outname)

    print 'Total', count

if __name__ == '__main__':
    ofname = './grade_order.txt'
    gfname = './grades_hw4.json'
    logname = './hw4_log.txt'
    outname = 'hw4_grades.csv'
    latename = 'hw4_late_days.csv'
    due = '2016-11-30T14:30:00.000000-05:00'
    yield_grades(ofname, gfname, outname)
    yield_late_days(gfname, logname, due, latename)
