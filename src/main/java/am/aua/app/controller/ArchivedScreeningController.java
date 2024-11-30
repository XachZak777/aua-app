package am.aua.app.controller;

import am.aua.app.dto.ArchivedScreeningRequest;
import am.aua.app.entity.ArchivedScreening;
import am.aua.app.service.ArchivedScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/archivedScreening")
@RequiredArgsConstructor
public class ArchivedScreeningController {

    private final ArchivedScreeningService archivedScreeningService;

    @GetMapping("/all")
    public ResponseEntity<List<ArchivedScreening>> findAllArchivedScreenings() {
        return ResponseEntity.ok(archivedScreeningService.findAllArchivedScreenings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchivedScreening> findArchivedScreeningById (@PathVariable Integer id) {
        return ResponseEntity.ok(archivedScreeningService.findArchivedScreeningById(id));
    }

    @PostMapping()
    public ResponseEntity<ArchivedScreening> createArchivedScreening(@RequestBody ArchivedScreeningRequest archivedScreeningRequest) {
        return ResponseEntity.ok(archivedScreeningService.createArchivedScreening(archivedScreeningRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArchivedScreening (@PathVariable("id") Integer id) {
        archivedScreeningService.deleteArchivedScreeningById(id);
        return ResponseEntity.ok(String.format("Archived Screening with %s id is not found", id));
    }
}
