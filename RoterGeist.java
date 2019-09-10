
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
		int zielY=0;
		int zielX=0;
		//

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
		while (Game.feld.feld[geistY][geistX]=='1'){

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
	void draw (){
		
	}

}
