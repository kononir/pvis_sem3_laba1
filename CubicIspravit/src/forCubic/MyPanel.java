/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forCubic;
import cubic.Cubic;
import cubic.Main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MyPanel extends JPanel{


    //int y = 350, x = 350, size = 100; для 3
    int y = 350, x = 350, size;
    Cubic cub;
    public MyPanel(Cubic cub){
        this.cub=cub;
    }
    public void paintComponent (Graphics g){
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        this.size=(int)(300.0/(double)cub.getW_h());
        for(int i=0; i<cub.getW_h(); i++){
            for(int j=0; j<cub.getW_h(); j++){
                g.drawRect(x, y, size, size);
                x+=size;
            }
            y+=size; x = 350; 
        }
        paintColor(g);
    }    
           
 
    public void paintColor(Graphics g){
        //cub = new Cubic(cub.getW_h());
        int gran[][];
        gran=new int[cub.getW_h()+1][cub.getW_h()+1];
        for(int i=0; i<cub.getW_h(); i++)
            for(int j=0; j<cub.getW_h(); j++)
                gran[i][j]=cub.getCub(1, i+1, j+1);
        cub.Watch();
        super.paintComponents(g);
        g.setColor(Color.ORANGE);
        for(int i=1; i<=6; i++) {

            if (i == 1)
                g.setColor(Color.WHITE);
            if (i == 2)
                g.setColor(Color.RED);
            if (i == 3)
                g.setColor(Color.YELLOW);
            if (i == 4)
                g.setColor(Color.ORANGE);
            if (i == 5)
                g.setColor(Color.GREEN);
            if (i == 6)
                g.setColor(Color.BLUE);

            this.x=350;
            this.y=350;
            for(int j=0; j<cub.getW_h(); j++){
                for(int k=0; k<cub.getW_h(); k++){
                    if (gran[j][k] == i)
                        g.fillRect(x+1, y+1, size-1, size-1);
                    x+=size;
                    /*if (gran.w == i)
                g.fillRect(w_x+1, w_y+1, w_w-1, w_h-1);
            if (gran.e == i)
                g.fillRect(e_x+1, e_y+1, e_w-1, e_h-1);
            if (gran.a == i)
                g.fillRect(a_x+1, a_y+1, a_w-1, a_h-1);
            if (gran.s == i)
                g.fillRect(s_x+1, s_y+1, s_w-1, s_h-1);
            if (gran.d == i)
                g.fillRect(d_x+1, d_y+1, d_w-1, d_h-1);
            if (gran.z == i)
                g.fillRect(z_x+1, z_y+1, z_w-1, z_h-1);
            if (gran.x == i)
                g.fillRect(x_x+1, x_y+1, x_w-1, x_h-1);
            if (gran.c == i)
                g.fillRect(c_x+1, c_y+1, c_w-1, c_h-1);
            */
                }
                y+=size; x = 350;
            }
        }
    }
}

