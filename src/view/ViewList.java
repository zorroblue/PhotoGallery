package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;

public class ViewList extends JFrame {

	
	private int width=1000,height=750;
	BufferedImage image=null;
	int numberOfImages;
	int selectedIndex;
	/**
	 * Create the application.
	 */
	public ViewList() {
		initialize();
	}

/**
	 * Initialize the contents of the this.
	 */
	
	
	private void initialize() {
		

		this.setTitle("PHOTO LIST");
		 this.setSize(width, height);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	        ImageIcon left=new ImageIcon(getClass().getResource("left.png"));
	    	ImageIcon right=new ImageIcon(getClass().getResource("right.png"));
	    	JButton leftButton=new JButton("",left);
	    	JButton rightButton=new JButton("",right);
		JPanel rightPanel=new JPanel(new BorderLayout(10, 10));
        rightPanel.setVisible(true);
        
        
        final JPanel glass = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(image, 50, 50, null);
			}
			
		};
		rightPanel.setSize(500,750);
        glass.setSize(450, 450);
        
        JPanel controls = new JPanel();
        controls.setLayout(new BorderLayout());
        controls.setSize(200, 750);
  //      controls.setBackground(Color.RED);
        JLabel jltitle=new JLabel("Titles");
        jltitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        controls.add(jltitle,BorderLayout.NORTH);
       controls.add(new JLabel(""),BorderLayout.LINE_END);
       
        ArrayList<String> listItems=new Controller().getTitles();
        System.out.println("SIZE: "+listItems.size());
        final JList list=new JList(listItems.toArray());
        list.setLayoutOrientation(JList.VERTICAL);
        list.setFont(new Font(Font.SERIF,3,20));
        controls.add(list,BorderLayout.CENTER);
        controls.setVisible(true);
        final JLabel title=new JLabel();
        final JLabel description =new JLabel();
        
      //  description.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        list.addListSelectionListener(new ListSelectionListener() {
		
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(list.getSelectedIndex());
				selectedIndex=list.getSelectedIndex();
				String s=(String)list.getSelectedValue();
				image=new Controller().getImageByTitle(s);
				title.setText("Title: "+s);
				title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
				description.setText("Annotation: "+new Controller().getAnnoByTitle(s));
				description.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
				glass.revalidate();
				glass.repaint();
			//	Toast.makeToast(ViewList.this, "Title:"+s+"\n\n Annotation: "+new Controller().getAnnoByTitle(s), 3);
				
			}
		});
        
        rightPanel.add(glass);
        ImageIcon leftArrow=new ImageIcon("right.png");
        
        JPanel footer=new JPanel();
        JPanel desPanel=new JPanel();
        desPanel.setLayout(new BoxLayout(desPanel, BoxLayout.Y_AXIS));
        desPanel.add(title);
        desPanel.add(description);
        
      
        //        JButton rightArrow=new JButton(new)
        rightPanel.add(desPanel,BorderLayout.SOUTH);
       
        leftButton.setOpaque(true);
        leftButton.setForeground(Color.BLUE);
        rightPanel.add(leftButton,BorderLayout.WEST);
        rightPanel.add(rightButton,BorderLayout.EAST);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(width, height);
        splitPane.setDividerSize(2);
        splitPane.setDividerLocation(200);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(controls);
        splitPane.setRightComponent(rightPanel);

        getContentPane().add(splitPane);
      //  this.setVisible(true);
		
        numberOfImages=new Controller().getPhotos().size();
        leftButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(numberOfImages==0)
					return;
				if(selectedIndex>0)
					list.setSelectedIndex(selectedIndex-1);
				else
					list.setSelectedIndex(numberOfImages-1);
			}
		});
		
        numberOfImages=new Controller().getPhotos().size();
        
        rightButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Pressed");
				// TODO Auto-generated method stub
				if(selectedIndex<numberOfImages)
					list.setSelectedIndex((selectedIndex+1)%numberOfImages);
				else
					list.setSelectedIndex(0);
			}
		});
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}
	
}
