import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class RoterGeist {
	int geistX;
	int geistY;
	Image bild;
	
	public RoterGeist(int _startX,int _startY){
		this.geistX=_startX;
		this.geistY=_startY;
		
		bild = (new ImageIcon("rot_geist.png").getImage());

	}
	void move(){
		
		int vxAchse=0;
		int vyAchse=0;
		int xTemp=0;
		int yTemp=0;
		int xWhile=0;
		int yWhile=0;
		int zufall=0;
		
		int zielY=Game.feld.pac_y;
		int zielX=Game.feld.pac_x;
		

		xTemp=geistX;
		yTemp=geistY;
		
		
		vyAchse=Integer.signum(zielY-geistY);
		vxAchse=Integer.signum(zielX-geistX);
		
		// Gerader Weg
		if (vyAchse!=0){
			geistY+=vyAchse;
		}
		else{
			geistX+=vxAchse;
		}

		// Wenn kein gerader Weg zum Ziel gefunden, ausprobieren
		while (Game.feld.feld[geistY][geistX]==1){

			zufall=(int)(Math.random()*4+1);
			xWhile=xTemp;
			yWhile=yTemp;

			if(zufall==1){
				xWhile--;
			}
			else if (zufall==2){
				xWhile++;
			}
			else if (zufall==3){
				yWhile--;
			}
			else {
				yWhile++;
			}
			geistX=xWhile;
			geistY=yWhile;
		}
		
		
		


	}
	void draw (Graphics g){
		int size = 20;
		g.drawImage(bild, geistX*size, geistY*size, Game.feld);
		
	}
	double abstand (double _startX,double _startY,double _zielX,double _zielY){
		 double distance=0;
		distance= Math.sqrt(Math.pow(_startX-_zielX, 2)+Math.pow(_startY -_zielY,2));
		return distance;
	}
	boolean isWall(int _y, int _x){
		if (Game.feld.feld[_y][_x]==1){
			return true;
		}
		
		return false;
	}

}
