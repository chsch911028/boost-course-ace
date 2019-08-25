package kr.or.connect.pj3be.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages = "kr.or.connect.pj3be", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        viewResolverRegistry.jsp("/WEB-INF/",".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/htmls/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/font/").setCachePeriod(31556926);

        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/img_map/**").addResourceLocations("/img_map/").setCachePeriod(31556926);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(("/**"))
                .allowedOrigins("*")
                .allowCredentials(false)
                .maxAge(3600);
    }
}

