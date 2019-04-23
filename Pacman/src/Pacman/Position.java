package Pacman;

public class Position {
	int x, y;//position 
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;	
	}
	public int getY() {
		return y;	
	}
	public void setX(int x) {
		this.x = x;	
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean equals(Position o) {
		if (x==o.getX() && y==o.getY())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
