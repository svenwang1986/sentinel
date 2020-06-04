package com.alibaba.csp.sentinel.dashboard.datasource.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.csp.sentinel.dashboard.discovery.MachineInfo;

@Entity
@Table(name = "sentinel_machine_info")
public class MachineInfoPO {
	/** id，主键 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "app")
	private String app = "";
	
	@Column(name = "appType")
    private Integer appType = 0;
	
	@Column(name = "hostname")
    private String hostname = "";
	
	@Column(name = "ip")
    private String ip = "";
	
	@Column(name = "port")
    private Integer port = -1;
	
	@Column(name = "lastHeartbeat")
    private long lastHeartbeat;
	
	@Column(name = "heartbeatVersion")
    private long heartbeatVersion;
	
	@Column(name = "gmtCreate")
	private Date gmtCreate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Integer getAppType() {
		return appType;
	}

	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
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

	public long getLastHeartbeat() {
		return lastHeartbeat;
	}

	public void setLastHeartbeat(long lastHeartbeat) {
		this.lastHeartbeat = lastHeartbeat;
	}

	public long getHeartbeatVersion() {
		return heartbeatVersion;
	}

	public void setHeartbeatVersion(long heartbeatVersion) {
		this.heartbeatVersion = heartbeatVersion;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public static MachineInfoPO fromMachineInfo(MachineInfo info){
		MachineInfoPO po = new MachineInfoPO();
		po.app = info.getApp();
		po.appType = info.getAppType();
		po.hostname = info.getHostname();
		po.ip = info.getIp();
		po.port = info.getPort();
		po.lastHeartbeat = info.getLastHeartbeat();
		po.heartbeatVersion = info.getHeartbeatVersion();
		po.gmtCreate = new Date();
		return po;
	}

	
}
