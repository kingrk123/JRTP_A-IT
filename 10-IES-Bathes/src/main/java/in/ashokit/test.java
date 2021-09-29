package in.ashokit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String pass = "root";
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			con = DriverManager.getConnection(url,user,pass);
			
			if (con==null) {
				System.out.println("Failed");
			} else {
				System.out.println("Pass");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
