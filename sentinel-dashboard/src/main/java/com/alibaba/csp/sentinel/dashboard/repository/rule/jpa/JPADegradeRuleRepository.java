package com.alibaba.csp.sentinel.dashboard.repository.rule.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRulePO;
import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;
import com.alibaba.csp.sentinel.dashboard.repository.rule.RuleRepository;
import com.alibaba.csp.sentinel.util.StringUtil;


@Transactional
@Repository("jpaDegradeRuleRepository")
public class JPADegradeRuleRepository implements RuleRepository<DegradeRuleEntity, Long>{

	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public DegradeRuleEntity save(DegradeRuleEntity entity) {
		if (entity == null || StringUtil.isBlank(entity.getApp())) {
            return null;
        }
	
		em.merge(entity);
	    return null;
	}

	@Override
	public List<DegradeRuleEntity> saveAll(List<DegradeRuleEntity> rules) {
		if(rules == null){
			return null;
		}
		rules.forEach(this::save);
		return null;
	}

	@Override
	public DegradeRuleEntity delete(Long id) {
		DegradeRulePO po = em.find(DegradeRulePO.class, id);
		
		if(po != null){
			em.remove(po);
		}
		
		return null;
	}

	@Override
	public DegradeRuleEntity findById(Long id) {
		DegradeRuleEntity entity = em.find(DegradeRuleEntity.class, id);
		
		return entity;
	}

	@Override
	public List<DegradeRuleEntity> findAllByMachine(MachineInfo machineInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DegradeRuleEntity> findAllByApp(String appName) {
		// TODO Auto-generated method stub
		return null;
	}

}
