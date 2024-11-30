package am.aua.app.controller;

import am.aua.app.dto.ReservationRequest;
import am.aua.app.entity.Reservation;
import am.aua.app.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> findAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findReservationById (@PathVariable Integer id) {
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest reservationRequest) {
        return ResponseEntity.ok(reservationService.createReservation(reservationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation (@PathVariable("id") Integer id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok(String.format("Reservation with %s id is not found", id));
    }
}