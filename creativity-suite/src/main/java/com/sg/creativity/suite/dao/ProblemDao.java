/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Problem;
import java.util.List;

/**
 *
 * @author matt
 */
public interface ProblemDao {
    public Problem insertProblem(Problem concept);

    public Problem getProblemById(int id);

    public List<Problem> getAllProblems();

    public void removeProblem(Problem concept);

    public void updateProblem(Problem concept);
    
}
