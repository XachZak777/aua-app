package am.aua.app.service;

import am.aua.app.dto.StaffRequest;
import am.aua.app.entity.Staff;
import am.aua.app.exception.StaffNotFoundException;
import am.aua.app.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    public List<Staff> findAllStaffs () {
        return staffRepository.findAll();
    }

    public Staff getStaffById (Integer staffId){
        return staffRepository.findStaffById(staffId).orElseThrow(() ->
                new StaffNotFoundException("Staff not found")
        );
    }

    public Staff createStaff (StaffRequest staffRequest) {
        var savedStaff = staffRepository.save(
                Staff.builder()
                        .user(staffRequest.getUser())
                        .staffPosition(staffRequest.getStaffPosition())
                        .hireDate(staffRequest.getHireDate())
                        .permissions(staffRequest.getPermissions())
                        .build()
        );
        return savedStaff;
    }

    public Staff findStaffById(Integer id) {
        return  staffRepository.findStaffById(id).orElseThrow(() ->
                new StaffNotFoundException("No Staff found")
        );
    }

    public void deleteStaffById (Integer id) {
        Staff staff = staffRepository.findStaffById(id).orElseThrow(() ->
                new StaffNotFoundException("Staff not found!")
        );
        staffRepository.deleteById(id);
    }
}
