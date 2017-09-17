package com.springboot.app.configuration;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;


@Configuration
@RestController
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude =
{
  DataSourceAutoConfiguration.class
})
@ComponentScan(basePackages =
{
  "com.springboot.app"
})
@MapperScan(basePackages =
{
  "com.springboot.app.persistence.mappers.mybatis"
})
@PropertySource("classpath:/application/application.properties")
public class AppConfiguration extends WebMvcConfigurerAdapter
{

  private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Environment env;

  @Value("${spring.datasource.driver-class-name}")
  private String DB_DRIVER;

  @Value("${spring.datasource.url}")
  private String DB_URL;

  @Value("${spring.datasource.username}")
  private String DB_USERNAME;

  @Value("${spring.datasource.password}")
  private String DB_PASSWORD;

  @Value("${cofg.dir.resources}")
  private String DIR_RESOURCES;

  @Value("${cofg.dir.webapp}")
  private String DIR_WEBAPP;

  @Value("${cofg.persistence.models}")
  private String PERSISTENCE_MODELS;

  @Value("${cofg.persistence.xml.mybatis}")
  private String PERSISTENCE_IBATIS;


  @Override
  public void configurePathMatch(PathMatchConfigurer configurer)
  {
    configurer.setUseSuffixPatternMatch(false);
  }


  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler(this.DIR_RESOURCES + "**")
            .addResourceLocations("classpath:" + this.DIR_RESOURCES)
            .setCachePeriod(0).
            resourceChain(true)
            .addResolver(new PathResourceResolver());

    registry.addResourceHandler(this.DIR_WEBAPP + "**")
            .addResourceLocations("classpath:" + this.DIR_WEBAPP)
            .setCachePeriod(0).
            resourceChain(true)
            .addResolver(new PathResourceResolver());
  }


  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource)
  {
    return new JdbcTemplate(dataSource);
  }


  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource)
  {
    return new DataSourceTransactionManager(dataSource);
  }


  @Bean
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception
  {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    bean.setDataSource(this.dataSource());
    bean.setTypeAliasesPackage(this.PERSISTENCE_MODELS);
    bean.setMapperLocations(resolver.getResources("classpath*:" + this.PERSISTENCE_IBATIS));

    return bean.getObject();
  }


  private DataSource dataSource()
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName(this.DB_DRIVER);
    dataSource.setUrl(this.DB_URL);
    dataSource.setUsername(this.DB_USERNAME);
    dataSource.setPassword(this.DB_PASSWORD);

    return dataSource;
  }

}
