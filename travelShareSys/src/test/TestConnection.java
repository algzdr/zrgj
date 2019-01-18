package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.wyt.travelShare.util.MyDBUtils;

public class TestConnection {
	
	@Test
	public void testDB() throws SQLException {
		Connection connection = MyDBUtils.getConnection();
		System.out.println(connection);
		connection.close();
	}
	
}
