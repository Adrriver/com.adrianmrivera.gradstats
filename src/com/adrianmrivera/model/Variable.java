/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.model;

import javafx.beans.property.*;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 *
 * @author Adrian_and_Alanna
 */
public class Variable {
    
    private StringProperty varName;
    private ComboBox type;
    private StringProperty label;
    private StringProperty values;
    private ComboBox measures;
    private ComboBox role;
    
    public Variable(String vName, ComboBox tp, String lbl, String vals,
            ComboBox msr, ComboBox rl) {
        
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
    public void setVarType(ComboBox cMenu){
        setVarTypeList(cMenu);
    }
    public Node getTypes(){
        return type;
    }
    public Node setVarTypeList(Node cMenu){
        if( type != null){            
            type = new ComboBox<>();
            type.getItems().addAll("A","B","C","D","E");
    type.setCellFactory(
        new Callback<ListView<String>, ListCell<String>>() {
            @Override 
                public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    {
                        super.setPrefWidth(100);
                    }    
                    @Override public void updateItem(String item, 
                        boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null) {
                                setText(item);    
                                if (item.contains("A")) {                                    
                                    setTextFill(Color.RED);
                                }
                                else if (item.contains("B")){
                                    setTextFill(Color.GREEN);
                                }
                                else {
                                    setTextFill(Color.BLACK);
                                }
                            }
                            else {
                                setText(null);
                            }
                        }
            };
            return cell;
            }
           
        });
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
    public void setMeasType(Node msr){
        setMeasureList(msr);
    }
    public Node getMeasType(){
        return measures;
    }
    public Node setMeasureList(Node msr){
        if( measures == null){
            ComboBox<Label> msrs = new ComboBox<>();
            msrs.getItems().addAll(new Label("Ordinal"), new Label("Inverval/Scale"), new Label("Nominal"));
            measures = msrs;
        }
        return measures;
    }
    //roles
    public void setRoles(ComboBox roleBox){
        setRoleList(roleBox);
    }
   
    public Node setRoleList(Node roleBox){
        if( role == null){
            ComboBox<Label> rb = new ComboBox<>();
            rb.getItems().addAll(new Label("Input"), new Label("Inverval/Scale"), new Label("Nominal"));
            role = rb;
        }
        return role;
    }
}

  