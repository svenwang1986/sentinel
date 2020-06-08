package com.alibaba.csp.sentinel.dashboard.datasource.entity.rule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;

@Entity
@Table(name = "sentinel_flow_rule")
public class FlowRulePO {
	
	/** id，主键 */
	@Id
	//@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/** 应用名称 */
	@Column(name = "app")
    private String app;
	
	@Column(name = "ip")
    private String ip;
	
	@Column(name = "port")
    private Integer port;
	
	@Column(name = "limitApp")
    private String limitApp;
    
    /** 资源名称 */
	@Column(name = "resource")
    private String resource;
    /**
     * 0为线程数;1为qps
     */
	@Column(name = "grade")
    private Integer grade;
	
	@Column(name = "count")
    private Double count;
    /**
     * 0为直接限流;1为关联限流;2为链路限流
     ***/
	@Column(name = "strategy")
    private Integer strategy;
	
	@Column(name = "refResource")
    private String refResource;
    /**
     * 0. default, 1. warm up, 2. rate limiter
     */
	@Column(name = "controlBehavior")
    private Integer controlBehavior;
	
	@Column(name = "warmUpPeriodSec")
    private Integer warmUpPeriodSec;
    /**
     * max queueing time in rate limiter behavior
     */
	@Column(name = "maxQueueingTimeMs")
    private Integer maxQueueingTimeMs;

	@Column(name = "clusterMode")
    private boolean clusterMode;
    /**
     * Flow rule config for cluster mode.
     */
	@Transient
    private ClusterFlowConfig clusterConfig;

    /** 创建时间 */
	@Column(name = "gmt_create")
    private Date gmtCreate;
	
	/** 修改时间 */
	@Column(name = "gmt_modified")
    private Date gmtModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
