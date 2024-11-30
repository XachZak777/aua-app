package am.aua.app.dto;

import am.aua.app.entity.Customer;
import am.aua.app.entity.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    private Customer customer;
    private String textMessage;
    private Instant sentAt;
    private MessageType messageType;

}
