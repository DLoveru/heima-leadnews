package com.heima.common.zookeeper.sequence;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZkSequence {

    RetryPolicy retryPolicy = new ExponentialBackoffRetry(500, 3);

    DistributedAtomicLong distAtomicLong;
    DistributedAtomicInteger distributedAtomicInteger;

    public ZkSequence(CuratorFramework client, String counterPath) {
        this.distAtomicLong = distAtomicLong = new DistributedAtomicLong(client, counterPath, retryPolicy);
        this.distributedAtomicInteger = distributedAtomicInteger = new DistributedAtomicInteger(client, counterPath, retryPolicy);
    }

    /**
     * 生成序列
     *
     * @return
     * @throws Exception
     */
    public Long sequence() throws Exception {
        AtomicValue<Long> increment = distAtomicLong.increment();
        if (increment.succeeded()) {
            return increment.postValue();
        } else {
            return null;
        }
    }

    /**
     * 生成序列
     *
     * @return
     * @throws Exception
     */
    public Integer sequenceById() throws Exception {
        AtomicValue<Integer> increment = distributedAtomicInteger.increment();
        if (increment.succeeded()) {
            return increment.postValue();
        } else {
            return null;
        }
    }
}
