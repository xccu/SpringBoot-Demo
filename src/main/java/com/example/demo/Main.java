package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
	public static void main(String[] args)  {

		log.info("开始");
		//使用AnnotationConfigApplicationContext实现基于Java的配置类加载Spring的应用上下文
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

	}
}
