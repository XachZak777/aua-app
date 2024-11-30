package am.aua.app.repository;

import am.aua.app.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findStaffById(Integer id);
    Staff save(Staff staff);
}
