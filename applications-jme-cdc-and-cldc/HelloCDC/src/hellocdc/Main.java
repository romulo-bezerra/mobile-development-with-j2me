/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocdc;

import java.awt.*;

/**
 * @author romulo-temp
 */
public class Main extends Frame {

    public Main() {
        initComponents();
    }

    private void initComponents() {
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("Hello, World CDC!", 80, 50);
        g.drawRect(5, 30, 230, 30);
    }
}
