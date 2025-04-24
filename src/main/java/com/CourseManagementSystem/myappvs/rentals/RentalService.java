package com.CourseManagementSystem.myappvs.rentals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private static final Logger logger = LoggerFactory.getLogger(RentalService.class);

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Transactional
    public String rentEquipment(String userEmail, Long equipmentId, LocalDate rentalDate, LocalDate returnDate) {
        logger.info("Received rent equipment request: userEmail: {}, equipmentId: {}, rentalDate: {}, returnDate: {}", userEmail, equipmentId, rentalDate, returnDate);
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        if (optionalEquipment.isPresent()) {
            Equipment equipment = optionalEquipment.get();

            // Check if user already rented this equipment
            boolean alreadyRented = rentalRepository.existsByUserEmailAndEquipmentAndReturnDateAfter(userEmail, equipment, LocalDate.now());
            if (alreadyRented) {
                return "You have already rented this equipment.";
            }

            // Check availability
            if (equipment.getAvailableQuantity() > 0) {
                equipment.setAvailableQuantity(equipment.getAvailableQuantity() - 1);
                equipmentRepository.save(equipment);

                Rental rental = new Rental();
                rental.setEquipment(equipment);
                rental.setUserEmail(userEmail);
                rental.setRentalDate(rentalDate);
                rental.setReturnDate(returnDate);
                rentalRepository.save(rental);
                logger.info("Rental successful for user: {}, equipmentId: {}", userEmail, equipmentId);
                return "Rental successful!";
            } else {
                logger.warn("Exceeded limit for rental of item");
                return "No equipment available!";
            }
        } else {
            logger.warn("Equipment not found");
            return "Equipment not found!";
        }
    }

    public List<Rental> getUserRentals(String userEmail) {
        logger.info("Received request to get user rentals for user: {}", userEmail);
        return rentalRepository.findByUserEmail(userEmail);
    }

    public void deleteRentalById(Long id) {
        logger.info("Received request to delete rental with id: {}", id);
        rentalRepository.deleteById(id);
    }

    public List<Rental> findAllRentals() {
        logger.info("Received request to get all rentals for specific user");
        return rentalRepository.findAll();
    }
}





