/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.ui;

import com.adrianmrivera.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import java.util.*;
import javafx.collections.ObservableList;
/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStats extends Application {

    final StageStyle style;
    private HashMap<Integer, TableColumn> columns;
    private TableView<Double> table;
    private boolean dataTabInit;
            
            
    GraduateStatsModel gradStatsModel = new GraduateStatsModel();
    
    public GraduateStats() {
        this.style = StageStyle.UNDECORATED;
        columns = new HashMap(50);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = fxmlLoader.load();
        
        final FXMLDocumentController controller = fxmlLoader.getController();
        
        // insert TableView into each of the two main Panes
        controller.getDataTab().setContent(new ScrollPane(createTableView()));
        controller.getVarTab().setContent(new ScrollPane(createTableView()));
        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        
        
        stage.setScene(scene);
        stage.setTitle("Graduate Stats");
        
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    Node createTableView(){
        table = new TableView<>();
        ObservableList<Double> doubleList = gradStatsModel.getDataValues();     
        table.setItems(doubleList);
            
        if(dataTabInit == false){
            TableColumn rowCol = new TableColumn("n");
            rowCol.setPrefWidth(50);  
            rowCol.setEditable(false);
            table.getColumns().add(rowCol);
            dataTabInit = true;
        }
        
        for(int i = 0; i < 50; i++){
            TableColumn<String,Double> col = new TableColumn<String,Double>();
          
            columns.put(i, col);
            columns.get(i).setPrefWidth(75);  
            columns.get(i).setEditable(true);
            table.getColumns().add(columns.get(i));
            
        }
        table.setMaxSize(1187.0, 500);
        table.setMinSize(1187.0, 500);
        
        return table;
    }
    
}
