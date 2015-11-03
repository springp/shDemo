package com.iboss;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * 
 * @author pankaj.patel
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan({ "com.iboss.*" })
@PropertySource(value = { "classpath:configuration.properties" })
@Import(DatabaseConfiguration.class)
public class IBossApplication extends WebMvcConfigurerAdapter implements BeanPostProcessor{

	private static final Logger LOGGER = Logger.getLogger(IBossApplication.class);

	/**
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOGGER.info("Configure static resource location");
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		LOGGER.info("Configure view controllers");
		registry.addViewController("/").setViewName("/login");
	}
	
	/**
	 * Configure MessageSource to lookup any validation/error message in
	 * internationalized property files
	 */
	@Bean
	public MessageSource messageSource() {
		LOGGER.info("Configure view message source");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	
	/**
	 * Configure ViewResolvers to deliver preferred views.
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		LOGGER.info("Configure Internal view resolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * <code>Resolves views selected for rendering by @Controllers to tiles resources in the Apache TilesConfigurer bean</code>
	 */
	@Bean
	public UrlBasedViewResolver getUrlBasedViewResolver() {
		LOGGER.info("Configure Tiles view resolver");
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setViewClass(TilesView.class);
		return urlBasedViewResolver;
	}

	/**
	 * <code>Configures Apache tiles definitions bean used by Apache TilesViewResolver to resolve views selected for rendering by @Controllers</code>
	 */
	@Bean
	public TilesConfigurer getTilesConfigurer() {
		LOGGER.info("Configure Tiles configurer");
		
		// Add apache tiles definitions
		TilesConfiguration.addDefinitions();

		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setCheckRefresh(true);
		tilesConfigurer.setDefinitionsFactoryClass(TilesConfiguration.class);

		return tilesConfigurer;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	/**
	 * Method used to set application initial configurations.
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);		
		return bean;
	}	
	
	
}
