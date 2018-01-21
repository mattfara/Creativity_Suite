/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author matt
 */
public class Session {
    private int id;
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
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

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public List<String> getHat_sequence() {
        return hat_sequence;
    }
    
    //this will come in as a String from JDBC
    public void setHat_sequence(String sequence_string) {
        List<String> hat_sequence = new ArrayList<String>();
        hat_sequence = Arrays.asList(sequence_string.split("\\s*,\\s*"));
        this.hat_sequence = hat_sequence;
    }
    
    
}
