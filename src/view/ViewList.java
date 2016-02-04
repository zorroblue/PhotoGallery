package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

public class ViewList {

	private JFrame frame=new JFrame();
	private int width=600,height=450;
	BufferedImage image=null;
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewList window = new ViewList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewList() {
		initialize();
	}

/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		

		
		 frame.setSize(width, height);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
        
        try {
			image = ImageIO.read(new File("src/1.png"));
			if(image==null)
				throw new IOException();
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JPanel glass = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null);
			}
			
		};
        glass.setSize(450, 750);
//        glass.setBackground(Color.BLUE);
        glass.setVisible(true);

        
        JPanel controls = new JPanel();
        controls.setSize(150, 750);
  //      controls.setBackground(Color.RED);
        	
        controls.setVisible(true);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(width, height);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation(150);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(glass);

        frame.add(splitPane);
      //  frame.setVisible(true);
		
	
		
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}

}
