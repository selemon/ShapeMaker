package shapes;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * this class is responsible for setting up the interface 
 * 
 * @author selemon
 * */
public class Shapes {

	private JFrame frame;
	private DrawingCanves canvas;
	private int width = 40, height =40;
	private volatile static String shapeSelected = "Circle";
	private final JFileChooser fc = new JFileChooser();

	public void setupInterface(){
		//Create and set up the window.
		frame = new JFrame("Lets make shapes my nigga");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 550);

		//add canves on to the frame
		canvas = new DrawingCanves();
		canvas.addCanvas();
		frame.getContentPane().add(canvas.getCanvas());

		//add buttons
		addButtons();

		//Display the window.
		//	    frame.pack();
		frame.setVisible(true);
	}

	/**
	 * returns the shape that is selected
	 * 
	 * */
	public static String getShape(){
		return shapeSelected;
	}
	

	/**
	 * this method adds buttons to the screen
	 * and also adds action listeners to the buttons
	 * */
	private void addButtons() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();

		JButton load = new JButton("Load");
		JButton clear = new JButton("Clear");

		//respons for the button clear
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				//checking to see if the clear button is selected
				if(a.getActionCommand().equals("Clear")){
					canvas.getCanvas().repaint();
				}

			}
		});

		//response for load
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnVal = 0;
				if(e.getActionCommand().equals("Load")){
					 returnVal = fc.showOpenDialog(null);
				}
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            //This is where a real application would open the file.
		            FileReader r = new FileReader();
		            final ArrayList<Point> s = r.Read(file);
		            
		            Thread t = new Thread(new Runnable() {
						
		            	//this allows the user to draw on the screen while 
		            	//the content in the file is being drawn on the screen concurrently
						@Override
						public void run() {
							// TODO Auto-generated method stub
							canvas.DrawFile(s);
						}
					});
		            t.start();
//		           canvas.DrawFile(s);
		            
		            
		        } 
				
				
			}
		});
		
		//response to circle
		
		
		panel.add(load);
		panel.add(clear);

		JButton circle = new JButton("Circle");
		JButton rectangle = new JButton("rectangle");
		JButton square = new JButton("square");

		panel.add(square);
		panel.add(rectangle);
		panel.add(circle);
		panel.setLocation(500, 50);

		//response to circle
		circle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("Circle")){
					shapeSelected = "Circle";
				}
			}
		});
		
		//reponse to rectangle
		rectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("rectangle")){
					shapeSelected = "rectangle";
				}
			}
		});
		
		//response to square
		square.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("square")){
					shapeSelected = "square";
				}
			}
		});
		
		frame.getContentPane().add(panel);
		//		frame.getContentPane().add(panel2);
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shapes s = new Shapes();
		s.setupInterface();
	}

}
