package com.rental.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.core.model.Rent;
import com.rental.core.repository.RentalRepository;

@Service
public class RentalServiceImpl implements RentalService {
	@Autowired
	RentalRepository repository;

	@Override
	public Rent addNewRent(Rent newRent) {
		return repository.save(newRent);
	}

	@Override
	public Rent getRentInfo(Long rentId) {
		return repository.findById(rentId).orElse(null);
	}

	@Override
	public Rent updateRentInfo(Rent updatedRent) {
		return repository.save(updatedRent);
	}

	@Override
	public void removeRentInfo(Long Id) {
		repository.deleteById(Id);
	}

}
