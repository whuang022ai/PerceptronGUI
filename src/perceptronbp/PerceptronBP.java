/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronbp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class PerceptronBP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataReader rd= new DataReader();
        Neural perception=new Neural(4);
        
        try 
        {
           ArrayList< Sample> trainDatas=rd.getCSVTrainData("C:\\Users\\user\\Desktop\\Iris-setosa.csv",4);
            for(int j=0;j<20;j++)
            { 
                
                for(int i=0;i<trainDatas.size();i++)
                {   
                    Random ran = new Random();
                    int shift=ran.nextInt(100);
                    i=(i+shift)%100;
                    double predict=perception.Iterate(trainDatas.get(i).feature, trainDatas.get(i).d, 0.7);
                    
                }
           }
           System.out.println("神經元權重：");
            for(int i=0;i<perception.getWeight().length;i++)
            {
                System.out.print(perception.getWeight()[i]+" ");
            }
            System.out.println("");
             System.out.println("神經元偏權：");
            System.out.print(perception.getBias()+" ");
              System.out.println("");
        }
        catch (IOException ex)
        {
            Logger.getLogger(PerceptronBP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
