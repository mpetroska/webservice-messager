package lt.bt.messager.messanger.TestService;

import lt.bt.messager.messanger.entity.MessageEntity;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.UserReposiory;
import lt.bt.messager.messanger.service.MessageService;
import lt.bt.messager.messanger.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMessageService {

    @InjectMocks
    private MessageService messageService;

    @Mock
    UserReposiory userReposiory;

    @Mock
    UserService userService;

    @Test
    public void shouldReturnUser() {
        List <MessageEntity> messages = new ArrayList<>();

        Authentication authentication = new Authentication() {

            @Override
            public String getName() {
                return "kazkas";
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

        };

        SecurityContext securityContext = new SecurityContext() {
            private Authentication authentication;
            @Override
            public Authentication getAuthentication() {
                return null;
            }

            @Override
            public void setAuthentication(Authentication authentication) {

            }
        };

        securityContext.setAuthentication(authentication);

        SecurityContextHolder.setContext(securityContext);



        when(userService.findIdFromUsername("kazkas")).thenReturn(new Long(1));








    }
}
