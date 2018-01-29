/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Problem;
import com.sg.creativity.suite.dto.Session;
import com.sg.creativity.suite.dto.Value;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author matt
 */
public class ConceptDaoImpl implements ConceptDao {

    private final String SQL_INSERT_CONCEPT
            = "INSERT INTO Concepts (name, description) VALUES(?, ?);";

    private final String SQL_GET_CONCEPT_BY_ID
            = "SELECT * FROM Concepts WHERE id = ?";

    private final String SQL_GET_ALL_CONCEPTS
            = "SELECT * FROM Concepts ORDER BY id LIMIT ?, ?";

    private final String SQL_REMOVE_CONCEPT
            = "DELETE FROM Concepts WHERE id = ?";

    private final String SQL_UPDATE_CONCEPT
            = "UPDATE Concepts SET name = ?, description = ? WHERE id = ?";

    
    
    @Override
    public Concept insertConcept(Concept concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concept getConceptById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concept> getAllConcepts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeConcept(Concept concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateConcept(Concept concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class ConceptMapper
	    implements RowMapper<Concept> {

	@Override
	public Concept mapRow(ResultSet rs, int i)
		throws SQLException {
	    Concept concept = new Concept();

            concept.setId(rs.getInt("id"));
            concept.setName(rs.getString("name"));
            concept.setDescription(rs.getString("description"));
            
	    return concept;
	}
    }
    
}
