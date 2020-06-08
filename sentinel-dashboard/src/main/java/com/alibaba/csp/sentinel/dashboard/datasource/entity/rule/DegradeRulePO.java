package com.alibaba.csp.sentinel.dashboard.datasource.entity.rule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;


//@Entity
//@Table(name = "sentinel_degrade_rule")
public class DegradeRulePO {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "app")
    private String app;
	
	@Column(name = "ip")
    private String ip;
	
	@Column(name = "port")
    private Integer port;

	@Column(name = "resource")
    private String resource;

	@Column(name = "limitApp")
    private String limitApp;

	@Column(name = "count")
    private Double count;

	@Column(name = "timeWindow")
    private Integer timeWindow;
    
	/**
     * 0 rt 限流; 1为异常;
     */
	@Column(name = "grade")
    private Integer grade;

	@Column(name = "gmtCreate")
    private Date gmtCreate;
	

	@Column(name = "gmtModified")
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


	public String getResource() {
		return resource;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}


	public String getLimitApp() {
		return limitApp;
	}


	public void setLimitApp(String limitApp) {
		this.limitApp = limitApp;
	}


	public Double getCount() {
		return count;
	}


	public void setCount(Double count) {
		this.count = count;
	}


	public Integer getTimeWindow() {
		return timeWindow;
	}


	public void setTimeWindow(Integer timeWindow) {
		this.timeWindow = timeWindow;
	}


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
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
