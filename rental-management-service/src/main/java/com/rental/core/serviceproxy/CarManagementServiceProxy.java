package com.rental.core.serviceproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rental.core.model.CarProxy;

//@FeignClient(name = "car-management-service", url = "localhost:8100/car-service")
@FeignClient(name = "car-management-service")
@RibbonClient(name = "car-management-service")
public interface CarManagementServiceProxy {
	@GetMapping(path = "/car-service/getCarInfo/{Id}")
	public CarProxy getCarDetails(@PathVariable("Id") Long Id);
}
