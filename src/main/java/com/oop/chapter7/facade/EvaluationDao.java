package com.oop.chapter7.facade;

public class EvaluationDao {

    public Evaluation select(Long id) {
        return new Evaluation();
    }
}
