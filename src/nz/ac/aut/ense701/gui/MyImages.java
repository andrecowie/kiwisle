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
    ImageIcon[] sand = new ImageIcon[14];
    ImageIcon[] water = new ImageIcon[14];
    ImageIcon[] marsh = new ImageIcon[14];
    ImageIcon[] forest = new ImageIcon[14];
    ImageIcon[] shrub = new ImageIcon[14];
    MyImages(){
        sand[0] = new ImageIcon(new ImageIcon("resources/images/mysand.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[1] = new ImageIcon(new ImageIcon("resources/images/sandhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[2] = new ImageIcon(new ImageIcon("resources/images/mysandK.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[3] = new ImageIcon(new ImageIcon("resources/images/mysandKPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[4] = new ImageIcon(new ImageIcon("resources/images/mysandT.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[5] = new ImageIcon(new ImageIcon("resources/images/mysandTPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[6] = new ImageIcon(new ImageIcon("resources/images/mysandP.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[7] = new ImageIcon(new ImageIcon("resources/images/mysandPPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[8] = new ImageIcon(new ImageIcon("resources/images/mysandH.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[9] = new ImageIcon(new ImageIcon("resources/images/mysandHPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[10] = new ImageIcon(new ImageIcon("resources/images/mysandE.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[11] = new ImageIcon(new ImageIcon("resources/images/mysandEPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[12] = new ImageIcon(new ImageIcon("resources/images/mysandF.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        sand[13] = new ImageIcon(new ImageIcon("resources/images/mysandFPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        
        water[0] = new ImageIcon(new ImageIcon("resources/images/myocean.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[1] = new ImageIcon(new ImageIcon("resources/images/waterhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[2] = new ImageIcon(new ImageIcon("resources/images/myoceanK.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[3] = new ImageIcon(new ImageIcon("resources/images/myoceanKPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[4] = new ImageIcon(new ImageIcon("resources/images/myoceanT.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[5] = new ImageIcon(new ImageIcon("resources/images/myoceanTPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[6] = new ImageIcon(new ImageIcon("resources/images/myoceanP.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[7] = new ImageIcon(new ImageIcon("resources/images/myoceanPPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[8] = new ImageIcon(new ImageIcon("resources/images/myoceanH.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[9] = new ImageIcon(new ImageIcon("resources/images/myoceanHPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[10] = new ImageIcon(new ImageIcon("resources/images/myoceanE.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[11] = new ImageIcon(new ImageIcon("resources/images/myoceanEPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[12] = new ImageIcon(new ImageIcon("resources/images/myoceanF.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        water[13] = new ImageIcon(new ImageIcon("resources/images/myoceanFPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        
        marsh[0] = new ImageIcon(new ImageIcon("resources/images/mywater.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[1] = new ImageIcon(new ImageIcon("resources/images/marshhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[2] = new ImageIcon(new ImageIcon("resources/images/mywaterK.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[3] = new ImageIcon(new ImageIcon("resources/images/mywaterKPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[4] = new ImageIcon(new ImageIcon("resources/images/mywaterT.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[5] = new ImageIcon(new ImageIcon("resources/images/mywaterTPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[6] = new ImageIcon(new ImageIcon("resources/images/mywaterP.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[7] = new ImageIcon(new ImageIcon("resources/images/mywaterPPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[8] = new ImageIcon(new ImageIcon("resources/images/mywaterH.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[9] = new ImageIcon(new ImageIcon("resources/images/mywaterHPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[10] = new ImageIcon(new ImageIcon("resources/images/mywaterE.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[11] = new ImageIcon(new ImageIcon("resources/images/mywaterEPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[12] = new ImageIcon(new ImageIcon("resources/images/mywaterF.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        marsh[13] = new ImageIcon(new ImageIcon("resources/images/mywaterFPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        
        forest[0] = new ImageIcon(new ImageIcon("resources/images/myforest.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[1] = new ImageIcon(new ImageIcon("resources/images/foresthelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[2] = new ImageIcon(new ImageIcon("resources/images/myforestK.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[3] = new ImageIcon(new ImageIcon("resources/images/myforestKPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[4] = new ImageIcon(new ImageIcon("resources/images/myforestT.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[5] = new ImageIcon(new ImageIcon("resources/images/myforestTPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[6] = new ImageIcon(new ImageIcon("resources/images/myforestP.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[7] = new ImageIcon(new ImageIcon("resources/images/myforestPPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[8] = new ImageIcon(new ImageIcon("resources/images/myforestH.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[9] = new ImageIcon(new ImageIcon("resources/images/myforestHPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[10] = new ImageIcon(new ImageIcon("resources/images/myforestE.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[11] = new ImageIcon(new ImageIcon("resources/images/myforestEPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[12] = new ImageIcon(new ImageIcon("resources/images/myforestF.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        forest[13] = new ImageIcon(new ImageIcon("resources/images/myforestFPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        
        shrub[0] = new ImageIcon(new ImageIcon("resources/images/myshrub.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[1] = new ImageIcon(new ImageIcon("resources/images/scrubhelmetplayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[2] = new ImageIcon(new ImageIcon("resources/images/myshrubK.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[3] = new ImageIcon(new ImageIcon("resources/images/myshrubKPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[4] = new ImageIcon(new ImageIcon("resources/images/myshrubT.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[5] = new ImageIcon(new ImageIcon("resources/images/myshrubTPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[6] = new ImageIcon(new ImageIcon("resources/images/myshrubP.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[7] = new ImageIcon(new ImageIcon("resources/images/myshrubPPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[8] = new ImageIcon(new ImageIcon("resources/images/myshrubH.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[9] = new ImageIcon(new ImageIcon("resources/images/myshrubHPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[10] = new ImageIcon(new ImageIcon("resources/images/myshrubE.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[11] = new ImageIcon(new ImageIcon("resources/images/myshrubEPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[12] = new ImageIcon(new ImageIcon("resources/images/myshrubF.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
        shrub[13] = new ImageIcon(new ImageIcon("resources/images/myshrubFPlayer.png").getImage().getScaledInstance(24, 29, Image.SCALE_SMOOTH));
    }
    public ImageIcon getIcon(Terrain x, Boolean player, String occu){
       int y = 0;
       int z = 0;
       if(player){
           y=1;
       }
       if(occu == null){
           
       }else{
        if (occu.equals("K")){
            z += 2;
        } else if (occu.equals("T")){
            z += 4;
        }else if(occu.equals("P")){
            z += 6;
        }else if(occu.equals("H")){
            z += 8;
        }else if(occu.equals("E")){
            z += 10;
        }else if(occu.equals("F")){
            z += 12;
        }else{
        }
       }
        switch(x){
             case SAND: 
                return sand[y+z];
            case FOREST:       
                return forest[y+z];
            case WETLAND: 
                return marsh[y+z];
            case SCRUB: 
                return shrub[y+z];
            case WATER:
                return water[y+z];
            default:
                return new ImageIcon(); 
        }
    }
}

