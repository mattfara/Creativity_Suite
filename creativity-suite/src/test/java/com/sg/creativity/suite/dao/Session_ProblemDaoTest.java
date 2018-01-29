/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Problem;
import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.dto.Session_Problem;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class Session_ProblemDaoTest {
    
    @Inject private SessionDao sessionDao;
    @Inject private ProblemDao problemDao;
    @Inject private Session_ProblemDao spDao;
    
    private DaoTestHelper helper = new DaoTestHelper();
    
    public Session_ProblemDaoTest() {
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
     * Test of insertSession_Problem method, of class Session_ProblemDao.
     */
    @Test
    public void testInsertSession_Problem() {
        helper.insertASession_Problem();
    }
    
    /**
     * Test of getSession_ProblemById method, of class Session_ProblemDao.
     */
    @Test
    public void testGetSession_ProblemById() {
        helper.insertASession_Problem();
        Session_Problem sp = spDao.getSession_ProblemById(1);
        
        assertNotNull(sp.getId());
        assertEquals(1, sp.getSession().getId());
        assertEquals(1, sp.getProblem().getId());
    }
    
    //TODO: change to IdNotFoundException after discovering proper exception and making new exception class
    @Test(expected=Exception.class)
    public void testGetSession_ProblemByNonExistentId() {
        spDao.getSession_ProblemById(22);
    }
    
    /**
     * Test of getAllSession_Problems method, of class Session_ProblemDao.
     */
    @Test
    public void testGetAllSession_ProblemsWhenNoSession_ProblemsInDB() {
        int spCountBeforeInsertions = spDao.getAllSession_Problems().size();
        assertNotNull(spCountBeforeInsertions);
        assertEquals(0, spCountBeforeInsertions);
    }

    /**
     * Test of getAllSession_Problems method, of class Session_ProblemDao.
     */
    @Test
    public void testGetAllSession_Problems() {
        helper.insertASession_Problem();
        helper.insertASession_Problem();
        
        List<Session_Problem> allSession_Problems = spDao.getAllSession_Problems();
        assertEquals(2, allSession_Problems.size());
        assertEquals(1, allSession_Problems.get(0).getId());
        assertEquals(2, allSession_Problems.get(1).getId());
    }
    
    
    /**
     * Test of removeSession_Problem method, of class Session_ProblemDao.
     */
    @Test
    @Transactional
    public void testRemoveSession_Problem() {
        Session_Problem sp = helper.insertASession_Problem();
        spDao.removeSession_Problem(sp);
        assertNull(spDao.getSession_ProblemById(sp.getId()));
    }
    
    /**
     * Test of getSession_ProblemsBySession method, of class Session_ProblemDao.
     */
    @Test
    @Transactional
    public void testGetSession_ProblemsBySession() {
        Session session = helper.insertTwoSession_ProblemsSharingSameSession();
        Session_Problem unrelatedIp = helper.insertASession_Problem();
        List<Session_Problem> spList = spDao.getSession_ProblemsBySession(session);
        
        assertEquals(2, spList.size());
        assertFalse(spList.contains(unrelatedIp));
        
        Session_Problem sp1 = spList.get(0);
        assertEquals(1, sp1.getId());
        assertEquals(1, sp1.getSession().getId());
        
        Session_Problem sp2 = spList.get(1);
        assertEquals(2, sp2.getId());
        assertEquals(1, sp2.getSession().getId());
    }

    /**
     * Test of getSession_ProblemsByProblem method, of class Session_ProblemDao.
     */
    @Test
    @Transactional
    public void testGetSession_ProblemsByProblem() {
        Problem problem = helper.insertTwoSession_ProblemsSharingSameProblem();
        Session_Problem unrelatedIp = helper.insertASession_Problem();
        List<Session_Problem> spList = spDao.getSession_ProblemsByProblem(problem);
        
        assertEquals(2, spList.size());
        assertFalse(spList.contains(unrelatedIp));
        
        Session_Problem sp1 = spList.get(0);
        assertEquals(1, sp1.getId());
        assertEquals(1, sp1.getProblem().getId());
        
        Session_Problem sp2 = spList.get(1);
        assertEquals(2, sp2.getId());
        assertEquals(1, sp2.getProblem().getId());
    } 
}
