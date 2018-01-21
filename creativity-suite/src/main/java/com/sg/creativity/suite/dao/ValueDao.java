/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.creativity.suite.dao;

import com.sg.creativity.suite.dto.Value;
import java.util.List;

/**
 *
 * @author matt
 */
public interface ValueDao {
    public Value insertValue(Value concept);
    public Value getValueById(int id);
    public List<Value> getAllValues();
    public void removeValue(Value concept);
    public void updateValue(Value concept);
}
