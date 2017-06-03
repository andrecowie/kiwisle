/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import nz.ac.aut.ense701.gameModel.Game;

/**
 *
 * @author dre
 */
public class EndGame extends JFrame{
    Game game;
    URI docUri;
    URI kiwiUri;
    public EndGame(Game _game){
        try {
            this.docUri = new URI("http://www.doc.govt.nz/");
            this.kiwiUri = new URI("https://www.kiwisforkiwi.org/about-kiwi/kiwi-facts-characteristics/");
        } catch (URISyntaxException ex) {
            Logger.getLogger(EndGame.class.getName()).log(Level.SEVERE, null, ex);
        } 
        game = _game;
        endOfGame();
    }
    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }
    private class KiwiInfoListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            open(kiwiUri);
        }
        
    }
    private class DocListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            open(docUri);
        }
        
    }
    
    private static void open(URI uri) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(uri);
      } catch (IOException e) { /* TODO: error handling */ }
    } else { /* TODO: error handling */ }
    }
    
    private class StartListener implements ActionListener{
        JPanel container;
        private StartListener(JPanel _container){
            container = _container;
        }
        public void actionPerformed(ActionEvent ae) {
            String[] nameAndDifficulty = new String[2];
            nameAndDifficulty[0] = game._playerName;
            nameAndDifficulty[1] = game.difficulty;
            Dimension _mapSize = game.mapSize;
            final Game game = new Game(nameAndDifficulty, _mapSize);
            final KiwiCountUI  gui  = new KiwiCountUI(game);
            java.awt.EventQueue.invokeLater(new Runnable() 
            {
                @Override
                public void run() 
                {
                    gui.setVisible(true);
                }
            });
        }
    }
    
    private void endOfGame(){
        JPanel welcome = new JPanel();
        JLabel message = new JLabel("Thanks for playing KiwiIsland!", SwingConstants.CENTER);
        ImagePanel kiwi = new ImagePanel("resources/kiwi-bird.png", "resources/nz.png");
        
        
        JButton start = new JButton();
        JButton exit = new JButton();
        JButton doc = new JButton();
        JButton kiwiinfo = new JButton();
        JPanel buttons = new JPanel();
        
        start.addActionListener(new StartListener(welcome));
        exit.addActionListener(new CloseListener());
        doc.addActionListener(new DocListener());
        kiwiinfo.addActionListener(new KiwiInfoListener());
        
        exit.setText("Exit");
        exit.setToolTipText("");
        exit.setMaximumSize(new java.awt.Dimension(100, 23));
        exit.setMinimumSize(new java.awt.Dimension(100, 23));
        exit.setPreferredSize(new java.awt.Dimension(100, 23));
        
        start.setText("Replay");
        start.setToolTipText("");
        start.setMaximumSize(new java.awt.Dimension(100, 23));
        start.setMinimumSize(new java.awt.Dimension(100, 23));
        start.setPreferredSize(new java.awt.Dimension(100, 23));
        
        doc.setText("DOC");
        doc.setToolTipText("");
        doc.setMaximumSize(new java.awt.Dimension(100, 23));
        doc.setMinimumSize(new java.awt.Dimension(100, 23));
        doc.setPreferredSize(new java.awt.Dimension(100, 23));
        
        kiwiinfo.setText("Kiwi's");
        kiwiinfo.setToolTipText("");
        kiwiinfo.setMaximumSize(new java.awt.Dimension(100, 23));
        kiwiinfo.setMinimumSize(new java.awt.Dimension(100, 23));
        kiwiinfo.setPreferredSize(new java.awt.Dimension(100, 23));
        
        welcome.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        welcome.setLayout(new java.awt.BorderLayout(10, 0));
        welcome.setPreferredSize(new Dimension(1000, 1000));
        buttons.add(start);
        buttons.add(exit);
        buttons.add(doc);
        buttons.add(kiwiinfo);
        welcome.add(message, BorderLayout.NORTH);
        
        welcome.add(kiwi, BorderLayout.CENTER);
        welcome.add(buttons, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thanks for playing KiwiIsland!");
        getContentPane().add(welcome, java.awt.BorderLayout.CENTER);
        pack();
        
    }
    
}
