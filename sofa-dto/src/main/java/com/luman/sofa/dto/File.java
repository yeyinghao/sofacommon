package com.luman.sofa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class File extends DTO {

	private String fileName;

	private String fileKey;

}
