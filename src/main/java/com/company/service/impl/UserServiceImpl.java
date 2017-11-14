package com.company.service.impl;

import com.company.domain.Contribution;
import com.company.domain.User;
import com.company.repository.GenericEntityDao;
import com.company.repository.impl.EntityDaoFileImpl;
import com.company.service.UserService;

import java.io.IOException;

/**
 * User: Shantanu Roy
 * Date: 29-Oct-17
 * Time: 11:28 PM
 */
public class UserServiceImpl implements UserService {

    private GenericEntityDao<User> userEntityDao = new EntityDaoFileImpl<>(User.class);

    public UserServiceImpl() throws IOException {
    }

    @Override
    public Long userSignup(String fullName, String userName, String email) {
        return userEntityDao.create(new User(fullName, userName, email));
    }

    @Override
    public void addContribution(Long userId, Contribution contribution) {
        User contributor = userEntityDao.getById(userId);
        contributor.addContributions(contribution);
        userEntityDao.update(contributor);
    }

    @Override
    public void userUpdate(Long userId, String fullName, String userName, String email) {
        User user = userEntityDao.getById(userId);
        user.setFullName(fullName);
        user.setUserName(userName);
        user.setEmail(email);
        userEntityDao.update(user);
    }

    @Override
    public void userDelete(Long userId) {
        userEntityDao.delete(userEntityDao.getById(userId));
    }

    @Override
    public User getUserInfo(Long userId) {
        return userEntityDao.getById(userId);
    }

}