/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Problem;
import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.dto.Session_Problem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matt
 */
public class Session_ProblemDaoImpl implements Session_ProblemDao {

    private static String SQL_GET_SESSION_PROBLEM_BY_SESSION_AND_PROBLEM = "SELECT * FROM Session_Problem WHERE sessionId = ? AND problemId = ?";
    private static String SQL_INSERT_SESSION_PROBLEM = "INSERT INTO Session_Problem (sessionId, problemId) VALUES (?, ?)";
    private static String SQL_GET_SESSION_PROBLEM_BY_ID = "SELECT * FROM Session_Problem WHERE id = ?";
    private static String SQL_DELETE_SESSION_PROBLEM = "DELETE FROM Session_Problem WHERE id = ?";
    private static String SQL_GET_ALL_SESSION_PROBLEMS = "SELECT * FROM Session_Problem ORDER BY id LIMIT ?, ?";
    
    @Override
    public Session_Problem insertSession_Problem(Session_Problem session_problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session_Problem getSession_ProblemById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Session_Problem> getAllSession_Problems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSession_Problem(Session_Problem session_problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSession_Problem(Session_Problem session_problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Session_Problem> getSession_ProblemsBySession(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Session_Problem> getSession_ProblemsByProblem(Problem problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class SessionProblemMapper implements RowMapper<Session_Problem> {

        @Override
        public Session_Problem mapRow(ResultSet rs, int i) throws SQLException {
            Session_Problem session_problem = new Session_Problem();
            session_problem.setId(rs.getInt("id"));

            // Lazy load superperson
            Session session = new Session();
            session.setId(rs.getInt("session_id"));
            session_problem.setSession(session);

            // Lazy load problem
            Problem problem = new Problem();
            problem.setId(rs.getInt("problem_id"));
            session_problem.setProblem(problem);

            return session_problem;
        }
    }

}
