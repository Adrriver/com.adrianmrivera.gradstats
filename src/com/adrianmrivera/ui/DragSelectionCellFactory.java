/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.ui;

import com.adrianmrivera.model.ObjectValue;
import com.adrianmrivera.model.Variable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.collections.ObservableList;
/**
 *
 * @author AdrianMRivera
 */


public class DragSelectionCellFactory implements Callback<TableColumn<ObjectValue, String>, TableCell<ObjectValue, String>> {

        @Override  
        public TableCell<ObjectValue, String> call(final TableColumn<ObjectValue, String> col) {            
            return new DragSelection();  
        }  
    
}
