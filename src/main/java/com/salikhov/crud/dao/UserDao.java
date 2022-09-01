package com.salikhov.crud.dao;


import com.salikhov.crud.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void deleteUser(Long id);

    void saveOrUpdate(User user);

    List<User> listUsers();

    User getUser(Long id);
}
