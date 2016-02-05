package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class HomePage extends JFrame{

//	private JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//new MyFileIOManager().readFromFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}
				catch(Exception e)
				{
					//do nothing..skip 
				}
				
				try {
				    
					new HomePage().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Photo gallery");
		//setBounds(100,100,700,700);
		setSize(600,600);
		setResizable(false);
		//setBackground(Color.GRAY);
		
		JButton btnExit;
		JButton btnUpload;
		JButton btnViewList;
		btnExit=new JButton("EXIT APPLICATION");
		btnUpload = new JButton("UPLOAD NEW PHOTO");
		btnViewList=new JButton("VIEW LIST");
		
		JLabel label=new JLabel("        Welcome to the photo gallery application");
		label.setFont(new Font(Font.SERIF,3,20));
		setLayout(new BorderLayout());
		ImageIcon icon=new ImageIcon(getClass().getResource("back.jpeg"));
		JLabel background=new JLabel(icon);
		add(background);
	    background.setLayout(new BorderLayout());
		JPanel mainPanel=new JPanel(new BorderLayout());
		mainPanel.setVisible(true);
		//background.add(mainPanel);
		background.add(label, BorderLayout.NORTH);
	    JPanel panel = new JPanel();
	   // mainPanel.add(panel,BorderLayout.CENTER);
		//getContentPane().add(mainPanel);
		// //getContentPane().add(background);
		background.add(panel,BorderLayout.CENTER);
		panel.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//panel.setBackground(Color.blue);
		panel.setOpaque(false);
		
		panel.add(Box.createRigidArea(new Dimension(20,60)));
		
	
		btnUpload.setBackground(Color.BLACK);
		btnUpload.setForeground(Color.WHITE);
		btnUpload.setContentAreaFilled(false);
		btnUpload.setOpaque(true);
		panel.add(btnUpload);
		btnUpload.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(Box.createRigidArea(new Dimension(20,10)));
		
		
		
		btnViewList.setBackground(Color.BLACK);
		btnViewList.setHorizontalAlignment(SwingConstants.CENTER);
		btnViewList.setForeground(Color.WHITE);
		btnViewList.setContentAreaFilled(false);
		btnViewList.setOpaque(true);
		panel.add(btnViewList);
		//mainPanel.add(panel,BorderLayout.CENTER);
		//mainPanel.setVisible(true);
		
		panel.add(Box.createRigidArea(new Dimension(20,10)));
		
		
		btnExit.setBackground(Color.BLACK);
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setForeground(Color.WHITE);
		btnExit.setContentAreaFilled(false);
		btnExit.setOpaque(true);
		panel.add(btnExit);
		
	   setSize(599,599);
	   setSize(600,600);
	   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   //actions 
		
		btnUpload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	HomePage.this.setVisible(false);
				new UploadDialog().setVisible(true);
				
			}
		});
		
		btnViewList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ViewList().setVisible(true);
			}
		});
		
		
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

}
