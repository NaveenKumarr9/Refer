package com.thbs.controller;

import java.util.List;
import com.thbs.model.Country;
import com.thbs.service.CountryService;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/countries")
public class CourseController {

	CountryService countryservice = new CountryService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryservice.getAllCountries();

		return listOfCountries;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id) {
		return countryservice.getCountry(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		return countryservice.addCountry(country);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countryservice.updateCountry(country);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		countryservice.deleteCountry(id);
	}

}
