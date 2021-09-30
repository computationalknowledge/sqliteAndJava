// Download: http://www.java2s.com/Code/Jar/s/Downloadsqlitejdbc372jar.htm

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaSQLite {

	public static void main(String args[]) {
		Worker w = new Worker();
		w.connectToDB();
	}
}

class Worker {
	public void connectToDB() {
		try {
			// establish connection with database
			Class.forName("org.sqlite.JDBC");
			
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:/CES_2021_09_30/collegeEnrollmentSystem.db");
			
			Statement st = con.createStatement();

			// insert some records
			// System.out.println("Insert some records:");
			// st.executeUpdate("insert into record values('neeraj',21)");
			
			// reading records
			System.out.println("Reading records:");
			ResultSet rs = st.executeQuery("select * from students");
			
			while (rs.next()) { System.out.println(rs.getString("studentname") + " " +
					rs.getString("studentid")); } 
			rs.close(); 
			st.close();
			 
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
