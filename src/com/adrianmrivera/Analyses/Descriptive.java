/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.Analyses;

import com.adrianmrivera.model.DoubleValue;
import java.util.ArrayList;

/**
 *
 * @author Adrian_and_Alanna
 */
public abstract class Descriptive extends Analysis {
    
    private int[] nX, nY;    
    private ArrayList<ArrayList<Object>> independentVars;
    private ArrayList<ArrayList<Object>> dependentVars;  
    private ArrayList<ArrayList<Double>> sumOfX;
    private ArrayList<ArrayList<Double>> sumOfY;
    private ArrayList<ArrayList<Double>> sumOfSquaredX;
    private ArrayList<ArrayList<Double>> sumOfSqdDevSc;
    private ArrayList<ArrayList<Double>> sumOfCrossPrds;
    private Frequencies frequencies;
    
    
    
}
