package com.oop.chapter7.adapter.practice;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

public class IteratorEnumeration implements Enumeration<Object> {

    Iterator<Object> iterator;

    public IteratorEnumeration(Iterator<Object> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
