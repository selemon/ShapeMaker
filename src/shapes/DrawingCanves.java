package shapes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * this class is responsible for drawing on the canvas
 * 
 * @author selemon
 * */
public class DrawingCanves extends Canvas{

	private Canvas canvas;
	private int width = 40, height =40, angle = 180;
	
	public DrawingCanves(){
		canvas = new Canvas();
	}
	
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public void addCanvas() {
		// TODO Auto-generated method stub
		
//		canvas.setSize(350, 550);
		canvas.setBounds(0, 50, 550, 478);
		canvas.setBackground(Color.GRAY);
		//frame.getContentPane().add(canvas);
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				drawShapes(e.getPoint());
			}
		});
	}


   
	
	
	
	/**
	 * draws shapes on the canvas when the mouse is 
	 * clicked
	 * 
	 * @param Point
	 * */
	protected void drawShapes(Point point) {
		// TODO Auto-generated method stub
		
		Random randomNumber = new Random();
		Color c = getRandomColor(randomNumber);

		Graphics g = canvas.getGraphics();
		g.setColor(c);
		
		String shape = Shapes.getShape();
		if(shape.equals("Circle")){
			g.fillOval(point.x, point.y, width++, height++);
		}
		else if(shape.equals("rectangle")){
			g.fillRect(point.x, point.y, width++, height++);
		}
		else if(shape.equals("square")){
			g.fillArc(point.x, point.y, width++, height++, 90, angle++);
		}
		
		
	}
	
	/**
	 * draws shapes on the canvas from the list of points that read 
	 * from a file
	 * 
	 * @param ArrayList<Point>
	 * */
	public void DrawFile(ArrayList<Point> p){
		Random randomNumber = new Random();
		Color c = getRandomColor(randomNumber);

		Graphics g = canvas.getGraphics();
		g.setColor(c);
		
		for(Point v: p){
			g.fillOval(v.x, v.y, width++, height++);
			c = getRandomColor(new Random());
			g.setColor(c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * makes a random color then returns it
	 * @param Random
	 * @return Color
	 * */
	private Color getRandomColor(Random randomNumber) {
	    return new Color(randomNumber.nextFloat(),
	            randomNumber.nextFloat(), randomNumber.nextFloat());
	}
	
	
}
