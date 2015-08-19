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
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import sun.plugin2.jvm.RemoteJVMLauncher.CallBack;
/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStats extends Application {

    final StageStyle style;
    private HashMap<Integer, TableColumn> columns;
    private TableView<ObjectValue> table;
    private TableView varTable;
    private static boolean dataTabInit, dataTabDone;
    private Variable variable;
    private final ObservableList<Role> roleData 
            = FXCollections.observableArrayList(
                new Role("Input"),
                new Role("Output"));
    boolean toggle = true;
    private final ObservableList typeList = FXCollections.observableArrayList(
            "Numeric",
            "Currency",
            "Scientific Notation");
    private final ObservableList measLst = FXCollections.observableArrayList(
            "Scale",
                "Ordinal",
                    "Nominal");
    private CellEditEvent<Variable, String> varTabRow;
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
            
            columns.get(i).setCellValueFactory(new PropertyValueFactory<>("valueMain" + String.valueOf(i)));
            columns.get(i).setCellFactory(cellFactory);
            TableColumn tc = columns.get(i);
            columns.get(i).setOnEditStart(new EventHandler<CellEditEvent<ObjectValue, String>>() {
                        @Override
                        public void handle(CellEditEvent<ObjectValue, String> t) {                            
                            getColInit(t, tc);
                         
                        }
                    });
            
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
          GraduateStats.Variable var = new GraduateStats.Variable("", typeList, "", measLst, null);
          varTable = new TableView(gradStatsModel.getVarAttributes(var));
          
          
          TableColumn<Variable, String> nameColumn = new TableColumn<>("Name");
          
          nameColumn.setResizable(false);
          nameColumn.setCellValueFactory(new PropertyValueFactory<>("varName"));
          nameColumn.setPrefWidth(100);     
          nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
          nameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Variable, String>>() {

              public void handle(CellEditEvent<Variable, String> t) {
                  ((Variable) t.getTableView().getItems().get(
                          t.getTablePosition().getRow())
                          ).setValue(t.getNewValue());
                  table.getColumns().get((t.getTablePosition().getRow()) + 1).setText(t.getNewValue());
                  var.setVarName(t.getNewValue());
                  varTabRow = t;
              }
          });
          
//          
          TableColumn<ObservableList, String> typeColumn = new TableColumn<>("Type");
          typeColumn.setResizable(false);
          typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
          typeColumn.setPrefWidth(120); 
          typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), var.getTypes()));
          typeColumn.setOnEditCommit((CellEditEvent<ObservableList, String> t) -> {
              ((Variable) t.getTableView().getItems().get(
                      t.getTablePosition().getRow())
                      ).setValue(t.getNewValue());
                      var.setVarType(FXCollections.observableArrayList(t.getNewValue()));
                      
          });
          
          typeColumn.setOnEditCancel(new EventHandler<CellEditEvent<ObservableList, String>>() {
              
              @Override
              public void handle(CellEditEvent<ObservableList, String> t) {                  
                  var.setVarType(FXCollections.observableArrayList("null"));
                  
              }
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
           measuresColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), var.getMeasType()));
            measuresColumn.setOnEditCommit(new EventHandler<CellEditEvent<ObservableList, String>>() {

              public void handle(CellEditEvent<ObservableList, String> t) {
                  ((Variable) t.getTableView().getItems().get(
                          t.getTablePosition().getRow())
                          ).setValue(t.getNewValue());
              }
          }); 
         
          Callback<TableColumn<Variable, Role>, TableCell<Variable, Role>> comboBoxCellFactory
                = (TableColumn<Variable, Role> param) -> new ComboBoxEditingCell();  
            
          TableColumn<Variable, Role> rolesColumn = new TableColumn<>("Role");  
          rolesColumn.setResizable(false);
          rolesColumn.setSortable(false);   
          rolesColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
          rolesColumn.setPrefWidth(100);        
          rolesColumn.setCellFactory(comboBoxCellFactory);  
          rolesColumn.setOnEditCommit(new EventHandler<CellEditEvent<Variable, Role>>() {

              public void handle(CellEditEvent<Variable, Role> t) {
                  
                  ((Variable) t.getTableView().getItems().get(
                          t.getTablePosition().getRow())
                          ).setRoles(t.getNewValue());
                  //variable.setRoles((FXCollections.observableArrayList(t.getNewValue())));
              }
          });
          
          
          Clipboard clipboard = Clipboard.getSystemClipboard();
          
          varTable.getColumns().addAll(nameColumn, typeColumn, valsColumn, measuresColumn, rolesColumn );
          varTable.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {
              // this method will be called whenever user selects a row
            @Override
             public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
             
                     
                    
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



    public void getColInit( CellEditEvent<?, String> t, TableColumn tc ){
        
        for(Object tCol : varTable.getColumns()){
            varTable.getSelectionModel().select(getVarTableRow(), (TableColumn)tCol);
            String colValRef =  variable.getVarName();
            if( colValRef.toString() == null || varTable.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Name")){
                  System.out.println("It works");
            } else {
                System.out.println("Contents of type: " + variable.getTypes().toString());
            }
        }
    }
    public int getVarTableRow(){
        System.out.println(varTabRow.getTableView().getSelectionModel().getFocusedIndex());
        return varTabRow.getTableView().getSelectionModel().getFocusedIndex();
        
        
    }
    
     class ComboBoxEditingCell extends TableCell<Variable, Role> {

        private ComboBox<Role> comboBox;

        private ComboBoxEditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createComboBox();
                setText(null);
                setGraphic(comboBox);
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(getRole().getRole());
            setGraphic(null);
        }

        @Override
        public void updateItem(Role item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (comboBox != null) {
                        comboBox.setValue(getRole());
                    }
                    setText(getRole().getRole());
                    setGraphic(comboBox);
                } else {
                    setText(getRole().getRole());
                    setGraphic(null);
                }
            }
        }

        private void createComboBox() {
            comboBox = new ComboBox<>(roleData);
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getRole());
            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            comboBox.setOnAction((e) -> {
                System.out.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
                commitEdit(comboBox.getSelectionModel().getSelectedItem());
            });
//            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//                if (!newValue) {
//                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
//                }
//            });
        }

        private void comboBoxConverter(ComboBox<Role> comboBox) {
            // Define rendering of the list of values in ComboBox drop down. 
            comboBox.setCellFactory((c) -> {
                return new ListCell<Role>() {
                    @Override
                    protected void updateItem(Role item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getRole());
                        }
                    }
                };
            });
        }
     
    
     private Role getRole() {
            return getItem() == null ? new Role("") : getItem();
        }
    
}
     public static class Role {

        private final SimpleStringProperty role;

        public Role(String role) {
            this.role = new SimpleStringProperty(role);
        }

        public String getRole() {
            return this.role.get();
        }

        public StringProperty roleProperty() {
            return this.role;
        }

        public void setRole(String role) {
            this.role.set(role);
        }

        @Override
        public String toString() {
            return role.get();
        }

    }
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Adrian_and_Alanna
 */
public static class Variable {
    
    private SimpleStringProperty varName;
    private ObservableList type;
    private SimpleStringProperty values;
    private ObservableList measures;
    private final SimpleObjectProperty<Role> roles;
    private boolean initialized;
    
    public Variable(String varName, ObservableList type, String values,
            ObservableList measures, ObservableList<Role> roles) {
        
                this.varName = new SimpleStringProperty(varName);
                this.type = new SimpleListProperty(type);
                this.values = new SimpleStringProperty(values);
                this.measures = new SimpleListProperty(measures);
                this.roles = new SimpleObjectProperty(roles);
                
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

        type = typeList;
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
        
        
        if( measures == null){
            measures = measLst;
        }
        return measures;
    }
    //roles
    public void setRoles(Role roleList){
        roleProperty().set(roleList);
    }
    public Role getRoles(){
        return roleProperty().get();
    }
    public ObjectProperty<Role> roleProperty(){
               
        return this.roles;
    }
}

  

        }


