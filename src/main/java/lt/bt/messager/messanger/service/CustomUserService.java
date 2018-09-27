package lt.bt.messager.messanger.service;


import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.Authority;
import lt.bt.messager.messanger.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lt.bt.messager.messanger.repository.UserReposiory;

import java.util.Set;

@Service
public class CustomUserService implements UserDetailsService {



    @Autowired
    private UserReposiory repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }


        Set<Authority> authorities = user.getRoles().iterator().next().getAuthorities();



        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), true, true, true,
                true, user.getRoles().iterator().next().getAuthorities());
    }
}
