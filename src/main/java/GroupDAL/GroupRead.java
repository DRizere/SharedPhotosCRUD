package GroupDAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MySQLConnector.MySQLConnector;

public class GroupRead {
	
	static PreparedStatement sharedPhotosPreparedStatement = null;
	
	public static ResultSet readGroupsByOwner(String accountNameSearch, MySQLConnector databaseConnector) {
		 
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT group_name, account_name FROM groups " +
					"INNER JOIN accounts ON accounts.account_id = groups.account_id " +
					"WHERE account_name = BINARY ? ";
 
			sharedPhotosPreparedStatement = databaseConnector.sharedPhotosConn.prepareStatement(getQueryStatement);

			sharedPhotosPreparedStatement.setString(1, accountNameSearch);
 
			// Execute the Query, and get a java ResultSet
			ResultSet rs = sharedPhotosPreparedStatement.executeQuery();
 
			// Let's iterate through the java ResultSet
			/*while (rs.next()) {
				String accountName = rs.getString("account_name");
				String email = rs.getString("email");
				String accountOwner = rs.getString("account_owner");
				String creationDate = rs.getString("creation_date");
				String roleType = rs.getString("role_type");
 
				// Simply Print the results
				SysOLog.log( String.format("%s, %s, %s, %s, %s\n", accountName, email, accountOwner, creationDate, roleType));
			}*/
			
			return rs;
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		return null;
	}
	
	public static ResultSet readGroupCountByAccount(String accountNameSearch, MySQLConnector databaseConnector) {
		 
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT COUNT(group_id) AS NumberOfGroups FROM groups " +
					"INNER JOIN accounts ON accounts.account_id = groups.account_id " +
					"WHERE account_name = BINARY ? ";
 
			sharedPhotosPreparedStatement = databaseConnector.sharedPhotosConn.prepareStatement(getQueryStatement);

			sharedPhotosPreparedStatement.setString(1, accountNameSearch);
 
			// Execute the Query, and get a java ResultSet
			ResultSet rs = sharedPhotosPreparedStatement.executeQuery();
 
			// Let's iterate through the java ResultSet
			/*while (rs.next()) {
				String accountName = rs.getString("account_name");
				String email = rs.getString("email");
				String accountOwner = rs.getString("account_owner");
				String creationDate = rs.getString("creation_date");
				String roleType = rs.getString("role_type");
 
				// Simply Print the results
				SysOLog.log( String.format("%s, %s, %s, %s, %s\n", accountName, email, accountOwner, creationDate, roleType));
			}*/
			
			return rs;
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		return null;
	}
}
