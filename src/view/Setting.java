package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.hamcrest.core.IsInstanceOf;

import commons.IContants;
import controller.Manager;

@SuppressWarnings("deprecation")
public class Setting extends JFrame implements IContants, Observer{
	private static final long serialVersionUID = 1L;
	
	private JButton btReady = null;
	private JTextField archer_team1 = null;
	private JTextField archer_team2 = null;
	private JTextField archer_team3 = null;
	private JTextField marine_team1 = null;
	private JTextField marine_team2 = null;
	private JTextField marine_team3 = null;
	private JTextField walloper_team1 = null;
	private JTextField walloper_team2 = null;
	private JTextField walloper_team3 = null;
	private BufferedImage marine_image = null;
	private BufferedImage walloper_image = null;
	private BufferedImage archer_image = null;
	
	private Manager manager = null;
	
	public Setting() {
		super("Game setting");
		loadImage();
		manager = Manager.getInstance();
		manager.addObserver(this);
		this.setSize(WIDTH_SETTING, HEIGHT_SETTING);
		this.setLocation(X_SETTING,Y_SETTING);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		initComponents();
		initListeners();
		this.setLayout(null);
	}
	
	
	private void loadImage() {
		try {
			archer_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("\\images\\archer.png"));
			marine_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("images\\marine.png"));
			walloper_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("images\\walloper.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setVisible(boolean pVisible) {
		super.setVisible(pVisible);
	}
	
	private void initComponents() {
		btReady = new JButton("!READY¡");
		JLabel titleAcher = new JLabel("Archer");
		JLabel titleMarine = new JLabel("Marine");
		JLabel titleWalloper = new JLabel("Walloper");
		archer_team1 = new JTextField();
		archer_team2 = new JTextField();
		archer_team3 = new JTextField();
		marine_team1 = new JTextField();
		marine_team2 = new JTextField();
		marine_team3 = new JTextField();
		walloper_team1 = new JTextField();
		walloper_team2 = new JTextField();
		walloper_team3 = new JTextField();
		
		titleAcher.setBounds(20, ARCHER_SETTING_X, RADIO_POINT, 100);
		titleMarine.setBounds(20, MARINE_SETTING_X, RADIO_POINT, 100);
		titleWalloper.setBounds(20, WALLOPER_SETTING_X, RADIO_POINT*2, 100);
		btReady.setBounds(BTREADY_SETTING_X, BTREADY_SETTING_Y, BT_WIDTH, BT_HEIGHT);
		archer_team1.setBounds(ARCHER_SETTING_X, ARCHER_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		archer_team2.setBounds(MARINE_SETTING_X, ARCHER_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		archer_team3.setBounds(WALLOPER_SETTING_X, ARCHER_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		marine_team1.setBounds(ARCHER_SETTING_X, MARINE_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		marine_team2.setBounds(MARINE_SETTING_X, MARINE_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		marine_team3.setBounds(WALLOPER_SETTING_X, MARINE_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		walloper_team1.setBounds(ARCHER_SETTING_X, WALLOPER_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		walloper_team2.setBounds(MARINE_SETTING_X, WALLOPER_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		walloper_team3.setBounds(WALLOPER_SETTING_X, WALLOPER_SETTING_X, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		
		
		this.add(titleAcher);
		this.add(titleMarine);
		this.add(titleWalloper);
		this.add(btReady);
		this.add(archer_team1);
		this.add(archer_team2);
		this.add(archer_team3);
		this.add(marine_team1);
		this.add(marine_team2);
		this.add(marine_team3);
		this.add(walloper_team1);
		this.add(walloper_team2);
		this.add(walloper_team3);
	}
	
	private void initListeners() {
		btReady.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	}
	
	
	private void getTextFlied() {
		int archer_team1 = 0;
		int archer_team2 = 0;
		int archer_team3 = 0;
		int marine_team1 = 0;
		int marine_team2 = 0;
		int marine_team3 = 0;
		int walloper_team1 = 0;
		int walloper_team2 = 0;
		int walloper_team3 = 0;
		String value = "";
		try {
			archer_team1 = getValue(this.archer_team1.getText());
			archer_team2 = getValue(this.archer_team1.getText());
			archer_team3 = getValue(this.archer_team1.getText());
			marine_team1 = getValue(this.archer_team1.getText());
			marine_team2 = getValue(this.archer_team1.getText());
			marine_team3 = getValue(this.archer_team1.getText());
			walloper_team1 = getValue(this.archer_team1.getText());
			walloper_team2 = getValue(this.archer_team1.getText());
			walloper_team3 = getValue(this.archer_team1.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private int getValue(String pValue) throws Exception {
		int value = 0;
		try {
			if (pValue == "")
				value = 0;
			else 
				value = Integer.parseInt(pValue);	
		} catch (Exception e) {
			throw new Exception("\"Enter only numbers in the field\"");
		}
		return value;
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(archer_image, ARCHER_SETTING_X, WARRIOR_SETTING_Y, RADIO_POINT, RADIO_POINT, null);
		g.drawImage(marine_image,   MARINE_SETTING_X, WARRIOR_SETTING_Y, RADIO_POINT, RADIO_POINT, null);
		g.drawImage(walloper_image,  WALLOPER_SETTING_X, WARRIOR_SETTING_Y, RADIO_POINT, RADIO_POINT, null);
	}

	public void update(Observable o, Object arg) {
		
		if (arg instanceof Integer && (int)arg == 1) {
			this.setVisible(true);
		}
		
	}

}
