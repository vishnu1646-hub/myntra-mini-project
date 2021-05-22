package company.myntra.dataentry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropImage {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/myntra";
		String user = "root";
		String password = "Madhuvishnu14";
		String sql = "update products set image=? where product_id='2'";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			File file = new File("C:/Users/maddy/Pictures/vp.jpg");
			try (FileInputStream fIn = new FileInputStream(file)) {
				preparedStatement.setBinaryStream(1, fIn, (long) file.length());
				preparedStatement.executeUpdate();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
