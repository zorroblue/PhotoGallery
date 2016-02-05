package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		setBounds(100,100,700,700);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.blue);
		//panel.setOpaque(false);
		panel.add(Box.createRigidArea(new Dimension(20,10)));
		
		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.setBackground(Color.BLACK);
		btnUpload.setForeground(Color.WHITE);
	
		btnUpload.setContentAreaFilled(false);
		btnUpload.setOpaque(true);
		panel.add(btnUpload);
		
		panel.add(Box.createRigidArea(new Dimension(20,10)));
		
	
		JButton btnSlideShow = new JButton("START SLIDESHOW");
		btnSlideShow.setBackground(Color.BLACK);
		btnSlideShow.setForeground(Color.WHITE);
		btnSlideShow.setContentAreaFilled(false);
		btnSlideShow.setOpaque(true);
		panel.add(btnSlideShow);
		
		
		panel.add(Box.createRigidArea(new Dimension(20,10)));
		
		
		JButton btnViewList=new JButton("VIEW LIST");
		btnViewList.setBackground(Color.BLACK);
		
		btnViewList.setForeground(Color.WHITE);
		btnViewList.setContentAreaFilled(false);
		btnViewList.setOpaque(true);
		panel.add(btnViewList);
		
		
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
	}

}
