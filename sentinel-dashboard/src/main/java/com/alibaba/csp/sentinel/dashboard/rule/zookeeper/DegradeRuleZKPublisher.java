package com.alibaba.csp.sentinel.dashboard.rule.zookeeper;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;

@Component("degradeRuleZKPublisher")
public class DegradeRuleZKPublisher implements DynamicRulePublisher<List<DegradeRuleEntity>> {
	@Autowired
    private CuratorFramework zkClient;
    @Autowired
    private Converter<List<DegradeRuleEntity>, String> converter;

    
	@Override
	public void publish(String app, List<DegradeRuleEntity> rules) throws Exception {
		AssertUtil.notEmpty(app, "app name cannot be empty");

        String path = ZookeeperConfigUtil.getDegradeRulePath(app);
        Stat stat = zkClient.checkExists().forPath(path);
        if (stat == null) {
            zkClient.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, null);
        }
        byte[] data = CollectionUtils.isEmpty(rules) ? "[]".getBytes() : converter.convert(rules).getBytes();
        zkClient.setData().forPath(path, data);
		
	}

}
