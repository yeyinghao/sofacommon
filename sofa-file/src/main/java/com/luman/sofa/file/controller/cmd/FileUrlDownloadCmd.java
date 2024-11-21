package com.luman.sofa.file.controller.cmd;

import com.luman.sofa.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileUrlDownloadCmd extends Command {

	private String fileKey;

}
