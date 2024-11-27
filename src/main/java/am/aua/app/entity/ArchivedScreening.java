package am.aua.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "archived_screenings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArchivedScreening {
    @Id
    @ColumnDefault("nextval('archived_screenings_archive_id_seq'::regclass)")
    @Column(name = "archive_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_id")
    private Screening screening;

    @Column(name = "archived_at", nullable = false)
    private Instant archivedAt;

}