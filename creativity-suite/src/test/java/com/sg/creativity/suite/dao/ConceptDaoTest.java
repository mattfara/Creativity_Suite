/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Concept;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
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
public class ConceptDaoTest {
    
    @Inject
    private ApplicationContext ctx;
    
    @Inject
    private ConceptDao dao;
    
    DaoTestHelper helper = new DaoTestHelper();
    
    public ConceptDaoTest() {
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
     * Test of insertConcept method, of class ConceptDao.
     */
    
    @Test
    public void testInsertConcept() {
        helper.insertAConcept();
    }

    /**
     * Test of getConceptById method, of class ConceptDao.
     */
    @Test
    public void testGetConceptById() {
        Concept concept = helper.insertAConcept();
        assertEquals("putting a hole in something", concept.getName());
        assertEquals("taking an object or concept and putting a literal"
                + "or metaphorical hole in it", concept.getDescription());
    }

    /**
     * Test of getAllConcepts method, of class ConceptDao.
     */
    @Test
    @Transactional
    public void testGetAllConcepts() {
        Concept concept1 = helper.makeConceptAndSetFields();
        Concept concept2 = helper.makeConceptAndSetFields("abc", null);
        
        dao.insertConcept(concept1);
        dao.insertConcept(concept2);
        
        List<Concept> allConcepts = dao.getAllConcepts();
        int conceptCount = allConcepts.size();
        
        assertEquals(7, conceptCount);
        Concept concept1FromDao = dao.getConceptById(concept1.getId());
        Concept concept2FromDao = dao.getConceptById(concept2.getId());
        
        assertEquals("putting a hole in something", concept1FromDao.getName());
        assertEquals("taking an object or concept and putting a literal"
                + "or metaphorical hole in it", concept1FromDao.getDescription());
        
        assertEquals("abc", concept2FromDao.getName());
        assertNull(concept2FromDao.getDescription());
    }

    /**
     * Test of removeConcept method, of class ConceptDao.
     */
    @Test
    @Transactional
    public void testRemoveConcept() {
        Concept concept = helper.makeConceptAndSetFields();
        //add
        dao.insertConcept(concept);
        //get
        Concept fromDao = dao.getConceptById(concept.getId());
        
        //delete
        dao.removeConcept(fromDao);
        assertNull(dao.getConceptById(fromDao.getId()));
    
    }

    /**
     * Test of updateConcept method, of class ConceptDao.
     */
    @Test
    @Transactional
    public void testUpdateConcept() {
        Concept concept = helper.makeConceptAndSetFields();
        dao.insertConcept(concept);
        Concept conceptFromDao = dao.getConceptById(concept.getId());
        String newName = "abc";
        String newDescription = "xyz";
        
        conceptFromDao.setName(newName);
        conceptFromDao.setDescription(newDescription);
        
        dao.updateConcept(conceptFromDao);
        
        Concept updatedConceptFromDao = dao.getConceptById(concept.getId());
        
        assertEquals("abc", updatedConceptFromDao.getName());
        assertEquals("xyz", updatedConceptFromDao.getDescription());
    }
    
}
