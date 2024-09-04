package com.luman.sofa.common.dal.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.sofa.common.dal.convert.DataConvert;
import com.luman.sofa.common.dal.model.DO;
import com.luman.sofa.common.dal.model.DP;
import com.luman.sofa.common.dal.service.CoreService;
import com.luman.sofa.common.dto.PageModel;
import com.luman.sofa.common.dto.Paging;

import java.util.List;
import java.util.Optional;

/**
 * 网关实现
 *
 * @author yeyinghao
 * @date 2024/04/19
 */
@SuppressWarnings("unused")
public abstract class CoreServiceImpl<D extends DP, P extends DO, M extends BaseMapper<P>> extends ServiceImpl<M, P> implements CoreService<D>, DataConvert<P, D> {

	@Override
	public Long save(D entity) {
		P po = convertToPO(entity);
		save(po);
		entity.setId(po.getId());
		return po.getId();
	}

	@Override
	public Long saveOrUpdate(D entity) {
		P po = convertToPO(entity);
		saveOrUpdate(po);
		entity.setId(po.getId());
		return po.getId();
	}

	@Override
	public boolean saveBatch(List<D> entities) {
		return saveBatch(convertToPOs(entities));
	}

	@Override
	public boolean deleteById(Long id) {
		return removeById(id);
	}

	@Override
	public boolean deleteByIds(List<Long> ids) {
		return removeByIds(ids);
	}

	@Override
	public boolean updateById(D entity) {
		return updateById(convertToPO(entity));
	}

	@Override
	public Optional<D> findById(Long id) {
		return Optional.ofNullable(getById(id)).map(this::convertToDP);
	}

	@Override
	public List<D> findAll() {
		return convertToDPs(list());
	}

	@Override
	public List<D> findByIds(List<Long> ids) {
		return convertToDPs(listByIds(ids));
	}

	@Override
	public PageModel<D> listByPage(Paging paging) {
		return page2PageModel(lambdaQuery().page(paging2Page(paging)).convert(this::convertToDP));
	}
}
