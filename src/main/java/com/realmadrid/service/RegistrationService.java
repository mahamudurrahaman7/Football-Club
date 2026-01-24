package com.realmadrid.service;

import com.realmadrid.model.User;
import com.realmadrid.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleList;

@Service
public class RegistrationService {
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //find with email
    public User findWithEmail(String email) {

        if(userRepository.findByEmail(email).isPresent()){
            return userRepository.findByEmail(email).get();
        }
        return null;
    }

    public boolean isAdmin(User user){

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            User user1 = userRepository.findByEmail(user.getEmail()).get();
            for(String roles: user1.getRoleList()){
                if(roles.equalsIgnoreCase("ROLE_ADMIN")){
                    return true;
                }
            }
        }
        return false;

    }

    public long totalUsers(){
        long a = userRepository.count();
        System.out.println(a);
        return a;
    }


    //For saving user
    public User save(User user){

        //For checking if the email address already have an account
        if(userRepository.findByEmail(user.getEmail() ).isPresent()){
            System.err.println("Email already exists");
            return null;
        }

        return userRepository.save(user);

    }
}
