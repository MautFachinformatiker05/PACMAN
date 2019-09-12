import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Geist {
	int geistX;
	int geistY;
	Image bild;
	Image bild2;
	Image bild_schatten;
	public Image debug_green;
	Image debug_red;
	int zielY;
	int zielX;
	int deathtimer;
	int alte_richtung = 4;
	int gespeicherteRichtung;

	final int RECHTS =  0;
	final int UNTEN  =  1;
	final int LINKS  =  2;
	final int OBEN   =  3;
	final int NEUTRAL=4;
	final int DEATHTIME=15;

	int richtung = NEUTRAL;

	public Geist(int _startX, int _startY, String bildText) {
		this.geistX = _startX;
		this.geistY = _startY;
		bild = (new ImageIcon(bildText).getImage());
		bild2 = (new ImageIcon("pupille.png").getImage());
		bild_schatten = (new ImageIcon("schatten_geist.png").getImage());
		debug_green = (new ImageIcon("grun_feld.png").getImage());
		debug_red = (new ImageIcon("rot_feld.png").getImage());
		deathtimer = 0;
		

	}

	void run(){

		if ( (geistX>=10 && geistX<=12) && (geistY>=12 && geistY<=15) ){				// sorry, manuel
			if (geistY==15 || geistY==13 || geistY==12 || (geistX==11 && geistY==14)) {	// aber neue ausbruch-methode quasi
				move(OBEN);	
			}
			else if(geistX==12 && geistY==14) {
				move(LINKS);
			}
			else if(geistX==10 && geistY==14) {
				move(RECHTS);
			}
		}

		else if ( this.deathtimer==1){
			this.respawn();

		}
		else if (this.deathtimer > 1){
			
			this.deathtimer--;
			this.geistX=Spielfeld.GEIST_START_X;
			this.geistY=Spielfeld.GEIST_START_Y;
		}
		else {
			move(NEUTRAL);	// stehl still; entferne, wenn planen move nutzt
			planen();

		}

	}
	void move (int _richtung){
		int [] vx =  {+1, 0, -1, 0, 0}; 
		int [] vy =  {0, +1, 0, -1, 0};
		alte_richtung=_richtung;
		geistX+=vx[_richtung];
		geistY+=vy[_richtung];
		if ( _richtung!=NEUTRAL){
			gespeicherteRichtung=_richtung;
		}



	}

	void respawn(){
		this.deathtimer=0;
		}
	
	abstract void planen();

	void draw(Graphics g) {
		int [] vx =  {-1, 0, +1, 0, 0}; 
		int [] vy =  {0, -1, 0, +1, 0};

		if (this.deathtimer == 0) {
			int size = 20;
			g.drawImage(bild, (geistX - 1) * size+(Game.frames*vx[alte_richtung]), geistY * size+(Game.frames*vy[alte_richtung]), Game.feld);
			if (Game.frightened == false) {
				g.drawImage(bild2, ((geistX - 1) * size) + 6+(Game.frames*vx[alte_richtung]), (geistY * size) + 6+(Game.frames*vy[alte_richtung]), Game.feld);
				g.drawImage(bild2, ((geistX - 1) * size) + 12+(Game.frames*vx[alte_richtung]), (geistY * size) + 6+(Game.frames*vy[alte_richtung]), Game.feld);
			} else {
				g.drawImage(bild2, ((geistX - 1) * size) + 5 + (int) (Math.random() * 4)+(Game.frames*vx[alte_richtung]),(geistY * size) + 5 + (int) (Math.random() * 4)+(Game.frames*vy[alte_richtung]), Game.feld);
				g.drawImage(bild2, ((geistX - 1) * size) + 11 + (int) (Math.random() * 4)+(Game.frames*vx[alte_richtung]),(geistY * size) + 5 + (int) (Math.random() * 4)+(Game.frames*vy[alte_richtung]), Game.feld);
			}
		}
	}

	void draw_shadow(Graphics g)
	{
		int [] vx =  {-1, 0, +1, 0, 0}; 
		int [] vy =  {0, -1, 0, +1, 0};

		if (this.deathtimer == 0) {
			int size = 20;
			g.drawImage(bild_schatten, (geistX - 1) * size+(Game.frames*vx[alte_richtung]), geistY * size+(Game.frames*vy[alte_richtung]), Game.feld);
		}
	}
	
	void draw_debug_green(Graphics g, int x_coor, int y_coor) {
		int size = 20;
		g.drawImage(debug_green, (x_coor - 1) * size, y_coor * size, Game.feld);
	}
	
	void draw_debug_red(Graphics g, int x_coor, int y_coor) {
		int size = 20;
		g.drawImage(debug_red, (x_coor - 1) * size, y_coor * size, Game.feld);
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
	void death(){
		this.deathtimer=DEATHTIME;
	}
}
