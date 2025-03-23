package com.luman.sofa.file.controller;

import com.luman.sofa.common.constant.LoggerConstant;
import com.luman.sofa.common.helper.ResponseHelper;
import com.luman.sofa.common.log.Logged;
import com.luman.sofa.file.controller.cmd.FileUrlDownloadCmd;
import com.luman.sofa.file.controller.cmd.FileUrlUploadCmd;
import com.luman.sofa.file.controller.dto.FileVO;
import com.luman.sofa.file.manager.FileManager;
import com.luman.sofa.model.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
@Logged(topic = LoggerConstant.REST_LOG)
public class FileController {

	private final FileManager fileManager;

	@PostMapping("/getFileUploadUrl")
	public SingleResponse<FileVO> getFileUploadUrl(@RequestBody FileUrlUploadCmd cmd) {
		return ResponseHelper.singleSuccess(fileManager.getFileUploadUrl(cmd));
	}

	@PostMapping("/getFileDownloadUrl")
	public SingleResponse<FileVO> getFileDownloadUrl(@RequestBody FileUrlDownloadCmd cmd) {
		return ResponseHelper.singleSuccess(fileManager.getFileDownloadUrl(cmd));
	}

}
