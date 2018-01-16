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
public class Idea_Value {
    private int id;
    private Idea idea;
    private Value value;

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

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
    
    
}
