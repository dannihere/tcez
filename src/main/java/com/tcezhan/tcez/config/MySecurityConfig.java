package com.tcezhan.tcez.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/","/manager").permitAll();
        //全部人可以访问/
        //VIP1能访问level1
        //开启自动配置的登陆功能
        http.formLogin().usernameParameter("user").passwordParameter("password").loginPage("/login");
        //根据请求到userlogin页面
        //http.formLogin();
        //1、/login来到登录页，默认spring Security的登录页面
        //2、重定向到/login？error表示登录失败
        //3、更多详细规则
        //4、默认post形式的/login代表处理登录


        http.csrf().disable();
        //关闭防跨域攻击



        //开启自动配置的注销功能。
        http.logout();
        //1、访问/logout表示用户注销，清空session
        //2、注销成功会返回/login？logout页面
        //http.logout().logoutSuccessUrl("/");//注销成功前往的页面


        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");//remeber：键的name
        //登录成功以后，将cookie发给浏览器保存，以后登录带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //在内存中使用
//        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1","VIP2").and().withUser....;
    }
}
