/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Problem;
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
public class ProblemDaoTest {
    @Inject
    private ApplicationContext ctx;
    
    @Inject
    ProblemDao dao;
    public ProblemDaoTest() {
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

    
    public Problem makeProblemAndSetFields(String name, String description){
        Problem problem = new Problem();
        problem.setName(name);
        problem.setDescription(description);
        
        return problem;
    }
    
    public Problem makeProblemAndSetFields(){
        Problem problem = new Problem();
        problem.setName("too many lawyers in my town");
        problem.setDescription("the census in my town revealed that the excess of"
                + "lawyers in my town is leading to unemployment");
        
        return problem;
    }
    
    
    
    /**
     * Test of insertProblem method, of class ProblemDao.
     */
    @Test
    @Transactional
    public void testInsertProblem() {
        Problem problem = makeProblemAndSetFields();
        //add
        dao.insertProblem(problem);
        //get
        Problem fromDao = dao.getProblemById(problem.getId());
        assertEquals("too many lawyers in my town", fromDao.getName());
        assertEquals("the census in my town revealed that the excess of"
                + "lawyers in my town is leading to unemployment", fromDao.getDescription());
    }

    /**
     * Test of getProblemById method, of class ProblemDao.
     */
    @Test
    @Transactional
    public void testGetProblemById() {
           Problem problem = makeProblemAndSetFields();
        //add
        dao.insertProblem(problem);
        //get
        Problem fromDao = dao.getProblemById(problem.getId());
        assertEquals("too many lawyers in my town", fromDao.getName());
        assertEquals("the census in my town revealed that the excess of"
                + "lawyers in my town is leading to unemployment", fromDao.getDescription());
    
    }

    /**
     * Test of getAllProblems method, of class ProblemDao.
     */
    @Test
    @Transactional
    public void testGetAllProblems() {
        Problem problem1 = makeProblemAndSetFields();
        Problem problem2 = makeProblemAndSetFields("abc", null);
        
        dao.insertProblem(problem1);
        dao.insertProblem(problem2);
        
        List<Problem> allProblems = dao.getAllProblems();
        int problemCount = allProblems.size();
        
        assertEquals(7, problemCount);
        Problem problem1FromDao = dao.getProblemById(problem1.getId());
        Problem problem2FromDao = dao.getProblemById(problem2.getId());
        
        assertEquals("too many lawyers in my town", problem1FromDao.getName());
        assertEquals("the census in my town revealed that the excess of"
                + "lawyers in my town is leading to unemployment", problem1FromDao.getDescription());
        
        assertEquals("abc", problem2FromDao.getName());
        assertNull(problem2FromDao.getDescription());
        
    }

    /**
     * Test of removeProblem method, of class ProblemDao.
     */
    @Test
    @Transactional
    public void testRemoveProblem() {
        Problem problem = makeProblemAndSetFields();
        //add
        dao.insertProblem(problem);
        //get
        Problem fromDao = dao.getProblemById(problem.getId());
        
        //delete
        dao.removeProblem(fromDao);
        assertNull(dao.getProblemById(fromDao.getId()));
    
    }

    /**
     * Test of updateProblem method, of class ProblemDao.
     */
    @Test
    @Transactional
    public void testUpdateProblem() {
        Problem problem = makeProblemAndSetFields();
        dao.insertProblem(problem);
        Problem problemFromDao = dao.getProblemById(problem.getId());
        String newName = "abc";
        String newDescription = "xyz";
        
        problemFromDao.setName(newName);
        problemFromDao.setDescription(newDescription);
        
        dao.updateProblem(problemFromDao);
        
        Problem updatedProblemFromDao = dao.getProblemById(problem.getId());
        
        assertEquals("abc", updatedProblemFromDao.getName());
        assertEquals("xyz", updatedProblemFromDao.getDescription());
    }
    
}
