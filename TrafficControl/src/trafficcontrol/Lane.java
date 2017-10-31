/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficcontrol;

/**
 *
 * @author owner
 */
public class Lane {
    public Lane(int d, int l) {
        this.D = d;
        this.L = l;

    }
    int T1=6; //duration till first car passes
    int t=1; // time till next car takes the pose of current car
    int D; // Direction
    int L; // Lane
    int Q; // queue 
    int TQ = 0; // time till all queue passes
    int WT; // wait time so far
    Lane ascL1;
    Lane ascL2;
    Lane ascL3;
    static int Tthreshold = 120; // max wait time
    boolean lightStatus = false; // true for green, false for red
    
    int computeWT(){
        if(this.lightStatus==true){WT=0;}
        else{WT = (int) (((System.currentTimeMillis()- Phase.lightChangeTime)/1000) );}
        return WT;    
    }
    void computeTQ(){
        TQ =  T1 + (t * (Q -1)) ;
    }
}
