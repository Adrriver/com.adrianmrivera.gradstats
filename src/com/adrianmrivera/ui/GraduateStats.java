/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.ui;

import com.adrianmrivera.model.*;
import java.awt.Font;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;
/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStats extends Application {

    final StageStyle style;
    private HashMap<Integer, TableColumn> columns;
    private TableView<ObjectValue> table;
    private static boolean dataTabInit, dataTabDone;
    private Variable variable;
            
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

    Node createTableView(){
       
      if(dataTabDone == false){
        
        table = new TableView<>(gradStatsModel.getDataValues());           
        table.setId("dataTable");
        
        if(dataTabInit == false){
            TableColumn rowCol = new TableColumn<>("Observation");
            rowCol.setId("Observations");
            rowCol.setPrefWidth(100);  
            rowCol.setEditable(false);  
            rowCol.setCellValueFactory(new PropertyValueFactory<>("valueMain"));
            rowCol.setCellFactory(TextFieldTableCell.forTableColumn());
            table.getColumns().add(rowCol);
            dataTabInit = true;
        }
         final Callback<TableColumn<ObjectValue, String>, TableCell<ObjectValue, String>> cellFactory = new DragSelectionCellFactory();  
        for(int i = 1; i <= 50; i++){
            TableColumn<ObjectValue, String> col = new TableColumn<>("Variable " + i);
          
            columns.put(i, col);
            columns.get(i).setPrefWidth(75);  
            
            columns.get(i).setCellValueFactory(new PropertyValueFactory<>("valueMain"));
            columns.get(i).setCellFactory(cellFactory);
            columns.get(i).setOnEditCommit(
                    new EventHandler<CellEditEvent<ObjectValue, String>>() {
                        @Override
                        public void handle(CellEditEvent<ObjectValue, String> t) {
                            ((ObjectValue) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                                    ).setValue(t.getNewValue());
                            
                        }
                    });
            table.getColumns().add(columns.get(i));
            
        }
        
        table.setMaxSize(1187.0, 500);
        table.setMinSize(1187.0, 500);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().setCellSelectionEnabled(true);        
        table.setEditable(true);
            dataTabDone = true;
            return table;
            
      // Create variable control tableview
      } else {
          
          ObservableList ol = FXCollections.observableArrayList();
          variable = new Variable("Name", ol , "Values", ol, ol);
          TableView varTable = new TableView(gradStatsModel.getVarAttributes(variable));
          
          TableColumn<Variable, String> nameColumn = new TableColumn<>("Var Name");
          
          nameColumn.setResizable(false);
          nameColumn.setCellValueFactory(new PropertyValueFactory<>("varName"));
          nameColumn.setPrefWidth(100);     
          nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
          nameColumn.setOnEditCommit((CellEditEvent<Variable, String> t) -> {
              ((Variable) t.getTableView().getItems().get(
                      t.getTablePosition().getRow())
                      ).setValue(t.getNewValue());
          });
//          
          TableColumn<ObservableList, String> typeColumn = new TableColumn<>("Type");
          typeColumn.setResizable(false);
          typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
          typeColumn.setPrefWidth(100); 
          typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), variable.getTypes()));
          typeColumn.setOnEditCommit((CellEditEvent<ObservableList, String> t) -> {
              ((Variable) t.getTableView().getItems().get(
                      t.getTablePosition().getRow())
                      ).setValue(t.getNewValue());
     
          });
          
          
          
          TableColumn<Variable, String> valsColumn = new TableColumn("Values");
          valsColumn.setResizable(false);
          valsColumn.setCellValueFactory(new PropertyValueFactory("values"));
          valsColumn.setPrefWidth(100);     
           valsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            /*labelColumn.setOnEditCommit(
                    new EventHandler<CellEditEvent<String, String>>() {
                        @Override
                        public void handle(CellEditEvent<String, String> t) {
                            ((String) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                                    ).setValue(t.getNewValue());
                        }
                    });*/
                  
           
          TableColumn<ObservableList, String> measuresColumn = new TableColumn<>("Measure");  
          measuresColumn.setResizable(false);
          measuresColumn.setCellValueFactory(new PropertyValueFactory<>("measures"));
          measuresColumn.setPrefWidth(100);        
           measuresColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), variable.getMeasType()));
            measuresColumn.setOnEditCommit((CellEditEvent<ObservableList, String> t) -> {
                ((Variable) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setValue(t.getNewValue());
          }); 
            
          TableColumn<ObservableList, String> rolesColumn = new TableColumn<>("Role");  
          rolesColumn.setResizable(false);
          rolesColumn.setCellValueFactory(new PropertyValueFactory<>("roles"));
          rolesColumn.setPrefWidth(100);        
        /*  rolesColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), variable.getRoles()));
          rolesColumn.setOnEditCommit((CellEditEvent<ObservableList, String> t) -> {
              ((Variable) t.getTableView().getItems().get(
                      t.getTablePosition().getRow())
                      ).setValue(t.getNewValue());
     
          });*/
          
          
          Clipboard clipboard = Clipboard.getSystemClipboard();
          
          varTable.getColumns().addAll(nameColumn, typeColumn, valsColumn, measuresColumn, rolesColumn );
          varTable.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
              // this method will be called whenever user selected row
            @Override
             public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               Variable selectedUser = (Variable)newValue;
             ClipboardContent content = new ClipboardContent();
                 // make sure you override toString in UserClass
             content.putString(selectedUser.toString());
             System.out.println("Content contains " + selectedUser);
             clipboard.setContent(content); 
             System.out.println("clipboard.getString() returns " + clipboard.getString());
             
                     
                    
            }
            });
          
              varTable.setMaxSize(1187.0, 500);
              varTable.setMinSize(1187.0, 500);
              varTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
              varTable.getSelectionModel().setCellSelectionEnabled(true);            
              varTable.setFocusTraversable(true);
              varTable.setEditable(true);
               
                return varTable;
        
            
      }        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);   
        
       
    }

    
    
    
    

}


