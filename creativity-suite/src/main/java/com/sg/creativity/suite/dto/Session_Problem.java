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
public class Session_Problem {
    private int id;
    private Session session;
    private Problem problem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
    
    
}
