package com.demo.controller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Cityzen {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    
	    @Column
	    private String name;
	    
	    @Column(name = "vaccine_id")
	    private String vaccineId;
	    
	    // getters and setters
	

	public Cityzen() {
		super();
		// TODO Auto-generated constructor stub
	}

		public Cityzen(int id, String name, String vaccineId) {
			super();
			this.id = id;
			this.name = name;
			this.vaccineId = vaccineId;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVaccineId() {
			return vaccineId;
		}

		public void setVaccineId(String vaccineId) {
			this.vaccineId = vaccineId;
		}
	
	
	

}
