package com.CourseManagementSystem.myappvs.rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CourseManagementSystem.myappvs.rentals.Rental;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUserEmail(String userEmail);
    boolean existsByUserEmailAndEquipmentAndReturnDateAfter(String userEmail, Equipment equipment, LocalDate returnDate);
}
