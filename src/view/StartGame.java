package view;

import java.awt.*;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import controller.Manager;
import java.util.ArrayList;

import commons.IContants;
import controller.Team;

import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.*;
/**
 *
 * @author Alexander
 */

@SuppressWarnings("deprecation")
public class StartGame extends javax.swing.JFrame implements IContants, Observer{
	private static final long serialVersionUID = 1L;
	private Manager manager = null;
	private ArrayList<Warrior> Team1 = new ArrayList<Warrior>();
	private ArrayList<Warrior> Team2 = new ArrayList<Warrior>();
	private ArrayList<Warrior> Team3 = new ArrayList<Warrior>();
	private int destinyTeam1 = UPPERCORNER;
	private int destinyTeam2 = CENTER;
	private int destinyTeam3 = LOWERCORNER;
	
    private javax.swing.JLabel archerAvailable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonSetDestiny;
    private java.awt.Choice choiceTeam;
    private java.awt.Choice choiceWarrior;
    private java.awt.Choice choiceDestiny;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelArcher;
    private javax.swing.JLabel labelMarine;
    private javax.swing.JLabel labelWalloper;
    private javax.swing.JLabel marineAvailable;
    private javax.swing.JLabel walloperAvailable;
    // End of variables declaration        
	
	
    /**
     * Creates new form NewJFrame
     */
    public StartGame() {
        this.setTitle("Config Game");
        manager = Manager.getInstance();
        manager.addObserver(this);
        initComponents();
    }

                   
    private void initComponents() {

        labelArcher = new JLabel();
        labelWalloper = new JLabel();
        labelMarine = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        choiceWarrior = new Choice();
        archerAvailable = new JLabel();
        marineAvailable = new JLabel();
        walloperAvailable = new JLabel();
        choiceTeam = new Choice();
        choiceDestiny = new Choice();
        buttonAdd = new JButton();
        buttonStart = new JButton();
        buttonSetDestiny = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Archer");

        jLabel2.setText("Walloper");

        jLabel3.setText("Marine");

        archerAvailable.setText("3");

        marineAvailable.setText("2");

        walloperAvailable.setText("6");

        buttonAdd.setText("Add warrior");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonStart.setText(" All ready");

        buttonSetDestiny.setText("Set Destiny To Team");
        buttonSetDestiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetDestinyActionPerformed(evt);
            }
        });
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(archerAvailable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelWalloper, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(walloperAvailable))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marineAvailable)
                                    .addComponent(labelMarine, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(choiceWarrior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(choiceTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelArcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSetDestiny)
                                    .addComponent(choiceDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(204, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(buttonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonStart)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(choiceTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelArcher, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelWalloper, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMarine, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(archerAvailable)
                                    .addComponent(marineAvailable)
                                    .addComponent(walloperAvailable))
                                .addGap(56, 56, 56)
                                .addComponent(choiceWarrior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(choiceDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonStart)
                            .addComponent(buttonSetDestiny))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonAdd)
                        .addGap(32, 32, 32))))
        );

        pack();
        
        ImageIcon archer = new ImageIcon(getClass().getResource("images\\archer.png"));
        ImageIcon walloper = new ImageIcon(getClass().getResource("images\\walloper.png"));
        ImageIcon  marine = new ImageIcon(getClass().getResource("images\\marine.png"));       
        Icon iconoArcher = new ImageIcon(archer.getImage().getScaledInstance(labelArcher.getWidth(), labelArcher.getHeight(), Image.SCALE_DEFAULT));
        Icon iconoWalloper = new ImageIcon(walloper.getImage().getScaledInstance(labelArcher.getWidth(), labelArcher.getHeight(), Image.SCALE_DEFAULT));
        Icon iconoMarine = new ImageIcon(marine.getImage().getScaledInstance(labelArcher.getWidth(), labelArcher.getHeight(), Image.SCALE_DEFAULT));
        labelArcher.setIcon(iconoArcher);
        labelWalloper.setIcon(iconoWalloper);
        labelMarine.setIcon(iconoMarine);
        choiceWarrior.add("Archer");
        choiceWarrior.add("Walloper");
        choiceWarrior.add("Marine");
        choiceTeam.add("Team1");
        choiceTeam.add("Team2");
        choiceTeam.add("Team3");
        choiceDestiny.add("Upper corner");
        choiceDestiny.add("Center");
        choiceDestiny.add("Lower corner");
        
    }// </editor-fold>                        

                                          

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {  
    	
    	if("Archer".equals(choiceWarrior.getSelectedItem())){
    		int aux = Integer.valueOf(archerAvailable.getText());
    		if (aux != 0) {           
	            aux--;
	            archerAvailable.setText(String.valueOf(aux));
	            if("Team1".equals(choiceTeam.getSelectedItem())) {
	            	Team1.add(new Acher());
	            }else if("Team2".equals(choiceTeam.getSelectedItem())){
	            	Team2.add(new Acher());
	            }else if("Team3".equals(choiceTeam.getSelectedItem())){
	            	Team3.add(new Acher());
	            }
            }else {
            	JOptionPane.showMessageDialog(null, "No archers available", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    		
        }    	
    	else if("Walloper".equals(choiceWarrior.getSelectedItem())){
        	int aux = Integer.valueOf(walloperAvailable.getText());
    		if (aux != 0) {           
    			aux--;
	            walloperAvailable.setText(String.valueOf(aux));
	            if("Team1".equals(choiceTeam.getSelectedItem())) {
	            	Team1.add(new Walloper());
	            }else if("Team2".equals(choiceTeam.getSelectedItem())){
	            	Team2.add(new Walloper());
	            }else if("Team3".equals(choiceTeam.getSelectedItem())){
	            	Team3.add(new Walloper());
	            }
            }else {
            	JOptionPane.showMessageDialog(null, "No wallopers available", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    	}else if("Marine".equals(choiceWarrior.getSelectedItem())){
        	int auxi = Integer.valueOf(marineAvailable.getText());
    		if (auxi != 0) {           
    			auxi--;
	            marineAvailable.setText(String.valueOf(auxi));
	            if("Team1".equals(choiceTeam.getSelectedItem())) {
	            	Team1.add(new Marine());
	            }else if("Team2".equals(choiceTeam.getSelectedItem())){
	            	Team2.add(new Marine());
	            }else if("Team3".equals(choiceTeam.getSelectedItem())){
	            	Team3.add(new Marine());
	            }           
    		}else {
            	JOptionPane.showMessageDialog(null, "No Marine available", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
    
    private void buttonSetDestinyActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	if("Upper corner".equals(choiceDestiny.getSelectedItem())){   		
            if("Team1".equals(choiceTeam.getSelectedItem())) {
            	destinyTeam1 = UPPERCORNER;
            }else if("Team2".equals(choiceTeam.getSelectedItem())){
            	destinyTeam2 = UPPERCORNER;
            }else if("Team3".equals(choiceTeam.getSelectedItem())){
            	destinyTeam3 = UPPERCORNER;
            }
                		
        }    	
    	else if("Center".equals(choiceDestiny.getSelectedItem())){
    		if("Team1".equals(choiceTeam.getSelectedItem())) {
    			destinyTeam1 = CENTER;
    		}else if("Team2".equals(choiceTeam.getSelectedItem())){
    			destinyTeam2 = CENTER;
    		}else if("Team3".equals(choiceTeam.getSelectedItem())){
    			destinyTeam3 = CENTER;
    		}
    	}else if("Lower corner".equals(choiceDestiny.getSelectedItem())){
    		if("Team1".equals(choiceTeam.getSelectedItem())) {
    			destinyTeam1 = LOWERCORNER;
    		}else if("Team2".equals(choiceTeam.getSelectedItem())){
    			destinyTeam2 = LOWERCORNER;
    		}else if("Team3".equals(choiceTeam.getSelectedItem())){
    			destinyTeam3 = LOWERCORNER;
    		}
    	}
    }


    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {  
        if(Integer.valueOf(marineAvailable.getText())+Integer.valueOf(walloperAvailable.getText())+Integer.valueOf(archerAvailable.getText()) == 0) {        	
        	ArrayList<Integer> auxDest = new ArrayList<>();
        	auxDest.add(destinyTeam1);
        	auxDest.add(destinyTeam2);
        	auxDest.add(destinyTeam3);
        	manager.getGameAdjusments(new Team(Team1), new Team(Team2),new Team(Team3), auxDest);
        }else {
        	JOptionPane.showMessageDialog(null, "You must assign all warriors", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Integer && (int)arg == 1) {
			this.setVisible(true);
		}
		if (arg instanceof Integer && (int)arg == 2) {
			this.setVisible(false);
		}
	}
}
