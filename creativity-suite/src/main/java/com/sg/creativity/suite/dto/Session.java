/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author matt
 */
public class Session {
    private int id;
    private LocalDate date;
    private Time start_time;
    private Time end_time;
    private List<String> hat_sequence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public List<String> getHat_sequence() {
        return hat_sequence;
    }

    public void setHat_sequence(List<String> hat_sequence) {
        this.hat_sequence = hat_sequence;
    }
    
    
}
