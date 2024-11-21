package com.luman.sofa.file.controller;

import com.luman.sofa.common.helper.ResponseHelper;
import com.luman.sofa.common.monitor.rest.RestLog;
import com.luman.sofa.dto.FileVO;
import com.luman.sofa.dto.Response;
import com.luman.sofa.file.controller.model.FileUrlDownloadCmd;
import com.luman.sofa.file.controller.model.FileUrlUploadCmd;
import com.luman.sofa.file.manager.FileManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RestLog
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

	private final FileManager fileManager;

	@PostMapping("/getFileUploadUrl")
	public Response<FileVO> getFileUploadUrl(@RequestBody FileUrlUploadCmd cmd) {
		return ResponseHelper.success(fileManager.getFileUploadUrl(cmd));
	}

	@PostMapping("/getFileDownloadUrl")
	public Response<FileVO> getFileUploadUrl(@RequestBody FileUrlDownloadCmd cmd) {
		return ResponseHelper.success(fileManager.getFileDownloadUrl(cmd));
	}

}
