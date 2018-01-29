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
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
    
    private DaoTestHelper helper = new DaoTestHelper();
    
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
        helper.insertAnIdea_Concept();
    }

    /**
     * Test of getIdea_ConceptById method, of class Idea_ConceptDao.
     */
    @Test
    @Transactional
    public void testGetIdea_ConceptById() {
        helper.insertAnIdea_Concept();
        Idea_Concept ic = icDao.getIdea_ConceptById(1);
        
        assertNotNull(ic.getId());
        assertEquals(1, ic.getIdea().getId());
        assertEquals(1, ic.getConcept().getId());
    }

      //TODO: change to IdNotFoundException after discovering proper exception and making new exception class
    @Test(expected=Exception.class)
    public void testGetIdea_ConceptByNonExistentId() {
        icDao.getIdea_ConceptById(22);
    }
    
    /**
     * Test of getAllIdea_Concepts method, of class Idea_ConceptDao.
     */
    
    @Test
    public void testGetAllIdea_ConceptsWhenNoIdea_ConceptsInDB() {
        int icCountBeforeInsertions = icDao.getAllIdea_Concepts().size();
        assertNotNull(icCountBeforeInsertions);
        assertEquals(0, icCountBeforeInsertions);
    }
    
    @Test
    @Transactional
    public void testGetAllIdea_Concepts() {
        helper.insertAnIdea_Concept();
        helper.insertAnIdea_Concept();
        
        List<Idea_Concept> allIdea_Concepts = icDao.getAllIdea_Concepts();
        assertEquals(2, allIdea_Concepts.size());
        assertEquals(1, allIdea_Concepts.get(0).getId());
        assertEquals(2, allIdea_Concepts.get(1).getId());
    }

    /**
     * Test of removeIdea_Concept method, of class Idea_ConceptDao.
     */
    @Test
    @Transactional
    public void testRemoveIdea_Concept() {
        Idea_Concept ic = helper.insertAnIdea_Concept();
        icDao.removeIdea_Concept(ic);
        assertNull(icDao.getIdea_ConceptById(ic.getId()));
    }
    
    /**
     * Test of getIdea_ConceptsByIdea method, of class Idea_ConceptDao.
     */
    @Test
    @Transactional
    public void testGetIdea_ConceptsByIdea() {
        Idea idea = helper.insertTwoIdea_ConceptsSharingSameIdea();
        Idea_Concept unrelatedIp = helper.insertAnIdea_Concept();
        List<Idea_Concept> icList = icDao.getIdea_ConceptsByIdea(idea);
        
        assertEquals(2, icList.size());
        assertFalse(icList.contains(unrelatedIp));
        
        Idea_Concept ic1 = icList.get(0);
        assertEquals(1, ic1.getId());
        assertEquals(1, ic1.getIdea().getId());
        
        Idea_Concept ic2 = icList.get(1);
        assertEquals(2, ic2.getId());
        assertEquals(1, ic2.getIdea().getId());
        
    }

    /**
     * Test of getIdea_ConceptsByConcept method, of class Idea_ConceptDao.
     */
    @Test
    @Transactional
    public void testGetIdea_ConceptsByConcept() {
        Concept concept = helper.insertTwoIdea_ConceptsSharingSameConcept();
        Idea_Concept unrelatedIp = helper.insertAnIdea_Concept();
        List<Idea_Concept> icList = icDao.getIdea_ConceptsByConcept(concept);
        
        assertEquals(2, icList.size());
        assertFalse(icList.contains(unrelatedIp));
        
        Idea_Concept ic1 = icList.get(0);
        assertEquals(1, ic1.getId());
        assertEquals(1, ic1.getConcept().getId());
        
        Idea_Concept ic2 = icList.get(1);
        assertEquals(2, ic2.getId());
        assertEquals(1, ic2.getConcept().getId());
    }
}
