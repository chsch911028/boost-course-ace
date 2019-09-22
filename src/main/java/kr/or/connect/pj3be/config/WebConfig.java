package kr.or.connect.pj3be.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages = "kr.or.connect.pj3be", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private static final Integer ONE_HOUR_CACHE_PERIOD = 3600;

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        viewResolverRegistry.jsp("/WEB-INF/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/htmls/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
        registry.addResourceHandler("/template/**").addResourceLocations("/WEB-INF/template/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
        registry.addResourceHandler("/lib/**").addResourceLocations("/WEB-INF/lib/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
        registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/font/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);

        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
        registry.addResourceHandler("/img_map/**").addResourceLocations("/WEB-INF/img_map/").setCachePeriod(ONE_HOUR_CACHE_PERIOD);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(("/**")).allowedOrigins("*").allowCredentials(false).maxAge(ONE_HOUR_CACHE_PERIOD);
    }
}
