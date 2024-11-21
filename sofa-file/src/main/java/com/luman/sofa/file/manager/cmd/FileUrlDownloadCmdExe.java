package com.luman.sofa.file.manager.cmd;

import com.luman.sofa.dto.FileVO;
import com.luman.sofa.file.controller.model.FileUrlDownloadCmd;
import com.luman.sofa.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUrlDownloadCmdExe {

	private final FileService fileService;

	public FileVO getFileDownloadUrl(FileUrlDownloadCmd cmd) {
		String objectFileUrl = fileService.getObjectFileUrl(cmd.getFileKey(), 3600L);
		return buildFileVO(objectFileUrl);
	}

	private FileVO buildFileVO(String objectFileUrl) {
		FileVO fileVO = new FileVO();
		fileVO.setFileUrl(objectFileUrl);
		return fileVO;
	}
}
