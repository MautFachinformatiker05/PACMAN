import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Spielfeld extends JPanel{

	static final String[] filenames = {"h_wand.png","v_wand.png",
										"o_wand.png","r_wand.png","u_wand.png","l_wand.png",
										"ro_wand.png","ru_wand.png","lo_wand.png","lu_wand.png",
										"oru_wand.png","rul_wand.png","oul_wand.png","olr_wand.png","roul_wand.png",
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
	static final int ROUL_WAND = 		14;
	static final int TRENNWAND_BILD = 	15;
	static final int PUNKT_BILD = 		16;
	static final int POWER_BILD = 		17;
	static final int PAC_START = 		18;
	static final int PAC_EAT1 = 		19;
	
	static Image bild_array[] = new Image[filenames.length];
	
	public final int NICHTS = 0;
	public final int WAND = 1;
	public final int PUNKT = 2;
	public final int POWER = 3;
	public final int KIRSCHE = 4;
	public final int TRENNWAND = 5;

	public byte[][] feld = {		// 0=nix, 1=Wand, 2=Punkt; 3=Power ;4=Kirsche		
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
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
			{0,0,0,0,0,1,2,1,0,1,1,5,1,1,0,1,2,1,0,0,0,0,0},
			{0,1,1,1,1,1,2,1,0,1,0,0,0,1,0,1,2,1,1,1,1,1,0},
			{0,0,0,0,0,0,2,0,0,1,0,0,0,1,0,0,2,0,0,0,0,0,0},
			{0,1,1,1,1,1,2,1,0,1,1,5,1,1,0,1,2,1,1,1,1,1,0},
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
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} 
	};	// x,y	21,27

	private byte[][] backup = feld;
	
	
	public int breite = (feld[0].length-2)*20;
	public int hoehe = feld.length*20;

	public int pac_x = 11;
	public int pac_y = 16;
	public int pac_leben=5;
	public int pac_richtung = 0; // l,o,r,u
	public int score = 0;
	RoterGeist rot = new RoterGeist(11, 11,"rot_geist.png");
	BlauerGeist blau = new BlauerGeist(10, 10,"blau_geist.png");
	GelberGeist gelb = new GelberGeist(9, 11, "gelb_geist.png");
	
	
	
	
	

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
//		ausgabe_konsole();
		pac_move();
		rot.run();
		blau.run();
		gelb.run();
		pac_touch();
		repaint();
	}

	private void pac_touch() {
		
		// Geist berührt? 
		if (pac_x==rot.geistX && pac_y==rot.geistY || pac_x==blau.geistX && pac_y==blau.geistY || pac_x==gelb.geistX && pac_y==gelb.geistY)
		{
			if (Game.frightened==false)
			{
				pac_leben--;
				// Pacman stirbt
				pac_x = 11;
				pac_y = 16;
			}
			else
			{
				if (pac_x==rot.geistX && pac_y==rot.geistY){
				score+=100;
				rot.deathtimer=15;
				}
				else if (pac_x==blau.geistX && pac_y==blau.geistY){
					score+=100;
					blau.deathtimer=15;
				}
				else if (pac_x==gelb.geistX && pac_y==gelb.geistY){
					score+=100;
					gelb.deathtimer=15;
				}
				
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
		
		if((x==0 || x==22)) {
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
		gelb.draw(g);
		repaint();
	}


	private void pacman_zeichnen(Graphics g) {
		
		int size = 20;
		g.drawImage(bild_array[PAC_START], (pac_x-1)*size, pac_y*size, this);
	}


	private void spielfeld_zeichnen(Graphics g) {			// für zeichnen immer x2 benutzen!!! wehe nicht
		
		int size = 20;
		boolean komplett = false;
		for(int y=0;y<28;y++)
		{
			for(int x=0;x<22;x++)
			{
				int x2 = x-1;
				if(feld[y][x]==2) {
					g.drawImage(bild_array[PUNKT_BILD], (x2)*size, y*size, this);
					komplett=true; }
				if(feld[y][x]==3)
					g.drawImage(bild_array[POWER_BILD], (x2)*size, y*size, this);
				if(feld[y][x]==5)
					g.drawImage(bild_array[TRENNWAND_BILD], (x2)*size, y*size, this);
				if(feld[y][x]==1)
				{
					boolean oben,rechts,links,unten;
					oben = rechts = links = unten = false;
					if(feld[y-1][x]==1)
						oben = true;
					if(feld[y][x+1]==1)
						rechts = true;
					if(feld[y+1][x]==1)
						unten = true;
					if(feld[y][x-1]==1)
						links = true;
					
					if(oben==false && rechts==true && unten==false && links==true)
						g.drawImage(bild_array[H_WAND], x2*size, y*size, this);
					if(oben==true && rechts==false && unten==true && links==false)
						g.drawImage(bild_array[V_WAND], x2*size, y*size, this);
					
					if(oben==true && rechts==false && unten==false && links==false)
						g.drawImage(bild_array[O_WAND], x2*size, y*size, this);
					if(oben==false && rechts==true && unten==false && links==false)
						g.drawImage(bild_array[R_WAND], x2*size, y*size, this);
					if(oben==false && rechts==false && unten==true && links==false)
						g.drawImage(bild_array[U_WAND], x2*size, y*size, this);
					if(oben==false && rechts==false && unten==false && links==true)
						g.drawImage(bild_array[L_WAND], x2*size, y*size, this);
					
					if(oben==true && rechts==true && unten==false && links==false)
						g.drawImage(bild_array[RO_WAND], x2*size, y*size, this);
					if(oben==false && rechts==true && unten==true && links==false)
						g.drawImage(bild_array[RU_WAND], x2*size, y*size, this);
					if(oben==false && rechts==false && unten==true && links==true)
						g.drawImage(bild_array[LU_WAND], x2*size, y*size, this);
					if(oben==true && rechts==false && unten==false && links==true)
						g.drawImage(bild_array[LO_WAND], x2*size, y*size, this);
					
					if(oben==true && rechts==true && unten==true && links==false)
						g.drawImage(bild_array[ORU_WAND], x2*size, y*size, this);
					if(oben==false && rechts==true && unten==true && links==true)
						g.drawImage(bild_array[RUL_WAND], x2*size, y*size, this);
					if(oben==true && rechts==false && unten==true && links==true)
						g.drawImage(bild_array[OUL_WAND], x2*size, y*size, this);
					if(oben==true && rechts==true && unten==false && links==true)
						g.drawImage(bild_array[OLR_WAND], x2*size, y*size, this);
					if(oben==true && rechts==true && unten==true && links==true)
						g.drawImage(bild_array[ROUL_WAND], x2*size, y*size, this);
				}
			}
		}
		Font f = new Font("Calibri", Font.BOLD, 26);
		g.setFont(f);
		FontMetrics metrics = getFontMetrics(f);
		g.setColor(Color.decode("#DDDDDD"));
		g.drawString("SCORE", 5, 20);
		g.drawString(""+score, 217-metrics.stringWidth(""+score), 20);
		g.drawString("SCORE",345, 20);
		
		for(int i=0;i<pac_leben;i++)
		{
			g.drawImage(bild_array[PAC_EAT1], (int)((6.5+i*1.5)*size), 28*size, this);
		}
		
		if (komplett==true)
			feld = backup;
	}
}
