package com.luman.sofa.common.dal.integration.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luman.sofa.common.constant.CommConstant;
import com.luman.sofa.common.dal.integration.model.PO;
import com.luman.sofa.model.PageQuery;
import com.luman.sofa.model.PageVO;

import java.util.Objects;

public interface PageConverter {

	/**
	 * 构建page
	 *
	 * @param page 分页
	 */
	default <D> PageVO<D> convert2PageVO(IPage<D> page) {
		PageVO<D> pageVO = new PageVO<>();
		pageVO.setRecords(page.getRecords());
		pageVO.setPageSize(page.getSize());
		pageVO.setPageIndex(page.getCurrent());
		pageVO.setTotalSize(page.getTotal());
		return pageVO;
	}

	/**
	 * 构建页面
	 *
	 * @param pageQuery 分页
	 * @return {@link IPage }<{@link P }>
	 */
	default <P extends PO> IPage<P> convert2IPage(PageQuery pageQuery) {
		if (Objects.isNull(pageQuery) || Objects.isNull(pageQuery.getPageIndex()) || Objects.isNull(pageQuery.getPageSize())) {
			return new Page<>(CommConstant.DEFAULT_PAGE_INDEX, CommConstant.DEFAULT_PAGE_SIZE);
		}
		return new Page<>(pageQuery.getPageIndex(), pageQuery.getPageSize());
	}

}
