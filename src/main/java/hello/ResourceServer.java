package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/user/**")
                .authorizeRequests()
                .antMatchers("/user/user").access("#oauth2.hasScope('user.read')")
                .antMatchers("/user/guest").access("#oauth2.hasScope('guest.read')");
    }
}
