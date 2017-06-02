/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import nz.ac.aut.ense701.gameModel.Terrain;

/**
 *
 * @author dre
 */
public class MyImages {
    ImageIcon[] sand = new ImageIcon[2];
    ImageIcon[] water = new ImageIcon[2];
    ImageIcon[] marsh = new ImageIcon[2];
    ImageIcon[] forest = new ImageIcon[2];
    ImageIcon[] shrub = new ImageIcon[2];
    MyImages(){
        sand[0] = new ImageIcon(new ImageIcon("resources/images/mysand.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[1] = new ImageIcon(new ImageIcon("resources/images/sandhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[0] = new ImageIcon(new ImageIcon("resources/images/myocean.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[1] = new ImageIcon(new ImageIcon("resources/images/waterhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[0] = new ImageIcon(new ImageIcon("resources/images/mywater.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[1] = new ImageIcon(new ImageIcon("resources/images/marshhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[0] = new ImageIcon(new ImageIcon("resources/images/myforest.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[1] = new ImageIcon(new ImageIcon("resources/images/foresthelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[0] = new ImageIcon(new ImageIcon("resources/images/myshrub.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[1] = new ImageIcon(new ImageIcon("resources/images/scrubhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        
    }
    public ImageIcon getIcon(Terrain x, Boolean player){
       int y = 0;
       if(player){
           y=1;
       }
        switch(x){
             case SAND: 
                return sand[y];
            case FOREST:       
                return forest[y];
            case WETLAND: 
                return marsh[y];
            case SCRUB: 
                return shrub[y];
            case WATER:
                return water[y];
            default:
                return new ImageIcon(); 
        }
    }
}

