package am.aua.app.controller;

import am.aua.app.dto.StaffRequest;
import am.aua.app.entity.Staff;
import am.aua.app.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> findAllStaffs() {
        return ResponseEntity.ok(staffService.findAllStaffs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> findStaffById (@PathVariable Integer id) {
        return ResponseEntity.ok(staffService.findStaffById(id));
    }

    @PostMapping()
    public ResponseEntity<Staff> createStaff(@RequestBody StaffRequest staffRequest) {
        return ResponseEntity.ok(staffService.createStaff(staffRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff (@PathVariable("id") Integer id) {
        staffService.deleteStaffById(id);
        return ResponseEntity.ok(String.format("Staff with %s id is not found", id));
    }

}
