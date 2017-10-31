/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficcontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author owner
 */
public class Controller {
    
    static Lane [][] ArrayOfLanes = new Lane[4][2];  // all lanes
    static Lane L1;
    static Lane L2;
    static int Qmax=0;
    
    // Valid cases initilization
    
    
    
        public int getQmax(){
            for(int i=0; i<4; i++){
                for(int j=0; j<2; j++){
                    if(ArrayOfLanes[i][j].Q > Qmax){
                        Qmax = ArrayOfLanes[i][j].Q;
                        L1 = ArrayOfLanes[i][j];
                    }
            }
        }
        return Qmax;
    }
            
    public static Lane getL2(Lane L1){
        
        int QlocalMax=0;
        if(L1.ascL1.Q > QlocalMax){
        QlocalMax = L1.ascL1.Q;
        L2 = L1.ascL1;
        }
        if(L1.ascL2.Q > QlocalMax){
        QlocalMax = L1.ascL2.Q;
        L2 = L1.ascL2;
        }
        if(L1.ascL3.Q > QlocalMax){
        QlocalMax = L1.ascL3.Q;
        L2 = L1.ascL3;
        }
        
        return L2;
}
    public static void lanesInit(){
        for(int i=0; i<4; i++){
            for(int j=0; j<2; j++){
                Controller.ArrayOfLanes[i][j]= new Lane(i,j);
            }
        }
    }

    public static void casesInit (){
        // N S E w  F R
        // 0 1 2 3  0 1      
        
        // N,F
       ArrayOfLanes[0][0].ascL1 = ArrayOfLanes[0][1];
       ArrayOfLanes[0][0].ascL2 = ArrayOfLanes[1][0];
       ArrayOfLanes[0][0].ascL3 = ArrayOfLanes[3][1];
        
        // S,F
       ArrayOfLanes[1][0].ascL1 = ArrayOfLanes[1][1];
       ArrayOfLanes[1][0].ascL2 = ArrayOfLanes[2][1];
       ArrayOfLanes[1][0].ascL3 = ArrayOfLanes[0][0];
        
        // E,F
       ArrayOfLanes[2][0].ascL1 = ArrayOfLanes[2][1];
       ArrayOfLanes[2][0].ascL2 = ArrayOfLanes[3][0];
       ArrayOfLanes[2][0].ascL3 = ArrayOfLanes[0][1];
        
        // W,F
       ArrayOfLanes[3][0].ascL1 = ArrayOfLanes[3][1];
       ArrayOfLanes[3][0].ascL2 = ArrayOfLanes[1][1];
       ArrayOfLanes[3][0].ascL3 = ArrayOfLanes[2][0];
        
        // N,R
       ArrayOfLanes[0][1].ascL1 = ArrayOfLanes[0][0];
       ArrayOfLanes[0][1].ascL2 = ArrayOfLanes[1][1];
       ArrayOfLanes[0][1].ascL3 = ArrayOfLanes[2][0];
        
        // S,R
       ArrayOfLanes[1][1].ascL1 = ArrayOfLanes[1][0];
       ArrayOfLanes[1][1].ascL2 = ArrayOfLanes[0][1];
       ArrayOfLanes[1][1].ascL3 = ArrayOfLanes[3][0];
        
        // E,R
       ArrayOfLanes[2][1].ascL1 = ArrayOfLanes[2][0];
       ArrayOfLanes[2][1].ascL2 = ArrayOfLanes[3][1];
       ArrayOfLanes[2][1].ascL3 = ArrayOfLanes[1][0];
        
        // W,R
       ArrayOfLanes[3][1].ascL1 = ArrayOfLanes[3][0];
       ArrayOfLanes[3][1].ascL2 = ArrayOfLanes[2][1];
       ArrayOfLanes[3][1].ascL3 = ArrayOfLanes[0][0];
                
    }
}
