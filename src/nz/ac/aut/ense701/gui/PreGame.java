/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatter;
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
    
    
    public void startGame(JPanel container, String[] nameAndDifficulty, Dimension mapSize){
        this.remove(container);
        this.dispose();
        
        final Game game = new Game(nameAndDifficulty, mapSize);
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
        
        JPanel mapSizePanel = new JPanel();
        mapSizePanel.setLayout(new BorderLayout());
        
        JLabel mapSizeLabel = new JLabel("Map Size:");
        JLabel blankLabel = new JLabel("");
        
        JLabel heightLabel = new JLabel("Height: ");
        JLabel widthLabel = new JLabel("Width: ");
        
        SpinnerNumberModel widthModel = new SpinnerNumberModel();
        widthModel.setStepSize(1);
        widthModel.setValue(25);
        widthModel.setMaximum(50);
        widthModel.setMinimum(5);
        SpinnerNumberModel heightModel = new SpinnerNumberModel();
        heightModel.setStepSize(1);
        heightModel.setValue(25);
        heightModel.setMaximum(50);
        heightModel.setMinimum(5);
        final JSpinner width = new JSpinner(widthModel);
        JComponent myWidthSpinner = width.getEditor();
        JFormattedTextField widthText = ((JSpinner.DefaultEditor)myWidthSpinner).getTextField();
        widthText.setColumns(3);
        final JSpinner height = new JSpinner(heightModel);
        JComponent myHeightSpinner = height.getEditor();
        JFormattedTextField heightText = ((JSpinner.DefaultEditor)myHeightSpinner).getTextField();
        heightText.setColumns(3);
        
        
        String[] difficult = new String[3];
        difficult[0] = "Easy";
        difficult[1] = "Medium";
        difficult[2] = "Hard";
        final JSpinner difficulties = new JSpinner(new SpinnerListModel(difficult));
        JLabel difficultLabel = new JLabel("Difficulty");
        
        JPanel mapSize = new JPanel();
        mapSize.setLayout(new GridLayout(0, 2));
        
        mapSize.add(mapSizeLabel);
        mapSize.add(blankLabel);
        mapSize.add(widthLabel);
        mapSize.add(width);
        mapSize.add(heightLabel);
        mapSize.add(height);
        mapSize.add(difficultLabel);
        mapSize.add(difficulties);
        
        
        mapSizePanel.add(mapSize, BorderLayout.NORTH);
        
        nameLayout.add(enterName, BorderLayout.WEST);
        nameLayout.add(name, BorderLayout.CENTER);
        name.setPreferredSize(new Dimension(100, 50));
        name.setMaximumSize(new Dimension(100, 50));
        
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(name.getText().length() > 0){
                    String[] nameAndDifficulty = new String[2];
                    nameAndDifficulty[0] = name.getText();
                    nameAndDifficulty[1] = (String) difficulties.getValue();
                    startGame(container, nameAndDifficulty, new Dimension(((Integer)width.getValue()),((Integer) height.getValue())));
                }else{
                    JPanel errorPanel = new JPanel();
                    errorPanel.setLayout(new BorderLayout());
                    JLabel inputName = new JLabel("Please provide a name.");
                    errorPanel.add(inputName, BorderLayout.NORTH);
                    container.add(errorPanel, BorderLayout.CENTER);
                    container.updateUI();
                }
                
            }
        });
        
        container.add(mapSizePanel, BorderLayout.WEST);
        container.add(nameLayout, BorderLayout.NORTH);
        container.add(start, BorderLayout.SOUTH);
    }
    
    public void introductionGame(JPanel container){
        container.removeAll();
        container.updateUI();
        
        JTextArea howToPlay = new JTextArea("In KiwiIsland your goal is to navigate the island and count all the kiwis that inhabit the island.\n\nYou can also find tools and food to help you on your journey.\n\nTools can be used to eradicate the predators on the island to make the Kiwi's Island more hospitible.\n\nThe game's winning conditions are that you need to eradicate the predators and know how many Kiwi's inhabit KiwiIsland.");
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
