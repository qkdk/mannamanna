package com.ssafy.manna.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //https://i9b205.p.ssafy.io/member/img/imgg3.jpg 을 통해 이미지에 접근
        //file:실제 파일 저장 경로/
        //ec2에서 설정을 /home/ubuntu/manna/member/upload
        //이미지 파일 저장된 경로 : 어쩌구/manna/upload/images/member/
        //domain/member/img/+imgname;
        // domain/api/member/img/


        registry.addResourceHandler("/api/user/member/img/**")       //url패턴 설정
                .addResourceLocations("file:/home/ubuntu/manna/upload/images/member/");    //실제 파일 저장 경로
    }
}
