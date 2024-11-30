package am.aua.app.service;

import am.aua.app.dto.ReservationRequest;
import am.aua.app.entity.Reservation;
import am.aua.app.exception.ReservationNotFoundException;
import am.aua.app.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> findAllReservations () {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById (Integer reservationId){
        return reservationRepository.findReservationById(reservationId).orElseThrow(() ->
                new ReservationNotFoundException("Reservation not found")
        );
    }

    public Reservation createReservation (ReservationRequest reservationRequest) {
        var savedReservation = reservationRepository.save(
                Reservation.builder()
                        .screening(reservationRequest.getScreening())
                        .customer(reservationRequest.getCustomer())
                        .seatNumber(reservationRequest.getSeatNumber())
                        .reservationTime(reservationRequest.getReservationTime())
                        .status(reservationRequest.getStatus())
                        .paymentStatus(reservationRequest.getPaymentStatus())
                        .build()
        );
        return savedReservation;
    }

    public Reservation findReservationById(Integer id) {
        return  reservationRepository.findReservationById(id).orElseThrow(() ->
                new ReservationNotFoundException("No Reservation found")
        );
    }

    public void deleteReservationById (Integer id) {
        Reservation reservation = reservationRepository.findReservationById(id).orElseThrow(() ->
                new ReservationNotFoundException("Reservation not found!")
        );
        reservationRepository.deleteById(id);
    }
}
