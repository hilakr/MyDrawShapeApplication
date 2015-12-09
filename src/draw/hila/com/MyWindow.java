package draw.hila.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//MyWindow class responsible for creating the user GUI 
public class MyWindow {
	
	//Buttons for the gui		
	JButton line,circle,curve,polygon,clear;	
	//buttonPanel is panel that include the default buttons 
	final JPanel buttonPanel = new JPanel();
	//userInputPanel is panel that include input fields from the user in the gui
	final JPanel userInputPanel = new JPanel();
	//messagePanel is panel that include the buttonPanel and the userInputPanel
	final JPanel messagePanel = new JPanel();
	//input field is the input field from the user .
	static JTextField input = new JTextField();
	//panel is Object from DrawShape class, and this object responsible for drawing shapes .
	final static DrawShape panel = new DrawShape();
	protected static final int PADDING = 0;
	//app is JFrame that include all the previous components .	
	final JFrame app = new JFrame();
	
	//MyWindow constructor creates the gui .
	MyWindow (){
	//create the message panel
	messagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0,0));
	messagePanel.setLayout(new BorderLayout());
	messagePanel.setPreferredSize(new Dimension(200,150));
	//create the buttons
	line =  new JButton ("line");
	circle = new JButton ("circle");
	curve = new JButton ("curve");
	polygon = new JButton ("polygon");
	clear =  new JButton ("clear");
	//add the buttons to the buttonPanel
	buttonPanel.add(line);
	buttonPanel.add(circle);
	buttonPanel.add(curve);
	buttonPanel.add(polygon);
	buttonPanel.add(clear);
	//add buttonPanel to messagePanel
	messagePanel.add(buttonPanel,BorderLayout.PAGE_START);
	//create userInputPanel	
	userInputPanel.setLayout(new FlowLayout());
	userInputPanel.setPreferredSize(new Dimension (300,200));
	JTextArea textArea = new JTextArea(
            "Welcome to Draw Shape App, Choose a shape to begin :) " , 5, 50);
	   textArea.setLineWrap(true);
	   textArea.setWrapStyleWord(true);
	   textArea.setOpaque(false);
	   textArea.setEditable(false);
	   textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, -30,-25));
	userInputPanel.add(textArea);
	userInputPanel.setVisible(true);
	
	
	
	
	//userInputPanel.setVisible(false);
	//add userInputPanel to messagePanel
	messagePanel.add(userInputPanel,BorderLayout.CENTER);	
	//create the app JFrame
	app.setLayout(new BorderLayout());
	app.add(messagePanel,BorderLayout.PAGE_START);
	app.add(panel);
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	app.setSize(600,600);
	app.setVisible(true);
	    
		//Add Action Listeners for the buttons 	    
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
            {
				panel.shape = Shape.LINE;
				userInputPanel.setVisible(false);
				//Execute when button is pressed
				userInputPanel.removeAll();
			    userInputPanel.revalidate();
				JTextArea textArea = new JTextArea(
						"Hi, To draw a straight line you have to click on two points on the surface." , 5, 40);
				 //  textArea.setFont(new Font("David", Font.DIALOG, 12));
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				textArea.setOpaque(false);
				textArea.setEditable(false);
				textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, -30,-25));
				userInputPanel.add(textArea);
			    userInputPanel.setVisible(true);
				System.out.println("You clicked the button");
            }
			
			
		} );
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
            {
				panel.shape = Shape.CIRCLE;
				userInputPanel.setVisible(false);
				userInputPanel.removeAll();
		        userInputPanel.revalidate();
				JTextArea textArea = new JTextArea(
		                "Hi, To create a circle, you have to click two clicks: " +
		                "The first click is the center of the circle and the second click is a point on the circumference of the circle." , 5, 50);
				 //  textArea.setFont(new Font("David", Font.DIALOG, 12));
				   textArea.setLineWrap(true);
				   textArea.setWrapStyleWord(true);
				   textArea.setOpaque(false);
				   textArea.setEditable(false);
				   textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, -30,-25));
				userInputPanel.add(textArea);
				userInputPanel.setVisible(true);
                System.out.println("You clicked the button");
            }
			
			
		} );
		curve.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
            {
				panel.shape = Shape.CURVE;
				userInputPanel.setVisible(false);
				userInputPanel.removeAll();
			    userInputPanel.revalidate();
				JButton button =  new JButton("Change number of lines and click");
				JTextArea textArea = new JTextArea(
			                "Hi, In order to draw curve you should click on the surface 4 check points. " +
			                "if you want to improve the curve you can increase the number of the accuracy lines. " , 5, 35);
			 //  textArea.setFont(new Font("David", Font.DIALOG, 12));
			   textArea.setLineWrap(true);
			   textArea.setWrapStyleWord(true);
			   textArea.setOpaque(false);
			   textArea.setEditable(false);
			   textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, -30,-25));
			   userInputPanel.add(textArea);
			   JPanel temp = new JPanel();
			   temp.setSize(40, 10);
			   input = new JTextField ("20",5);
			   temp.add(input);
			   temp.add(button);
			   userInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, PADDING, PADDING));
			   userInputPanel.add(temp,FlowLayout.CENTER);
			   userInputPanel.setVisible(true);
			   System.out.println("You clicked the curve button");
			   button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
			        {
						panel.repaint();
						
			        }
					
				});
				
            }
			
			
		} );
		polygon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
            {
				
				panel.shape = Shape.POLYGON;
				userInputPanel.setVisible(false);
				userInputPanel.removeAll();
			    userInputPanel.revalidate();
				JTextArea textArea = new JTextArea(
						"Hi, To draw a polygon you must click on two points: a mid-point, point on the perimeter and noted a number of ribs." , 5, 40);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				textArea.setOpaque(false);
				textArea.setEditable(false);
				textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, -30,-25));
				userInputPanel.add(textArea);
				Label descrip =  new Label("Change number of ribs and click:");
				JPanel temp = new JPanel();
				temp.setSize(40, 10);
				input = new JTextField ("5",5);
				temp.add(descrip);
				temp.add(input);
				userInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, PADDING, PADDING));
				userInputPanel.add(temp,FlowLayout.CENTER);
				
				userInputPanel.setVisible(true);
            }
		} );
		
	   
    clear.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
        {
			panel.shape = Shape.CLEAR;
			userInputPanel.setVisible(false);
			userInputPanel.removeAll();
		    userInputPanel.revalidate();
			JTextArea textArea = new JTextArea(
					"Clear the surface..." , 5, 40);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setOpaque(false);
			textArea.setEditable(false);
			textArea.setBorder(BorderFactory.createEmptyBorder(10, 0, -30,-25));
			userInputPanel.add(textArea);
			userInputPanel.setVisible(true);
			panel.clicksforLine.clear();
			panel.clicksforCircle.clear();
			panel.clicksforCurve.clear();
			panel.clicksforPoly.clear();
			panel.repaint();
			
        }
    });



	};
		

}
