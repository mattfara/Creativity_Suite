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

/**
 *
 * @author matt
 */
public interface Session_ProblemDao {
    public Session_Problem insertSession_Problem(Session_Problem session_problem);
    public Session_Problem getSession_ProblemById(int id);
    public List<Session_Problem> getAllSession_Problems();
    public void removeSession_Problem(Session_Problem session_problem);
    public void updateSession_Problem(Session_Problem session_problem);
    public List<Session_Problem> getSession_ProblemsBySession(Session session);
    public List<Session_Problem> getSession_ProblemsByProblem(Problem problem);
}
