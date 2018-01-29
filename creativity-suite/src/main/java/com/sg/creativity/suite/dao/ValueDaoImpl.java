/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

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
public class ValueDaoImpl implements ValueDao {

    private final String SQL_INSERT_VALUE
            = "INSERT INTO Values (name, description) VALUES(?, ?);";

    private final String SQL_GET_VALUE_BY_ID
            = "SELECT * FROM Values WHERE id = ?";

    private final String SQL_GET_ALL_VALUES
            = "SELECT * FROM Values ORDER BY id LIMIT ?, ?";

    private final String SQL_REMOVE_VALUE
            = "DELETE FROM Values WHERE id = ?";

    private final String SQL_UPDATE_VALUE
            = "UPDATE Values SET name = ?, description = ? WHERE id = ?";

    
    @Override
    public Value insertValue(Value concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Value getValueById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Value> getAllValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeValue(Value concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateValue(Value concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class ValueMapper
	    implements RowMapper<Value> {

	@Override
	public Value mapRow(ResultSet rs, int i)
		throws SQLException {
	    Value value = new Value();

            value.setId(rs.getInt("id"));
            value.setName(rs.getString("name"));
            value.setDescription(rs.getString("description"));
            
	    return value;
	}
    }

    
}
