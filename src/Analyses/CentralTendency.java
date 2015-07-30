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
 * @author Adrian_Rivera
 */
public class CentralTendency {
    
    private ArrayList<double[]> sample;
    
    private int sampleNum;
    private double[] mean;
    private Object[] mode;
    private double[] median;
    private double[] maximum;
    private double[] minimum;
    private double[] range;
    private double[] standardDeviation;
    private double[] variance;
    private double[] sum;
    private boolean nominal;
    
    public CentralTendency(ArrayList<Object[]> sample, boolean nom){
        int i = 0;
        nominal = nom;        
        
        
        if(!nominal){
            sampleNum = this.sample.size();
            sample = new ArrayList<>();                            
            this.sample.addAll(sample);
                setMean();
                setMode();
                setMedian();
                setMax();
                setMin();
                setRange();
                setSD();
            setVariance();
            setSum();
        } else {
            setMode();
        }
            
    }
    
    public void setMean(){
        int i = 0;
        int n;
        for( double[] var : sample ) {            
            for( double val : var ) {
                sum[i] += val;                
            }
            n = sum.length;
                mean[i] = (sum[i]/n);
            i++;
        }
        
    }
    public double[] getMean() {
        return mean;
    }
    public void setMode(){
        if(nominal) {
            for( double[] var : sample ) {
                for( )
            }
        } else {
            
        }
    }
    public Object[] getMode() {
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
