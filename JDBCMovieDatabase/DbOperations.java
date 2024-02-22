package JDBCMovieDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DbOperations {
	private static final String host = "jdbc:mysql://localhost:3306/moviesdb";
	private static final String userName = "root";
	private static final String password = "Vikram@88708";

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(host, userName, password);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void toAddMovies(Movies Mdata) {
		try {
			Connection con = getConnection();
			String query = "insert into movies (mname,mtype,mrating,mcomments)" + "values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, Mdata.Mname);
			stmt.setString(2, Mdata.Mtype);
//			stmt.setString(3, Float.toString(Mdata.Mrating));
			stmt.setFloat(3, Mdata.Mrating);
			stmt.setString(4, Mdata.Mcomments);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("student creation successful!!!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, Movies> toGetAllMoviesData() {
		try {
			Connection con = getConnection();
			String query = "Select * from Movies";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			HashMap<Integer, Movies> Mdatabase = new HashMap<Integer, Movies>();
			while (result.next()) {
				Movies obj = new Movies();
//				the number denotes inside the get function is column present in database
				obj.Mid = result.getInt(1);
				obj.Mname = result.getString(2);
				obj.Mtype = result.getString(3);
				obj.Mrating = result.getFloat(4);
				obj.Mcomments = result.getString(5);
				Mdatabase.put(obj.Mid, obj);
			}
			stmt.close();
			con.close();
			return Mdatabase;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static Movies toSearchMovies(int id) {
		try {
			Connection con = getConnection();
			String query = "select * from movies where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			Movies obj = new Movies();
			result.next();
			obj.Mid = result.getInt(1);
			obj.Mname = result.getString(2);
			obj.Mtype = result.getString(3);
			obj.Mrating = result.getFloat(4);
			obj.Mcomments = result.getString(5);
			stmt.close();
			con.close();
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static boolean moviesExists(int id) {
		try {
			Connection con = getConnection();
			String query = "select * from movies where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			boolean flag = result.next();
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public static void toRemoveMovies(int id) {
		try {
			Connection con = getConnection();
			String query = "delete from movies where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Movie with id " + id + " successfully removed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void toUpdateMName(int id, String name) {
		try {
			Connection con = getConnection();
			String query = "update movies set mname=? where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("student was updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void toUpdateMType(int id, String mtype) {
		try {
			Connection con = getConnection();
			String query = "update Movies set mtype=? where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, mtype);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("The Movie type was Updated Successfully!!!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void toUpdateMRating(int id, float rating) {
		try {
			Connection con = getConnection();
			String query = "update Movies set mrating=? where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setFloat(1, rating);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("The movies rating was updated Successfully!!!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void toUpdateMComments(int id, String comments) {
		try {
			Connection con = getConnection();
			String query = "update movies set mcomments=? where mid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, comments);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Movies comments was updated successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
