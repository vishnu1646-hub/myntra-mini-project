package company.myntra.dataentry;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {
	public static void main(String args[]) throws Exception {
		// Registering the Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Getting the connection
		String mysqlUrl = "jdbc:mysql://localhost:3306/myntra";
		Connection con = DriverManager.getConnection(mysqlUrl, "root", "Madhuvishnu14");
		System.out.println("Connection established......");
		PreparedStatement pstmt = con.prepareStatement("update products set image=? where product_id='45'");
		// Inserting Blob type
		InputStream in = new FileInputStream("C:/Users/maddy/Pictures/nb9.jpg");
		pstmt.setBlob(1, in);
		// Executing the statement
		pstmt.execute();
		System.out.println("Record inserted......");
	}
}
