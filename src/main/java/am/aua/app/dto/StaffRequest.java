package am.aua.app.dto;

import am.aua.app.entity.User;
import am.aua.app.entity.enums.StaffPositionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffRequest {

    private User user;
    private LocalDate hireDate;
    private String permissions;
    private StaffPositionType staffPosition;
}
