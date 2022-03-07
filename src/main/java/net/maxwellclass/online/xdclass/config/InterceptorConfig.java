package net.maxwellclass.online.xdclass.config;
import net.maxwellclass.online.xdclass.interceptor.CorsInterceptor;
import net.maxwellclass.online.xdclass.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 拦截器配置 不⽤权限可以访问url /api/v1/pub/ 要登录可以访问url /api/v1/pri/
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/26 15:06
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 拦截全部路径，这个跨域需要放在最上面
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截哪些目录
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
       WebMvcConfigurer.super.addInterceptors(registry);
    }
}
