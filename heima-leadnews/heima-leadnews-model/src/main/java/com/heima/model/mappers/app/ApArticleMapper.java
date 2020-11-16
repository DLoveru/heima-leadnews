package com.heima.model.mappers.app;

import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApArticleMapper {
    List<ApArticle> loadArticleListByLocation(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);

    List<ApArticle> loadArticleListByIdList(List<ApUserArticleList> list);

    ApArticle selectById(Long id);

    void insert(ApArticle apArticle);

    List<ApArticle> loadLastArticleForHot(String lastDay);

    /**
     * 更新文章数
     * @param articleId
     * @param viewCount
     * @param collectCount
     * @param commontCount
     * @param likeCount
     * @return
     */
    int updateArticleView(@Param("articleId") Integer articleId, @Param("viewCount") long viewCount,@Param("collectCount") long collectCount,@Param("commontCount") long commontCount,@Param("likeCount") long likeCount);

}
