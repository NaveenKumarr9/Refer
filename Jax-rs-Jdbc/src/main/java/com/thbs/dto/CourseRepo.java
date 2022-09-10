package com.thbs.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.thbs.model.Course;

public class CourseRepo {
	Connection con = null;

	public CourseRepo() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1/rest", "root", "root");
		} catch (Exception e) {

			System.out.println(e);
		}

	}

	public List<Course> getAll() {
		List<Course> courses = new ArrayList<>();
		String sql = "Select * from course;";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Course c = new Course();

				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setDuration(rs.getInt(3));
				c.setFee(rs.getDouble(4));

				courses.add(c);
			}
		} catch (SQLException e) {

			System.out.println(e);
		}

		return courses;
	}

	public Course getId(int id) {
		String sql = "select * from course where id= " + id;
		Course c = new Course();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setDuration(rs.getInt(3));
				c.setFee(rs.getDouble(4));

			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return c;

	}

	public Course create(Course course) {
		String sql = "insert into course values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, course.getId());
			ps.setString(2, course.getName());
			ps.setInt(3, course.getDuration());
			ps.setDouble(4, course.getFee());
			ps.executeQuery();
		} catch (SQLException e) {

			System.out.println(e);
		}
		return course;
	}

	public void update(Course course) {
		String sql = " UPDATE course  SET name = ?,  duration = ?, fee=? WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setInt(2, course.getDuration());
			ps.setDouble(3, course.getFee());
			ps.setInt(4, course.getId());
			ps.executeUpdate();
		} catch (SQLException e) {

			System.out.println(e);
		}

	}

	public void delete(int id) {
		String sql = "delete from course" + " WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
