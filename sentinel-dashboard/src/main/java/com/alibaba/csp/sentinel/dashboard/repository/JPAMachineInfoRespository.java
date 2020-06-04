package com.alibaba.csp.sentinel.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.MachineInfoPO;
import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;

@Transactional
@Repository("jpaMachineInfoRepository")
public class JPAMachineInfoRespository {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 查询机器 不存在则添加，存在则更新
	 * 
	 * @param appName
	 */
	public void addOrUpdate(MachineInfo machineInfo) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("FROM MachineInfoPO");
		hql.append(" WHERE app=:app");
		hql.append(" AND hostname=:hostname");
		hql.append(" AND ip=:ip");
		hql.append(" AND port=:port");

		Query query = em.createQuery(hql.toString());
		query.setParameter("app", machineInfo.getApp());
		query.setParameter("hostname", machineInfo.getHostname());
		query.setParameter("ip", machineInfo.getIp());
		query.setParameter("port", machineInfo.getPort());
		
		List<MachineInfoPO> list = query.getResultList();
		if (!CollectionUtils.isEmpty(list)) {
			list.forEach(item -> {
				item.setLastHeartbeat(machineInfo.getLastHeartbeat());
				em.merge(item);
				return ;
			} );
		}else{
			MachineInfoPO po = MachineInfoPO.fromMachineInfo(machineInfo);
			em.merge(po);
		}

	}

	public void delete(MachineInfo machineInfo) {
		StringBuilder hql = new StringBuilder();
		hql.append("FROM MachineInfoPO");
		hql.append(" WHERE app=:app");
		hql.append(" AND hostname=:hostname");
		hql.append(" AND ip=:ip");
		hql.append(" AND port=:port");

		Query query = em.createQuery(hql.toString());
		query.setParameter("app", machineInfo.getApp());
		query.setParameter("hostname", machineInfo.getHostname());
		query.setParameter("ip", machineInfo.getIp());
		query.setParameter("port", machineInfo.getPort());
		
		List<MachineInfoPO> list = query.getResultList();
		if (!CollectionUtils.isEmpty(list)) {
			list.forEach(item -> {
				em.remove(item);
			} );
		}
		
	}

}
