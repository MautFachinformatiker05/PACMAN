import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Spielfeld extends JPanel{

	static final String[] filenames = {"h_wand.png","v_wand.png",
										"o_wand.png","r_wand.png","u_wand.png","l_wand.png",
										"ro_wand.png","ru_wand.png","lo_wand.png","lu_wand.png",
										"oru_wand.png","rul_wand.png","oul_wand.png","olr_wand.png",
										"trennwand.png",
										"punkt.png","power.png","pac_start.png","pac_eat1.png"}; 
	static final int H_WAND = 			0;
	static final int V_WAND = 			1;
	static final int O_WAND = 			2;
	static final int R_WAND = 			3;
	static final int U_WAND = 			4;
	static final int L_WAND = 			5;
	static final int RO_WAND = 			6;
	static final int RU_WAND = 			7;
	static final int LO_WAND = 			8;
	static final int LU_WAND = 			9;
	static final int ORU_WAND = 		10;
	static final int RUL_WAND = 		11;
	static final int OUL_WAND = 		12;
	static final int OLR_WAND = 		13;
	static final int TRENNWAND_BILD = 	14;
	static final int PUNKT_BILD = 		15;
	static final int POWER_BILD = 		16;
	static final int PAC_START = 		17;
	static final int PAC_EAT1 = 		18;
	
	static Image bild_array[] = new Image[filenames.length];
	
	public final int NICHTS = 0;
	public final int WAND = 1;
	public final int PUNKT = 2;
	public final int POWER = 3;
	public final int KIRSCHE = 4;
	public final int TRENNWAND = 5;

	public byte[][] feld = {		// 0=nix, 1=Wand, 2=Punkt; 3=Power ;4=Kirsche
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1,0},
			{0,1,3,1,0,1,2,1,0,1,2,1,2,1,0,1,2,1,0,1,3,1,0},
			{0,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1,0},
			{0,1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,0},
			{0,1,1,1,1,1,2,1,1,1,2,2,2,1,1,1,2,1,1,1,1,1,0},
			{0,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0,0},
			{0,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0,0},
			{1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},
			{0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0},
			{1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},
			{0,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0,0},
			{0,0,0,0,0,1,2,1,0,1,1,1,1,1,0,1,2,1,0,0,0,0,0},
			{0,1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1,0},
			{0,1,3,2,2,1,2,2,2,2,2,2,2,2,2,2,2,1,2,2,3,1,0},
			{0,1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,0},
			{0,1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,0},
			{0,1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}
			
		/*	{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1,0},
			{0,1,3,1,0,1,2,1,0,1,2,1,2,1,0,1,2,1,0,1,3,1,0},
			{0,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1,0},
			{0,1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,0},
			{0,1,1,1,1,1,2,1,1,1,2,2,2,1,1,1,2,1,1,1,1,1,0},
			{0,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0,0},
			{0,0,0,0,0,1,2,1,0,1,1,5,1,1,0,1,2,1,0,0,0,0,0},
			{1,1,1,1,1,1,2,1,0,1,0,0,0,1,0,1,2,1,1,1,1,1,1},
			{0,0,0,0,0,0,2,0,0,1,0,0,0,1,0,0,2,0,0,0,0,0,0},
			{1,1,1,1,1,1,2,1,0,1,1,1,1,1,0,1,2,1,1,1,1,1,1},
			{0,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0,0},
			{0,0,0,0,0,1,2,1,0,1,1,1,1,1,0,1,2,1,0,0,0,0,0},
			{0,1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1,0},
			{0,1,3,2,2,1,2,2,2,2,2,2,2,2,2,2,2,1,2,2,3,1,0},
			{0,1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,0},
			{0,1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,0},
			{0,1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0} */
	};	// x,y	21,27

	
	
	public int breite = (feld[0].length-2)*20;
	public int hoehe = feld.length*20;

	public int pac_x = 11;
	public int pac_y = 15;
	public int pac_leben=5;
	public int pac_richtung = 0; // l,o,r,u
	public int score = 0;
	RoterGeist rot = new RoterGeist(11, 11);
	BlauerGeist blau = new BlauerGeist(10, 10);


	public Spielfeld() {

		this.setBackground(Color.decode("#111111"));
		for(int i=0;i<filenames.length;i++)
		{
			bild_array[i] = (new ImageIcon(filenames[i]).getImage());
		}
	}


	public void ausgabe_konsole()
	{
		for(int y=0;y<feld.length;y++)
		{
			for(int x=1;x<feld[0].length-1;x++)
			{
				switch (feld[y][x]) {
				case NICHTS:
					System.out.print(" ");
					break;
				case WAND:
					System.out.print("X");
					break;
				case PUNKT:
					System.out.print(".");
					break;
				case POWER:
					System.out.print(":");
					break;
				case KIRSCHE:
					System.out.print("K");
					break;
				case TRENNWAND:
					System.out.print("_");
					break;
				default:
					break;
				}
				if(pac_x==x && pac_y==y)
				{
					System.out.print("P");
				}
				if(rot.geistX==x && rot.geistY==y)
				{
					System.out.print("R");
				}
				if(blau.geistX==x && blau.geistY==y)
				{
					System.out.print("B");
				}
				if((pac_x==x+1 && pac_y==y) || (rot.geistX==x+1 && rot.geistY==y ) || (blau.geistX==x+1 && blau.geistY==y)) {
					System.out.print("");
				}
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void update()
	{
		ausgabe_konsole();
		pac_move();
		rot.move();
		blau.move();
		pac_touch();
		repaint();
	}

	private void pac_touch() {
		
		// Geist berührt? 
		if (pac_x==rot.geistX && pac_y==rot.geistY || pac_x==blau.geistX && pac_y==blau.geistY )
		{
			if (Game.frightened==false)
			{
				pac_leben--;
				// Pacman stirbt
				pac_x = 11;
				pac_y = 15;
			}
			else
			{
				score+=100;
				// Methode -> roter Geist stirbt und respawned später
			}
		}
		// Frightened?
		if (Game.counter > 0)
		{
			Game.counter--;
		}
		else {
			Game.frightened = false;
		}
		
	}


	public void pac_move() {
		int [] vx =  {-1, 0, +1, 0}; 
		int [] vy =  {0, -1, 0, +1};

		int x = pac_x+vx[pac_richtung];
		int y = pac_y+vy[pac_richtung];
//		System.out.println(feld.length+"  "+feld[0].length);
		
		if(y==13 && (x==0 || x==22)) {
			if(x==0)
				pac_x = 21;
			else
				pac_x = 1;
		}	
		else if(feld[y][x]!=1 && feld[y][x]!=5) 
		{
			if(feld[y][x]==2)
			{
				score+= 10;
				feld[y][x]=0;
			}
			if(feld[y][x]==4)
			{
				score+= 10;
				feld[y][x]=0;
			}
			if(feld[y][x]==3)
			{
				score+= 50;
				feld[y][x]=0;
				Game.frightened = true;
				Game.counter = 20;
			}
			pac_x+=vx[pac_richtung];
			pac_y+=vy[pac_richtung];
		}

	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		spielfeld_zeichnen(g);
		pacman_zeichnen(g);
		
		rot.draw(g);
		blau.draw(g);
		
	}


	private void pacman_zeichnen(Graphics g) {
		
		int size = 20;
		g.drawImage(bild_array[PAC_START], (pac_x-1)*size, pac_y*size, this);
	}


	private void spielfeld_zeichnen(Graphics g) {
		
		int size = 20;
		g.drawImage(bild_array[RU_WAND], 0, 0, this);
		for (int i=1;i<20;i++)
		{
			if(i!=10)
				g.drawImage(bild_array[H_WAND], i*size, 0, this);
		}
		g.drawImage(bild_array[RUL_WAND], 10*size, 0, this);
		g.drawImage(bild_array[V_WAND], 10*size, 1*size, this);
		g.drawImage(bild_array[V_WAND], 10*size, 2*size, this);
		g.drawImage(bild_array[V_WAND], 10*size, 3*size, this);
		g.drawImage(bild_array[O_WAND], 10*size, 4*size, this);
		g.drawImage(bild_array[LU_WAND], 20*size, 0, this);
		for (int i=1;i<9;i++)
		{
			g.drawImage(bild_array[V_WAND], 0, i*size, this);
			g.drawImage(bild_array[V_WAND], 20*size, i*size, this);
		}
		quadrat_zeichnen(2,2,size,g);
		quadrat_zeichnen(6,2,size,g);
		quadrat_zeichnen(12,2,size,g);
		quadrat_zeichnen(16,2,size,g);
		quader_zeichnen(2,6,size,g);
		quader_zeichnen(16,6,size,g);
		g.drawImage(bild_array[RO_WAND], 0*size, 9*size, this);
		g.drawImage(bild_array[LO_WAND], 20*size, 9*size, this);
		for(int i=1;i<4;i++)
		{
			g.drawImage(bild_array[H_WAND], i*size, 9*size, this);
			g.drawImage(bild_array[H_WAND], (i+16)*size, 9*size, this);
		}
		g.drawImage(bild_array[LU_WAND], 4*size, 9*size, this);
		g.drawImage(bild_array[RU_WAND], 16*size, 9*size, this);
		for(int i=10;i<12;i++)
		{
			g.drawImage(bild_array[V_WAND], 4*size, i*size, this);
			g.drawImage(bild_array[V_WAND], 6*size, i*size, this);
			g.drawImage(bild_array[V_WAND], 14*size, i*size, this);
			g.drawImage(bild_array[V_WAND], 16*size, i*size, this);
		}	
		g.drawImage(bild_array[LO_WAND], 4*size, 12*size, this);
		g.drawImage(bild_array[RO_WAND], 16*size, 12*size, this);
		for(int i=0;i<4;i++)
		{
			g.drawImage(bild_array[H_WAND], i*size, 12*size, this);
			g.drawImage(bild_array[H_WAND], (i+17)*size, 12*size, this);
		}
		g.drawImage(bild_array[U_WAND], 6*size, 6*size, this);
		g.drawImage(bild_array[V_WAND], 6*size, 7*size, this);
		g.drawImage(bild_array[V_WAND], 6*size, 8*size, this);
		g.drawImage(bild_array[U_WAND], 14*size, 6*size, this);
		g.drawImage(bild_array[V_WAND], 14*size, 7*size, this);
		g.drawImage(bild_array[V_WAND], 14*size, 8*size, this);
		g.drawImage(bild_array[ORU_WAND], 6*size, 9*size, this);
		g.drawImage(bild_array[OUL_WAND], 14*size, 9*size, this);
		g.drawImage(bild_array[H_WAND], 7*size, 9*size, this);
		g.drawImage(bild_array[H_WAND], 13*size, 9*size, this);
		g.drawImage(bild_array[L_WAND], 8*size, 9*size, this);
		g.drawImage(bild_array[R_WAND], 12*size, 9*size, this);
		for(int i=9;i<12;i+=2)
		{
			g.drawImage(bild_array[H_WAND], i*size, 6*size, this);
			g.drawImage(bild_array[H_WAND], i*size, 7*size, this);
		}
		g.drawImage(bild_array[H_WAND], 10*size, 6*size, this);
		g.drawImage(bild_array[RUL_WAND], 10*size, 7*size, this);
		g.drawImage(bild_array[O_WAND], 10*size, 8*size, this);
		g.drawImage(bild_array[RO_WAND], 8*size, 7*size, this);
		g.drawImage(bild_array[RU_WAND], 8*size, 6*size, this);
		g.drawImage(bild_array[LO_WAND], 12*size, 7*size, this);
		g.drawImage(bild_array[LU_WAND], 12*size, 6*size, this);
		g.drawImage(bild_array[O_WAND], 6*size, 12*size, this);
		g.drawImage(bild_array[O_WAND], 14*size, 12*size, this);
	}


	private void quader_zeichnen(int x, int y, int size, Graphics g) {
		
		g.drawImage(bild_array[RU_WAND], (x)*size, (y)*size, this);
		g.drawImage(bild_array[RO_WAND], (x)*size, (y+1)*size, this);
		g.drawImage(bild_array[H_WAND], (x+1)*size, (y)*size, this);
		g.drawImage(bild_array[H_WAND], (x+1)*size, (y+1)*size, this);
		g.drawImage(bild_array[LU_WAND], (x+2)*size, (y)*size, this);
		g.drawImage(bild_array[LO_WAND], (x+2)*size, (y+1)*size, this);
	}


	private void quadrat_zeichnen(int x, int y, int size,Graphics g) {
		
		g.drawImage(bild_array[RU_WAND], (x)*size, (y)*size, this);
		g.drawImage(bild_array[V_WAND], (x)*size, (y+1)*size, this);
		g.drawImage(bild_array[RO_WAND], (x)*size, (y+2)*size, this);
		g.drawImage(bild_array[H_WAND], (x+1)*size, (y)*size, this);
		g.drawImage(bild_array[H_WAND], (x+1)*size, (y+2)*size, this);
		g.drawImage(bild_array[LU_WAND], (x+2)*size, (y)*size, this);
		g.drawImage(bild_array[V_WAND], (x+2)*size, (y+1)*size, this);
		g.drawImage(bild_array[LO_WAND], (x+2)*size, (y+2)*size, this);
	}

	/*
	public static void main(String[] args) {

		Spielfeld spiel = new Spielfeld();
		spiel.ausgabe_konsole();
	}
	 */
}
