package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("MY_NEW_APP")
                .secret("{noop}sagar")
                .authorizedGrantTypes("authorization_code", "refresh_token", "client_credentials", "password")
                .scopes("guest.read", "user.read")
                .redirectUris("http://localhost:7070/client/authorized", "http://localhost:7070/client/guest", "http://localhost:7070/client/user");
    }
}
