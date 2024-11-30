package am.aua.app.entity;

import am.aua.app.entity.enums.MessageType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @ColumnDefault("nextval('notifications_notification_id_seq'::regclass)")
    @Column(name = "notification_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "text_message", nullable = false, length = Integer.MAX_VALUE)
    private String textMessage;

    @Column(name = "sent_at", nullable = false)
    private Instant sentAt;

    @Column(name = "message_type", columnDefinition = "message_type not null")
    @Enumerated(EnumType.STRING)
    private MessageType messageType;
}