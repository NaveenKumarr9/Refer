package com.thbs.service;

import java.util.List;
import com.thbs.dto.CourseRepo;
import com.thbs.model.Course;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("courses")
public class CourseService {

	CourseRepo repo = new CourseRepo();

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAll() {
		return repo.getAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourse(@PathParam("id") int id) {
		return repo.getId(id);

	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Course add(Course course) {
		return repo.create(course);

	}

	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public Course update(Course course) {

		if (repo.getId(course.getId()).getId() == 0) {
			repo.create(course);
		} else {

			repo.update(course);
		}
		return course;
	}

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course delete(@PathParam("id") int id) {
		Course c = repo.getId(id);

		if (c.getId() != 0)
			repo.delete(id);
		return c;

	}

}
