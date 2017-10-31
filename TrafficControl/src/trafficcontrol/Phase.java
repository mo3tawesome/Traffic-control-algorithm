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
public class Phase {
    
    public Phase(Lane l1, Lane l2) {
        this.L1 = l1;
        this.L2 = l2;
    }
    
    Lane L1;
    Lane L2;
    int TPmax=90;
    int TQx=0; // time till al queue pass
    int TPx=0; //max allowed time for green
    int Qx=0; // not used
    static int lightChangeTime = 0;

    
    public boolean changeLightStatus(){
        L1.lightStatus = !(L1.lightStatus);
        L2.lightStatus = !(L2.lightStatus);
        lightChangeTime = (int) System.currentTimeMillis();
        Qx = getQx();
        TQx = getTQx();
        TPx = getTPx();
        if((L1.lightStatus && L2.lightStatus)==true){return true;}
        else if((L1.lightStatus && L2.lightStatus)==false){return true;}
        
        return false;
    }
    int getQx(){
        if(L1.Q>L2.Q){return L1.Q;}
        else{return L2.Q;}
    }
    int getTQx(){
        L1.computeTQ();
        L2.computeTQ();
        if(L1.TQ>L2.TQ){return L1.TQ;}
        else{return L2.TQ;}
    }
    int getTPx(){
        if(TQx<TPmax){return TQx;}
        else{return TPmax;}
    }
}
