package am.aua.app.service;

import am.aua.app.dto.NotificationRequest;
import am.aua.app.entity.Notification;
import am.aua.app.exception.NotificationNotFoundException;
import am.aua.app.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public List<Notification> findAllNotifications () {
        return notificationRepository.findAll();
    }

    public Notification findNotificationById (Integer notificationId) {
        return notificationRepository.findNotificationById(notificationId).orElseThrow(() ->
                new NotificationNotFoundException("Notification not found!")
        );
    }

    public Notification createNotification (NotificationRequest notificationRequest) {
        var savedNotification = notificationRepository.save(
                Notification.builder()
                        .customer(notificationRequest.getCustomer())
                        .textMessage(notificationRequest.getTextMessage())
                        .sentAt(notificationRequest.getSentAt())
                        .messageType(notificationRequest.getMessageType())
                        .build()
        );
        return savedNotification;
    }

    public void deleteNotificationById (Integer id) {
        Notification notification = notificationRepository.findNotificationById(id).orElseThrow(() ->
                new NotificationNotFoundException("Notification not found!")
        );
        notificationRepository.deleteById(id);
    }
}
