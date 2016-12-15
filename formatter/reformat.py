#!/usr/bin/env python
# coding=utf-8

# reformat table name, print as SQL create table schema

def reformat():
    origin = ["STOREint","NAMEstring","ADDRESSstring","CITYstring","ZIPCODEint","COUNTY_NUMBERint","COUNTYstring","CATEGORYint","CATEGORY_NAMEstring","VENDOR_NOint","VENDORstring","ITEMint","DESCRIPTIONstring","PACKint","LITER_SIZEint","STATE_BTL_COSTFloatingPointError","BTL_PRICEFloatingPointError","BOTTLE_QTYint","TOTALfloat"]

    for column in origin:
        res = ''
        for c in column:
            if c.isupper() or c == '_':
                res += c
        print "ALTER TABLE iowa_sample RENAME " + column + ' TO ' + res + ';'

if __name__ == '__main__':
    reformat()
