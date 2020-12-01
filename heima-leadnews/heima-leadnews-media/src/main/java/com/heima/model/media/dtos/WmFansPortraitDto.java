package com.heima.model.media.dtos;

import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

import java.util.Date;

/**
 * @author Jalen.Deng
 * @description
 * @date 2020/11/27 15:42
 **/
@Data
public class WmFansPortraitDto extends PageRequestDto {
    /**
     * 起始日期
     */
    private Date stime;

    /**
     * 结束日期
     */
    private Date etime;
    /**
     *今日，本周，近7天 近30天;
     */
    private String type;

}
