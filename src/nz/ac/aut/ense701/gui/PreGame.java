/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.Document;
import nz.ac.aut.ense701.gameModel.Game;

/**
 *
 * @author dre
 */
public class PreGame extends JFrame{
    public PreGame(){
        beforeGame();
    }
    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }
    
    private class StartListener implements ActionListener{
        JPanel container;
        private StartListener(JPanel _container){
            container = _container;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            introductionGame(container);
        }
    }
    
    private class NextListener implements ActionListener{
        JPanel container;
        
        private NextListener(JPanel _container){
            container = _container;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            setupGame(container);
        }
    }
    
    private class StartGameListener implements ActionListener{
        JPanel container;
        String name;
        
        private StartGameListener(JPanel _container, String _name){
            container = _container;
            name = _name;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.print(name);
            startGame(container, name);
        }
    }
    
    
    public void startGame(JPanel container, String name){
        this.remove(container);
        this.dispose();
        final Game game = new Game(name);
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
    
    public void setupGame(final JPanel container){
        container.removeAll();
        container.updateUI();
        
        JButton start = new JButton();
        start.setText("Start Game");
        start.setToolTipText("");
        start.setPreferredSize(new Dimension(100, 23));
        start.setMaximumSize(new Dimension(100, 23));
        start.setMaximumSize(new Dimension(100, 23));
        
        
        JPanel nameLayout = new JPanel();
        nameLayout.setLayout(new BorderLayout());
        
        JLabel enterName = new JLabel("Enter your name:");
        enterName.setSize(new Dimension(400, 20));
        final JTextField name = new JTextField("");
        
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                startGame(container, name.getText());
            }
        });
                
        
        nameLayout.add(enterName, BorderLayout.WEST);
        nameLayout.add(name, BorderLayout.CENTER);
        name.setPreferredSize(new Dimension(100, 50));
        name.setMaximumSize(new Dimension(100, 50));
        
        container.add(nameLayout, BorderLayout.NORTH);
        container.add(start, BorderLayout.SOUTH);
    }
    
    public void introductionGame(JPanel container){
        container.removeAll();
        container.updateUI();
        
        JTextArea howToPlay = new JTextArea("In KiwiIsland your goal is to navigate the island and count all the kiwis that inhabit the island.\n\nYou can also find tools and food to help you on your journey.\n\nTools can be used to eradicate the predators on the island to make the Kiwi's Island more hospitible. \n\n Foods are used to heal your stamina which you require to move throughout the island. \n\nThe game's winning conditions are that you need to eradicate the predators or count how many Kiwi's inhabit KiwiIsland.");
        howToPlay.setEditable(false);
        howToPlay.setLineWrap(true);
        
        JButton next = new JButton();
        next.setText("Next");
        next.setToolTipText("");
        next.setPreferredSize(new Dimension(100, 23));
        next.setMaximumSize(new Dimension(100, 23));
        next.setMinimumSize(new Dimension(100, 23));
        next.addActionListener(new NextListener(container));
        
        container.add(howToPlay, BorderLayout.NORTH);
        container.add(next, BorderLayout.SOUTH);
    }
    
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
            g.drawImage(image2, 229, 0, this);
            g.drawImage(image, 230, 50, this);
            
        }
    }
    
    public void beforeGame(){
        JPanel welcome = new JPanel();
        JButton start = new JButton();
        JButton exit = new JButton();
        JPanel buttons = new JPanel();
        
        start.addActionListener(new StartListener(welcome));
        exit.addActionListener(new CloseListener());
       
        JLabel message = new JLabel("Welcome to KiwiIsland!", SwingConstants.CENTER);
        
        
        ImagePanel kiwi = new ImagePanel("resources/kiwi-bird.png", "resources/nz.png");
        
        
        
        exit.setText("Exit");
        exit.setToolTipText("");
        exit.setMaximumSize(new java.awt.Dimension(100, 23));
        exit.setMinimumSize(new java.awt.Dimension(100, 23));
        exit.setPreferredSize(new java.awt.Dimension(100, 23));
        
        start.setText("Start");
        start.setToolTipText("");
        start.setMaximumSize(new java.awt.Dimension(100, 23));
        start.setMinimumSize(new java.awt.Dimension(100, 23));
        start.setPreferredSize(new java.awt.Dimension(100, 23));
        
        welcome.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        welcome.setLayout(new java.awt.BorderLayout(10, 0));
        welcome.setPreferredSize(new Dimension(700, 350));
        buttons.add(start);
        buttons.add(exit);
        welcome.add(message, BorderLayout.NORTH);
        
        welcome.add(kiwi, BorderLayout.CENTER);
        welcome.add(buttons, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to KiwiIsland!");
        getContentPane().add(welcome, java.awt.BorderLayout.CENTER);
        pack();
    }
    
}
