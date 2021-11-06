package me.lym.myspace.core.uims.service;

import me.lym.myspace.core.uims.dao.UserDao;
import me.lym.myspace.core.uims.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.queryByUsername(username);
        user.setEnabled(true);
        user.setAccountNotExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNotLocked(true);
        return user;
    }


    public void createUser(User user) {
        if (user.getPassword() == null) {
            user.setPassword("hello");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.newUser(user);
    }


    public void updateUser(User user) {
        userDao.updateByUsername(user);
    }


    public void deleteUser(String userId) {
        userDao.deleteById(userId);
    }

    public void changePassword(String username,String oldPassword, String newPassword) {
        newPassword = passwordEncoder.encode(newPassword);
        userDao.changePassword(username, oldPassword, newPassword);
    }


    public boolean userExists(String username) {
        return userDao.userExists(username);
    }

    public List<User> queryWithPage(Integer limit, Integer offset) {
        return userDao.queryWithPage(limit,offset);
    }

    public User queryById(String id) {
        return userDao.queryById(id);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    public List<User> queryByGroupId(String id) {
        return userDao.queryByGroupId(id);
    }
}
