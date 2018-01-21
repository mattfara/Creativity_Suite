/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Problem;
import com.sg.creativity.suite.dto.Problem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matt
 */
public class Idea_ProblemDaoImpl implements Idea_ProblemDao {
    private static String SQL_GET_IDEA_PROBLEM_BY_IDEA_AND_PROBLEM = "SELECT * FROM Idea_Problem WHERE IdeaId = ? AND ProblemId = ?";
    private static String SQL_INSERT_IDEA_PROBLEM = "INSERT INTO Idea_Problem (IdeaId, ProblemId) VALUES (?, ?)";
    private static String SQL_GET_IDEA_PROBLEM = "SELECT * FROM Idea_Problem WHERE Idea_ProblemId = ?";
    private static String SQL_DELETE_IDEA_PROBLEM = "DELETE FROM Idea_Problem WHERE Idea_ProblemId = ?";
    private static String SQL_LIST_IDEA_PROBLEMS = "SELECT * FROM Idea_Problem LIMIT ?, ?";

    @Override
    public Idea_Problem insertIdea_Problem(Idea_Problem idea_problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Idea_Problem getIdea_ProblemById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Problem> getAllIdea_Problems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIdea_Problem(Idea_Problem idea_problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateIdea_Problem(Idea_Problem idea_problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Problem> getIdea_ProblemsByIdea(Idea idea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Problem> getIdea_ProblemsByProblem(Problem problem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class IdeaProblemMapper implements RowMapper<Idea_Problem> {

        @Override
        public Idea_Problem mapRow(ResultSet rs, int i) throws SQLException {
            Idea_Problem idea_problem = new Idea_Problem();
            idea_problem.setId(rs.getInt("id"));

            // Lazy load superperson
            Idea idea = new Idea();
            idea.setId(rs.getInt("idea_id"));
            idea_problem.setIdea(idea);

            // Lazy load problem
            Problem problem = new Problem();
            problem.setId(rs.getInt("problem_id"));
            idea_problem.setProblem(problem);

            return idea_problem;
        }
    }

}
