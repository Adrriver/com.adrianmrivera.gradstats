/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Adrian_and_Alanna
 */
public class DoubleValue {
    private DoubleProperty initValue;
    
    public void DoubleValue(Double value){
        setInitValue(value);
    }
    
    public DoubleProperty initValueProperty(){
        if(initValue == null)
            initValue = new SimpleDoubleProperty(0.00);
            
            return initValue;
    }
    
    public void setInitValue(Double val){
        initValueProperty().set(val);
    }
}
