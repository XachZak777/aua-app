package am.aua.app.controller;

import am.aua.app.dto.ArchivedScreeningRequest;
import am.aua.app.dto.ScreeningRequest;
import am.aua.app.entity.ArchivedScreening;
import am.aua.app.entity.Screening;
import am.aua.app.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/screening")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping("/all")
    public ResponseEntity<List<Screening>> findAllScreenings() {
        return ResponseEntity.ok(screeningService.findAllScreenings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> findScreeningById (@PathVariable Integer id) {
        return ResponseEntity.ok(screeningService.findScreeningById(id));
    }

    @PostMapping()
    public ResponseEntity<Screening> createScreening(@RequestBody ScreeningRequest screeningRequest) {
        return ResponseEntity.ok(screeningService.createScreening(screeningRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreening (@PathVariable("id") Integer id) {
        screeningService.deleteScreeningById(id);
        return ResponseEntity.ok(String.format("Screening with %s id is not found", id));
    }
}
