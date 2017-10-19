/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forCubic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowYes extends JFrame {
    JLabel Label;
    JButton Button;
    public WindowYes(){
        Font font= new Font("TimesNewRoman", Font.PLAIN, 15);
        Label = new JLabel("Кубик успешно собран!");
        Label.setHorizontalAlignment(JLabel.CENTER);
        Label.setFont(font);
        Button = new JButton("OK");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        add(Label, BorderLayout.NORTH);
        buttonsPanel.add(Button);
        add(buttonsPanel, BorderLayout.SOUTH);
        Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent r){
                setVisible(false);
            }
        });
                        
    }
}
