/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;


/**
 *
 * @author Adrian Rivera
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MenuBar mainMenu;
    private ToolBar prToolbar;
    private ToolBar secToolbar;
    private TabPane tabPane;
    private ScrollPane dataPane = new ScrollPane();
    private ScrollPane varPane;
    private HBox tTipHBox;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
