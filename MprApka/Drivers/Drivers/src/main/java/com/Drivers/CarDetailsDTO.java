package com.Drivers;

import jakarta.persistence.*;

@Entity
public class CarDetailsDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String color;
        private String fuelType;

        @OneToOne(mappedBy = "carDetails")
        private CarDTO carDTO;

        // Getters and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public CarDTO getAuto() {
            return carDTO;
        }

        public void setAuto(CarDTO carDTO) {
            this.carDTO = carDTO;
        }
    }
