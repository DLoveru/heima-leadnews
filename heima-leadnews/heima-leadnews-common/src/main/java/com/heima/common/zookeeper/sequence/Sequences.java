package com.heima.common.zookeeper.sequence;

import com.heima.common.zookeeper.ZookeeperClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sequences {

    @Autowired
    private ZookeeperClient client;

    public Long sequenceApLikes() {
        return this.client.sequence(ZkSequenceEnum.AP_LIKES);
    }

    public Integer sequenceWmNews() {
        return this.client.sequenceById(ZkSequenceEnum.WM_NEWS);
    }

    public Integer sequenceWmNewsArticle() {
        return this.client.sequenceById(ZkSequenceEnum.WM_NEWS_ARTICLE);
    }

    public Long sequenceApReadBehavior() {
        return this.client.sequence(ZkSequenceEnum.AP_READ_BEHAVIOR);
    }

    public Long sequenceApCollection() {
        return this.client.sequence(ZkSequenceEnum.AP_COLLECTION);
    }

    public Long sequenceApUserFollow() {
        return this.client.sequence(ZkSequenceEnum.AP_USER_FOLLOW);
    }

    public Long sequenceApUserFan() {
        return this.client.sequence(ZkSequenceEnum.AP_USER_FAN);
    }

    public Integer sequenceWmNewsMaterial() {
        return this.client.sequenceById(ZkSequenceEnum.WM_NEWS_MATERIAL);
    }

    public Integer sequenceAdChannel() {
        return this.client.sequenceById(ZkSequenceEnum.AD_CHANNEL);
    }
}
