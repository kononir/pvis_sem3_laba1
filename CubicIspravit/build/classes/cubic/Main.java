package cubic;
import forCubic.WindowYes;
import forCubic.WindowNo;
import forCubic.MyPanel;
import forCubic.File;
import forCubic.MyFrame;
import forCubic.Action;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

    MyFrame frame;
    boolean aright;
    public static Cubic cub;
    public static void main(String[] args) {
        cub = File.WRiTE(cub);
        Cubic.Watch(cub);

        Main gui = new Main();
        gui.go();
    }

    public void go(){
        frame = new MyFrame(cub);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent Cubic) {

                if (Cubic.getKeyCode()== Cubic.VK_NUMPAD7 && Cubic.isControlDown())
                    gran = Cubic.rotate_Vl(gran);
                if (Cubic.getKeyCode()== Cubic.VK_NUMPAD9 && Cubic.isControlDown())
                    gran = Cubic.rotate_Vr(gran);
                if (Cubic.getKeyCode()== Cubic.VK_NUMPAD4 && Cubic.isControlDown())
                    gran = Cubic.rotate_Zl(gran);
                if (Cubic.getKeyCode()== Cubic.VK_NUMPAD6 && Cubic.isControlDown())
                    gran = Cubic.rotate_Zr(gran);
                if (Cubic.getKeyCode()== Cubic.VK_NUMPAD1 && Cubic.isControlDown())
                    gran = Cubic.rotate_Nl(gran);
                if (Cubic.getKeyCode()== Cubic.VK_NUMPAD3 && Cubic.isControlDown())
                    gran = Cubic.rotate_Nr(gran);

                if (Cubic.getKeyCode() == Cubic.VK_NUMPAD7 && Cubic.isAltDown())
                    gran = Cubic.left_up(gran);
                if (Cubic.getKeyCode() == Cubic.VK_NUMPAD8 && Cubic.isAltDown())
                    gran = Cubic.midle_up(gran);
                if (Cubic.getKeyCode() == Cubic.VK_NUMPAD9 && Cubic.isAltDown())
                    gran = Cubic.right_up(gran);
                if (Cubic.getKeyCode() == Cubic.VK_NUMPAD1 && Cubic.isAltDown())
                    gran = Cubic.left_down(gran);
                if (Cubic.getKeyCode() == Cubic.VK_NUMPAD2 && Cubic.isAltDown())
                    gran = Cubic.midle_down(gran);
                if (Cubic.getKeyCode() == Cubic.VK_NUMPAD3 && Cubic.isAltDown())
                    gran = Cubic.right_down(gran);

                if (Cubic.getKeyCode() == Cubic.VK_D)
                    gran = Cubic.gran_right(gran);
                if (Cubic.getKeyCode() == Cubic.VK_A)
                    gran = Cubic.gran_left(gran);
                if (Cubic.getKeyCode() == Cubic.VK_W)
                    gran = Cubic.gran_up(gran);
                if (Cubic.getKeyCode() == Cubic.VK_X)
                    gran = Cubic.gran_down(gran);
                if (Cubic.getKeyCode() == Cubic.VK_SPACE){
                    aright = Cubic.check(cub);
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