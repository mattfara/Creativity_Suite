/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Session;
import java.util.List;

/**
 *
 * @author matt
 */
public interface SessionDao {
    public Session insertSession(Session concept);

    public Session getSessionById(int id);

    public List<Session> getAllSessions();

    public void removeSession(Session concept);

    public void updateSession(Session concept);
    
}
