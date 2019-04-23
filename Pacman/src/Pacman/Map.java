package Pacman;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;


public class Map extends Pane{
	public int unit = 40;// unit 
	public int size; //size of map
	int[][] map; //matrix for map
	Position start;//x,y position for start position
	
	//constructor 
	public Map(String mapFile) throws FileNotFoundException {
		try {
			this.start = new Position(0, 0);
			Scanner input = new Scanner(new File(mapFile));
			size = input.nextInt();
			map = new int[size][size];
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++)
					map[i][j] = input.nextInt();
			}
			
			input.close();
			mapConstructor(map);
			setStartPosition();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int getUnit() {//method for get Unit in map
		return unit;
	}
	public int getSize() {//method for get Size of map
		return size;
	}
	public int[][] getMap() {//method for get matrix Map
		return this.map;
	}
	public Position getStartPosition() {//method for getting Start x,y position
		return this.start;
	}
	Rectangle r;//rectangle  
	//method for Constructing map in the Pane
	public void mapConstructor(int[][] map) {
			for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j]==1) {
					getChildren().add(new Rectangle(unit*j, 
							i*unit, unit, unit));
			}else{
					r = new Rectangle(unit*j, i*unit, unit, unit);
					r.setStroke(Color.BLACK);
					r.setFill(Color.WHITE);
					getChildren().add(r);}}}
	}
	//method for setting Start x,y position thought matrix Map
	public void setStartPosition() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j]==2) {
					start.setX(j);
					start.setY(i);}}}
			
	}
		
	
}
