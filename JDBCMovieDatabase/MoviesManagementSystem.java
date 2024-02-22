package JDBCMovieDatabase;

import java.util.Scanner;

public class MoviesManagementSystem {

	public static void menuBar() {
		System.out.println("                                                    ");
		System.out.println("****************************************************");
		System.out.println("1 TO Create a Movie details");
		System.out.println("2 TO Display the Movie Details");
		System.out.println("3 TO Search for Movie details");
		System.out.println("4 TO Update the Movie details");
		System.out.println("5 TO Remove the Movie details");
		System.out.println("6  to exit application" + "\n");
		System.out.println("****************************************************");
		System.out.print("Enter Your Choice : ");
		System.out.println("                                                    ");
	}

	public static void main(String[] args) {
		System.out.println("****************************************************");
		System.out.println("               The Movie Database System            ");
		System.out.println("****************************************************");

		while (true) {
			Scanner input = new Scanner(System.in);
			menuBar();
			int option = input.nextInt();
			switch (option) {
			case 1:
				Movies.toCreate();
				break;
			case 2:
				Movies.toDisplay();
				break;
			case 3:
				Movies.toSearch();
				break;
			case 4:
				Movies.toUpdate();
				break;
			case 5:
				Movies.toRemove();
				break;
			case 6:
				System.out.println("Application Exitted!!!!!!!");
				return;
			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

}
