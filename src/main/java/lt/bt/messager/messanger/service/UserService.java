package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserReposiory userReposiory;

    public void createUser(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getName());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setEnabled(true);
        userEntity.setFirstname("none");
        userEntity.setLastname("none");

        userReposiory.save(userEntity);
    }

    public List<UserEntity> getAll() {
        List<UserEntity> users =(List<UserEntity>) userReposiory.findAll();

        return users;
    }

    public String findUserNameFromId (Long id) {
        UserEntity user = userReposiory.findById(id).get();

        if (user!=null) {
           return user.getUsername();
        }
        return null;
    }

    public Long findIdFromUsername (String name) {

        UserEntity user = userReposiory.findByUsername(name);
        if (user!=null) {
            return user.getUserId();
        }

        return null;

    }


}
