package am.aua.app.repository;

import am.aua.app.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findNotificationById (Integer id);
    Notification save(Notification notification);
}
