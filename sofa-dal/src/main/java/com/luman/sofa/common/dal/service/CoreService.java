package com.luman.sofa.common.dal.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luman.sofa.common.dal.model.DO;
import com.luman.sofa.common.dal.model.DP;

import java.util.List;
import java.util.Optional;

/**
 * 基础数据服务
 *
 * @author yeyinghao
 * @date 2024/04/02
 */
@SuppressWarnings("unused")
public interface CoreService<D extends DP, P extends DO> {

	/**
	 * 保存
	 *
	 * @param entity 数据库领域对象
	 */
	Long save(D entity);

	/**
	 * 保存
	 *
	 * @param entity 数据库领域对象
	 */
	Long saveOrUpdate(D entity);

	/**
	 * 批量保存
	 *
	 * @param entities 数据库领域对象
	 */
	boolean saveBatch(List<D> entities);

	/**
	 * 根据id删除
	 *
	 * @param id 主键id
	 */
	boolean deleteById(Long id);

	/**
	 * 根据id列表删除
	 *
	 * @param ids 主键id列表
	 */
	boolean deleteByIds(List<Long> ids);

	/**
	 * 根据id修改
	 *
	 * @param entity 数据库领域对象
	 */
	boolean updateById(D entity);

	/**
	 * 根据id查询
	 *
	 * @param id 主键id
	 */
	Optional<D> findById(Long id);

	/**
	 * 查询所有
	 */
	List<D> findAll();

	/**
	 * 根据id列表查询
	 *
	 * @param ids 主键id列表
	 * @return {@link List}<{@link D}>
	 */
	List<D> findByIds(List<Long> ids);

	/**
	 * 分页查询
	 */
	IPage<D> listByPage(IPage<P> paging);
}
