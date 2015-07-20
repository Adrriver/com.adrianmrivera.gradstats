/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera;

import javafx.application.Application;
import javafx.embed.swing.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.*;

/**
 *
 * @author Adrian_and_Alanna
 */ 
     
public class GraduateStats extends Application {
    //fields
    private ScrollPane dataPane = new ScrollPane();  
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        
        stage.setScene(scene);
        stage.setTitle("Graduate Stats");
        stage.show();
    
         final SwingNode swingNode = new SwingNode();

            createSwingContent(swingNode);
            
                                    
            dataPane.setContent(swingNode);
            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void createSwingContent(final SwingNode swingNode) {
        
        TableModel dataModel;
       
        dataModel = new AbstractTableModel(){
            @Override
            public int getColumnCount(){
                return 25;
            }
            @Override
            public int getRowCount(){
                return 200;
            }
            
            @Override
            public Object getValueAt(int row, int col) {
                return col*row;
            }
            public Object getValueAt(double row, double col){
                return (Double)(row*col);
            }
            
        };
        
            JTable dataTable = new JTable(dataModel);
        
                SwingUtilities.invokeLater(() -> {
                   swingNode.setContent(dataTable); 
                });
        
    }
    
}
