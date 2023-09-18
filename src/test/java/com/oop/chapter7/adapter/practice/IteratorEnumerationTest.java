package com.oop.chapter7.adapter.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IteratorEnumerationTest {
    private IteratorEnumeration iteratorEnumeration;

    @Test
    @DisplayName("arrayList도 Enumeration을 사용할 수 있습니다.")
    void test(){
        List<Object> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        iteratorEnumeration = new IteratorEnumeration(arrayList.iterator());
        boolean moreElements = iteratorEnumeration.hasMoreElements();
        assertEquals(true, moreElements);
    }

}