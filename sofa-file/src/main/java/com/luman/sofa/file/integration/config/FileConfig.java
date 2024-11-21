package com.luman.sofa.file.integration.config;

import com.luman.sofa.common.utils.LoggerUtil;
import io.minio.MinioClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * minio配置
 *
 * @author yeyinghao
 * @date 2023/09/16
 */
@Component
@Data
@Slf4j
public class FileConfig {

	/**
	 * 是一个URL，域名，IPv4或者IPv6地址")
	 */
	@Value("${minio.endpoint}")
	private String endPoint;

	/**
	 * "accessKey类似于用户ID，用于唯一标识你的账户"
	 */
	@Value("${minio.accessKey}")
	private String accessKey;

	/**
	 * "secretKey是你账户的密码"
	 */
	@Value("${minio.secretKey}")
	private String secretKey;

	/**
	 * "如果是true，则用的是https而不是http,默认值是true"
	 */
	@Value("${minio.secure}")
	private Boolean secure;

	/**
	 * 图片的最大大小
	 */
	@Value("${minio.imageSize}")
	private Long imageSize;

	/**
	 * 其他文件的最大大小
	 */
	@Value("${minio.fileSize}")
	private Long fileSize;

	/**
	 * bucket名称
	 */
	@Value("${minio.bucket-name}")
	private String bucketName;

	/**
	 * 下载地址是否替换为https
	 * 配置为true, 则使用http
	 * false, 使用https
	 */
	@Value("${minio.isHttp}")
	private Boolean isHttp;

	/**
	 * 下载地址默认过期时间
	 */
	@Value("${minio.expirySecond}")
	private Long expirySecond;

	/**
	 * minio客户
	 *
	 * @return {@link MinioClient}
	 */
	@Bean
	public MinioClient minioClient() {
		try {
			return MinioClient.builder().credentials(accessKey, secretKey).endpoint(endPoint).build();
		} catch (Throwable e) {
			LoggerUtil.error(log, e);
		}
		return null;
	}

	/**
	 * 下载地址是否替换为https
	 *
	 * @return boolean
	 */
	public boolean isHttp() {
		return this.isHttp;
	}

	/**
	 * 下载地址是否替换为https
	 *
	 * @return boolean
	 */
	public long expirySecond() {
		return expirySecond;
	}
}
