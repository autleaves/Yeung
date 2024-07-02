package mil.yaye.yours.common;

public class GlobalNames {

	public static String ENCODING = "utf-8";
	
	public static int PAGE_SIZE = 3;
	public static String URL_PATH = "";
	
	public static String TEMPLATE_PATH = "";
	public static String DOC_PATH = "";
	public static String DOC_URL_PATH = "";
	
	/*
	 * 上传文件默认大小
	 */
	public static int UPLOAD_FILE_SIZE = 2*1024*1024;
	
	/*
	 * 默认上传文件路径
	 */
	public static String UPLOAD_PATH = "";
	
	/**
	 * 会员头像保存路径
	 */
	public static String MEMBER_PIC_UPLOAD_PATH = "";
	public static String MEMBER_PIC_URL_PATH = URL_PATH+"member/pic/";
	public static int MEMBER_PIC_SIZE = 1024*1024;

	
	public static String CURRENT_SESSION_USER = "currentUserVO";
	public static final String PAGEHELPER = "pageHelper";

	public static final String LOGIN_PAGE = "login.jsp";
	
	/*
	 * 首页属性变量
	 */
	public static final String NEW_HOT_BLOCK ="new_hot_list";
	
	/**
	 * 
	 */
	public static final String SERVER = "http://localhost:8077/Yaye";
	
}
