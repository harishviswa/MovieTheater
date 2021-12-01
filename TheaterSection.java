//Harish Viswa
//Collaborated with Anwith in class
import java.lang.Math;
public class TheaterSection {

	private boolean[][] sectionBoolean;
	private char[][] charPrint;
	private int random;
	private static final int WIDTH = 25;
	private static final int HEIGHT = 5;

	public TheaterSection() {
		//instantiating array/adding booleans
		sectionBoolean = new boolean[5][WIDTH];
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				random = (int)(Math.random()* (HEIGHT - 1)) + 1;
				if(random == 1)
					sectionBoolean[i][j] = true;
				else
					sectionBoolean[i][j] = false;
			}
		}
		//converts boolean 2d array to characters
		charPrint = new char[HEIGHT][WIDTH];
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(sectionBoolean[i][j] == false) {
					charPrint[i][j] = 'X';
				}
				if(sectionBoolean[i][j] == true) {
					charPrint[i][j] = '*';
				}
			}
		}
	}
	
	public TheaterSection(boolean[][] sectionBoolean) {
		this.sectionBoolean = sectionBoolean;
	}
	//prints out raw map of available seats in console
	public void printSection() {
		for(int i = 0; i < WIDTH; i++) {
			System.out.print("\t" + i);
		}
		
		//prints out character array
		for(int i = 0; i < HEIGHT; i++) {
			System.out.println("\t");
			System.out.print((char)(65 + i));
			for(int j = 0; j < WIDTH; j++) {
				System.out.print("\t" + charPrint[i][j]);
			}
		}
		/*this prints out true/false in console instead of X/*
		 * for(int i = 0; i < HEIGHT; i++) {
			System.out.println(" ");
			System.out.print((char)(65 + i));
			for(int j = 0; j < WIDTH; j++) {
				System.out.print(" " + sectionBoolean[i][j]);
			}
		}
		*/
	}
	public void printAvailable() {
		int totalAvailable = 0;
		int rowAvailable = 0;
		System.out.println("\n\nRow   Available Seats");
		for(int i = 0; i < HEIGHT; i++) {
			System.out.println(" ");
			System.out.print(" " + (char)(65 + i)+ "   ");
			rowAvailable = 0;
			for(int j = 0; j < WIDTH; j++) {
				if(sectionBoolean[i][j] == true) {
					System.out.print(" " + j);
					totalAvailable++;
					rowAvailable++;
				}
				if(j == (WIDTH -1) && rowAvailable == 0){
					System.out.print("None available");
				}
			}
		}
		System.out.println("\n\nThe total number of seats available is " + totalAvailable + ".");
	}
	
	public static void main(String[] args) {	
		TheaterSection Theater = new TheaterSection();
		Theater.printSection();
		Theater.printAvailable();
	}
}
