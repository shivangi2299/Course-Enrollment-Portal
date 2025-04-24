package com.CourseManagementSystem.myappvs.rentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/rentals")
public class RentalController {
    private static final Logger logger = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent")
    public ResponseEntity<String> rentEquipment(@RequestBody RentalRequest request) {
        logger.info("Received rent equipment request: {}", request);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userEmail = authentication.getName();
            logger.info("User authenticated: {}", userEmail);
            LocalDate rentalDate = LocalDate.parse(request.getRentalDate());
            LocalDate returnDate = LocalDate.parse(request.getReturnDate());
            String message = rentalService.rentEquipment(userEmail, request.getEquipmentId(), rentalDate, returnDate);
            if (message.equals("Rental successful!")) {
                logger.info("Rental successful for user: {}, equipmentId: {}", userEmail, request.getEquipmentId());
                return ResponseEntity.ok().build();
            } else {
                logger.warn("Rental failed for user: {}, equipmentId: {}. Reason: {}", userEmail, request.getEquipmentId(), message);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }
        } else {
            logger.warn("Unauthorized rental attempt.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/userRentals")
    public List<Rental> getUserRentals() {
        logger.info("Received request to get user rentals");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userEmail = authentication.getName();
            logger.info("User authenticated: {}", userEmail);

            return rentalService.getUserRentals(userEmail);
        }
        logger.warn("Unauthorized request to get user rentals");
        return null;
    }

    @DeleteMapping("/deleteRental/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        logger.info("Received request to delete rental with id: {}", id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            rentalService.deleteRentalById(id);
            logger.info("Rental with id: {} deleted successfully", id);

            return ResponseEntity.ok().build();
        } else {
            logger.warn("Unauthorized attempt to delete rental with id: {}", id);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}