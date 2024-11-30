package am.aua.app.repository;

import am.aua.app.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Optional<Reservation> findReservationById (Integer id);
    Reservation save(Reservation reservation);
}
