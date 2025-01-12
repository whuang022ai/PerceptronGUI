/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronbp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DataReader 
{    
    public ArrayList< Sample>getCSVTrainData(String filePath,int dim) throws FileNotFoundException, IOException
    {
        ArrayList< Sample> trainDatas = new ArrayList< Sample>();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
       
        while (br.ready())
        {
            double []feature=new double[dim];
            String line=br.readLine();      
            String [] chunk=line.split(",");
            for(int i=0;i<dim;i++)
            {
                double value = Double.parseDouble(chunk[i]);
                feature[i]=value;
            }
            Sample sp=new Sample();
            sp.feature=feature;
            sp.d= Double.parseDouble(chunk[4]);
            trainDatas.add(sp);
        }fr.close();
        return trainDatas;
    }
}
