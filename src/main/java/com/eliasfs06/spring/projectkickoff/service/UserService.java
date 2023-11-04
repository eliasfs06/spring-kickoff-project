package com.eliasfs06.spring.projectkickoff.service;

import com.eliasfs06.spring.projectkickoff.model.Person;
import com.eliasfs06.spring.projectkickoff.model.User;
import com.eliasfs06.spring.projectkickoff.model.UserRole;
import com.eliasfs06.spring.projectkickoff.model.dto.RegisterDTO;
import com.eliasfs06.spring.projectkickoff.repository.GenericRepository;
import com.eliasfs06.spring.projectkickoff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User>{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonService personService;

    public UserService() {}

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void registerUser(RegisterDTO registerData){
        Person person = registerData.toPerson();
        User user = registerData.toUser();
        user.setPerson(person);
        encodePassword(user);

        if(user.getUserRole() == null)
            user.setUserRole(UserRole.USER);

        personService.save(person);
        save(user);
    }

    public void encodePassword(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    }

}
