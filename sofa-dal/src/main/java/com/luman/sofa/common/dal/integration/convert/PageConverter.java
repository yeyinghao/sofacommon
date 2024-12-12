package com.luman.sofa.common.dal.integration.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luman.sofa.common.constant.CommConstant;
import com.luman.sofa.common.dal.integration.model.PO;
import com.luman.sofa.common.dal.integration.model.DP;
import com.luman.sofa.dto.PageModel;
import com.luman.sofa.dto.Paging;

import java.util.Objects;

public interface PageConverter {

	/**
	 * 构建page
	 *
	 * @param page 分页
	 */
	default <D extends DP> PageModel<D> page2PageModel(IPage<D> page) {
		PageModel<D> pageModel = new PageModel<>();
		pageModel.setRecords(page.getRecords());
		pageModel.setPageSize(page.getSize());
		pageModel.setPageIndex(page.getCurrent());
		pageModel.setTotalSize(page.getTotal());
		return pageModel;
	}

	/**
	 * 构建页面
	 *
	 * @param paging 分页
	 * @return {@link IPage }<{@link P }>
	 */
	default <P extends PO> IPage<P> paging2Page(Paging paging) {
		if (Objects.isNull(paging) || Objects.isNull(paging.getPageIndex()) || Objects.isNull(paging.getPageSize())) {
			return new Page<>(CommConstant.DEFAULT_PAGE_INDEX, CommConstant.DEFAULT_PAGE_SIZE);
		}
		return new Page<>(paging.getPageIndex(), paging.getPageSize());
	}

}
