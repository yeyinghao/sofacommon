package com.luman.sofa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> extends VO {

	private Long pageSize;

	private Long pageIndex;

	private Long totalSize;

	private Collection<T> records;

}
