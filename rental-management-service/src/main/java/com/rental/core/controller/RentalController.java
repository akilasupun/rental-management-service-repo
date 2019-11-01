package com.rental.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.core.model.CarProxy;
import com.rental.core.model.Rent;
import com.rental.core.service.RentalService;
import com.rental.core.serviceproxy.CarManagementServiceProxy;

@RestController
@RequestMapping("/rental-service")
public class RentalController {
	@Autowired
	RentalService service;
	@Autowired
	CarManagementServiceProxy proxy;

	@PostMapping(path = "/newRent")
	public Rent addNewRent(@RequestBody Rent newRent) {
		if (newRent.getRentId() != null)
			newRent.setRentId(null);
		return service.addNewRent(newRent);
	}

	@GetMapping(path = "/getRentDetails/{Id}")
	public Rent getRentDetails(@PathVariable Long Id) {
		return service.getRentInfo(Id);
	}

	@PutMapping(path = "/updateRentDetails")
	public Rent updateRent(@RequestBody Rent updatedRent) {
		return service.updateRentInfo(updatedRent);
	}

	@DeleteMapping(path = "/removeRentDetials/{Id}")
	public void removeRent(@PathVariable Long Id) {
		service.removeRentInfo(Id);
	}

	@GetMapping(path = "/getCarFeign/{Id}")
	public ResponseEntity<CarProxy> getCarDetails(@PathVariable Long Id) {
		CarProxy carProxy = proxy.getCarDetails(Id);

		return ResponseEntity.status(HttpStatus.OK).body(carProxy);
	}
}
