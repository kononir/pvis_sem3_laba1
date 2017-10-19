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

public class MyFrame extends JFrame{
    public MyFrame(Cubic cub){
        setTitle("Кубик Рубика");
        setBounds(480,30,1000,1000);
        setBackground(Color.gray);
        MyPanel panel= new MyPanel(cub);
        Container pane = getContentPane();
        pane.add(panel);
    }
}
