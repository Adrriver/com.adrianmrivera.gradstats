/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmrivera.Analyses;

import java.util.*;

/**
 *
 * @author Adrian_and_Alanna
 */
public class Frequencies {
    
    private int N;
    private ArrayList<ArrayList<Object>> independentVars;
    private ArrayList<ArrayList<Object>> dependentVars;    
    private ArrayList<int[][][]> ordCumulFreq;
    private ArrayList<double[][][]> contCumulFreq;
    private ArrayList<Object[][][]> nomCumulFreq;
    private ArrayList<Object [][][]> percentiles;
    private ArrayList<double[]> quartiles;
    private ArrayList<double[]> quintiles;
    private CentralTendency centTend;
    private final String[] modality = new String[]{"Unimodal", "Bimodal", "Rectangular", "J-Curve"};
    
    public Frequencies(){
        //To do
    }
    
    
}
