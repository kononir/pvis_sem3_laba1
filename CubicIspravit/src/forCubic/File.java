/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forCubic;
import cubic.Cubic;        
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class File {
    static int num;
    static public Cubic cub;
    public static Cubic WRiTE() {
        
        try{
            FileInputStream fstream = new FileInputStream("D:/3.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){ //считываем цифру размера
                System.out.println(strLine);
                num = Integer.parseInt(strLine);
                break;
            }
            cub = new Cubic(num);
            for (int i = 1; i <= 6; i++)
                for (int j = 1; j <= cub.getW_h(); j++){      
                    while ((strLine = br.readLine()) != null){
                        System.out.println(strLine);
                        int num = Integer.parseInt(strLine);
                        cub.setCub(i,j,1,(num/(int)(Math.pow(10,cub.getW_h()-1)))); //первое число строки
                        for (int k = 2; k < cub.getW_h(); k++){
                            cub.setCub(i,j,k,(num/(int)((Math.pow(10,cub.getW_h())/(Math.pow(10,k))))%10)); //промежуточные числа
                        }
                        cub.setCub(i,j,cub.getW_h(),num%10); //последнне число строки                      
                        break;
                    }
                }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        return cub;
    }    
}
