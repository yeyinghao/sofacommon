package com.luman.sofa.file.manager.cmd;

import com.luman.sofa.common.enums.ErrorEnum;
import com.luman.sofa.common.exception.BizExceptionFactory;
import com.luman.sofa.common.utils.EnumUtil;
import com.luman.sofa.file.controller.cmd.FileUrlUploadCmd;
import com.luman.sofa.file.controller.dto.FileVO;
import com.luman.sofa.file.integration.enums.FileTypeEnum;
import com.luman.sofa.file.integration.util.FileUtil;
import com.luman.sofa.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUrlUploadCmdExe {

	private final FileService fileService;

	public FileVO getFileUploadUrl(FileUrlUploadCmd cmd) {
		FileTypeEnum fileType = EnumUtil.getEnumByCode(FileTypeEnum.class, cmd.getFileType()).orElseThrow(() ->
				BizExceptionFactory.build(ErrorEnum.ILLEGAL_ENUM, "fileType不合法, fileType={}", cmd.getFileType()));
		String fileKey = FileUtil.createObjectName(fileType, cmd.getUserNo(), cmd.getBizNo(), cmd.getFileName());
		String fileUrl = fileService.getObjectFileUrl(fileKey, 3600L);
		return buildFileVO(cmd.getFileName(), fileKey, fileUrl);
	}

	private FileVO buildFileVO(String fileName, String fileKey, String fileUrl) {
		FileVO fileVO = new FileVO();
		fileVO.setFileName(fileName);
		fileVO.setFileKey(fileKey);
		fileVO.setFileUrl(fileUrl);
		return fileVO;
	}
}
