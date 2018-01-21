/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Value;
import com.sg.creativity.suite.dto.Value;
import java.util.List;

/**
 *
 * @author matt
 */
public interface Idea_ValueDao {
    public Idea_Value insertIdea_Value(Idea_Value idea_value);
    public Idea_Value getIdea_ValueById(int id);
    public List<Idea_Value> getAllIdea_Values();
    public void removeIdea_Value(Idea_Value idea_value);
    public void updateIdea_Value(Idea_Value idea_value);
    public List<Idea_Value> getIdea_ValuesByIdea(Idea idea);
    public List<Idea_Value> getIdea_ValuesByValue(Value value);
}
