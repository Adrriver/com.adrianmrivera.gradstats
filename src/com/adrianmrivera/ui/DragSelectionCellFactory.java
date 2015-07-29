/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.ui;

import com.adrianmrivera.model.DoubleValue;
import com.adrianmrivera.model.Variable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.collections.ObservableList;
/**
 *
 * @author AdrianMRivera
 */


public class DragSelectionCellFactory implements Callback<TableColumn<DoubleValue, String>, TableCell<DoubleValue, String>> {

        @Override  
        public TableCell<DoubleValue, String> call(final TableColumn<DoubleValue, String> col) {            
            return new DragSelection();  
        }  
    
}
