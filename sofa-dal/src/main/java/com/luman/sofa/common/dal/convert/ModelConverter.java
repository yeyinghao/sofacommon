package com.luman.sofa.common.dal.convert;

import com.luman.sofa.common.dal.model.DO;
import com.luman.sofa.common.dal.model.DP;
import lombok.SneakyThrows;

public class ModelConverter {

	@SneakyThrows
	public static <D extends DP, P extends DO> D buildDP(Class<D> clazz, P p) {
		D d = clazz.getDeclaredConstructor().newInstance();
		d.setId(p.getId());
		d.setCreateTime(p.getCreateTime());
		d.setUpdateTime(p.getUpdateTime());
		d.setStatus(p.getStatus());
		return d;
	}

	@SneakyThrows
	public static <D extends DP, P extends DO> P buildDP(Class<P> clazz, D d) {
		P p = clazz.getDeclaredConstructor().newInstance();
		p.setId(d.getId());
		p.setCreateTime(d.getCreateTime());
		p.setUpdateTime(d.getUpdateTime());
		p.setStatus(d.getStatus());
		return p;
	}
}
