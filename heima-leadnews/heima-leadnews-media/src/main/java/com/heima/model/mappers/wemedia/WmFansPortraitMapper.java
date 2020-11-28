package com.heima.model.mappers.wemedia;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.media.pojos.WmFansPortrait;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/27 15:32
 **/
public interface WmFansPortraitMapper extends BaseMapper<WmFansPortrait> {
    void findAll();
}
