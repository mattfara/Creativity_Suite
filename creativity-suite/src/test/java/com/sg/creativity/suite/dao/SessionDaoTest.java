/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.helpers.CreativeObjectMaker;
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
public class SessionDaoTest {
    @Inject
    private ApplicationContext ctx;
    
    @Inject
    private SessionDao dao;
    
    CreativeObjectMaker objMaker = new CreativeObjectMaker();
    
    public SessionDaoTest() {
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
     * Test of insertSession method, of class SessionDao.
     */
    @Test
    @Transactional
    public void testInsertSession() {
        Session session = objMaker.makeSessionAndSetFields();
        dao.insertSession(session);
        Session fromDao = dao.getSessionById(session.getId());
        assertEquals("1992-05-14",fromDao.getDate().toString());
        assertEquals("12:15:00",fromDao.getStart_time().toString());
        assertEquals("12:20:00",fromDao.getEnd_time().toString());
        assertEquals("white,red,green,yellow,black,red,white",fromDao.getHat_sequence().toString());
        
        
        
    }

    /**
     * Test of getSessionById method, of class SessionDao.
     */
    @Test
    @Transactional
    public void testGetSessionById() {
        Session session = objMaker.makeSessionAndSetFields();
        dao.insertSession(session);
        Session fromDao = dao.getSessionById(session.getId());
        assertEquals("1992-05-14",fromDao.getDate().toString());
        assertEquals("12:15:00",fromDao.getStart_time().toString());
        assertEquals("12:20:00",fromDao.getEnd_time().toString());
        assertEquals("white,red,green,yellow,black,red,white",fromDao.getHat_sequence().toString());
    
    }

    /**
     * Test of getAllSessions method, of class SessionDao.
     */
    @Test
    @Transactional
    public void testGetAllSessions() {
        Session s1 = objMaker.makeSessionAndSetFields();
        Session s2 = objMaker.makeSessionAndSetFields("2005-05-05", "12:16:00", "12:21:00", "red,green,yellow,black,red");
        
        dao.insertSession(s1);
        dao.insertSession(s2);
        
        List<Session> allSessions = dao.getAllSessions();
        int sessionCount = allSessions.size();
        
        assertEquals(7, sessionCount);
        Session s1FromDao = dao.getSessionById(s1.getId());
        Session s2FromDao = dao.getSessionById(s2.getId());
        
        assertEquals("1992-05-14",s1FromDao.getDate().toString());
        assertEquals("12:15:00",s1FromDao.getStart_time().toString());
        assertEquals("12:20:00",s1FromDao.getEnd_time().toString());
        assertEquals("white,red,green,yellow,black,red,white",s1FromDao.getHat_sequence().toString());
        
        assertEquals("2005-05-05",s2FromDao.getDate().toString());
        assertEquals("12:16:00",s2FromDao.getStart_time().toString());
        assertEquals("12:21:00",s2FromDao.getEnd_time().toString());
        assertEquals("red,green,yellow,black,red",s2FromDao.getHat_sequence().toString());
    }

    /**
     * Test of removeSession method, of class SessionDao.
     */
    @Test
    @Transactional
    public void testRemoveSession() {
        Session session = objMaker.makeSessionAndSetFields();
        dao.insertSession(session);
        Session fromDao = dao.getSessionById(session.getId());
        dao.removeSession(fromDao);
        assertNull(dao.getSessionById(fromDao.getId()));
    
    }

    /**
     * Test of updateSession method, of class SessionDao.
     */
    @Test
    @Transactional
    public void testUpdateSession() {
        Session session = objMaker.makeSessionAndSetFields();
        dao.insertSession(session);
        Session fromDao = dao.getSessionById(session.getId());
        Session s2 = objMaker.makeSessionAndSetFields("2005-05-05", "12:16:00", "12:21:00", "red,green,yellow,black,red");
        
        fromDao.setDate(s2.getDate());
        fromDao.setEnd_time(s2.getEnd_time());
        fromDao.setHat_sequence(s2.getHat_sequence().toString());
        fromDao.setStart_time(s2.getStart_time());
        
        dao.updateSession(fromDao);
        
        Session updatedSessionFromDao = dao.getSessionById(fromDao.getId());
        
        assertEquals("2005-05-05",fromDao.getDate().toString());
        assertEquals("12:16:00",fromDao.getStart_time().toString());
        assertEquals("12:21:00",fromDao.getEnd_time().toString());
        assertEquals("red,green,yellow,black,red",fromDao.getHat_sequence().toString());
        
    }

    
    
}
