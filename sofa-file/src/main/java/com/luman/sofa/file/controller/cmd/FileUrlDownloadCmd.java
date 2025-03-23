package com.luman.sofa.file.controller.cmd;

import com.luman.sofa.model.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileUrlDownloadCmd extends Command {

	private String fileKey;

}
