package com.ems.services;

import com.ems.dto.UserSignUpDto;

public interface UserService {


    public UserSignUpDto saveNew(UserSignUpDto userSignUpDto);

    public UserSignUpDto findUserByEmail(String email);


}
