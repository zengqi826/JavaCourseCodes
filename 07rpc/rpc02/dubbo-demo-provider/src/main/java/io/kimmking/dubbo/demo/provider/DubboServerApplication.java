package io.kimmking.dubbo.demo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.dromara.hmily.spring.annotation.RefererAnnotationBeanPostProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableDubbo
@SpringBootApplication
@MapperScan("io.kimmking.dubbo.demo.provider.mapper")
public class DubboServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboServerApplication.class, args);
	}

	@Bean
	public BeanPostProcessor refererAnnotationBeanPostProcessor() {
		return new RefererAnnotationBeanPostProcessor();
	}
}
