package com.luman.sofa.file.manager;

import com.luman.sofa.dto.FileVO;
import com.luman.sofa.file.controller.cmd.FileUrlDownloadCmd;
import com.luman.sofa.file.controller.cmd.FileUrlUploadCmd;

public interface FileManager {
	FileVO getFileUploadUrl(FileUrlUploadCmd cmd);

	FileVO getFileDownloadUrl(FileUrlDownloadCmd cmd);
}
