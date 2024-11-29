package am.aua.app.dto;

import am.aua.app.entity.enums.StatusType;
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

    private String firstName;
    private String lastName;
    private String email;
    private String passkey;
    private LocalDate createdAt;
    private Boolean isActive = false;
    private StatusType status;

}
