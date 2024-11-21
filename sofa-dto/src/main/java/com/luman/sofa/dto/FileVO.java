package com.luman.sofa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileVO extends VO {
	
	private String fileName;

	private String fileKey;
	
	private String fileUrl;
	
}
