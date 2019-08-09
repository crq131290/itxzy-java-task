package com.crq.jdbc;

import java.util.List;

public interface UserDao {
    public void add(User u);
    public void update(User u);
    public void delete(int id);
    public User getUserById(int id);
    public List<User> query();

    //CRUD


}
