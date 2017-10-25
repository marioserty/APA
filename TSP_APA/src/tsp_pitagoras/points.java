/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_pitagoras;

/**
 *
 * @author Mário
 * DESIGN PATTERN OBSERVVER
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class points extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        
        GrafoXY gr = new GrafoXY();
        
        int x1,y1,x2,y2;

        for (int i = 0; i < 100; i++) {
            x1 = gr.cidades[i][0];
            y1 = gr.cidades[i][1];
            g2d.drawOval(x1, y1, 7, 7);
            g2d.fillOval(x1, y1, 7, 7);
        }
        
        g2d.setColor(Color.red);
        for (int i = 0; i < 99; i++) {
            x1 = gr.cidades[i][0];
            y1 = gr.cidades[i][1];
            x2 = gr.cidades[i+1][0];
            y2 = gr.cidades[i+1][1];
            g2d.drawLine(x1, y1, x2, y2);
        }
        x1 = gr.cidades[0][0];
        y1 = gr.cidades[0][1];
        x2 = gr.cidades[99][0];
        y2 = gr.cidades[99][1];
        g2d.drawLine(x1, y1, x2, y2);
        
    }

    public double euclidean(int x1, int y1, int x2, int y2){
        return Math.sqrt(((x2 - x1) ^ 2) + ((y2 - y1) ^ 2));
    }

    public static void main(String[] args) {
        points points = new points();
        JFrame frame = new JFrame("TSP APA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(points);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}
