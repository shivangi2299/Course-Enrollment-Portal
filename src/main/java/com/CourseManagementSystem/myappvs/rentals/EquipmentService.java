package com.CourseManagementSystem.myappvs.rentals;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service
public class EquipmentService {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentService.class);

        @Autowired
        private EquipmentRepository equipmentRepository;

        public List<Equipment> findAll() {
            logger.info("Fetching all equipment");
            return equipmentRepository.findAll();
        }

        public Optional<Equipment> findById(Long id) {
            logger.info("Fetching equipment by id: {}", id);
            return equipmentRepository.findById(id);
        }

        public Equipment save(Equipment equipment) {
            logger.info("Saving equipment: {}", equipment);
            return equipmentRepository.save(equipment);
        }

        public void deleteById(Long id) {
            logger.info("Deleting equipment by id: {}", id);
            equipmentRepository.deleteById(id);
        }
    }
