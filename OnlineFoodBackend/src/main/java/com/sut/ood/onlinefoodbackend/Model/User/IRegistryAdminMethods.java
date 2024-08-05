package com.sut.ood.onlinefoodbackend.Model.User;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;

import java.util.List;

public interface IRegistryAdminMethods {
    Response acceptUser(User user);
    Response declineUser(User user);
    List<User> watchAllUsers();
    List<User> watchAllInactiveUsers();
    List<User> watchAllActiveUsers();
    User watchUserInformation(Long id);
}
