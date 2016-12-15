#!/usr/bin/env python
# coding=utf-8

def test_use():
    # not possible
    rf.reformat()

def wrap_import():
    import reformat as rf
    rf.reformat()
    test_use()

wrap_import()
rf.reformat()
