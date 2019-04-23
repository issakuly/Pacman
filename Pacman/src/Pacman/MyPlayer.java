package Pacman;

import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;


public class MyPlayer implements Player {
	//shapes 
	public Arc ball;
	public Arc ball2, ball4;
	public Circle ball3;
	
	Map map;// map for pane
	public Position position;//x.y position
	//constructor
	public MyPlayer(Map map) {
		this.map = map;
		position = getPosition();
		
		ball = new Arc(position.x*map.getUnit()+map.unit/2.0, position.y*map.getUnit()+map.unit/2.0, map.unit/2.0, map.unit/2.0, 0, 180);
		
		ball2 = new Arc(position.x*map.getUnit()+map.unit/2.0, position.y*map.getUnit()+map.unit/2.0, map.unit/2.0, map.unit/2.0, 165, 170);
		
		ball3 = new Circle(position.x*map.getUnit()+map.unit/2.0-map.getUnit()/8.0, position.y*map.getUnit()+map.unit/2.0-map.getUnit()/5.0,
				map.unit/10.0);
		
		ball.setFill(Color.YELLOW);
		ball.setStroke(Color.BLACK);
		ball2.setFill(Color.YELLOW);
		ball2.setStroke(Color.BLACK);
		
		
	}
	
	@Override
	public void moveRight() {
		int[][] m = map.getMap();
		if(position.getX()+1< map.getSize()) {
			if(m[position.getY()][position.getX()+1]!=1){
				System.out.println("Right");
				ball.setTranslateX(ball.getTranslateX()+map.getUnit());
				ball2.setTranslateX(ball2.getTranslateX()+map.getUnit());
				ball3.setTranslateX(ball3.getTranslateX()+map.getUnit());
				position.setX(position.getX()+1);
			}
		}
	}
	@Override
	public void moveLeft() {
		int[][] m = map.getMap();
		if(position.getX() > 0) {
			if(m[position.getY()][position.getX()-1]!=1){
				System.out.println("Left");
				ball.setTranslateX(ball.getTranslateX()-map.getUnit());
				ball2.setTranslateX(ball2.getTranslateX()-map.getUnit());
				ball3.setTranslateX(ball3.getTranslateX()-map.getUnit());
				position.setX(position.getX()-1);
			}
		}
	}
	@Override
	public void moveUp() {
		int[][] m = map.getMap();
		if(position.getY()>0) {
			if(m[position.getY()-1][position.getX()]!=1){
				System.out.println("Up");
				ball.setTranslateY(ball.getTranslateY()-map.getUnit());
				ball2.setTranslateY(ball2.getTranslateY()-map.getUnit());
				ball3.setTranslateY(ball3.getTranslateY()-map.getUnit());
				position.setY(position.getY()-1);
			}
		}
	}
	@Override
	public void moveDown() {
		int[][] m = map.getMap();
		//System.out.println(position.getX()+1+"  "+position.getY()+"  "+m[position.getY()][position.getX()+1]);
		if(position.getY()+1 < map.getSize()) {
			if(m[position.getY()+1][position.getX()]!=1){
				System.out.println("Down");
				ball.setTranslateY(ball.getTranslateY()+map.getUnit());
				ball2.setTranslateY(ball2.getTranslateY()+map.getUnit());
				ball3.setTranslateY(ball3.getTranslateY()+map.getUnit());
				position.setY(position.getY()+1);
			}
		}
	}

	@Override
	public Position getPosition() {
		return this.map.getStartPosition();
	}	
}
