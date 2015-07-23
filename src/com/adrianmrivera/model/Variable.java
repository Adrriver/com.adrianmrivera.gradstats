/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.beans.property.*;

import javafx.collections.*;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Adrian_and_Alanna
 */
public class Variable {
    
    private StringProperty varName;
    private ContextMenu type;
    private StringProperty label;
    private StringProperty values;
    private ContextMenu measures;
    private ContextMenu role;
    
    public Variable(String vName, ContextMenu tp, String lbl, String vals,
            ContextMenu msr, ContextMenu rl) {
        
                setVarName(vName);
                setVarType(tp);
                setLab(lbl);
                setValue(vals);
                setMeasType(msr);
                setRoles(rl);
    }
    //variable name
    public void setVarName(String name){
      varNameProp().set(name);  
    }
    public String getVarName(){
        return varNameProp().get();
    }
    public StringProperty varNameProp() {
        
        if( varName == null)
            varName = new SimpleStringProperty(this, "Name");
        
        return varName;
    }
     //type
    public void setVarType(ContextMenu cMenu){
        varTypeList().set(cMenu);
    }
    public SimpleObjectProperty<ContextMenu> getTypes(){
        return varTypeList().get();
    }
    public SimpleObjectProperty<ContextMenu> varTypeList(){
        if( type == null){            
            SimpleObjectProperty<ContextMenu> cm = new SimpleObjectProperty(new ContextMenu());
            type = cm;
        }
        return type;
    }
    //label
    public void setLab(String label) {
        labelProperty().set(label);
    }
    public String getLab(){
        return labelProperty().get();
    }
    public StringProperty labelProperty(){
        if( label == null)
            label = new SimpleStringProperty(this, "label");
        return label;
    }
    
    //value 
    public void setValue(String name){
      valuesProp().set(name);  
    }
    public String getValues(){
        return valuesProp().get();
    }
    public StringProperty valuesProp() {
        
        if( values == null)
            values = new SimpleStringProperty(this, "Name");
        
        return values;
    }
    
     //measure
    public void setMeasType(int measures, Measure msr){
        measureList().set(measures, msr);
    }
   
    public ObservableList<Measure> measureList(){
        if( measures == null){
            ObservableList<Measure> msrs = FXCollections.observableArrayList();
            measures = msrs;
        }
        return measures;
    }
    //roles
    public void setRoles(int roles, Roles msr){
        roleList().set(roles, msr);
    }
   
    public ObservableList<Roles> roleList(){
        if( role == null){
            ObservableList<Roles> rl = FXCollections.observableArrayList();
            role = rl;
        }
        return role;
    }
}
