package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置viewController，为视图提供便捷的路径映射(不用创建Controller)
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //柱状图
        //http://localhost:8090/bar/demo1
        //registry.addViewController("/bar/demo1").setViewName("/bar/bar-demo-1");

        //折线图
        //http://localhost:8090/line/demo1
        registry.addViewController("/line/demo1").setViewName("line/line-demo-1");
        //http://localhost:8090/line/demo2
        registry.addViewController("/line/demo2").setViewName("line/line-demo-2");

        //饼图
        //http://localhost:8090/pie/demo1
        registry.addViewController("/pie/demo1").setViewName("pie/pie-demo-1");

        //仪表盘
        //http://localhost:8090/gauge/demo1
        registry.addViewController("/gauge/demo1").setViewName("gauge/gauge-demo-1");
        //http://localhost:8090/gauge/demo2
        registry.addViewController("/gauge/demo2").setViewName("gauge/gauge-demo-2");

        //日历
        //http://localhost:8090/calendar/demo1
        registry.addViewController("/calendar/demo1").setViewName("calendar/calendar-demo-1");
        //http://localhost:8090/calendar/demo2
        registry.addViewController("/calendar/demo2").setViewName("calendar/calendar-demo-2");

        //雷达图
        //http://localhost:8090/radar/demo1
        registry.addViewController("/radar/demo1").setViewName("radar/radar-demo-1");
    }

}

