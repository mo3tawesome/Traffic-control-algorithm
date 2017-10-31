/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficcontrol;

import java.util.Random;

/**
 *
 * @author owner
 */
public class TrafficControl {
    
    public static void main(String[] args) {
        Controller.lanesInit();
        Controller.casesInit();
        while (true){
        // get all the JSONs of the lanes
        // get an array of JSONs
        Recived [][] recivedArray = new Recived [4][2];
        //*******************************************************
        // for the sake of the trial i'll fill it with dummy numbers
        Random rand = new Random();
        int randomNum = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<2; j++){
               recivedArray[i][j] = new Recived();
               recivedArray[i][j].D = i;
               recivedArray[i][j].L = j;
               randomNum = rand.nextInt((25 - 0) + 1);
               recivedArray[i][j].Q = randomNum;
               
            }
        }
        //******************************************************
        for(int i=0; i<4; i++){
            for(int j=0; j<2; j++){
               Controller.ArrayOfLanes[i][j].Q = recivedArray[i][j].Q;
               if(Controller.ArrayOfLanes[i][j].Q > Controller.Qmax){
                        Controller.Qmax = Controller.ArrayOfLanes[i][j].Q;
                        Controller.L1 = Controller.ArrayOfLanes[i][j];
               }
               
            }
        }
        for(int i=0; i<4; i++){
            for(int j=0; j<2; j++){
                int WT = Controller.ArrayOfLanes[i][j].computeWT();
                if (WT > Lane.Tthreshold){Controller.L1=Controller.ArrayOfLanes[i][j];}
            }
        }
        Controller.getL2(Controller.L1);
        Phase p = new Phase(Controller.L1,Controller.L2);
        
        p.changeLightStatus();
        System.out.println(p.TPx);
        System.out.println(p.L1.D);
        System.out.println(p.L1.L);
        System.out.println(p.L1.Q);
        System.out.println(p.L2.D);
        System.out.println(p.L2.L);
        System.out.println(p.L2.Q);
        
        // Send P to the server
        while ((((int)System.currentTimeMillis()- p.lightChangeTime))/1000  < p.TPx){}
        p.changeLightStatus();
    }
}
}
