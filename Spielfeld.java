import javax.swing.JFrame;

public class Spielfeld extends JFrame{

	public final int NICHTS = 0;
	public final int WAND = 1;
	public final int PUNKT = 2;
	public final int POWER = 3;
	public final int KIRSCHE = 4;
	public final int TRENNWAND = 5;
	
	public byte[][] feld = {		// 0=nix, 1=Wand, 2=Punkt; 3=Power ;4=Kirsche
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1},
			{1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
			{1,3,1,0,1,2,1,0,1,2,1,2,1,0,1,2,1,0,1,3,1},
			{1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1},
			{1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1},
			{1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1},
			{1,1,1,1,1,2,1,1,1,2,2,2,1,1,1,2,1,1,1,1,1},
			{0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0},
			{0,0,0,0,1,2,1,0,1,1,5,1,1,0,1,2,1,0,0,0,0},
			{1,1,1,1,1,2,1,0,1,0,0,0,1,0,1,2,1,1,1,1,1},
			{0,0,0,0,0,2,0,0,1,0,0,0,1,0,0,2,0,0,0,0,0},
			{1,1,1,1,1,2,1,0,1,1,1,1,1,0,1,2,1,1,1,1,1},
			{0,0,0,0,1,2,1,0,0,0,0,0,0,0,1,2,1,0,0,0,0},
			{0,0,0,0,1,2,1,0,1,1,1,1,1,0,1,2,1,0,0,0,0},
			{1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1},
			{1,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,2,2,1},
			{1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,2,1},
			{1,3,2,2,1,2,2,2,2,2,2,2,2,2,2,2,1,2,2,3,1},
			{1,1,1,2,1,2,2,2,1,1,1,1,1,2,2,2,1,2,1,1,1},
			{1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1},
			{1,2,2,2,2,2,1,2,2,2,1,2,2,2,1,2,2,2,2,2,1},
			{1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1},
			{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};	// x,y	21,27
	
	
	public int breite = feld[0].length*20;
	public int hoehe = feld[1].length*20;
	
	public int pac_x = 15;
	public int pac_y = 9;
	
	
	public Spielfeld() {
		
		
	}

	
	public void ausgabe_konsole()
	{
		for(int y=0;y<feld.length;y++)
		{
			for(int x=0;x<feld[0].length;x++)
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
				if(pac_x==y && pac_y==x)
				{
					System.out.print("P");
				}
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		Spielfeld spiel = new Spielfeld();
		spiel.ausgabe_konsole();
	}
}
