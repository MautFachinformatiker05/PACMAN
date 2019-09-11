import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Geist {
	int geistX;
	int geistY;
	Image bild;
	Image bild2;
	int zielY;
	int zielX;
	int deathtimer;
	int deathtimerPrevioustick;
	boolean isPrison;
	int prisonCounter;
	int alte_richtung = 4;

	public Geist(int _startX, int _startY, String bildText) {
		this.geistX = _startX;
		this.geistY = _startY;
		bild = (new ImageIcon(bildText).getImage());
		bild2 = (new ImageIcon("pupille.png").getImage());
		deathtimer = 0;
		deathtimerPrevioustick = 0;
		isPrison=true;
		prisonCounter=2;

	}

	void run(){
		if (isPrison){
			ausbrauch();
		}
		
		else if ( this.deathtimerPrevioustick==2){
			this.respawn();
			
		}
		 else if (this.deathtimer != 0){
				this.deathtimerPrevioustick=this.deathtimer;
				this.deathtimer--;
				this.geistX=Spielfeld.GEIST_START_X;
				this.geistY=Spielfeld.GEIST_START_Y;
				
			}
		else {
			move();
			
		}
		
	}
	
	void respawn(){
		this.deathtimer=0;
		this.deathtimerPrevioustick=0;
		isPrison=true;
		prisonCounter=2;
	}
	abstract void move();

	void draw(Graphics g) {
		int [] vx =  {+1, 0, -1, 0, 0}; 
		int [] vy =  {0, +1, 0, -1, 0};
		
		if (this.deathtimer == 0) {
			int size = 20;
			g.drawImage(bild, (geistX - 1) * size+(Game.frames*vx[alte_richtung]), geistY * size+(Game.frames*vx[alte_richtung]), Game.feld);
			if (Game.frightened == false) {
				g.drawImage(bild2, ((geistX - 1) * size) + 6, (geistY * size) + 6, Game.feld);
				g.drawImage(bild2, ((geistX - 1) * size) + 12, (geistY * size) + 6, Game.feld);
			} else {
				g.drawImage(bild2, ((geistX - 1) * size) + 5 + (int) (Math.random() * 4),
						(geistY * size) + 5 + (int) (Math.random() * 4), Game.feld);
				g.drawImage(bild2, ((geistX - 1) * size) + 11 + (int) (Math.random() * 4),
						(geistY * size) + 5 + (int) (Math.random() * 4), Game.feld);
			}
		}
	}

	double abstand(double _startX, double _startY, double _zielX, double _zielY) {
		double distance = 0;
		distance = Math.sqrt(Math.pow(_startX - _zielX, 2) + Math.pow(_startY - _zielY, 2));
		return distance;
	}

	boolean isWall(int _y, int _x) {
		if (Game.feld.feld[_y][_x] == 1 || Game.feld.feld[_y][_x] == 5 ) {
			return true;
		}

		return false;
	}

	void checkFrightened() {
		if (Game.frightened) {
			int zufall = (int) (Math.random() * 4 + 1);
			switch (zufall) {
			case 1:
				zielX = 0;
				zielY = 0;
				break;
			case 2:
				zielX = 23;
				zielY = 0;
				break;
			case 3:
				zielX = 0;
				zielY = 26;
				break;
			case 4:
				zielX = 23;
				zielY = 26;
				break;
			}

		}
	}

	void tunnel_teleport() {
		if ((geistX == 0 || geistX == 22)) {
			if (geistX == 0) {
				geistX = 21;
			} else {
				geistX = 1;
			}

		}
	}
	void ausbrauch(){
		geistY--;
		prisonCounter--;
		if (prisonCounter==0){
			isPrison=false;
			
			
		}
	}
		
}
