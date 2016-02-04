package view;
	//package com.tutorialspoint.gui;

	import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	public class SwingContainerDemo {
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   private JLabel msglabel;

	   public SwingContainerDemo(){
	      prepareGUI();
	   }

	   public static void main(String[] args){
	      SwingContainerDemo  swingContainerDemo = new SwingContainerDemo();  
	      swingContainerDemo.showJPanelDemo();
	   }

	   private void prepareGUI(){
	      mainFrame = new JFrame("Java Swing Examples");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    

	      statusLabel.setSize(350,100);

	      msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);
		JLabel imageLabel=new JLabel();

		 controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());
		
		BufferedImage image=null;
		try {
			image = ImageIO.read(new File("b.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(image==null)
			System.out.println("Enter proper image");
		else
		{
			imageLabel.setIcon(new ImageIcon(fitimage(image,imageLabel.getWidth(),imageLabel.getHeight())));
			controlPanel.add(imageLabel);
		}	
			

	     

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }


	private Image fitimage(Image img , int w , int h)
{
    BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = resizedimage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(img, 0, 0,w,h,null);
    g2.dispose();
    return resizedimage;
}
	   private void showJPanelDemo(){
	      headerLabel.setText("Container in action: JPanel");      

	      JPanel panel = new JPanel();
	      panel.setBackground(Color.magenta);
	      panel.setLayout(new FlowLayout());        
	      panel.add(msglabel);

	      controlPanel.add(panel);        
	      mainFrame.setVisible(true);      
	   }   
	}

