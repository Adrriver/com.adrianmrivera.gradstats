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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.*;

/**
 *
 * @author Adrian_and_Alanna
 */
public class GraduateStats extends Application {

    final StageStyle style;

    GraduateStatsModel gradStatsModel = new GraduateStatsModel();
    
    public GraduateStats() {
        this.style = StageStyle.UNDECORATED;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = fxmlLoader.load();
        
        final FXMLDocumentController controller = fxmlLoader.getController();
        
        // insert TableView into main ScrollPanes
        controller.getDataPane().setContent(new ScrollPane(createTableView()));
        
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
        TableView table = new TableView(gradStatsModel.getDataValues());
        
    
        return table;
    }
    
}
