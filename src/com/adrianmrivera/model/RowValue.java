/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Adrian_and_Alanna
 */
public class RowValue {
    
    private IntegerProperty rowVal;
    
    public RowValue(Integer value){
        setRowValue(value);
    }
    
    public IntegerProperty rowValueProperty(){
        if(rowVal == null)
            rowVal = new SimpleIntegerProperty(0);
            
           return rowVal;
    }
    
    public final void setRowValue(Integer val){
        rowValueProperty().set(val);
    }
    
}
