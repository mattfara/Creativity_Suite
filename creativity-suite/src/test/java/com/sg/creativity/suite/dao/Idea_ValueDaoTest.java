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
public class Idea_ValueDaoTest {
    
    @Inject private IdeaDao ideaDao;
    @Inject private ValueDao valueDao;
    @Inject private Idea_ValueDao ivDao;
    
    private DaoTestHelper helper = new DaoTestHelper();

    public Idea_ValueDaoTest() {
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
     * Test of insertIdea_Value method, of class Idea_ValueDao.
     */
    @Test
    public void testInsertIdea_Value() {
        helper.insertAnIdea_Value();
    }

    /**
     * Test of getIdea_ValueById method, of class Idea_ValueDao.
     */
    @Test
    public void testGetIdea_ValueById() {
        helper.insertAnIdea_Value();
        Idea_Value iv = ivDao.getIdea_ValueById(1);
        
        assertNotNull(iv.getId());
        assertEquals(1, iv.getIdea().getId());
        assertEquals(1, iv.getValue().getId());
    }

    //TODO: change to IdNotFoundException after discovering proper exception and making new exception class
    @Test(expected=Exception.class)
    public void testGetIdea_ValueByNonExistentId() {
        ivDao.getIdea_ValueById(22);
    }
    
    @Test
    public void testGetAllIdea_ValuesWhenNoIdea_ValuesInDB() {
        int ivCountBeforeInsertions = ivDao.getAllIdea_Values().size();
        assertNotNull(ivCountBeforeInsertions);
        assertEquals(0, ivCountBeforeInsertions);
    }
    
    /**
     * Test of getAllIdea_Values method, of class Idea_ValueDao.
     */
    @Test
    public void testGetAllIdea_Values() {
        helper.insertAnIdea_Value();
        helper.insertAnIdea_Value();
        
        List<Idea_Value> allIdea_Values = ivDao.getAllIdea_Values();
        assertEquals(2, allIdea_Values.size());
        assertEquals(1, allIdea_Values.get(0).getId());
        assertEquals(2, allIdea_Values.get(1).getId());
    }

    /**
     * Test of removeIdea_Value method, of class Idea_ValueDao.
     */
    @Test
    public void testRemoveIdea_Value() {
        Idea_Value iv = helper.insertAnIdea_Value();
        ivDao.removeIdea_Value(iv);
        assertNull(ivDao.getIdea_ValueById(iv.getId()));
    }
    
    /**
     * Test of getIdea_ValuesByIdea method, of class Idea_ValueDao.
     */
    @Test
    public void testGetIdea_ValuesByIdea() {
         Idea idea = helper.insertTwoIdea_ValuesSharingSameIdea();
        Idea_Value unrelatedIp = helper.insertAnIdea_Value();
        List<Idea_Value> ivList = ivDao.getIdea_ValuesByIdea(idea);
        
        assertEquals(2, ivList.size());
        assertFalse(ivList.contains(unrelatedIp));
        
        Idea_Value iv1 = ivList.get(0);
        assertEquals(1, iv1.getId());
        assertEquals(1, iv1.getIdea().getId());
        
        Idea_Value iv2 = ivList.get(1);
        assertEquals(2, iv2.getId());
        assertEquals(1, iv2.getIdea().getId());
    }

    /**
     * Test of getIdea_ValuesByValue method, of class Idea_ValueDao.
     */
    @Test
    public void testGetIdea_ValuesByValue() {
        Value value = helper.insertTwoIdea_ValuesSharingSameValue();
        Idea_Value unrelatedIp = helper.insertAnIdea_Value();
        List<Idea_Value> ivList = ivDao.getIdea_ValuesByValue(value);
        
        assertEquals(2, ivList.size());
        assertFalse(ivList.contains(unrelatedIp));
        
        Idea_Value iv1 = ivList.get(0);
        assertEquals(1, iv1.getId());
        assertEquals(1, iv1.getValue().getId());
        
        Idea_Value iv2 = ivList.get(1);
        assertEquals(2, iv2.getId());
        assertEquals(1, iv2.getValue().getId());
    }

    
}
