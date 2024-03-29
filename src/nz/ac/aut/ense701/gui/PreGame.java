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
import javax.swing.BoxLayout;
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
 * @author andre
 * This is a class to modify and simplify how our pre-game can interact 
 * with game to allow the game to have more customization from the get go.
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
    
    //This method is to setup the game i will add onto it on the new branch to create more links between a gui and the game creation.
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
        
        JLabel mapSizeLabel = new JLabel("Map Size(10-50):");
        JLabel blankLabel = new JLabel("");
        
        SpinnerNumberModel sizeModel = new SpinnerNumberModel();
        sizeModel.setStepSize(1);
        sizeModel.setValue(25);
        sizeModel.setMaximum(50);
        sizeModel.setMinimum(10);
        final JSpinner size = new JSpinner(sizeModel);
        JComponent mySizeSpinner = size.getEditor();
        JFormattedTextField sizeText = ((JSpinner.DefaultEditor)mySizeSpinner).getTextField();
        sizeText.setColumns(3);
        
        
        String[] difficult = new String[3];
        difficult[0] = "Easy";
        difficult[1] = "Medium";
        difficult[2] = "Hard";
        final JSpinner difficulties = new JSpinner(new SpinnerListModel(difficult));
        JLabel difficultLabel = new JLabel("Difficulty");
        
        JPanel mapSize = new JPanel();
        mapSize.setLayout(new GridLayout(0, 2));
        
        mapSize.add(mapSizeLabel);
        mapSize.add(size);
        
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
                    startGame(container, nameAndDifficulty, new Dimension(((Integer)size.getValue()),((Integer)size.getValue())));
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
    
    //This is an informational text window to talk of the goals of KiwiIsland. We will look to add extra functionality to this by
    //having it *not* appear everytime on launch as well as making it accessible by a button from the setup game menu.
    public void introductionGame(JPanel container){
        container.removeAll();
        container.updateUI();
        
        JLabel goal = new JLabel("In KiwiIsland your goal is to navigate the island and count all the kiwis that inhabit the island.", SwingConstants.CENTER);
        JLabel help = new JLabel("You can also find tools and food to help you on your journey.", SwingConstants.CENTER);
        JLabel tools = new JLabel("Tools can be used to eradicate the predators on the island to make the Kiwi's Island more hospitible.", SwingConstants.CENTER);
        JLabel food = new JLabel("Food are used to heal your stamina which you require to move throughout the island.", SwingConstants.CENTER);
        JLabel winning = new JLabel("The game's winning conditions are that you need to eradicate the predators or count how many Kiwi's inhabit KiwiIsland.", SwingConstants.CENTER);
        JLabel goal2 = new JLabel("Try to make your islands more inhabitable for the Kiwi's!", SwingConstants.CENTER);
        JPanel helpContainer = new JPanel();
        
        helpContainer.setLayout(new GridLayout(0,1));
        helpContainer.add(goal);
        helpContainer.add(help);
        helpContainer.add(tools);
        helpContainer.add(food);
        helpContainer.add(winning);
        helpContainer.add(goal2);
        
        JButton next = new JButton();
        next.setText("Next");
        next.setToolTipText("");
        next.setPreferredSize(new Dimension(100, 23));
        next.setMaximumSize(new Dimension(100, 23));
        next.setMinimumSize(new Dimension(100, 23));
        next.addActionListener(new NextListener(container));
        
        container.add(helpContainer, BorderLayout.CENTER);
        container.add(next, BorderLayout.SOUTH);
    }
    
    //This is a simple class that contains two image files to be displayed over oneanother.

    
    //Welcome sign could have quick user select and maybe quick game with dynamic options.
    //This is a simple first start screen.
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
        welcome.setPreferredSize(new Dimension(1000, 350));
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
