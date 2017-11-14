package com.company.service;

import com.company.domain.Contribution;
import com.company.domain.User;

/**
 * User: Shantanu Roy
 * Date: 29-Oct-17
 * Time: 11:23 PM
 */
public interface UserService {
    Long userSignup(String fullName, String userName, String email);
    void addContribution(Long userId, Contribution contribution);
    void userUpdate(Long userId, String fullName, String userName, String email);
    void userDelete(Long userId);
    User getUserInfo(Long userId);
}