package am.aua.app.dto;

import am.aua.app.entity.enums.HallFeaturesType;
import am.aua.app.entity.enums.HallStatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieHallRequest {

    private String hallName;
    private Integer capacity;
    private HallStatusType hallStatus;
    private HallFeaturesType features;

}
