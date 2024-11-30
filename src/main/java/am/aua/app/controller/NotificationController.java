package am.aua.app.controller;

import am.aua.app.dto.MovieHallRequest;
import am.aua.app.dto.NotificationRequest;
import am.aua.app.entity.MovieHall;
import am.aua.app.entity.Notification;
import am.aua.app.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/all")
    public ResponseEntity<List<Notification>> findAllNotifications() {
        return ResponseEntity.ok(notificationService.findAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> findNotificationById(Integer id) {
        return ResponseEntity.ok(notificationService.findNotificationById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createNotification(@RequestBody NotificationRequest notificationRequest) {
        return ResponseEntity.ok(notificationService.createNotification(notificationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable("id") Integer id) {
        notificationService.deleteNotificationById(id);
        return ResponseEntity.ok(String.format("Notification with %s id is not found", id));
    }
}