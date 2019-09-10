
public class Geist {
	int startX;
	int startY;
	public Geist(int _startX,int _startY){
		this.startX=_startX;
		this.startY=_startY;

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

		vyAchse=Integer.signum(zielY-startY);
		vxAchse=Integer.signum(zielX-startX);
		
		// Gerader Weg
		if (vyAchse!=0){
			startY+=vyAchse;
		}
		else{
			startX+=vxAchse;
		}

		// Wenn kein gerader Weg zum Ziel gefunden, ausprobieren
		while (spielbrett[startY][startX]=='X'){

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
			startX=xWhile;
			startY=yWhile;
		}



	}
	void draw (){
		
	}

}
