package com.heima.media.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.common.media.constans.WmMediaConstans;
import com.heima.media.service.StatisticsService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.mappers.wemedia.WmFansPortraitMapper;
import com.heima.model.mappers.wemedia.WmNewsStatisticsMapper;
import com.heima.model.mappers.wemedia.WmUserMapper;
import com.heima.model.media.dtos.StatisticDto;
import com.heima.model.media.dtos.WmFansPortraitDto;
import com.heima.model.media.pojos.WmFansPortrait;
import com.heima.model.media.pojos.WmNewsStatistics;
import com.heima.model.media.pojos.WmUser;
import com.heima.utils.common.BurstUtils;
import com.heima.utils.threadlocal.WmThreadLocalUtils;
import org.apache.lucene.search.WildcardQuery;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    WmUserMapper wmUserMapper;

    @Autowired
    WmNewsStatisticsMapper wmNewsStatisticsMapper;

    @Autowired
    WmFansPortraitMapper wmFansPortraitMapper;

    @Override
    public ResponseResult findWmNewsStatistics(StatisticDto dto) {
        if (dto == null && dto.getType() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        if (WmMediaConstans.WM_NEWS_STATISTIC_CUR != dto.getType() && (dto.getStime() == null || dto.getEtime() == null)) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //查询用户
        WmUser user = WmThreadLocalUtils.getUser();
        WmUser wmUser = wmUserMapper.selectById(user.getId());
        String burst = BurstUtils.groudOne(wmUser.getApUserId());
        List<WmNewsStatistics> list = wmNewsStatisticsMapper.findByTimeAndUserId(burst, wmUser.getApUserId(), dto);
        return ResponseResult.okResult(list);
    }

    @Override
    public ResponseResult<WmFansPortrait> findWmFansPortraitList(WmFansPortraitDto wmFansPortraitDto) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Page page = new Page(wmFansPortraitDto.getPage(), wmFansPortraitDto.getPage());
        Page wmFansPortraitsPage = wmFansPortraitMapper.selectPage(page, queryWrapper);
        return ResponseResult.okResult(wmFansPortraitsPage.getRecords());
    }
}
