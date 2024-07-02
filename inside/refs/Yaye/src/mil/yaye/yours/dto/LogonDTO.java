package mil.yaye.yours.dto;

public class LogonDTO {

	// Fields
	
//	private String username;
	private String logonid;
	private String password;
	private String validatecode;
	
	// Default Constructor
	public LogonDTO(){
	}
	
	// Accessors
	
	/*public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidatecode() {
		return validatecode;
	}
	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}
	public String getLogonid() {
		return logonid;
	}
	public void setLogonid(String logonid) {
		this.logonid = logonid;
	}
	
}
