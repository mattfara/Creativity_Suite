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

/**
 *
 * @author matt
 */
public interface Idea_ProblemDao {
    public Idea_Problem insertIdea_Problem(Idea_Problem idea_problem);
    public Idea_Problem getIdea_ProblemById(int id);
    public List<Idea_Problem> getAllIdea_Problems();
    public void removeIdea_Problem(Idea_Problem idea_problem);
    public void updateIdea_Problem(Idea_Problem idea_problem);
    public List<Idea_Problem> getIdea_ProblemsByIdea(Idea idea);
    public List<Idea_Problem> getIdea_ProblemsByProblem(Problem problem);
}
