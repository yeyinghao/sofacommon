/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.luman.sofasmy.util.constant;

/**
 * http常数
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
public interface HttpConstant extends BaseConstant {
	// HttpStatus 定义 开始
	/**
	 * 200（成功） 服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。
	 */
	int OK = 200;

	/**
	 * 400（错误请求） 服务器不理解请求的语法。
	 */
	int BAD_REQUEST = 400;

	/**
	 * 403（禁止） 服务器拒绝请求。
	 */
	int FORBIDDEN = 403;

	/**
	 * 404 服务器无法根据客户端的请求找到资源（网页）。
	 * 通过此代码，网站设计人员可设置"您所请求的资源无法找到"的个性页面。
	 * 也可以在服务器拒绝请求且不想说明理由时使用
	 */
	int NOT_FOUND = 404;

	/**
	 * 500（服务器内部错误） 服务器遇到错误，无法完成请求。
	 */
	int INTERNAL_SERVER_ERROR = 500;

	/**
	 * 503（服务不可用） 服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。
	 */
	int SERVICE_UNAVAILABLE = 503;
	// HttpStatus 定义 结束
}
