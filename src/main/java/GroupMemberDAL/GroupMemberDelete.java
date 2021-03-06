package GroupMemberDAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import MySQLConnector.MySQLConnector;
import SharedPhotosUtils.SysOLog;

public class GroupMemberDelete {
	
	static PreparedStatement sharedPhotosPreparedStatement = null;
	 
	public static int deleteGroupMember(String groupName, String accountName, MySQLConnector databaseConnector) {
 
		try {
			String insertQueryStatement = "DELETE FROM group_member "
					+ "WHERE group_member.account_id = (SELECT account_id FROM accounts WHERE account_name = BINARY ?) "
					+ "AND group_member.group_id = (SELECT group_id FROM groups WHERE group_name = BINARY ?)";
 
			sharedPhotosPreparedStatement = databaseConnector.sharedPhotosConn.prepareStatement(insertQueryStatement);
			sharedPhotosPreparedStatement.setString(1, accountName);
			sharedPhotosPreparedStatement.setString(2, groupName);
 
			// execute insert SQL statement
			sharedPhotosPreparedStatement.executeUpdate();
			SysOLog.log(groupName + " deleted successfully");
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}
	
	public static int deleteGroupMemberByGroup(String groupName, MySQLConnector databaseConnector) {
		 
		try {
			String insertQueryStatement = "DELETE FROM group_member WHERE group_member.group_id = (SELECT group_id FROM groups WHERE groups.group_name = BINARY ?);";
 
			sharedPhotosPreparedStatement = databaseConnector.sharedPhotosConn.prepareStatement(insertQueryStatement);
			sharedPhotosPreparedStatement.setString(1, groupName);
 
			// execute insert SQL statement
			sharedPhotosPreparedStatement.executeUpdate();
			SysOLog.log(groupName + " deleted successfully");
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}
}
