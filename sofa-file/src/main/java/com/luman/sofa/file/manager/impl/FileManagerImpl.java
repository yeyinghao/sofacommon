package com.luman.sofa.file.manager.impl;

import com.luman.sofa.dto.FileVO;
import com.luman.sofa.file.controller.cmd.FileUrlDownloadCmd;
import com.luman.sofa.file.controller.cmd.FileUrlUploadCmd;
import com.luman.sofa.file.manager.FileManager;
import com.luman.sofa.file.manager.cmd.FileUrlDownloadCmdExe;
import com.luman.sofa.file.manager.cmd.FileUrlUploadCmdExe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileManagerImpl implements FileManager {

	private final FileUrlUploadCmdExe fileUrlUploadCmdExe;

	private final FileUrlDownloadCmdExe fileUrlDownloadCmdExe;

	@Override
	public FileVO getFileUploadUrl(FileUrlUploadCmd cmd) {
		return fileUrlUploadCmdExe.getFileUploadUrl(cmd);
	}

	@Override
	public FileVO getFileDownloadUrl(FileUrlDownloadCmd cmd) {
		return fileUrlDownloadCmdExe.getFileDownloadUrl(cmd);
	}
}
