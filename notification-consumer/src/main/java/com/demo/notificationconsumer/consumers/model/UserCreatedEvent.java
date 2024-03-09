package com.demo.notificationconsumer.consumers.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreatedEvent {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean status;

}
