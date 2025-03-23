package com.luman.sofa.file.manager;

import com.luman.sofa.file.controller.cmd.FileUrlDownloadCmd;
import com.luman.sofa.file.controller.cmd.FileUrlUploadCmd;
import com.luman.sofa.file.controller.dto.FileVO;

public interface FileManager {
	FileVO getFileUploadUrl(FileUrlUploadCmd cmd);

	FileVO getFileDownloadUrl(FileUrlDownloadCmd cmd);
}
