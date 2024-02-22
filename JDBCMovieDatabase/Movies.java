package JDBCMovieDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Movies {
	int Mid;
	String Mname;
	String Mtype;
	float Mrating;
	String Mcomments;
	public static void toCreate() {
		System.out.println("Adding a New Movie");
		Movies Mdata = new Movies();
		Scanner input = new Scanner(System.in);

		System.out.println("Movie Name :");
		Mdata.Mname = input.nextLine();

		System.out.println("movie Type :");
		Mdata.Mtype = input.nextLine();

		System.out.println("movie Rating :");
		Mdata.Mrating = input.nextFloat();
		input.nextLine();

		System.out.println("movie Comments :");
		Mdata.Mcomments = input.nextLine();

		DbOperations.toAddMovies(Mdata);
		System.out.println("Student created successfully!!!!!!");
		System.out.println("                                                    ");

	}

	public static void toDisplay() {
		HashMap<Integer, Movies> MoviesDb = DbOperations.toGetAllMoviesData();
		System.out.println("Dispaying the Movie Details");
		System.out.println("\t movieID \t MovieName \t MovieType \t MovieRating \t MovieComments");
		for (Map.Entry<Integer, Movies> MovieEntry : MoviesDb.entrySet()) {
			System.out.print("\t\t" + MovieEntry.getKey());
			System.out.print("\t\t" + MovieEntry.getValue().Mname);
			System.out.print("\t\t" + MovieEntry.getValue().Mtype);
			System.out.print("\t\t" + MovieEntry.getValue().Mrating);
			System.out.print("\t\t" + MovieEntry.getValue().Mcomments);
			System.out.println(" ");
		}

	}

	public static void toSearch() {
		System.out.println("Search your movie here");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the movie id to search :");
		int id = input.nextInt();
		if (DbOperations.moviesExists(id)) {
			Movies obj = DbOperations.toSearchMovies(id);
			System.out.println("movie ID        :" + obj.Mid);
			System.out.println("movie Name      :" + obj.Mname);
			System.out.println("movie Type      :" + obj.Mtype);
			System.out.println("movie Rating    :" + obj.Mrating);
			System.out.println("movie Comments  :" + obj.Mcomments);
		} else {
			System.out.println("The given movie ID " + id + " is not available");
		}
	}

	public static void toUpdate() {
		System.out.println("Update the Movie Details");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Movie id to be updated :");
		int id = input.nextInt();
		input.nextLine();
		if (DbOperations.moviesExists(id)) {
			System.out.println("1  To Update the movie Name");
			System.out.println("2  To Update the movie Type");
			System.out.println("3  To Update the Movie Rating");
			System.out.println("4  To Update the Movie Comments");
			System.out.println("5  To Exit from the Update section");

			System.out.println("Enter the Choice");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter the Updated movie Name");
				DbOperations.toUpdateMName(id, input.nextLine());
				break;
			case 2:
				System.out.println("Enter the Updated movie Type");
				DbOperations.toUpdateMType(id, input.nextLine());
				break;
			case 3:
				System.out.println("Enter the  Updated Movie Rating");
				DbOperations.toUpdateMRating(id, input.nextFloat());
				break;
			case 4:
				System.out.println("Enter the Updated Movie Comments");
				DbOperations.toUpdateMComments(id, input.nextLine());
				break;
			case 5:
				System.out.println("exited from the Update Section");
				return;
			default:
				System.out.println("Invalid Choice");
				toUpdate();
			}

		} else {
			System.out.println("The given Movie id " + id + " not available");

		}

	}

	public static void toRemove() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the movie Id To be Removed");
		int id = input.nextInt();
		if (DbOperations.moviesExists(id)) {
			DbOperations.toRemoveMovies(id);
		} else {
			System.err.println("The Movie with id " + id + " is not available");
		}

	}
}
