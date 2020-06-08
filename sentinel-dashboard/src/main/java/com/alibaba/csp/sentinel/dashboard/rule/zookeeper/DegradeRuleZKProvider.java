package com.alibaba.csp.sentinel.dashboard.rule.zookeeper;

import java.util.ArrayList;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;

@Component("degradeRuleZKProvider")
public class DegradeRuleZKProvider implements DynamicRuleProvider<List<DegradeRuleEntity>> {

	@Autowired
	private CuratorFramework zkClient;
	@Autowired
	private Converter<String, List<DegradeRuleEntity>> converter;

	@Override
	public List<DegradeRuleEntity> getRules(String appName) throws Exception {
		String zkPath = ZookeeperConfigUtil.getDegradeRulePath(appName);
		Stat stat = zkClient.checkExists().forPath(zkPath);
		if (stat == null) {
			return new ArrayList<>(0);
		}
		byte[] bytes = zkClient.getData().forPath(zkPath);
		if (null == bytes || bytes.length == 0) {
			return new ArrayList<>();
		}
		String s = new String(bytes);

		return converter.convert(s);
	}

}
