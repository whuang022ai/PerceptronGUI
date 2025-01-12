/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptrongui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import perceptronbp.DataReader;
import perceptronbp.Neural;
import perceptronbp.Sample;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
   XYChart.Series series = new XYChart.Series();
     int i=0;
    @FXML  LineChart<String, Integer>ErrorChart;
  
    @FXML public void  plus()
    {   
        
    try {
           ErrorChart.setCreateSymbols(false);
           series.setName("每次迭代誤差函數輸出總和");
           DataReader rd= new DataReader();
           Neural perception=new Neural(4);
           ArrayList< Sample> trainDatas=rd.getCSVTrainData("C:\\Users\\user\\Desktop\\Iris-setosa.csv",4);
           ArrayList< XYChart.Data> errors=new ArrayList< XYChart.Data>();
           int k=0;
           for(int j=0;j<100;j++)
           {
                double error=0;
               for(int i=0;i<trainDatas.size();i++)
               {
                   Random ran = new Random();
                   int shift=ran.nextInt(100);
                   i=(i+shift)%100;
                  error+=perception.Iterate(trainDatas.get(i).feature, trainDatas.get(i).d, 0.1);
                   
                   
               } 
              
               errors.add( new XYChart.Data(k+"",  error));
               k++;
           }
            series.getData().addAll(errors);
            ErrorChart.getData().add(series);
       } catch (IOException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    
    }    
    
}
