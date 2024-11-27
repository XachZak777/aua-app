package am.aua.app.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passkey;
    private LocalDate createdAt;
    private Boolean isActive = false;
    private Object status;

}
