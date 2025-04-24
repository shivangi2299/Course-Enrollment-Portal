package com.CourseManagementSystem.myappvs.rentals;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "Inventory")
@Data
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
    private Long resourceId;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

    @Column(name = "type", nullable = false)
    private String type;  // E.g., laptop, projector

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "max_quantity", nullable = false)
    private int maxQuantity;

    @Column(name = "available_quantity", nullable = false)
    private int availableQuantity;

    @OneToMany(mappedBy = "equipment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rental> rentals;
}