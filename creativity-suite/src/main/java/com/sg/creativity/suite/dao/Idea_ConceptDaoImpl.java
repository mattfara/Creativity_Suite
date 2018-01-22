/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Concept;
import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Concept;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matt
 */
public class Idea_ConceptDaoImpl implements Idea_ConceptDao {

    private static String SQL_GET_IDEA_CONCEPT_BY_IDEA_AND_CONCEPT = "SELECT * FROM Idea_Concept WHERE IdeaId = ? AND ConceptId = ?";
    private static String SQL_INSERT_IDEA_CONCEPT = "INSERT INTO Idea_Concept (IdeaId, ConceptId) VALUES (?, ?)";
    private static String SQL_GET_IDEA_CONCEPT = "SELECT * FROM Idea_Concept WHERE Idea_ConceptId = ?";
    private static String SQL_DELETE_IDEA_CONCEPT = "DELETE FROM Idea_Concept WHERE Idea_ConceptId = ?";
    private static String SQL_LIST_IDEA_CONCEPTS = "SELECT * FROM Idea_Concept LIMIT ?, ?";

    
    @Override
    public Idea_Concept insertIdea_Concept(Idea_Concept idea_concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Idea_Concept getIdea_ConceptById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Concept> getAllIdea_Concepts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIdea_Concept(Idea_Concept idea_concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateIdea_Concept(Idea_Concept idea_concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Concept> getIdea_ConceptsByIdea(Idea idea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Concept> getIdea_ConceptsByConcept(Concept concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class IdeaConceptMapper implements RowMapper<Idea_Concept> {

        @Override
        public Idea_Concept mapRow(ResultSet rs, int i) throws SQLException {
            Idea_Concept idea_concept = new Idea_Concept();
            idea_concept.setId(rs.getInt("id"));

            
            Idea idea = new Idea();
            idea.setId(rs.getInt("idea_id"));
            idea_concept.setIdea(idea);
            
            Concept concept = new Concept();
            concept.setId(rs.getInt("concept_id"));
            idea_concept.setConcept(concept);

            return idea_concept;
        }
    }

    
}
