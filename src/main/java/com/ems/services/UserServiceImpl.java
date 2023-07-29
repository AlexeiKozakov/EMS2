package com.ems.services;

import com.ems.domain.UserRole;
import com.ems.domain.User;
import com.ems.dto.UserSignUpDto;
import com.ems.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Component

public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;


    @Override
    public UserSignUpDto saveNew(UserSignUpDto userSignUpDto) {
       // UserRole userRole;


     //   User user = userRepo.findByEmail(userSignUpDto.getEmail());
       // if (user == null) {
         //   if (userSignUpDto.is {
           //     userRole = roleRepository.findByName(UserRoles.EMPLOYEE.name());
           // } else {
          //      userRole = roleRepository.findByName(UserRoles.STUDENT.name());
         //   }



    //    }
        return null;
    }

    @Override
    public UserSignUpDto findUserByEmail(String email) {
        return null;
    }
}
