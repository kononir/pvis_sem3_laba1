/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forCubic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import cubic.Cubic; 

public class WindowNo extends JFrame {
    JLabel Label;
    JButton Button1;
    JButton Button2;
    public WindowNo(Cubic cub, MyFrame frame){
        Label = new JLabel("Кубик не собран! Хотите продолжить или выполнить автоматическую сборку?");
        Font font= new Font("TimesNewRoman", Font.PLAIN, 15);
        Label.setHorizontalAlignment(JLabel.CENTER);
        Label.setFont(font);
        Button1 = new JButton("Продолжить");
        Button2 = new JButton("Собрать");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        add(Label, BorderLayout.NORTH);
        buttonsPanel.add(Button1);
        buttonsPanel.add(Button2);
        add(buttonsPanel, BorderLayout.SOUTH);
        Button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent r1){
                setVisible(false);
            }
        });
        Button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent r2){
                for(int i=1; i <=6; i++)
                    for(int j=1; j <=cub.getW_h(); j++)
                        for(int k=1; k <=cub.getW_h(); k++)
                            cub.setCub(i,j,k,i);
                setVisible(false);
                frame.repaint();
            }
        });
                        
    }
}
