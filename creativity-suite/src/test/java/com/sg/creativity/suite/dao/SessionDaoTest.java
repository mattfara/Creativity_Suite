/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Session;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
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

    public Session makeSessionAndSetFields(String date, String start_time, String end_time, String hat_sequence){
        Session session = new Session();
        session.setDate(LocalDate.parse(date));
        session.setStart_time(LocalTime.parse(start_time));
        session.setEnd_time(LocalTime.parse(end_time));
        session.setHat_sequence(hat_sequence);
        
        return session;
    }
    
    public Session makeSessionAndSetFields(){
        
        Session session = new Session();
        session.setDate(LocalDate.parse("1992-05-14"));
        session.setStart_time(LocalTime.parse("12:15:00"));
        session.setEnd_time(LocalTime.parse("12:20:00"));
        session.setHat_sequence("white,red,green,yellow,black,red,white");
        
        return session;
    }
    
    /**
     * Test of insertSession method, of class SessionDao.
     */
    @Test
    public void testInsertSession() {
    }

    /**
     * Test of getSessionById method, of class SessionDao.
     */
    @Test
    public void testGetSessionById() {
    }

    /**
     * Test of getAllSessions method, of class SessionDao.
     */
    @Test
    public void testGetAllSessions() {
    }

    /**
     * Test of removeSession method, of class SessionDao.
     */
    @Test
    public void testRemoveSession() {
    }

    /**
     * Test of updateSession method, of class SessionDao.
     */
    @Test
    public void testUpdateSession() {
    }

    public class SessionDaoImpl implements SessionDao {

        public Session insertSession(Session concept) {
            return null;
        }

        public Session getSessionById(int id) {
            return null;
        }

        public List<Session> getAllSessions() {
            return null;
        }

        public void removeSession(Session concept) {
        }

        public void updateSession(Session concept) {
        }
    }
    
}
