/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Idea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author matt
 */
public class IdeaDaoImpl implements IdeaDao{

    private final String SQL_INSERT_IDEA
            = "INSERT INTO Ideas (name, description) VALUES(?, ?);";

    private final String SQL_GET_IDEA_BY_ID
            = "SELECT * FROM Ideas WHERE id = ?";

    private final String SQL_GET_ALL_IDEAS
            = "SELECT * FROM Ideas ORDER BY id LIMIT ?, ?";

    private final String SQL_REMOVE_IDEA
            = "DELETE FROM Ideas WHERE id = ?";

    private final String SQL_UPDATE_IDEA
            = "UPDATE Ideas SET name = ?, description = ? WHERE id = ?";

    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Idea insertIdea(Idea idea) {
        jdbcTemplate.update(SQL_INSERT_IDEA, 
                idea.getName(),
                idea.getDescription());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        idea.setId(id);
        return idea;
    }

    @Override
    public Idea getIdeaById(int id) throws EmptyResultDataAccessException {
        Idea idea = jdbcTemplate.queryForObject(SQL_GET_IDEA_BY_ID, 
                new IdeaMapper(), id);
        return idea;
    }

    @Override
    public List<Idea> getAllIdeas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIdea(Idea concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateIdea(Idea concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class IdeaMapper
	    implements RowMapper<Idea> {

	@Override
	public Idea mapRow(ResultSet rs, int i)
		throws SQLException {
	    Idea idea = new Idea();

            idea.setId(rs.getInt("id"));
            idea.setName(rs.getString("name"));
            String description = rs.getString("description");
            idea.setDescription(rs.wasNull() ? "" : description);
            
	    return idea;
	}
    }
    
}
