/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.beans.property.*;

/**
 *
 * @author Adrian_and_Alanna
 */
public class ObjectValue {
    private ObjectProperty valueMain;
    
    public ObjectValue(Object value){
        setValue(value);
    }
    
    public ObjectProperty valueProperty(){
        if(valueMain == null)
            valueMain = new SimpleObjectProperty((Double)0.00);
            
           return valueMain;
    }
    
    public final void setValue(Object val){
        valueProperty().set(val);
    }
    public Object getValue(){
        return valueProperty().get();
    }

}
