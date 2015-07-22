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
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStats extends Application {

    final StageStyle style;
    private HashMap<Integer, TableColumn> columns;
    private TableView<DoubleValue> table;
    private static boolean dataTabInit, dataTabDone;
            
            
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
        stage.setResizable(false);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    Node createTableView(){
       
      if(dataTabDone == false){
        
        table = new TableView<>(gradStatsModel.getDataValues());           
        
        if(dataTabInit == false){
            TableColumn rowCol = new TableColumn<>("n");
            rowCol.setPrefWidth(50);  
            rowCol.setEditable(false);  
            rowCol.setCellValueFactory(new PropertyValueFactory<>("valueMain"));
            rowCol.setCellFactory(TextFieldTableCell.forTableColumn());
            table.getColumns().add(rowCol);
            dataTabInit = true;
        }
        
        for(int i = 1; i <= 50; i++){
            TableColumn<DoubleValue, String> col = new TableColumn<>("Variable " + i);
          
            columns.put(i, col);
            columns.get(i).setPrefWidth(75);  
            
            columns.get(i).setCellValueFactory(new PropertyValueFactory<>("valueMain"));
            columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
            columns.get(i).setOnEditCommit(
                    new EventHandler<CellEditEvent<DoubleValue, String>>() {
                        @Override
                        public void handle(CellEditEvent<DoubleValue, String> t) {
                            ((DoubleValue) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                                    ).setValue(Double.parseDouble(t.getNewValue()));
                        }
                    });
            table.getColumns().add(columns.get(i));
            
        }
        /*table.getSelectionModel().selectedItemProperty().addListener((ObservableValue observable, Object oldValue, Object newValue) -> {
            DoubleValue selectedDouble = (DoubleValue) newValue;
        });*/
        table.setMaxSize(1187.0, 500);
        table.setMinSize(1187.0, 500);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().setCellSelectionEnabled(true);        
        table.setEditable(true);
        
            dataTabDone = true;
      // Create variable control tableview
      } else {
          table = new TableView<>(gradStatsModel.getDataValues());           
        
        if(dataTabInit == false){
            TableColumn rowCol = new TableColumn<>("n");
            rowCol.setPrefWidth(50);  
            rowCol.setEditable(false);  
            rowCol.setCellValueFactory(new PropertyValueFactory<>("valueMain"));
            rowCol.setCellFactory(TextFieldTableCell.forTableColumn());
            table.getColumns().add(rowCol);
            dataTabInit = true;
        }
        
        for(int i = 1; i <= 50; i++){
            TableColumn<DoubleValue, String> col = new TableColumn<>("Variable " + i);
          
            columns.put(i, col);
            columns.get(i).setPrefWidth(75);  
            
            columns.get(i).setCellValueFactory(new PropertyValueFactory<>("valueMain"));
            columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
            columns.get(i).setOnEditCommit(
                    new EventHandler<CellEditEvent<DoubleValue, String>>() {
                        @Override
                        public void handle(CellEditEvent<DoubleValue, String> t) {
                            ((DoubleValue) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                                    ).setValue(Double.parseDouble(t.getNewValue()));
                        }
                    });
            table.getColumns().add(columns.get(i));
            
        }
        /*table.getSelectionModel().selectedItemProperty().addListener((ObservableValue observable, Object oldValue, Object newValue) -> {
            DoubleValue selectedDouble = (DoubleValue) newValue;
        });*/
        table.setMaxSize(1187.0, 500);
        table.setMinSize(1187.0, 500);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().setCellSelectionEnabled(true);        
        table.setEditable(true);
      }
        return table;
    }
    
    public static boolean getDataTabInit(){
        return dataTabInit;
    }

}
