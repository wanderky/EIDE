package com.cy.eide.framework.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.nio.charset.Charset;
import java.util.List;


@Configuration//相当于配置文件
@ComponentScan("包名")//配置包扫描(Controller,Repository,service等)
@EnableWebMvc//启用mvc支持 annotation-driven
@MapperScan(value="mapper包名",sqlSessionFactoryRef = "sqlSessionFactory")//mapper扫描器
@EnableTransactionManagement//开启事务
public class SpringmvcConfig extends WebMvcConfigurerAdapter {
    /**
     * jsp视图解析器的bean
     */
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * 配置数据源
     */
    @Bean(name = "dataSource")
    public DriverManagerDataSource getDataSource() {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            //useAffectedRows 可以返回删除更新受影响行数 使用：在mapper里面返回值设置为int而不是void
            dataSource.setUrl("jdbc:mysql://localhost:3306/movies?useAffectedRows=true");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            return dataSource;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 创建事务管理 用来指定数据源
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    /**
     * 配置SqlSessionFactory，给MapperScan调用
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory.getObject();
    }


    /**
     * mvc返回资源编码设置为utf-8
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //在StringHttpMessageConverter构造方法设置utf-8编码
        StringHttpMessageConverter shmc = new StringHttpMessageConverter(Charset.forName("utf-8"));
        converters.add(shmc);
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    /**
     * mvc资源路径配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //后面根据路径自己配置
        registry.addResourceHandler("/**").addResourceLocations("/");
    }


    /**
     * mvc拦截器配置
     */
    //@Override
    //public void addInterceptors(InterceptorRegistry registry) {
//
    //    registry.addInterceptor(new testInterceptors()).addPathPatterns("/home");
    // }

}
