/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dto;

/**
 *
 * @author matt
 */
public class Idea_Problem {
    private int id;
    private Idea idea;
    private Problem problem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
    
    
}
