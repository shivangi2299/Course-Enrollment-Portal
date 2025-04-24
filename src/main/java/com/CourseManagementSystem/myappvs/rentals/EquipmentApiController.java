package com.CourseManagementSystem.myappvs.rentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class EquipmentApiController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getInventory() {
        return equipmentService.findAll();
    }
}

