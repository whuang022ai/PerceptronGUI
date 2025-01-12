/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronbp;

/**
 *
 * @author user
 */
public class Neural//神經元
{
   private double [] weight;//神經元權重組態
   private double bias;//神經元偏權組態
   public Neural(int dimension)//建構子 ,感知機的維度
   {
       weight=new double [dimension];      
       bias=0;  
   }
   public double []getWeight()
   {
       return weight;
   }
   public double getBias()
   {
       return bias;
   }
   private  double Net(double [] weight,double [] xi,double bias)//神經元狀態
   {
        double net=0;
        for(int i=0;i<xi.length;i++)
        {
          net+= xi[i]* weight[i];//每個神經元權重*輸入+偏權值
        }
        net+=bias;
        return net;
   }
   private  double Y (double net)//神經元輸出
   {
       return Sigmoid(net) ;
   }
   private   double Sigmoid(double x) //Sigmoid函數
   {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
   }
   private double D(double d,double Y)//誤差
   {
       return d-Y;
   }
   private  double E(double D)//平方誤差
   {
       double E=0.5*D*D;
       return E;
   }  
  
   public  double Iterate(double [] xi,double d,double learningRate)//一次迭代 ,輸入,期望輸出 回傳本次迭代誤差函數輸出
   {
       //---前向傳遞
       double net=Net( weight,xi,bias);
       //System.out.println("net"+net);
       double Y=Y(net);
       //---

       //---誤差計算
       double D=D(d,Y);
       //---
       
       //---平方誤差(誤差函數)
       double E=E(D);
       //System.out.println(E);
       //---

       ////誤差倒傳遞
       
       //---對每個weight做更新
       for(int i=0;i< weight.length;i++)
       {
            double deltaWeight=D*-1*Y*(1-Y)*xi[i];//weight 修正量
            weight[i]= weight[i]-learningRate*deltaWeight;//更新
       }
       //---
       
       //---對bias做更新
       double deltaBias=D*Y*(1-Y)*-1;//bias 修正量
       bias=bias-learningRate*deltaBias;//更新         
       //---
       
       ////---
       return E;
   }
  
}
