package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_hardware")
    private Boolean isHardware;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIsHardware() {
		return isHardware;
	}

	public void setIsHardware(Boolean isHardware) {
		this.isHardware = isHardware;
	}


}
