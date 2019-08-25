package kr.or.connect.pj3be.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "kr.or.connect.pj3be", excludeFilters = @ComponentScan.Filter(Controller.class))
@Import({DBConfig.class})
public class AppConfig {
}
