package com.heima.common.mysql.mybatis;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Jalen.Deng
 * @description mybatisPlus 配置
 * @date 2020/11/30 17:07
 **/
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mysql.core")
@PropertySource("classpath:mysql-core-jdbc.properties")
@MapperScan(basePackages = "com.heima.model.mappers",sqlSessionFactoryRef = "mybatisSqlSessionFactoryBean")
public class MybatisConfig {
    String jdbcUrl;
    String jdbcUserName;
    String jdbcPassword;
    String jdbcDriver;
    String rootMapper;//mapper文件在classpath下存放的根路径
    String aliasesPackage;//

    /**
     * 设置一个数据库的连接池
     */
    @Bean("mysqlCoreDataSource")
    public DataSource mysqlCoreDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(this.getJdbcUserName());
        dataSource.setPassword(this.getRealPassword());
        dataSource.setJdbcUrl(this.getJdbcUrl());
        dataSource.setDriverClassName(this.getJdbcDriver());
        //最大连接数
        dataSource.setMaximumPoolSize(50);
        //最小连接数
        dataSource.setMinimumIdle(5);
        return dataSource;
    }

    /**
     * 密码反转操作
     */
    public String getRealPassword(){
        String jdbcPassword = this.getJdbcPassword();//123456
        String reverse = StringUtils.reverse(jdbcPassword);//654321
        return  reverse;
    }
    /**
     * 整合mybatis-plus
     * @param dataSource mybatisSqlSessionFactoryBean
     * @return
     * @throws IOException
     */
    @Bean("mybatisSqlSessionFactoryBean")
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(@Qualifier("mysqlCoreDataSource") DataSource dataSource) throws IOException{
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(this.getMapperFilePath());
        factoryBean.setMapperLocations(resources);
        //开启驼峰标识  user_name  --  》 userName
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        return factoryBean;
    }
    /**
     * 拼接mapper.xml文件的存储位置
     */
    public String getMapperFilePath(){
        return new StringBuffer("classpath:").append(this.getRootMapper()).append("/**/*.xml").toString();
    }
}
