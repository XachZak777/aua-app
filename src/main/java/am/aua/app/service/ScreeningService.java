package am.aua.app.service;

import am.aua.app.dto.ScreeningRequest;
import am.aua.app.entity.Screening;
import am.aua.app.exception.ScreeningNotFoundException;
import am.aua.app.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    public List<Screening> findAllScreenings () {
        return screeningRepository.findAll();
    }

    public Screening getScreeningById (Integer screeningId){
        return screeningRepository.findScreeningById(screeningId).orElseThrow(() ->
                new ScreeningNotFoundException("Screening not found")
        );
    }

    public Screening createScreening (ScreeningRequest screeningRequest) {
        var savedScreening = screeningRepository.save(
                Screening.builder()
                        .build()
        );
        return savedScreening;
    }

    public Screening findScreeningById(Integer id) {
        return  screeningRepository.findScreeningById(id).orElseThrow(() ->
                new ScreeningNotFoundException("No Screening found")
        );
    }

    public void deleteScreeningById (Integer id) {
        Screening screening = screeningRepository.findScreeningById(id).orElseThrow(() ->
                new ScreeningNotFoundException("Screening not found!")
        );
        screeningRepository.deleteById(id);
    }
}