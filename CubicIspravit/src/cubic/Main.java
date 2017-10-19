package cubic;
import forCubic.WindowYes;
import forCubic.WindowNo;
import forCubic.MyPanel;
import forCubic.File;
import forCubic.MyFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

    MyFrame frame;
    boolean aright;
    public static Cubic cub;
    public static void main(String[] args) {
        cub = File.WRiTE();
        Cubic.Watch();

        Main gui = new Main();
        gui.go();
    }

    public void go(){
        frame = new MyFrame(cub);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent num) {

                if (num.getKeyCode()== num.VK_NUMPAD7 && num.isControlDown())
                    cub.rotate_Vl();
                if (num.getKeyCode()== num.VK_NUMPAD9 && num.isControlDown())
                    cub.rotate_Vr();
                if (num.getKeyCode()== num.VK_NUMPAD4 && num.isControlDown())
                    cub.rotate_Zl();
                if (num.getKeyCode()== num.VK_NUMPAD6 && num.isControlDown())
                    cub.rotate_Zr();
                if (num.getKeyCode()== num.VK_NUMPAD1 && num.isControlDown())
                    cub.rotate_Nl();
                if (num.getKeyCode()== num.VK_NUMPAD3 && num.isControlDown())
                    cub.rotate_Nr();

                if (num.getKeyCode() == num.VK_NUMPAD7 && num.isAltDown())
                    cub.left_up();
                if (num.getKeyCode() == num.VK_NUMPAD8 && num.isAltDown())
                    cub.midle_up();
                if (num.getKeyCode() == num.VK_NUMPAD9 && num.isAltDown())
                    cub.right_up();
                if (num.getKeyCode() == num.VK_NUMPAD1 && num.isAltDown())
                    cub.left_down();
                if (num.getKeyCode() == num.VK_NUMPAD2 && num.isAltDown())
                    cub.midle_down();
                if (num.getKeyCode() == num.VK_NUMPAD3 && num.isAltDown())
                    cub.right_down();

                if (num.getKeyCode() == num.VK_D)
                    cub.gran_right();
                if (num.getKeyCode() == num.VK_A)
                    cub.gran_left();
                if (num.getKeyCode() == num.VK_W)
                    cub.gran_up();
                if (num.getKeyCode() == num.VK_X)
                    cub.gran_down();
                if (num.getKeyCode() == num.VK_SPACE){
                    aright = cub.check();
                    if(aright){
                        WindowYes window1 = new WindowYes();
                        window1.setBounds(900,150,250,120);
                        window1.setVisible(true);
                    }
                    if(!aright){
                        WindowNo window2 = new WindowNo(cub, frame);
                        window2.setBounds(630,150,700,120);
                        window2.setVisible(true);
                    }
                }
                frame.repaint();
            }
        });
        MyPanel drawPanel = new MyPanel(cub);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setVisible(true);
    }
}