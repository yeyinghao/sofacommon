package com.luman.sofa.file.controller.cmd;

import com.luman.sofa.model.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileUrlUploadCmd extends Command {

	private String fileName;

	private String userNo;

	private String bizNo;

	/**
	 * @see com.luman.sofa.file.integration.enums.FileTypeEnum
	 */
	private String fileType;

}
