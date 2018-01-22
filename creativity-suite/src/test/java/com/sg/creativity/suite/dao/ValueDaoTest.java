/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Value;
import com.sg.creativity.suite.helpers.CreativeObjectMaker;
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
public class ValueDaoTest {
    @Inject
    private ApplicationContext ctx;
    
    @Inject
    private ValueDao dao;

    CreativeObjectMaker objMaker = new CreativeObjectMaker();
    
    public ValueDaoTest() {
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
     * Test of insertValue method, of class ValueDao.
     */
    /**
     * Test of insertValue method, of class ValueDao.
     */
    
    @Test
    @Transactional
    public void testInsertValue() {
        Value value = objMaker.makeValueAndSetFields();
        //add
        dao.insertValue(value);
        //get
        Value fromDao = dao.getValueById(value.getId());
        assertEquals("a bucket with a hole in the bottom", fromDao.getName());
        assertEquals("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up", fromDao.getDescription());
    }

    /**
     * Test of getValueById method, of class ValueDao.
     */
    @Test
    @Transactional
    public void testGetValueById() {
        Value value = objMaker.makeValueAndSetFields();
        //add
        dao.insertValue(value);
        //get
        Value fromDao = dao.getValueById(value.getId());
        assertEquals("a bucket with a hole in the bottom", fromDao.getName());
        assertEquals("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up", fromDao.getDescription());
    
    }

    /**
     * Test of getAllValues method, of class ValueDao.
     */
    @Test
    @Transactional
    public void testGetAllValues() {
        Value value1 = objMaker.makeValueAndSetFields();
        Value value2 = objMaker.makeValueAndSetFields("abc", null);
        
        dao.insertValue(value1);
        dao.insertValue(value2);
        
        List<Value> allValues = dao.getAllValues();
        int valueCount = allValues.size();
        
        assertEquals(7, valueCount);
        Value value1FromDao = dao.getValueById(value1.getId());
        Value value2FromDao = dao.getValueById(value2.getId());
        
        assertEquals("a bucket with a hole in the bottom", value1FromDao.getName());
        assertEquals("this bucket has a dime-sized hole at its lowest "
                + "point when stood with mouth up", value1FromDao.getDescription());
        
        assertEquals("abc", value2FromDao.getName());
        assertNull(value2FromDao.getDescription());
        
    }

    /**
     * Test of removeValue method, of class ValueDao.
     */
    @Test
    @Transactional
    public void testRemoveValue() {
        Value value = objMaker.makeValueAndSetFields();
        //add
        dao.insertValue(value);
        //get
        Value fromDao = dao.getValueById(value.getId());
        
        //delete
        dao.removeValue(fromDao);
        assertNull(dao.getValueById(fromDao.getId()));
    
    }

    /**
     * Test of updateValue method, of class ValueDao.
     */
    @Test
    @Transactional
    public void testUpdateValue() {
        Value value = objMaker.makeValueAndSetFields();
        dao.insertValue(value);
        Value valueFromDao = dao.getValueById(value.getId());
        String newName = "abc";
        String newDescription = "xyz";
        
        valueFromDao.setName(newName);
        valueFromDao.setDescription(newDescription);
        
        dao.updateValue(valueFromDao);
        
        Value updatedValueFromDao = dao.getValueById(value.getId());
        
        assertEquals("abc", updatedValueFromDao.getName());
        assertEquals("xyz", updatedValueFromDao.getDescription());
    }
    
}
