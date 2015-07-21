/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.collections.*;
/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStatsModel {
    
    public ObservableList getDataValues() {
        ObservableList dataValues = FXCollections.observableArrayList();
        for(int i = 1; i <=1000; i++){
            dataValues.add(0.00);
        }
        
        return dataValues;
    }
    
}
