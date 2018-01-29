/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class IdeaDaoTest {
    
    @Inject private ApplicationContext ctx;
    @Inject private IdeaDao ideaDao;
    @Inject private DaoTestHelper helper;
    
    public IdeaDaoTest() {
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
     * Test of insertIdea method, of class IdeaDao.
     */
    
    @Test
    @Transactional
    public void testInsertIdea() {
        helper.insertAnIdea();
        return;
    }

    @Test
    public void testInsertIdeaWithNullDescription() {
        helper.insertAnIdeaWithNullDescription();
    }
    
    @Test(expected=DataIntegrityViolationException.class) //data integrity violation //should be MissingARequiredFieldException
    public void testInsertIdeaWithNullName() {
        helper.insertAnIdeaWithNullName();
    }
    
    /**
     * Test of getIdeaById method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testGetIdeaByIdFillsIdField() {
        helper.insertAnIdea();
        Idea idea = ideaDao.getIdeaById(1);
        
        assertNotNull(idea.getId());
    }

    @Test
    @Transactional
    public void testGetIdeaByIdFillsNameField() {
        helper.insertAnIdea();
        Idea idea = ideaDao.getIdeaById(1);
        
        assertEquals("ABC", idea.getName());    
    }
    
    @Test
    @Transactional
    public void testGetIdeaByIdFillsDescriptionField() {
        helper.insertAnIdea();
        Idea idea = ideaDao.getIdeaById(1);
        
        assertEquals("XYZ", idea.getDescription());
    }
    
    @Test
    @Transactional
    public void testGetIdeaByIdFillsDescriptionFieldEvenIfNullInDb() {
        Idea idea = helper.insertAnIdeaWithNullDescription();
        assertEquals("", idea.getDescription());
    }
    
    @Test(expected=EmptyResultDataAccessException.class)
    public void testGetIdeaByNonExistantId() {
        ideaDao.getIdeaById(1);
    }
    
    
    /**
     * Test of getAllIdeas method, of class IdeaDao.
     */
    
    @Test
    public void testGetAllIdeasWhenNoIdeasInDB() {
        int ideaCountBeforeInsertions = ideaDao.getAllIdeas().size();
        assertNotNull(ideaCountBeforeInsertions);
        assertEquals(0, ideaCountBeforeInsertions);
    }

    
    @Test
    @Transactional
    public void testGetAllIdeas() {
        helper.insertAnIdea();
        helper.insertAnIdea();
        
        List<Idea> allIdeas = ideaDao.getAllIdeas();
        assertEquals(2, allIdeas.size());
        assertEquals(1, allIdeas.get(0).getId());
        assertEquals(2, allIdeas.get(1).getId());
        
    }

    /**
     * Test of removeIdea method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testRemoveIdea() {
        Idea idea = helper.insertAnIdea();
        ideaDao.removeIdea(idea);
        assertNull(ideaDao.getIdeaById(idea.getId()));
    }

    /**
     * Test of updateIdea method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testUpdateIdea() {
        Idea idea = helper.makeAndUpdateAnIdea();
        
        assertEquals("abc", idea.getName());
        assertEquals("xyz", idea.getDescription());
    }
}
