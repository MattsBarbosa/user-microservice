package com.ms.user.services;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;
    final UserModel userModel;

    public UserService(UserRepository userRepository, UserProducer userProducer, UserModel userModel) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
        this.userModel = userModel;
    }

    @Transactional
    public UserModel save(UserRecordDto userRecordDto){
        BeanUtils.copyProperties(userRecordDto, userModel);
        userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
