import java.awt.Image;

import javax.swing.ImageIcon;

public class BlauerGeist extends RoterGeist{

	Image bild;
	
	public BlauerGeist(int _startX, int _startY) {
		super(_startX, _startY);
		bild = (new ImageIcon("blau_geist.png").getImage());
		
	}
	
	void move (){
		int zielY=Game.feld.pac_y;
		int zielX=Game.feld.pac_x;
		
		int xBewegung=-1;
		int yBewegung=0;
		
		// 1. Fall X-Kor -1
		double distance = abstand(geistX-1, geistY, zielX, zielY);
		if (isWall(geistY, geistX-1)){
			xBewegung=0;
		}
		
		// 2. Fall X-Kor +1
		double tempDistance=abstand(geistX+1, geistY, zielX, zielY);
		
		if (tempDistance<distance && !isWall(geistY, geistX+1)){
			distance=tempDistance;
			xBewegung=1;
		}
		
		// 3. Fall Y-Kor +1
		tempDistance=abstand(geistX, geistY+1, zielX, zielY);
		if (tempDistance<distance && !isWall(geistY+1, geistX)){
			distance=tempDistance;
			xBewegung=0;
			yBewegung=1;
		}
		
		// 4. Fall X-Kor -1
		tempDistance=abstand(geistX, geistY-1, zielX, zielY);
		if (tempDistance<distance && !isWall(geistY-1, geistX)){
			distance=tempDistance;
			xBewegung=0;
			yBewegung=-1;
		}
		
		System.out.println("Der Abstand ist " + distance);
		System.out.println("X : " +xBewegung);
		System.out.println("Y : " +yBewegung);
		
		geistX +=xBewegung;
		geistY+=yBewegung;
		
		
		
	}

}
