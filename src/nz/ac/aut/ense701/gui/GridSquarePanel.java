package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel implements ComponentListener
{
    ImageIcon imageIcon;
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        imageIcon = new ImageIcon("resources/images/Player.png"); // load the image to a imageIcon
        initComponents();
    }

    /**
     * Updates the representation of the grid square panel.
     */
    public void update() 
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        Color      color;
        String textureImagePath = null;
        
        switch ( terrain )
        {
            case SAND     : color = Color.YELLOW; textureImagePath = "resources/images/beach_sand.png";break;
            case FOREST   : color = Color.GREEN;textureImagePath = "resources/images/forest_grass.png";break;
            case WETLAND : color = Color.BLUE;textureImagePath = "resources/images/Marsh_Turf_Texture.png"; break;
            case SCRUB : color = Color.DARK_GRAY;textureImagePath = "resources/images/scrub.png"; break;
            case WATER    : color = Color.CYAN;textureImagePath = "resources/images/water.png";   break;
            default  : color = Color.LIGHT_GRAY; break;
        }
        
        if ( squareExplored || squareVisible )
        {
            // Set the text of the JLabel according to the occupant
            lblText.setText(game.getOccupantStringRepresentation(row,column));
            // Set the colour. 
            
            if ( squareVisible && !squareExplored ) 
            {
                
                // When explored the colour is brighter
                color = new Color(Math.min(255, color.getRed()  ), 
                                  Math.min(255, color.getGreen() ), 
                                  Math.min(255, color.getBlue()));
            }
            lblText.setBackground(color);
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
//            ImageIcon teraIcon = new ImageIcon(textureImagePath);
//            Image teraImage = teraIcon.getImage();
//            Image playerImage = imageIcon.getImage();
//            Image teraNewImg;
//            Image newimg;
//            Image image;
//            Graphics g2;
//            
//            
//            if(game.hasPlayer(row, column)){
//                if(getHeight() == 0){
//                image = new BufferedImage(50,50,  TYPE_INT_RGB);
//                teraNewImg = teraImage.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//                newimg = playerImage.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//                g2 = image.getGraphics();
//                g2.drawImage(teraNewImg, 0, 0, this);
//                g2.drawImage(newimg, 0, 0, this);
//                g2.dispose();
//            }else{
//                image = new BufferedImage(getHeight(),getWidth(),  TYPE_INT_RGB);
//                teraNewImg = teraImage.getScaledInstance(getHeight(), getWidth(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//                newimg = playerImage.getScaledInstance(getHeight()/2, getWidth()/2,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//                g2 = image.getGraphics();
//                
//                g2.drawImage(newimg, 0, 0, this);
//                g2.drawImage(teraNewImg, 0, 0, this);
//                
//                g2.dispose();
//            }
//            imageIcon = new ImageIcon(image);
//                lblText.setIcon(imageIcon);
//                lblText.setText(null);
//            }else{
//                lblText.setText(game.getOccupantStringRepresentation(row,column));
//                lblText.setIcon(new ImageIcon(teraImage));
//            }
//            updateUI();
            
        }
        else
        {
            lblText.setText("");
            lblText.setBackground(null);
            setBorder(normalBorder);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("content");
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    private Game game;
    private int row, column;
    
    private static final Border normalBorder = new LineBorder(Color.BLACK, 0);
    private static final Border activeBorder = new LineBorder(Color.RED, 1);

    @Override
    public void componentResized(ComponentEvent ce) {
        System.out.print("Resized");
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
