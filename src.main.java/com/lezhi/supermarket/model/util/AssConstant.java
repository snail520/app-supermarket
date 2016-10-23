package com.lezhi.supermarket.model.util;


/**
 * Description: ass 常量类
 * 
 * @author shizy
 * @version:V1.0
 * @createDateTime：2013-7-2上午09:55:57
 * @Company:MSD
 * @Copyright:Copyright(c) 2013
 */

public abstract class AssConstant {
	
	/**
	 * 远程登录失败是否进行本地登录
	 */
	public static Boolean		LOCAL_LOGIN;
	
	/**
	 * 是否开启验证码验证
	 */
	public static Boolean		VALIDATE_CODE;
	
	/**
	 * 是否开启密码验证
	 */
	public static Boolean		VALIDATE_PASS;
	
	/**
	 * 版本号
	 */
	public static String		VERSIONS;
	
	/**
	 * 密码加密时,用到的盐值
	 */
	public static String		SALT_VALUE;
	
	/**
	 * 是否检查session
	 */
	public static Boolean		CHECK_SESSION;
	
	/**
	 * 是否检查权限
	 */
	public static Boolean		CHECK_PERMISSION;
	
	/**
	 * 自动登录 测试帐户,为空则不进行自动登录
	 */
	public static String		TEST_ACCOUNT;
	public static String		TEST_PASSWORD;
	
	/**
	 * 页宽
	 */
	public static String		PAGE_SIZE;
	
	/**
	 * 配置文件reload间隔,单位毫秒
	 */
	public static Long			propRefreshDelay			= 2000L;
	
	/**
	 * 接口访问，超时时间
	 */
	public static Integer		INTERFACE_TIMEOUT;
	
	/**
	 * ScriptCssFilter 过滤器，处理的javascript css 文件，缓存时间(更新间隔) script css
	 */
	public static String		scriptCssRefreshDelay;
	
	/**
	 * 异常邮件发送开关
	 */
	public static Boolean		EXCEPTION_MAIL_SWITCH		= false;
	
	public static Boolean		DEBUG						= false;
	
	/**
	 * 定时器启动开关
	 */
	public static Boolean		QUARTZ_SWITCH				= false;
	
	public static Integer		startupDelay;
	
	public static Boolean		waitForJobsToCompleteOnShutdown;
	public static Boolean		overwriteExistingJobs		= true;
	
	/**
	 * 网站根路径
	 */
	public static String		WEB_PATH;
	
	/**
	 * 响应头的Server
	 */
	public static String		WEB_SERVER;
	
	/**
	 * 用户最后的请求时间的KEY,存放于Session中
	 */
	public static final String	SESSION_LAST_REQUEST_TIME	= "SESSION_LAST_REQUEST_TIME";
	
	/**
	 * 接口参数配置bean的名称
	 */
	public static final String	API_CONFIG_BEAN_NAME		= "apiConfig";
	
	/**
	 * 根权限的上一级权限ID为0
	 */
	public static final String	ROOT_LIMIT_PARENT_ID		= "0";
	
	/**
	 * 首页路径,网站开始路径
	 */
	public static String		WEB_START_PATH				= "/menu/index";				
	
	/**
	 * 首页路径,网站开始路径--后部分
	 */
	public static String		LOGIN_PATH					= "/login";
	
	/**
	 * 换行符
	 */
	public static final String	LINE_SEPARATOR				= System.getProperty(
																	"line.separator",
																	"/r/n");
	
	/**
	 * 默认编码字集
	 */
	public static final String	UTF8						= "UTF-8";
	
	/**
	 *
	 */
	public static final String	GBK							= "GBK";
	
	/**
	 * 令牌
	 */
	public static final String	SPRINGMVC_TOKEN				= "SPRINGMVC_TOKEN";
	public static final String	SPRINGMVC_TOKEN_MAP			= "SPRINGMVC_TOKEN_MAP";
	
	/**
	 * 系统管理员帐号列表
	 */
	public static String[]		SYS_ADMIN_ACCOUNT_LIST;
	
	/**
	 * 未知用户ID，标识
	 */
	public static final String	UNKNOWN_USERID				= "-1";
	/**
	 * 未知商户ID，标识
	 */
	public static final String	UNKNOWN_MERCHANTID			= "-1";
	
	/**
	 * (批量新增和批量更新时)多少个数量级,flush一次
	 */
	public static final Integer	FLUSH_CRITICAL_VAL			= 100;
	
	/**
	 * (批量新增和批量更新时)大数量级,flush一次
	 */
	public static final Integer	FLUSH_BIG_CRITICAL_VAL		 = 99999;
	
	/**
	 * 批量删除时,多少个数量级,重新使用or连接 Oracle IN语句的最大表达式数为 1000
	 */
	public static final Integer	DELETE_CRITICAL_VAL			= 999;
	
	/**
	 * varchar2
	 */
	public static final Integer	JDBC_VARCHAR2_MAXLEN		= 2000;

	/**
	 * 更新bbs论坛用户名
	 */
	public static Boolean		MODIFY_BBS_USERNAME			= true;
	
	public static Long			UPLOAD_FILE_MAX_SIZE		= 10485760L;
	
}
