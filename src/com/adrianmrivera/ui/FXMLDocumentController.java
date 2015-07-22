/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;

/**
 *
 * @author Adrian Rivera
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Pane mainPane;
     @FXML
    private MenuBar mainMenu;
     @FXML
    private ToolBar prToolbar;
     @FXML
    private ToolBar secToolbar;
     @FXML
    private TabPane tabPane;
     @FXML
    private Pane dataPane;
     @FXML
    private Tab dataTab;
     @FXML
    private Tab varTab;
     @FXML
    private ScrollPane varPane;
     @FXML
    private HBox tTipHBox;
    @FXML
    private MenuItem file_Close;
    @FXML
    private Button newFile;
    
    
    private Stage stage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    public Tab getDataTab(){
        return this.dataTab;
    }
    
    public Tab getVarTab(){
        return this.varTab;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
