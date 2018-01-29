/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

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
public class ProblemDaoImpl implements ProblemDao{

    private final String SQL_INSERT_PROBLEM
            = "INSERT INTO Problems (name, description) VALUES(?, ?);";

    private final String SQL_GET_PROBLEM_BY_ID
            = "SELECT * FROM Problems WHERE id = ?";

    private final String SQL_GET_ALL_PROBLEMS
            = "SELECT * FROM Problems ORDER BY id LIMIT ?, ?";

    private final String SQL_REMOVE_PROBLEM
            = "DELETE FROM Problems WHERE id = ?";

    private final String SQL_UPDATE_PROBLEM
            = "UPDATE Problems SET name = ?, description = ? WHERE id = ?";

    
    @Override
    public Problem insertProblem(Problem concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Problem getProblemById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Problem> getAllProblems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeProblem(Problem concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProblem(Problem concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class ProblemMapper
	    implements RowMapper<Problem> {

	@Override
	public Problem mapRow(ResultSet rs, int i)
		throws SQLException {
	    Problem problem = new Problem();

            problem.setId(rs.getInt("id"));
            problem.setName(rs.getString("name"));
            problem.setDescription(rs.getString("description"));
            
	    return problem;
	}
    }
    
}
