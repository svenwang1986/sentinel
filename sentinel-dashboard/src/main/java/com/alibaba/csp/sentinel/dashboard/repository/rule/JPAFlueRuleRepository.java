package com.alibaba.csp.sentinel.dashboard.repository.rule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlueRulePO;
import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;
import com.alibaba.csp.sentinel.util.StringUtil;

@Transactional
@Repository("jpaFlueRuleRepository")
public class JPAFlueRuleRepository implements RuleRepository<FlowRuleEntity, Long>{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public FlowRuleEntity save(FlowRuleEntity entity) {
		if (entity == null || StringUtil.isBlank(entity.getApp())) {
            return null;
        }

        FlueRulePO rulePo = new FlueRulePO();
        BeanUtils.copyProperties(entity,rulePo);
        em.merge(rulePo);
        return null;
	}

	@Override
	public List<FlowRuleEntity> saveAll(List<FlowRuleEntity> rules) {
		if(rules == null){
			return null;
		}
		rules.forEach(this::save);
		return null;
	}

	@Override
	public FlowRuleEntity delete(Long id) {
		
		FlueRulePO po = em.find(FlueRulePO.class, id);
		
		if(po != null){
			em.remove(po);
		}
		
		return null;
	}

	@Override
	public FlowRuleEntity findById(Long id) {
		return em.find(FlowRuleEntity.class, id);
	}

	@Override
	public List<FlowRuleEntity> findAllByMachine(MachineInfo machineInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlowRuleEntity> findAllByApp(String appName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
