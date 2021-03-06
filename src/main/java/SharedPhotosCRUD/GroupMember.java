package SharedPhotosCRUD;

public class GroupMember {
	private String groupName;
	private String accountName;
	private String accountOwner;
	private int membershipStatus;	
	
	public GroupMember() {
		
	}
	
	public GroupMember(String groupName) {
		this.groupName = groupName;
	}
	
	public GroupMember(String groupName, String accountName, String accountOwner, int membershipStatus) {
		this.groupName  = groupName;
		this.accountName = accountName;
		this.accountOwner = accountOwner;
		this.membershipStatus = membershipStatus;
	}

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getMembershipStatus() {
		return membershipStatus;
	}
	public void setMemberShipStatus(int memberShipStatus) {
		this.membershipStatus = memberShipStatus;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
}
