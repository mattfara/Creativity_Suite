/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author matt
 */
public class SessionDaoImpl implements SessionDao {
    private final String SQL_INSERT_SESSION
            = "INSERT INTO Sessions (date, start_time, end_time, hat_sequence) VALUES(?, ?, ?, ?);";

    private final String SQL_GET_SESSION_BY_ID
            = "SELECT * FROM Sessions WHERE id = ?";

    private final String SQL_GET_ALL_SESSIONS
            = "SELECT * FROM Sessions";

    private final String SQL_REMOVE_SESSION
            = "DELETE FROM Sessions WHERE id = ?";

    private final String SQL_UPDATE_SESSION
            = "UPDATE Sessions SET date = ?, start_time = ?, end_time = ?, hat_sequence = ? WHERE id = ?";

    
    @Override
    public Session insertSession(Session concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Session getSessionById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Session> getAllSessions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSession(Session concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSession(Session concept) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class SessionMapper
	    implements RowMapper<Session> {

	@Override
	public Session mapRow(ResultSet rs, int i)
		throws SQLException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM:SS");
            //formatter for MySQL Time?
            
	    Session session = new Session();

            session.setId(rs.getInt("id"));
            
            java.sql.Date dbSqlDate = rs.getDate("date");
            session.setDate(dbSqlDate.toLocalDate());
   
            session.setStart_time(LocalTime.parse(rs.getTime("start_time").toString()));
            session.setEnd_time(LocalTime.parse(rs.getTime("end_time").toString()));
            session.setHat_sequence(rs.getString("hat_sequence"));
	    return session;
	}
    }
    
    
}
