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
    Idea_ConceptDao icDao;
    
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
    }

    /**
     * Test of getIdea_ConceptById method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetIdea_ConceptById() {
    }

    /**
     * Test of getAllIdea_Concepts method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetAllIdea_Concepts() {
    }

    /**
     * Test of removeIdea_Concept method, of class Idea_ConceptDao.
     */
    @Test
    public void testRemoveIdea_Concept() {
    }

    /**
     * Test of updateIdea_Concept method, of class Idea_ConceptDao.
     */
    @Test
    public void testUpdateIdea_Concept() {
    }

    /**
     * Test of getIdea_ConceptsByIdea method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetIdea_ConceptsByIdea() {
    }

    /**
     * Test of getIdea_ConceptsByConcept method, of class Idea_ConceptDao.
     */
    @Test
    public void testGetIdea_ConceptsByConcept() {
    }

    public class Idea_ConceptDaoImpl implements Idea_ConceptDao {

        public Idea_Concept insertIdea_Concept(Idea_Concept idea_concept) {
            return null;
        }

        public Idea_Concept getIdea_ConceptById(int id) {
            return null;
        }

        public List<Idea_Concept> getAllIdea_Concepts() {
            return null;
        }

        public void removeIdea_Concept(Idea_Concept idea_concept) {
        }

        public void updateIdea_Concept(Idea_Concept idea_concept) {
        }

        public List<Idea_Concept> getIdea_ConceptsByIdea(Idea idea) {
            return null;
        }

        public List<Idea_Concept> getIdea_ConceptsByConcept(Concept concept) {
            return null;
        }
    }
    
}
