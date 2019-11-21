package view;

import java.awt.*;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import controller.Manager;

import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
@SuppressWarnings("deprecation")
public class StartGame extends javax.swing.JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	// Variables declaration 
	
	private Manager manager = Manager.getInstance();
    private javax.swing.JLabel archerAvailable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonStart;
    private java.awt.Choice choiceTeam;
    private java.awt.Choice choiceWarrior;
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
        buttonAdd = new JButton();
        buttonStart = new JButton();

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
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(choiceWarrior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(choiceTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelArcher, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(archerAvailable)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelWalloper, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(walloperAvailable))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(marineAvailable)
                            .addComponent(labelMarine, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 161, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(buttonAdd)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonStart)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(choiceTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(labelArcher, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelWalloper, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMarine, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(archerAvailable)
                            .addComponent(marineAvailable)
                            .addComponent(walloperAvailable))
                        .addGap(56, 56, 56)
                        .addComponent(choiceWarrior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonStart)
                        .addGap(18, 18, 18))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
        
    }// </editor-fold>                        

                                          

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	if("Archer".equals(choiceWarrior.getSelectedItem())){
    		int aux = Integer.valueOf(archerAvailable.getText());
    		if (aux != 0) {           
	            aux--;
	            archerAvailable.setText(String.valueOf(aux));
            }
        }else if("Walloper".equals(choiceWarrior.getSelectedItem())){
        	int aux = Integer.valueOf(walloperAvailable.getText());
    		if (aux != 0) {           
	            aux--;
	            walloperAvailable.setText(String.valueOf(aux));
            }
    	}else if("Marine".equals(choiceWarrior.getSelectedItem())){
        	int auxi = Integer.valueOf(marineAvailable.getText());
    		if (auxi != 0) {           
	            auxi--;
	            marineAvailable.setText(String.valueOf(auxi));           
    		}
        }
    } 
    
    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
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