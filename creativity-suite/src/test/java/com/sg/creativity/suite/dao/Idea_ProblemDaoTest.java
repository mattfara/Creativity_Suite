/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Problem;
import com.sg.creativity.suite.dto.Problem;
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
public class Idea_ProblemDaoTest {
    
    @Inject private IdeaDao ideaDao;
    @Inject private ProblemDao problemDao;
    @Inject private Idea_ProblemDao ipDao;
    
    private DaoTestHelper helper = new DaoTestHelper();
    
    public Idea_ProblemDaoTest() {
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
     * Test of insertIdea_Problem method, of class Idea_ProblemDao.
     */
    @Test
    public void testInsertIdea_Problem() {
        helper.insertAnIdea_Problem();
    }
    
    /**
     * Test of getIdea_ProblemById method, of class Idea_ProblemDao.
     */
    @Test
    public void testGetIdea_ProblemById() {
        helper.insertAnIdea_Problem();
        Idea_Problem ip = ipDao.getIdea_ProblemById(1);
        
        assertNotNull(ip.getId());
        assertEquals(1, ip.getIdea().getId());
        assertEquals(1, ip.getProblem().getId());
    }
    
    //TODO: change to IdNotFoundException after discovering proper exception and making new exception class
    @Test(expected=Exception.class)
    public void testGetIdea_ProblemByNonExistentId() {
        ipDao.getIdea_ProblemById(22);
    }
    
    /**
     * Test of getAllIdea_Problems method, of class Idea_ProblemDao.
     */
    @Test
    public void testGetAllIdea_ProblemsWhenNoIdea_ProblemsInDB() {
        int ipCountBeforeInsertions = ipDao.getAllIdea_Problems().size();
        assertNotNull(ipCountBeforeInsertions);
        assertEquals(0, ipCountBeforeInsertions);
    }

    /**
     * Test of getAllIdea_Problems method, of class Idea_ProblemDao.
     */
    @Test
    public void testGetAllIdea_Problems() {
        helper.insertAnIdea_Problem();
        helper.insertAnIdea_Problem();
        
        List<Idea_Problem> allIdea_Problems = ipDao.getAllIdea_Problems();
        assertEquals(2, allIdea_Problems.size());
        assertEquals(1, allIdea_Problems.get(0).getId());
        assertEquals(2, allIdea_Problems.get(1).getId());
    }
    
    
    /**
     * Test of removeIdea_Problem method, of class Idea_ProblemDao.
     */
    @Test
    @Transactional
    public void testRemoveIdea_Problem() {
        Idea_Problem ip = helper.insertAnIdea_Problem();
        ipDao.removeIdea_Problem(ip);
        assertNull(ipDao.getIdea_ProblemById(ip.getId()));
    }
    
    /**
     * Test of getIdea_ProblemsByIdea method, of class Idea_ProblemDao.
     */
    @Test
    @Transactional
    public void testGetIdea_ProblemsByIdea() {
        Idea idea = helper.insertTwoIdea_ProblemsSharingSameIdea();
        Idea_Problem unrelatedIp = helper.insertAnIdea_Problem();
        List<Idea_Problem> ipList = ipDao.getIdea_ProblemsByIdea(idea);
        
        assertEquals(2, ipList.size());
        assertFalse(ipList.contains(unrelatedIp));
        
        Idea_Problem ip1 = ipList.get(0);
        assertEquals(1, ip1.getId());
        assertEquals(1, ip1.getIdea().getId());
        
        Idea_Problem ip2 = ipList.get(1);
        assertEquals(2, ip2.getId());
        assertEquals(1, ip2.getIdea().getId());
    }

    /**
     * Test of getIdea_ProblemsByProblem method, of class Idea_ProblemDao.
     */
    @Test
    @Transactional
    public void testGetIdea_ProblemsByProblem() {
        Problem problem = helper.insertTwoIdea_ProblemsSharingSameProblem();
        Idea_Problem unrelatedIp = helper.insertAnIdea_Problem();
        List<Idea_Problem> ipList = ipDao.getIdea_ProblemsByProblem(problem);
        
        assertEquals(2, ipList.size());
        assertFalse(ipList.contains(unrelatedIp));
        
        Idea_Problem ip1 = ipList.get(0);
        assertEquals(1, ip1.getId());
        assertEquals(1, ip1.getProblem().getId());
        
        Idea_Problem ip2 = ipList.get(1);
        assertEquals(2, ip2.getId());
        assertEquals(1, ip2.getProblem().getId());
    } 
}
