/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Problem;
import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.dto.Value;
import java.util.List;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author matt
 */
public interface ConceptDao {
    public Concept insertConcept(Concept concept);

    public Concept getConceptById(int id);

    public List<Concept> getAllConcepts();

    public void removeConcept(Concept concept);

    public void updateConcept(Concept concept);
    
   
}
