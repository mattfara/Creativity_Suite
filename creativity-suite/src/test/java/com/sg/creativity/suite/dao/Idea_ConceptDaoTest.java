/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Concept;
import com.sg.creativity.suite.helpers.CreativeObjectMaker;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author matt
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@Transactional
public class Idea_ConceptDaoTest {
    
    @Inject
    private IdeaDao ideaDao;
    @Inject
    private ConceptDao conceptDao;
    @Inject 
    private Idea_ConceptDao icDao;
    
    private CreativeObjectMaker objMaker = new CreativeObjectMaker();
    
    public Idea_ConceptDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    
    
    /**
     * Test of insertIdea_Concept method, of class Idea_ConceptDao.
     */
    @Test
    @Transactional
    public void testInsertIdea_Concept() {
        Idea idea = objMaker.makeIdeaAndSetFields();
        Concept concept = objMaker.makeConceptAndSetFields();
        
        ideaDao.insertIdea(idea);
        conceptDao.insertConcept(concept);
        Idea_Concept ic = new Idea_Concept();
        ic.setIdea(idea);
        ic.setConcept(concept);
        
        icDao.insertIdea_Concept(ic);
        Idea_Concept icFromDao = icDao.getIdea_ConceptById(ic.getId());
        
        assertNotNull(ic.getId());
        assertEquals(idea.getId(), ic.getIdea().getId());
        assertEquals(concept.getId(), ic.getConcept().getId());
        
        
    
    }

    /**
     * Test of getIdea_ConceptById method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetIdea_ConceptById() {
        Idea idea = objMaker.makeIdeaAndSetFields();
        Concept concept = objMaker.makeConceptAndSetFields();
        
        ideaDao.insertIdea(idea);
        conceptDao.insertConcept(concept);
        Idea_Concept ic = new Idea_Concept();
        ic.setIdea(idea);
        ic.setConcept(concept);
        
        icDao.insertIdea_Concept(ic);
        Idea_Concept icFromDao = icDao.getIdea_ConceptById(ic.getId());
        
        assertNotNull(ic.getId());
        assertEquals(idea.getId(), ic.getIdea().getId());
        assertEquals(concept.getId(), ic.getConcept().getId());
    
    }

    /**
     * Test of getAllIdea_Concepts method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetAllIdea_Concepts() {
        int icCountBeforeInsertions = icDao.getAllIdea_Concepts().size();
        assertNotNull(icCountBeforeInsertions);
        
        Idea idea = objMaker.makeIdeaAndSetFields();
        Concept concept = objMaker.makeConceptAndSetFields();
        
        ideaDao.insertIdea(idea);
        conceptDao.insertConcept(concept);
        Idea_Concept ic = new Idea_Concept();
        ic.setIdea(idea);
        ic.setConcept(concept);
        
        icDao.insertIdea_Concept(ic);
        Idea_Concept icFromDao = icDao.getIdea_ConceptById(ic.getId());
        
        List<Idea_Concept> allIdea_Concepts = icDao.getAllIdea_Concepts();
        assertTrue(icCountBeforeInsertions+1 == allIdea_Concepts.size());
        
        assertNotNull(ic.getId());
        assertEquals(idea.getId(), ic.getIdea().getId());
        assertEquals(concept.getId(), ic.getConcept().getId());
    }

    /**
     * Test of removeIdea_Concept method, of class Idea_ConceptDao.
     */
    @Test
    public void testRemoveIdea_Concept() {
        Idea idea = objMaker.makeIdeaAndSetFields();
        Concept concept = objMaker.makeConceptAndSetFields();
        
        ideaDao.insertIdea(idea);
        conceptDao.insertConcept(concept);
        Idea_Concept ic = new Idea_Concept();
        ic.setIdea(idea);
        ic.setConcept(concept);
        
        icDao.insertIdea_Concept(ic);
        Idea_Concept icFromDao = icDao.getIdea_ConceptById(ic.getId());
        
        icDao.removeIdea_Concept(icFromDao);
        assertNull(icDao.getIdea_ConceptById(icFromDao.getId()));
    }
    
    /**
     * Test of getIdea_ConceptsByIdea method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetIdea_ConceptsByIdea() {
        Idea idea = objMaker.makeIdeaAndSetFields();
        Concept concept1 = objMaker.makeConceptAndSetFields();
        Concept concept2 = objMaker.makeConceptAndSetFields("abc", "xyz");
        
        ideaDao.insertIdea(idea);
        conceptDao.insertConcept(concept1);
        conceptDao.insertConcept(concept2);
        
        Idea_Concept ic1 = new Idea_Concept();
        Idea_Concept ic2 = new Idea_Concept();
        
        ic1.setIdea(idea);
        ic1.setConcept(concept1);
        
        ic2.setIdea(idea);
        ic2.setConcept(concept2);
        
        icDao.insertIdea_Concept(ic1);
        icDao.insertIdea_Concept(ic2);
        
        List<Idea_Concept> icList = icDao.getIdea_ConceptsByIdea(idea);
        Idea_Concept ic1FromDao = icList.get(icList.size()-2);
        Idea_Concept ic2FromDao = icList.get(icList.size()-1);
        
        assertEquals(ic1.getId(), ic1FromDao.getId());
        assertEquals(ic2.getId(), ic2FromDao.getId());
        
        assertEquals(idea.getId(), ic1FromDao.getIdea().getId());
        assertEquals(idea.getId(), ic2FromDao.getIdea().getId());
        
        assertEquals(concept1.getId(), ic1FromDao.getConcept().getId());
        assertEquals(concept2.getId(), ic2FromDao.getConcept().getId());
        
    }

    /**
     * Test of getIdea_ConceptsByConcept method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetIdea_ConceptsByConcept() {
        Concept concept = objMaker.makeConceptAndSetFields();
        Idea idea1 = objMaker.makeIdeaAndSetFields();
        Idea idea2 = objMaker.makeIdeaAndSetFields();
        
        conceptDao.insertConcept(concept);
        ideaDao.insertIdea(idea1);
        ideaDao.insertIdea(idea2);
        
        Idea_Concept ic1 = new Idea_Concept();
        Idea_Concept ic2 = new Idea_Concept();
        
        ic1.setConcept(concept);
        ic1.setIdea(idea1);
        
        ic2.setConcept(concept);
        ic2.setIdea(idea2);
        
        icDao.insertIdea_Concept(ic1);
        icDao.insertIdea_Concept(ic2);
        
        List<Idea_Concept> icList = icDao.getIdea_ConceptsByConcept(concept);
        Idea_Concept ic1FromDao = icList.get(icList.size()-2);
        Idea_Concept ic2FromDao = icList.get(icList.size()-1);
        
        assertEquals(ic1.getId(), ic1FromDao.getId());
        assertEquals(ic2.getId(), ic2FromDao.getId());
        
        assertEquals(concept.getId(), ic1FromDao.getConcept().getId());
        assertEquals(concept.getId(), ic2FromDao.getConcept().getId());
        
        assertEquals(idea1.getId(), ic1FromDao.getIdea().getId());
        assertEquals(idea2.getId(), ic2FromDao.getIdea().getId());
    }
}
