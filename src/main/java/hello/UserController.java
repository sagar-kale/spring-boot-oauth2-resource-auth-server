package hello;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/user")
    public User getUser(Authentication authentication) {
        User user = new User();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            user.setAddress(authentication.getName() + ", You have " + role);
        }
        user.setUid(UUID.randomUUID().toString());
        user.setName("Sagar");
        user.setPwd("password");
        return user;
    }

    @GetMapping("/guest")
    public String guest(Authentication authentication) {
        return authentication.getName() + ", You have " + authentication.getAuthorities().stream().map(o -> ((GrantedAuthority) o).getAuthority()).collect(Collectors.joining());
    }
}
