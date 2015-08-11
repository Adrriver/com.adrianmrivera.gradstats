/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Adrian_and_Alanna
 */
public class Variable {
    
    private SimpleStringProperty varName;
    private ObservableList type;
    private SimpleStringProperty values;
    private ObservableList measures;
    private ListProperty<ObservableList> roles;
    private boolean initialized;
    
    public Variable(String vName, ObservableList tp, String vals,
            ObservableList msr, ObservableList rl) {
        
                setVarName(vName); 
                setVarType(tp);
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
    public SimpleStringProperty varNameProp() {
        
        if( varName == null)
            varName = new SimpleStringProperty("");
        
        return varName;
    }
     //type
    public void setVarType(ObservableList typeList){
        
        setVarTypeList(typeList);
    }
    public ObservableList getTypes(){
        return type;
    }
    public ObservableList setVarTypeList(ObservableList typeList){
            
                
        if( type == null && !initialized){   
            typeList = FXCollections.observableArrayList(
            "Numeric",
            "Currency",
            "Scientific Notation");
        
            type = typeList; 
            System.out.println("Contents of Type: " + type);
            } else {
                type = typeList;
            }
        initialized = true;
        System.out.println("Contents of Type: " + type);
        return type;
    }
    
    
    //value 
    public void setValue(String values){
      valuesProp().set(values);  
    }
    public String getValues(){
        return valuesProp().get();
    }
    public SimpleStringProperty valuesProp() {
        
        if( this.values == null)
            this.values = new SimpleStringProperty(this, "Values");
            
        return values;
    
    }
     //measure
    public void setMeasType(ObservableList measList){
        setMeasureList(measList);
    }
    public ObservableList getMeasType(){
        return measures;
    }
    public ObservableList setMeasureList(ObservableList measLst){
        measLst = FXCollections.observableArrayList(
            "Scale",
                "Ordinal",
                    "Nominal");
        
        if( measures == null){
            measures = measLst;
        }
        return measures;
    }
    //roles
    public void setRoles(ObservableList<ObservableList> roleList){
        setRolesList().set(roleList);
    }
    public ObservableList<ObservableList> getRoles(){
        return setRolesList().get();
    }
    public ListProperty<ObservableList> setRolesList(){
       if( roles == null ) {   
            roles = new SimpleListProperty(FXCollections.observableArrayList(
            "Input",
            "Output"));
        
       }
               
        return this.roles;
    }
}

  