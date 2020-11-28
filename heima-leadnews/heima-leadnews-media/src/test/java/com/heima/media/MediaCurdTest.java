package com.heima.media;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/27 15:37
 **/

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.media.service.StatisticsService;
import com.heima.model.mappers.wemedia.WmFansPortraitMapper;
import com.heima.model.mappers.wemedia.WmUserMapper;
import com.heima.model.media.dtos.WmFansPortraitDto;
import com.heima.model.media.pojos.WmUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MediaJarApplication.class)
@RunWith(SpringRunner.class)
public class MediaCurdTest {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private WmUserMapper wmUserMapper;
    @Autowired
    private WmFansPortraitMapper wmFansPortraitMapper;

    @Test
    public void Test() {
        WmFansPortraitDto wmFansPortraitDto = new WmFansPortraitDto();
        wmFansPortraitDto.setPage(1);
        wmFansPortraitDto.setSize(5);
        WmUser wmUser = wmUserMapper.selectById(1L);
        System.out.println(JSONObject.toJSON(wmUser));
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", 1);
        Page page = new Page(wmFansPortraitDto.getPage(), wmFansPortraitDto.getPage());
        Page wmFansPortraitsPage = wmFansPortraitMapper.selectPage(page, queryWrapper);
        System.out.println(JSONObject.toJSON(wmFansPortraitsPage.getRecords()));

    }
}
