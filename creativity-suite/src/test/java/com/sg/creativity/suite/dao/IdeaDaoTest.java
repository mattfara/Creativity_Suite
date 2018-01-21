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
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class IdeaDaoTest {
    
    @Inject
    private ApplicationContext ctx;
    
    @Inject
    private IdeaDao dao;
    
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
    /**
     * Test of insertIdea method, of class IdeaDao.
     */
    
    @Test
    @Transactional
    public void testInsertIdea() {
        Idea idea = makeIdeaAndSetFields();
        //add
        dao.insertIdea(idea);
        //get
        Idea fromDao = dao.getIdeaById(idea.getId());
        assertEquals("a bucket with a hole in the bottom", fromDao.getName());
        assertEquals("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up", fromDao.getDescription());
    }

    /**
     * Test of getIdeaById method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testGetIdeaById() {
        Idea idea = makeIdeaAndSetFields();
        //add
        dao.insertIdea(idea);
        //get
        Idea fromDao = dao.getIdeaById(idea.getId());
        assertEquals("a bucket with a hole in the bottom", fromDao.getName());
        assertEquals("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up", fromDao.getDescription());
    
    }

    /**
     * Test of getAllIdeas method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testGetAllIdeas() {
        Idea idea1 = makeIdeaAndSetFields();
        Idea idea2 = makeIdeaAndSetFields("abc", null);
        
        dao.insertIdea(idea1);
        dao.insertIdea(idea2);
        
        List<Idea> allIdeas = dao.getAllIdeas();
        int ideaCount = allIdeas.size();
        
        assertEquals(7, ideaCount);
        Idea idea1FromDao = dao.getIdeaById(idea1.getId());
        Idea idea2FromDao = dao.getIdeaById(idea2.getId());
        
        assertEquals("a bucket with a hole in the bottom", idea1FromDao.getName());
        assertEquals("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up", idea1FromDao.getDescription());
        
        assertEquals("abc", idea2FromDao.getName());
        assertNull(idea2FromDao.getDescription());
        
    }

    /**
     * Test of removeIdea method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testRemoveIdea() {
        Idea idea = makeIdeaAndSetFields();
        //add
        dao.insertIdea(idea);
        //get
        Idea fromDao = dao.getIdeaById(idea.getId());
        
        //delete
        dao.removeIdea(fromDao);
        assertNull(dao.getIdeaById(fromDao.getId()));
    
    }

    /**
     * Test of updateIdea method, of class IdeaDao.
     */
    @Test
    @Transactional
    public void testUpdateIdea() {
        Idea idea = makeIdeaAndSetFields();
        dao.insertIdea(idea);
        Idea ideaFromDao = dao.getIdeaById(idea.getId());
        String newName = "abc";
        String newDescription = "xyz";
        
        ideaFromDao.setName(newName);
        ideaFromDao.setDescription(newDescription);
        
        dao.updateIdea(ideaFromDao);
        
        Idea updatedIdeaFromDao = dao.getIdeaById(idea.getId());
        
        assertEquals("abc", updatedIdeaFromDao.getName());
        assertEquals("xyz", updatedIdeaFromDao.getDescription());
    }
}
