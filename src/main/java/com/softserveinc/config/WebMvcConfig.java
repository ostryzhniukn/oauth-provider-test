package com.softserveinc.config;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//import javax.sql.DataSource;
//
@Configuration
//@ComponentScan(basePackages = {"com.softserveinc"})
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
		defaultView.setExtractValueFromSingleKeyModel(true);

		ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
		contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
		contentViewResolver.setViewResolvers(Arrays.<ViewResolver> asList(viewResolver));
		contentViewResolver.setDefaultViews(Arrays.<View> asList(defaultView));
		return contentViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
//
//    //@Configuration
//    @EnableTransactionManagement
//    protected static class Config {
//
////          that's thing that's going wrong: http://stackoverflow.com/questions/8999597/mybatis-spring-configuration-cant-autowire-mapper-beans
////          @MapperScan also fails build, possible cause of jesey depends on spring 3.2.3 (@ImportResource was fixed since 3.2.8)
////          exclusion of dependency also doesn't work
////        @Bean
////        public MapperScannerConfigurer mapperScannerConfigurer(){
////            MapperScannerConfigurer scanner = new MapperScannerConfigurer();
////            scanner.setBasePackage("com.softserveinc.if052_restful.mappers");
////            return scanner;
////        }
//
////        @Bean()
////        public DataSource dataSource() {
////            return new EmbeddedDatabaseBuilder()
////                    .setType(EmbeddedDatabaseType.H2)
////                    .addScript("classpath*:schema.sql")
////                    .addScript("classpath*:test-data.sql")
////                    .build();
////        }
//
//        @Autowired
//        DataSource dataSource;
//
//        @Bean
//        public DataSourceTransactionManager transactionManager(){
//            DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
////            transactionManager.setDataSource(dataSource());
//            transactionManager.setDataSource(dataSource);
//            return transactionManager;
//        }
//
//        private Resource [] mapperLocations = {
//            new ClassPathResource("classpath*:com/softserveinc/if052_restful/mappers/AddressMapper.xml"),
//            new ClassPathResource("classpath*:com/softserveinc/if052_restful/mappers/IndicatorMapper.xml"),
//            new ClassPathResource("classpath*:com/softserveinc/if052_restful/mappers/MeterTypeMapper.xml"),
//            new ClassPathResource("classpath*:com/softserveinc/if052_restful/mappers/ReportMapper.xml"),
//            new ClassPathResource("classpath*:com/softserveinc/if052_restful/mappers/UserMapper.xml"),
//            new ClassPathResource("classpath*:com/softserveinc/if052_restful/mappers/WaterMeterMapper.xml")
//        };
//
//        @Bean
//        public SqlSessionFactoryBean sqlSessionFactoryBean(){
//            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//            //sessionFactory.setDataSource(dataSource());
//            sessionFactory.setDataSource(dataSource);
//            sessionFactory.setTypeAliasesPackage("com.softserveinc.if052_restful.domain");
//            sessionFactory.setMapperLocations(mapperLocations);
//            return sessionFactory;
//        }
//
//        private static Logger logger = Logger.getLogger(WebMvcConfig.Config.class);
//
//        @Bean
//        public SqlSessionTemplate sqlSessionTemplate(){
//            try {
//                SqlSessionFactory sessionFactory = sqlSessionFactoryBean().getObject();
//                SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sessionFactory);
//                return sessionTemplate;
//            } catch (Exception e) {
//                logger.error(e.getStackTrace());
//            }
//            return null;
//        }
//    }
}
