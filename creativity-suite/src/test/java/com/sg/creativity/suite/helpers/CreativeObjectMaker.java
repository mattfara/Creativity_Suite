/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.helpers;

import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Problem;
import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.dto.Value;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author matt
 */
public class CreativeObjectMaker {
    public Idea makeIdeaAndSetFields(String name, String description){
        Idea idea = new Idea();
        idea.setName(name);
        idea.setDescription(description);
        
        return idea;
    }
    
    public Idea makeIdeaAndSetFields(){
        Idea idea = new Idea();
        idea.setName("a bucket with a hole in the bottom");
        idea.setDescription("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up");
        
        return idea;
    }
    
    public Concept makeConceptAndSetFields(String name, String description){
        Concept concept = new Concept();
        concept.setName(name);
        concept.setDescription(description);
        
        return concept;
    }
    
    public Concept makeConceptAndSetFields(){
        Concept concept = new Concept();
        concept.setName("putting a hole in something");
        concept.setDescription("taking an object or concept and putting a literal"
                + "or metaphorical hole in it");
        
        return concept;
    }
    
    public Problem makeProblemAndSetFields(String name, String description){
        Problem problem = new Problem();
        problem.setName(name);
        problem.setDescription(description);
        
        return problem;
    }
    
    public Problem makeProblemAndSetFields(){
        Problem problem = new Problem();
        problem.setName("too many lawyers in my town");
        problem.setDescription("the census in my town revealed that the excess of"
                + "lawyers in my town is leading to unemployment");
        
        return problem;
    }
    
    public Value makeValueAndSetFields(String name, String description){
        Value value = new Value();
        value.setName(name);
        value.setDescription(description);
        
        return value;
    }
    
    public Value makeValueAndSetFields(){
        Value value = new Value();
        value.setName("a bucket with a hole in the bottom");
        value.setDescription("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up");
        
        return value;
    }

    
    public Session makeSessionAndSetFields(String date, String start_time, String end_time, String hat_sequence){
        Session session = new Session();
        session.setDate(LocalDate.parse(date));
        session.setStart_time(LocalTime.parse(start_time));
        session.setEnd_time(LocalTime.parse(end_time));
        session.setHat_sequence(hat_sequence);
        
        return session;
    }
    
    public Session makeSessionAndSetFields(){
        
        Session session = new Session();
        session.setDate(LocalDate.parse("1992-05-14"));
        session.setStart_time(LocalTime.parse("12:15:00"));
        session.setEnd_time(LocalTime.parse("12:20:00"));
        session.setHat_sequence("white,red,green,yellow,black,red,white");
        
        return session;
    }
    
}
