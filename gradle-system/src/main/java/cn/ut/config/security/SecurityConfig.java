package cn.ut.config.security;

import cn.ut.config.filter.JwtAuthorizationFilter;
import cn.ut.config.filter.RestAuthorizationEntryPoint;
import cn.ut.config.filter.RestfulAccessDeniedHandler;
import cn.ut.entity.SysAdmin;
import cn.ut.service.ISysAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Security配置类
 * @author PuTongjiao
 * @date 2022/7/30 15:35
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private ISysAdminService sysAdminService;

    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            SysAdmin sysAdmin = sysAdminService.getAdminByUsername(username);
            if (null != sysAdmin){
                return sysAdmin;
            }
            return null;
        };
    }

    /**
     * 密码明文加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                //基于token 不需要csrf
                .csrf().disable()
                //基于token 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //设置jwtTokenError处理认证失败 授权失败
                .exceptionHandling().authenticationEntryPoint(restAuthorizationEntryPoint).accessDeniedHandler(restfulAccessDeniedHandler).and()
                .authorizeRequests(authorize -> authorize
                        //请求放开
//                        .antMatchers("/login").permitAll()
//                        .antMatchers("/logout").permitAll()
//                        .antMatchers("/doc.html").permitAll()
//                        .antMatchers("/index.html").permitAll()
//                        .antMatchers("/css/**").permitAll()
//                        .antMatchers("/js/**").permitAll()
//                        .antMatchers("/favicon.ico").permitAll()
//                        .antMatchers("/webjars/**").permitAll()
//                        .antMatchers("/swagger-resources/**").permitAll()
//                        .antMatchers("/v3/api-docs/**").permitAll()
//                        .antMatchers("/**").permitAll()
//                        .antMatchers("/**").permitAll()
                        .antMatchers("/login",
                                "/doc.html",
                                "/index.html",
                                "/css/**",
                                "/js/**",
                                "/favicon.ico",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated())
                //添加jwt过滤器 过滤器在用户名密码过滤认证过滤器之前
                .addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userDetailsService())
                .build();
    }

    /**
     * 配置跨源访问(CORS)
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
