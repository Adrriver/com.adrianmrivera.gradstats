/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.collections.*;
import javafx.collections.ObservableList;

/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStatsModel {      
    
     final public ObservableList<Variable> getVarAttributes(Variable var) {
        ObservableList attributes = FXCollections.observableArrayList();
        for(int i = 1; i <=1000; i++){
            
            attributes.add(var);
        }
        
        return attributes;
    }
    
    final public ObservableList<ObjectValue> getDataValues() {
        ObservableList dataValues = FXCollections.observableArrayList();
        for(int i = 1; i <=1000; i++){
            dataValues.add(new ObjectValue("."));
        }
        
        return dataValues;
    }

    
    
}

