/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analyses;

import com.adrianmrivera.model.DoubleValue;
import java.util.ArrayList;

/**
 *
 * @author Adrian_and_Alanna
 */
public class CentralTendency {
    
    private ArrayList<double[]> sample;
    private int sampleNum;
    private double[] mean;
    private double[] mode;
    private double[] median;
    private double[] maximum;
    private double[] minimum;
    private double[] range;
    private double[] standardDeviation;
    private double[] variance;
    private double[] sum;
    
    public CentralTendency(ArrayList<double[]> sample){
        int i = 0;
        sample = new ArrayList<>();
                            
        this.sample.addAll(sample);
        sampleNum = this.sample.size();
           
            setMean();
            setMode();
            setMedian();
            setMax();
            setMin();
            setRange();
            setSD();
            setVariance();
            setSum();
        
            
        }
    
    public void setMean(){
        
    }
    public double[] getMean() {
        return mean;
    }
    public double[] getMode() {
        return mode;
    }
    public double[] getMedian() {
        return median;
    }
    public double[] getMax() {
        return maximum;
    }
    public double[] getMin() {
        return minimum;
    }
    public double[] getRange() {
        return range;
    }
    public double[] getSD() {
        return standardDeviation;
    }
    public double[] getVariance() {
        return variance;
    }
    public double[] getSum() {
        return sum;
    }
} // end class CentralTendency
