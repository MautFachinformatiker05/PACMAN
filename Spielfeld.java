import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Spielfeld extends JPanel{

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
			{0,1,1,1,2,1,2,2,2,1,1,1,1,1,2,2,2,1,2,1,1,1,0},
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
			{0,1,1,1,2,1,2,2,2,1,1,1,1,1,2,2,2,1,2,1,1,1,0},
			{0,1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,0},
			{0,1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1,0},
			{0,1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,0},
			{0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0} */
	};	// x,y	21,27


	public int breite = feld[0].length*20;
	public int hoehe = feld[1].length*20;

	public int pac_x = 11;
	public int pac_y = 15;
	public int pac_leben=5;
	public int pac_richtung = 0; // l,o,r,u
	public int score = 0;
	RoterGeist rot = new RoterGeist(11, 11);


	public Spielfeld() {


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
				if((pac_x==x+1 && pac_y==y) || (rot.geistX==x+1 && rot.geistY==y )) {
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
		pac_touch();
	}

	private void pac_touch() {
		
		// Geist berührt? 
		if (pac_x==rot.geistX && pac_y==rot.geistY)
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

	/*
	public static void main(String[] args) {

		Spielfeld spiel = new Spielfeld();
		spiel.ausgabe_konsole();
	}
	 */
}
