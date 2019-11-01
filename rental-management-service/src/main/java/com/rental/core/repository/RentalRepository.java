package com.rental.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.rental.core.model.Rent;

public interface RentalRepository extends CrudRepository<Rent, Long> {

}
