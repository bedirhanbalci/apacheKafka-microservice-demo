package com.demo.userservice.service;

import com.demo.userservice.config.producer.KafkaProducer;
import com.demo.userservice.config.properties.UserCreatedTopicProperties;
import com.demo.userservice.dto.UserCreateRequest;
import com.demo.userservice.dto.UserCreatedPayload;
import com.demo.userservice.entity.User;
import com.demo.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.kafka.support.KafkaHeaders.KEY;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final KafkaProducer kafkaProducer;

    private final UserCreatedTopicProperties userCreatedTopicProperties;


    public User create(UserCreateRequest userCreateRequest) {
        User user = User.getUser(userCreateRequest);
        User savedUser = userRepository.save(user);

        UserCreatedPayload payload = UserCreatedPayload.GetUserCreatedPayload(savedUser, userCreateRequest.getAddressText());

        Map<String, Object> headers = new HashMap<>();
        headers.put(TOPIC, userCreatedTopicProperties.getTopicName());
        headers.put(KEY, savedUser.getId().toString());

        kafkaProducer.sendMessage(new GenericMessage<>(payload, headers));
        return savedUser;
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return null;
        }
        return userOptional.get();

    }
}
