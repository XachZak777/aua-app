package am.aua.app.dto;

import am.aua.app.entity.User;
import am.aua.app.entity.enums.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private User user;
    private String preferences;
    private MembershipType membershipLevel;

}
