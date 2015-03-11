package shapes;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * this class reads a file with x and y coordinates and stores them into 
 * an arraylist of points
 * 
 * @author selemon
 * */
public class FileReader {
	
	/**
	 * this method reads a file
	 * @param File
	 * @return ArrayList<Point>
	 * 
	 * */
	public ArrayList<Point> Read(File file){
		ArrayList<Point> list = new ArrayList<Point>();
		
		try {
			Scanner scan = new Scanner(file);
			int x, y;
			while(scan.hasNextLine()){
//				scan.nextInt();
				x = (int)scan.nextDouble();
				y = (int)scan.nextDouble();
				Point p = new Point(x, y);
				list.add(p);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return list;
	}
	
	
}
