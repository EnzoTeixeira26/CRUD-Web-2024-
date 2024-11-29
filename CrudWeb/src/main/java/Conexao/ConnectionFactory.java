package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection c;

	public static Connection getConnection() {
		try {
			c = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
			return c;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void close() {
		try {
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}

