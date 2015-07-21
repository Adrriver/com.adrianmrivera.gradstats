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
    private ScrollPane dataPane;
     @FXML
    private ScrollPane varPane;
     @FXML
    private HBox tTipHBox;
    @FXML
    private MenuItem file_Close;
    
    private Stage stage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    public ScrollPane getDataPane(){
        return this.dataPane;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
