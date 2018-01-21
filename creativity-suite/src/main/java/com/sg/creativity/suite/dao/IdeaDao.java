/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import java.util.List;

/**
 *
 * @author matt
 */
public interface IdeaDao {
    public Idea insertIdea(Idea concept);

    public Idea getIdeaById(int id);

    public List<Idea> getAllIdeas();

    public void removeIdea(Idea concept);

    public void updateIdea(Idea concept);
    
}
