package com.luman.sofa.common.dal.convert;

import cn.hutool.core.collection.CollectionUtil;
import com.luman.sofa.common.dal.model.DP;
import com.luman.sofa.common.dal.model.PO;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface DataConvert<P extends PO, D extends DP> {

	/**
	 * 转换成Po
	 *
	 * @param d 域对象
	 * @return {@link P}
	 */
	P convert(D d);

	/**
	 * 转换来DO
	 *
	 * @param p 持久化对象
	 * @return {@link D}
	 */
	D convert(P p);

	/**
	 * 转换为DOs
	 *
	 * @param ps 持久化对象
	 * @return {@link List}<{@link D}>
	 */
	default List<D> convert2DPs(List<P> ps) {
		if (CollectionUtil.isEmpty(ps)) {
			return CollectionUtil.newArrayList();
		}
		return ps.stream().map(this::convert).collect(Collectors.toList());
	}

	/**
	 * 转换为POs
	 *
	 * @param ds 域对象
	 * @return {@link List}<{@link P}>
	 */
	default List<P> convert2POs(List<D> ds) {
		if (CollectionUtil.isEmpty(ds)) {
			return CollectionUtil.newArrayList();
		}
		return ds.stream().map(this::convert).collect(Collectors.toList());
	}

	default P convert(D d, Supplier<P> target) {
		return convert(d, target, null);
	}

	/**
	 * 转换来DO
	 *
	 * @param p 持久化对象
	 * @return {@link D}
	 */
	default D convert(P p, Supplier<D> target) {
		return convert(p, target, null);
	}

	default P convert(D d, Supplier<P> target, BiConsumer<D, P> consumer) {
		P p = target.get();
		p.setId(d.getId());
		p.setCreateTime(d.getCreateTime());
		p.setUpdateTime(d.getUpdateTime());
		p.setStatus(d.getStatus());
		if (consumer != null) {
			consumer.accept(d, p);
		}
		return p;
	}

	/**
	 * 转换来DO
	 *
	 * @param p 持久化对象
	 * @return {@link D}
	 */
	default D convert(P p, Supplier<D> target, BiConsumer<P, D> consumer) {
		D d = target.get();
		d.setId(p.getId());
		d.setCreateTime(p.getCreateTime());
		d.setUpdateTime(p.getUpdateTime());
		d.setStatus(p.getStatus());
		if (consumer != null) {
			consumer.accept(p, d);
		}
		return d;
	}
}
