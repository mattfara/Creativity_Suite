/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import com.sg.creativity.suite.dto.Idea_Value;
import com.sg.creativity.suite.dto.Value;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matt
 */
public class Idea_ValueDaoImpl implements Idea_ValueDao{

    private static String SQL_GET_IDEA_VALUE_BY_IDEA_AND_VALUE = "SELECT * FROM Idea_Value WHERE ideaId = ? AND valueId = ?";
    private static String SQL_INSERT_IDEA_VALUE = "INSERT INTO Idea_Value (ideaId, valueId) VALUES (?, ?)";
    private static String SQL_GET_IDEA_VALUE_BY_ID = "SELECT * FROM Idea_Value WHERE id = ?";
    private static String SQL_DELETE_IDEA_VALUE = "DELETE FROM Idea_Value WHERE id = ?";
    private static String SQL_GET_ALL_IDEA_VALUES = "SELECT * FROM Idea_Value ORDER BY id LIMIT ?, ?";

    @Override
    public Idea_Value insertIdea_Value(Idea_Value idea_value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Idea_Value getIdea_ValueById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Value> getAllIdea_Values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIdea_Value(Idea_Value idea_value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateIdea_Value(Idea_Value idea_value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Value> getIdea_ValuesByIdea(Idea idea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idea_Value> getIdea_ValuesByValue(Value value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class IdeaValueMapper implements RowMapper<Idea_Value> {

        @Override
        public Idea_Value mapRow(ResultSet rs, int i) throws SQLException {
            Idea_Value idea_value = new Idea_Value();
            idea_value.setId(rs.getInt("id"));

            // Lazy load superperson
            Idea idea = new Idea();
            idea.setId(rs.getInt("idea_id"));
            idea_value.setIdea(idea);

            // Lazy load value
            Value value = new Value();
            value.setId(rs.getInt("value_id"));
            idea_value.setValue(value);

            return idea_value;
        }
    }
    
}
