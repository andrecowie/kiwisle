/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author dre
 */
    public class ImagePanel extends JPanel{
        
        private BufferedImage image;
        private BufferedImage image2;
        
        public ImagePanel(String x, String y){
            try {
                image = ImageIO.read(new File(x));
                image2 = ImageIO.read(new File(y));
            } catch (IOException ex){
                System.err.print(ex.toString());
            }
        }
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image2, 350, 0, this);
            g.drawImage(image, 350, 50, this);
            
        }
    }
