package ksh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Configuration
public class KshDozerConfig {

	@Bean
	public Mapper getMapper() {
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		return mapper;
	}

}
