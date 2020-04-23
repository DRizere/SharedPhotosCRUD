package GroupDAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import MySQLConnector.MySQLConnector;
import SharedPhotosUtils.SysOLog;

public class GroupCreation {

	static PreparedStatement sharedPhotosPreparedStatement = null;
	 
	public static void addGroupToDB(String accountName, String groupName, MySQLConnector databaseConnector) {
 
		try {
			String insertQueryStatement = "INSERT INTO groups (account_id, group_name) "
					+ "SELECT accounts.account_id, ? FROM accounts "
					+ "WHERE account_name = BINARY ?";

			sharedPhotosPreparedStatement = databaseConnector.sharedPhotosConn.prepareStatement(insertQueryStatement);
			sharedPhotosPreparedStatement.setString(1, groupName);
			sharedPhotosPreparedStatement.setString(2, accountName);
 
			// execute insert SQL statement
			sharedPhotosPreparedStatement.executeUpdate();
			SysOLog.log(accountName + " added successfully");
		} catch (
 
		SQLException e) {
			e.printStackTrace();
		}
	}
	
}
