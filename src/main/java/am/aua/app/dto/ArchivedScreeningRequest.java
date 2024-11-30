package am.aua.app.dto;

import am.aua.app.entity.Screening;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArchivedScreeningRequest {

    private Screening screening;
    private Instant archivedAt;
}
