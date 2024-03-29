import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
										"punkt.png","power.png","pac_start.png","pac_eat_o.png","pac_eat_r.png","pac_eat_u.png","pac_eat_l.png"}; 
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
	static final int PAC_EAT_0 = 		19;
	static final int PAC_EAT_R = 		20;
	static final int PAC_EAT_U = 		21;
	static final int PAC_EAT_L = 		22;
	
	static final int GEIST_START_X  =   11; 
	static final int GEIST_START_Y  =   14;
	
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
			{0,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,1,1,0},
			{0,0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0,0},
			{0,0,0,0,0,1,2,1,0,1,1,5,1,1,0,1,2,1,0,0,0,0,0},
			{0,1,1,1,1,1,2,1,0,1,0,0,0,1,0,1,2,1,1,1,1,1,0},
			{0,0,0,0,0,0,2,0,0,1,0,0,0,1,0,0,2,0,0,0,0,0,0},
			{0,1,1,1,1,1,2,1,0,1,1,1,1,1,0,1,2,1,1,1,1,1,0},
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
//	RoterGeist rot = new RoterGeist(GEIST_START_X-1, GEIST_START_Y,"rot_geist.png");
	BlauerGeist blau = new BlauerGeist(GEIST_START_X, GEIST_START_Y,"blau_geist.png");
	GelberGeist gelb = new GelberGeist(GEIST_START_X+1, GEIST_START_Y, "gelb_geist.png");
//	GrauerGeist grau = new GrauerGeist(GEIST_START_X, GEIST_START_Y-1, "grau_geist.png");
	GrunerGeist grun = new GrunerGeist(GEIST_START_X-1, GEIST_START_Y,"gr�n_geist.png");
	long old_time = 0;
	
	int alte_richtung = 0;
	
	
	
	

	public Spielfeld() {

		this.setBackground(Color.decode("#111111"));
		for(int i=0;i<filenames.length;i++)
		{
			bild_array[i] = (new ImageIcon(filenames[i]).getImage());
		}
	}


	/*public void ausgabe_konsole()
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
	} */

	public void update()
	{
//		ausgabe_konsole();
		pac_move();
		pac_touch();
//		rot.run();
		blau.run();
		gelb.run();
//		grau.run();
		grun.run();
		pac_touch();
		fright();
		repaint();
	}

	private void pac_touch() {
		
		// Geist ber�hrt? 
		if (pac_x==grun.geistX && pac_y==grun.geistY || pac_x==blau.geistX && pac_y==blau.geistY || pac_x==gelb.geistX && pac_y==gelb.geistY) // || pac_x==grau.geistX && pac_y==grau.geistY)
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
				if (pac_x==grun.geistX && pac_y==grun.geistY){
				score+=100;
				grun.deathtimer=15;
				}
				else if (pac_x==blau.geistX && pac_y==blau.geistY){
					score+=100;
					blau.deathtimer=15;
				}
				else if (pac_x==gelb.geistX && pac_y==gelb.geistY){
					score+=100;
					gelb.deathtimer=15;
				}
//				else if (pac_x==grau.geistX && pac_y==grau.geistY){
//					score+=100;
//					grau.deathtimer=15;
//				}
				
			}
		}	
	}


	public void fright() {
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
		
		int [] vx =  {-1, 0, +1, 0, 0}; 
		int [] vy =  {0, -1, 0, +1, 0};

		int x = pac_x+vx[pac_richtung];
		int y = pac_y+vy[pac_richtung];
		
		if((x==0 || x==22)) {
			if(x==0)
				pac_x = 21;
			else
				pac_x = 1;
		}	
		else if(feld[y][x]!=1 && feld[y][x]!=5) 
		{
			alte_richtung = pac_richtung;
			
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
		else
			alte_richtung=4;

	}
	
	@Override
	public void paintComponent(Graphics g) {
		

		super.paintComponent(g);
		spielfeld_zeichnen(g);
		pacman_zeichnen(g);
		
//		rot.draw_shadow(g);
		blau.draw_shadow(g);
		gelb.draw_shadow(g);
//		grau.draw_shadow(g);
		grun.draw_shadow(g);
		
		Image debug_green = (new ImageIcon("grun_feld.png").getImage());
		for (Integer[] inte : grun.astern) {
			g.drawImage(debug_green, (inte[0]-1)*20, inte[1]*20, this);
		}
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setComposite(MultiplyComposite.Multiply);
		
//		rot.draw(g2D);
		blau.draw(g2D);
		gelb.draw(g2D);
//		grau.draw(g2D);
		grun.draw(g2D);
		
		

	}


	private void pacman_zeichnen(Graphics g) {
		
		int size = 20;
		int [] vx =  {+1, 0, -1, 0, 0}; 
		int [] vy =  {0, +1, 0, -1, 0};
		
		switch (alte_richtung) {
		case 0:
			if(Game.frames%10==0 || Game.frames%10==1 || Game.frames%10==2 || Game.frames%10==3 || Game.frames%10==4 || Game.frames%10==5)
				g.drawImage(bild_array[PAC_START], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);
			else
				g.drawImage(bild_array[PAC_EAT_L], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);		
			break;
			
		case 1:
			if(Game.frames%10==0 || Game.frames%10==1 || Game.frames%10==2 || Game.frames%10==3 || Game.frames%10==4 || Game.frames%10==5)
				g.drawImage(bild_array[PAC_START], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);
			else
				g.drawImage(bild_array[PAC_EAT_0], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);		
			break;
			
		case 2:
			if(Game.frames%10==0 || Game.frames%10==1 || Game.frames%10==2 || Game.frames%10==3 || Game.frames%10==4 || Game.frames%10==5)
				g.drawImage(bild_array[PAC_START], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);
			else
				g.drawImage(bild_array[PAC_EAT_R], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);		
			break;
			
		case 3:
			if(Game.frames%10==0 || Game.frames%10==1 || Game.frames%10==2 || Game.frames%10==3 || Game.frames%10==4 || Game.frames%10==5)
				g.drawImage(bild_array[PAC_START], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);
			else
				g.drawImage(bild_array[PAC_EAT_U], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);		
			break;

		default:
			g.drawImage(bild_array[PAC_START], (pac_x-1)*size+(Game.frames*vx[alte_richtung]), pac_y*size+(Game.frames*vy[alte_richtung]), this);
			break;
		}
		
	}


	private void spielfeld_zeichnen(Graphics g) {			// f�r zeichnen immer x2 benutzen!!! wehe nicht
		
		int size = 20;
		boolean komplett = true;
//		old_time = System.currentTimeMillis();
		for(int y=0;y<28;y++)
		{
			for(int x=0;x<22;x++)
			{
				int x2 = x-1;
				if(feld[y][x]==2) {
					g.drawImage(bild_array[PUNKT_BILD], (x2)*size, y*size, this);
					komplett=false; }
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
			g.drawImage(bild_array[PAC_EAT_R], (int)((6.5+i*1.5)*size), 28*size, this);
		}
		if (komplett==true)
			feld = backup;
		
//		long new_time = System.currentTimeMillis();
//		System.out.println("Delay: "+(new_time-old_time));
	}
}
