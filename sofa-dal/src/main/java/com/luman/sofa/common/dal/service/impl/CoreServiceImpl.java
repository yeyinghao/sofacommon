package com.luman.sofa.common.dal.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.sofa.common.constant.LoggerConstant;
import com.luman.sofa.common.dal.convert.DataConvert;
import com.luman.sofa.common.dal.model.DP;
import com.luman.sofa.common.dal.model.PO;
import com.luman.sofa.common.dal.service.CoreService;
import com.luman.sofa.common.log.Logged;

import java.util.List;
import java.util.Optional;

/**
 * 网关实现
 *
 * @author yeyinghao
 * @date 2024/04/19
 */
@SuppressWarnings("unused")
@Logged(topic = LoggerConstant.DAL_LOG)
public abstract class CoreServiceImpl<D extends DP, P extends PO, M extends BaseMapper<P>> extends ServiceImpl<M, P> implements CoreService<D, P>, DataConvert<P, D> {

	@Override
	public Long save(D entity) {
		P po = convert(entity);
		save(po);
		entity.setId(po.getId());
		return po.getId();
	}

	@Override
	public Long saveOrUpdate(D entity) {
		P po = convert(entity);
		saveOrUpdate(po);
		entity.setId(po.getId());
		return po.getId();
	}

	@Override
	public boolean saveBatch(List<D> entities) {
		return saveBatch(convert2POs(entities));
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
		return updateById(convert(entity));
	}

	@Override
	public Optional<D> findById(Long id) {
		return Optional.ofNullable(getById(id)).map(this::convert);
	}

	@Override
	public List<D> findAll() {
		return convert2DPs(list());
	}

	@Override
	public List<D> findByIds(List<Long> ids) {
		return convert2DPs(listByIds(ids));
	}

	@Override
	public IPage<D> listByPage(IPage<P> paging) {
		return lambdaQuery().page(paging).convert(this::convert);
	}
}
