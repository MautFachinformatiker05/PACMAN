import java.awt.Graphics;

public class RoterGeist {
	int geistX;
	int geistY;
	public RoterGeist(int _startX,int _startY){
		this.geistX=_startX;
		this.geistY=_startY;

	}
	void move(){
		// TO-DO: braucht Feld und X,Y-Koordinanten vom Ziel
		// Bessere Sache kommt nach, jetzt ist er ein bisschen doof noch
		int vxAchse=0;
		int vyAchse=0;
		int xTemp=0;
		int yTemp=0;
		int xWhile=0;
		int yWhile=0;
		int zufall=0;
		//		Dummy
		int zielY=Game.feld.pac_y;
		int zielX=Game.feld.pac_x;
		//

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
//		System.out.println("gerader weg");

//		System.out.println("Feld das der geist wählen möchte " +Game.feld.feld[geistY][geistX]);
		// Wenn kein gerader Weg zum Ziel gefunden, ausprobieren
		while (Game.feld.feld[geistY][geistX]==1){
//				System.out.println("Raten \n \n \n");
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
		
		System.out.println("Der Abstand zu Pacman ist " + abstand(geistX, geistY, zielX, zielY));
//		if (abstand(geistX, geistY, zielX, zielY)==0){
//			System.exit(0);
//		}
//		Game.feld.feld[2][1]='4';
		


	}
	void draw (Graphics g){
		
		
	}
	double abstand (double _startX,double _startY,double _zielX,double _zielY){
		 double distance=0;
		distance= Math.sqrt(Math.pow(_startX-_zielX, 2)+Math.pow(_startY -_zielY,2));
		return distance;
	}

}
