package am.aua.app.service;

import am.aua.app.dto.ArchivedScreeningRequest;
import am.aua.app.entity.ArchivedScreening;
import am.aua.app.exception.ArchivedScreeningNotFoundException;
import am.aua.app.repository.ArchivedScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArchivedScreeningService {

    private final ArchivedScreeningRepository archivedScreeningRepository;

    public List<ArchivedScreening> findAllArchivedScreenings () {
        return archivedScreeningRepository.findAll();
    }

    public ArchivedScreening getArchivedScreeningById (Integer archivedScreeningId){
        return archivedScreeningRepository.findArchivedScreeningById(archivedScreeningId).orElseThrow(() ->
                new ArchivedScreeningNotFoundException("Archived Screening not found")
        );
    }

    public ArchivedScreening createArchivedScreening (ArchivedScreeningRequest archivedScreeningRequest) {
        var savedArchivedScreening = archivedScreeningRepository.save(
                ArchivedScreening.builder()
                        .screening(archivedScreeningRequest.getScreening())
                        .archivedAt(archivedScreeningRequest.getArchivedAt())
                        .build()
        );
        return savedArchivedScreening;
    }

    public ArchivedScreening findArchivedScreeningById(Integer id) {
        return  archivedScreeningRepository.findArchivedScreeningById(id).orElseThrow(() ->
                new ArchivedScreeningNotFoundException("No Archived Screening found")
        );
    }

    public void deleteArchivedScreeningById (Integer id) {
        ArchivedScreening archivedScreening = archivedScreeningRepository.findArchivedScreeningById(id).orElseThrow(() ->
                new ArchivedScreeningNotFoundException("Archived Screening not found!")
        );
        archivedScreeningRepository.deleteById(id);
    }
}
