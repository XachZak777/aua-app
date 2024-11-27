package am.aua.app.dto;

import am.aua.app.entity.AuthorRoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {

    private String authorFirstName;
    private String authorLastName;
    private String biography;
    private AuthorRoleType authorRole;

}
