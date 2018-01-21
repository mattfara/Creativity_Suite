/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Concept;
import java.util.List;

/**
 *
 * @author matt
 */
public interface Idea_ConceptDao {
    public Idea_Concept insertIdea_Concept(Idea_Concept idea_concept);
    public Idea_Concept getIdea_ConceptById(int id);
    public List<Idea_Concept> getAllIdea_Concepts();
    public void removeIdea_Concept(Idea_Concept idea_concept);
    public void updateIdea_Concept(Idea_Concept idea_concept);
    public List<Idea_Concept> getIdea_ConceptsByIdea(Idea idea);
    public List<Idea_Concept> getIdea_ConceptsByConcept(Concept concept);
}
