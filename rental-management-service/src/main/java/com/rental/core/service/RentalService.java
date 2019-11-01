package com.rental.core.service;

import com.rental.core.model.Rent;

public interface RentalService {
	Rent addNewRent(Rent newRent);

	Rent getRentInfo(Long rentId);

	Rent updateRentInfo(Rent updatedRent);

	void removeRentInfo(Long Id);
}
