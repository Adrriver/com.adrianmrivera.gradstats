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
    private DoubleProperty valueMain;
    
    public DoubleValue(Double value){
        setValue(value);
    }
    
    public DoubleProperty valueProperty(){
        if(valueMain == null)
            valueMain = new SimpleDoubleProperty(0.00);
            
           return valueMain;
    }
    
    public final void setValue(Double val){
        valueProperty().set(val);
    }

}
