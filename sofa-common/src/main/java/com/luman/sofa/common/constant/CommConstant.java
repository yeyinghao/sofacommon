package com.luman.sofa.common.constant;

/**
 * 通讯常数
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
public interface CommConstant extends BaseConstant {

	/**
	 * 请求id
	 */
	String TRACE_ID = "traceId";

	/**
	 * 冒号
	 */
	String COLON = ": ";

	/**
	 * 分号
	 */
	String SEMICOLON = "; ";

	/**
	 * 短横
	 */
	String SHORT_HORIZONTAL = "-";

	/**
	 * 下划线
	 */
	String UNDERLINE = "_";

	/**
	 * 分隔符
	 */
	String DELIMITER = ", ";

	/**
	 * Y
	 */
	String Y = "Y";

	/**
	 * N
	 */
	String N = "N";

	/**
	 * = 符号
	 */
	String EQUAL_SIGN = "=";

	/**
	 * & 符号
	 */
	String ESPERLUETTE = "&";

	/**
	 * 毫秒
	 */
	String COST_TIME_MILL_SECOND = "ms";

	/**
	 * 系统字符编码
	 */
	String CHARSET = "UTF-8";

	/**
	 * 线程池Executor默认
	 */
	String THREAD_POOL_EXECUTOR_DEFAULT = "sofasmy";

	/**
	 * 线程池Executor默认
	 */
	String SCHEDULED_THREAD_NAME_PREFIX = "sofasmy-scheduling-";

	String EXECUTOR_THREAD_NAME_PREFIX = "sofasmy-executor-";

	/**
	 * js的number最大安全值
	 */
	Long MAX_VALUE = 9007199254740991L;

	/**
	 * 跨域最大时间 3600 * 24
	 */
	Long CORS_MAX_AGE_SECOND = 86400L;

	/**
	 * 默认页面索引
	 */
	Integer DEFAULT_PAGE_INDEX = 1;

	/**
	 * 默认页面大小
	 */
	Integer DEFAULT_PAGE_SIZE = 20;
}
