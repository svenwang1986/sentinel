package com.alibaba.csp.sentinel.dashboard.domain.vo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;

/**
 * 页面展示数据时使用 ID做为long型，过长时JS代码会将末尾几位置成0，所以改String 类型
 * 
 * @author sven
 *
 */
public class DegradeRuleVO {

	private String id;

	private String app;

	private String ip;

	private Integer port;

	private String resource;

	private String limitApp;

	private Double count;

	private Integer timeWindow;

	/**
	 * 0 rt 限流; 1为异常;
	 */
	private Integer grade;

	private Date gmtCreate;

	private Date gmtModified;

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

	private static DegradeRuleVO fromEntity(DegradeRuleEntity entity) {
		DegradeRuleVO vo = new DegradeRuleVO();
		vo.setId(String.valueOf(entity.getId()));
		vo.setApp(entity.getApp());
		vo.setLimitApp(entity.getLimitApp());
		vo.setCount(entity.getCount());
		vo.setGmtCreate(entity.getGmtCreate());
		vo.setGmtModified(vo.getGmtModified());
		vo.setGrade(entity.getGrade());
		vo.setIp(entity.getIp());
		vo.setPort(entity.getPort());
		vo.setResource(entity.getResource());
		vo.setTimeWindow(entity.getTimeWindow());
		return vo;

	}

	public static List<DegradeRuleVO> fromEntity(List<DegradeRuleEntity> entityList) {
		return entityList.stream().map(DegradeRuleVO::fromEntity).collect(Collectors.toList());

	}

}
