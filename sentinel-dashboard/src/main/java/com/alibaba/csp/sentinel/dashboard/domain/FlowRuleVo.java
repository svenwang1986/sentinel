package com.alibaba.csp.sentinel.dashboard.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;

public class FlowRuleVo {

	private String id;
	private String app;
	private String ip;
	private Integer port;
	private String limitApp;
	private String resource;
	private Integer grade;
	private Double count;
	private Integer strategy;
	private String refResource;
	private Integer controlBehavior;
	private Integer warmUpPeriodSec;
	private Integer maxQueueingTimeMs;
	private boolean clusterMode;
	private ClusterFlowConfig clusterConfig;
	private Date gmtCreate;
	private Date gmtModified;

	public static List<FlowRuleVo> fromFlueRuleEntityList(List<FlowRuleEntity> rules) {
		if (rules == null)
			return null;
		List<FlowRuleVo> list = new ArrayList<>();
		for (FlowRuleEntity entity : rules) {
			FlowRuleVo vo = new FlowRuleVo();
			vo.id = String.valueOf(entity.getId());
			vo.app = entity.getApp();
			vo.ip = entity.getIp();
			vo.port = entity.getPort();
			vo.limitApp = entity.getLimitApp();
			vo.resource = entity.getResource();
			vo.grade = entity.getGrade();
			vo.count = entity.getCount();
			vo.strategy = entity.getStrategy();
			vo.refResource = entity.getRefResource();
			vo.controlBehavior = entity.getControlBehavior();
			vo.warmUpPeriodSec = entity.getWarmUpPeriodSec();
			vo.maxQueueingTimeMs = entity.getMaxQueueingTimeMs();
			vo.clusterMode = entity.isClusterMode();
			vo.clusterConfig = entity.getClusterConfig();
			vo.gmtCreate = entity.getGmtCreate();
			vo.gmtModified = entity.getGmtModified();
			list.add(vo);
		}
		return list;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getLimitApp() {
		return limitApp;
	}

	public void setLimitApp(String limitApp) {
		this.limitApp = limitApp;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Integer getStrategy() {
		return strategy;
	}

	public void setStrategy(Integer strategy) {
		this.strategy = strategy;
	}

	public String getRefResource() {
		return refResource;
	}

	public void setRefResource(String refResource) {
		this.refResource = refResource;
	}

	public Integer getControlBehavior() {
		return controlBehavior;
	}

	public void setControlBehavior(Integer controlBehavior) {
		this.controlBehavior = controlBehavior;
	}

	public Integer getWarmUpPeriodSec() {
		return warmUpPeriodSec;
	}

	public void setWarmUpPeriodSec(Integer warmUpPeriodSec) {
		this.warmUpPeriodSec = warmUpPeriodSec;
	}

	public Integer getMaxQueueingTimeMs() {
		return maxQueueingTimeMs;
	}

	public void setMaxQueueingTimeMs(Integer maxQueueingTimeMs) {
		this.maxQueueingTimeMs = maxQueueingTimeMs;
	}

	public boolean isClusterMode() {
		return clusterMode;
	}

	public void setClusterMode(boolean clusterMode) {
		this.clusterMode = clusterMode;
	}

	public ClusterFlowConfig getClusterConfig() {
		return clusterConfig;
	}

	public void setClusterConfig(ClusterFlowConfig clusterConfig) {
		this.clusterConfig = clusterConfig;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}


}
