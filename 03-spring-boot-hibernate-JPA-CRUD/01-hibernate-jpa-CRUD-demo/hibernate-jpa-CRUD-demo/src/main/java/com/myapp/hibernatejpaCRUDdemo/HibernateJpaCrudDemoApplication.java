package com.myapp.hibernatejpaCRUDdemo;

import com.myapp.hibernatejpaCRUDdemo.dao.BasicDAO;
import com.myapp.hibernatejpaCRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateJpaCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BasicDAO studentDAO) {
		return runner -> {
			//<First of all we need to create the Student object. We create method just for easy following.>
			//<This is example for creating ONE entity/object.>
			//createStudent(studentDAO);

			//<This is example for creating MANY entities.>
			//createMultipleStudents(studentDAO);

			//<This is example for finding ONE entity/object.>
			//readStudent(studentDAO);

			//<This is example for finding MULTIPLE entities/objects.>
			readMultipleStudents(studentDAO);

			//<This is example for finding MULTIPLE entities/objects by lastName>
			//findStudentsByLastName(studentDAO);

			//<This is example for updating ONE entity/object in hte Database>
			//updateStudent(studentDAO);

			//<This is example for deleting entities/objects in hte Database by firstName>
			//deleteStudentsByFirstName(studentDAO);

			//<This is example for deleting entities/objects in hte Database by ID>
			//deleteStudentById(studentDAO);

			//<This is example for deleting ALL entities/objects in hte Database by firstName>
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(BasicDAO studentDAO) {
		//First of all, we need to show whole list of Students in the Database.
		System.out.println("Whole list of Students in the Database...");
		List<Student> studentList = studentDAO.findAll();
		for (Student student : studentList) {
			System.out.println(student);
		}

		//Then delete ALL Students in the Database.
		System.out.println("Delete ALL Students in the Database...");
		int numberOfDeletedRows = studentDAO.deleteAll();

		//Finally, we need to show whole updated list of Students in the Database.
		System.out.println("Number of deleted rows: " + numberOfDeletedRows);
	}

	private void deleteStudentById(BasicDAO studentDAO) {
		//First of all, we need to show whole list of Students in the Database.
		System.out.println("Whole list of Students in the Database...");
		List<Student> studentList = studentDAO.findAll();
		for (Student student : studentList) {
			System.out.println(student);
		}

		//Then delete Student in the Database by ID.
		System.out.println("Delete student in the Database by ID...");
		studentDAO.deleteById(2);

		//After deleting, we need to show whole updated list of Students in the Database.
		System.out.println("Whole updated list of Students in the Database...");
		studentList = studentDAO.findAll();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}


	private void deleteStudentsByFirstName (BasicDAO studentDAO){
			//First of all, we need to show whole list of Students in the Database.
			System.out.println("Whole list of Students in the Database...");
			List<Student> studentList = studentDAO.findAll();
			for (Student student : studentList) {
				System.out.println(student);
			}

			//Next, we need to delete Students in the Database by firstName.
			//As an example firstName will be "F".
			System.out.println("Deleting Students in the Database by firstName...");
			studentDAO.deleteByFirstName("F");

			//After deleting, we need to show whole updated list of Students in the Database.
			System.out.println("Whole updated list of Students in the Database...");
			studentList = studentDAO.findAll();
			for (Student student : studentList) {
				System.out.println(student);
			}
		}

		private void updateStudent (BasicDAO studentDAO){
			//First of all, we need to find entity/object in the Database for the future update.
			System.out.println("Searching for the Student object to update with ID of 1...");
			Student student = (Student) studentDAO.findById(1);

			//We get the Entity in the Database with ID of 1;
			//Just make an Email random generated.
			System.out.println("Student found : " + student);
			System.out.println("Updating the Student object...");
			int randomMailNumber = (int) (Math.random() * 100);
			student.setEmail(randomMailNumber + "@gmail.com");

			//Now Email is changed, and we can update Student object as Entity in the Database.
			studentDAO.update(student);
			System.out.println("Updated student is: " + student);
		}

		private void findStudentsByLastName (BasicDAO studentDAO){

			//find all Students in the Database by last Name.
			System.out.println("Finding all saved students in Database by last Name...");
			List<Student> studentList = studentDAO.findByLastName("D");
			for (Student foundStudent : studentList) {
				System.out.println(foundStudent);
			}
		}

		private void readMultipleStudents (BasicDAO studentDAO){
			//find all Students in the Database.
			System.out.println("Finding all saved students in Database...");
			List<Student> studentList = studentDAO.findAll();
			for (Student foundStudent : studentList) {
				System.out.println(foundStudent);
			}
		}

		private void readStudent (BasicDAO studentDAO){
			//Creating the Student object, just for sure, if no Student objects in the DataBase
			System.out.println("creating the Student object...");
			Student student = new Student("Margarita", "Ostrovskaia", "margarita@example.com");

			//Saving the Student object.
			System.out.println("Saving new student object...");
			studentDAO.save(student);

			//Display ID of the saved Student object.
			int savedID = student.getId();
			System.out.println("Student saved, ID: " + savedID);

			//Finding the Student object.
			System.out.println("Finding the Student object with ID of " + savedID);
			Student foundStudent = (Student) studentDAO.findById(savedID);
			System.out.println(foundStudent);
		}

	//Created method for many Students.
	private void createMultipleStudents(BasicDAO studentDAO) {
		//create multiple Students.
		System.out.println("creating many students...");
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("A", "A", "A@example.com"));
		studentList.add(new Student("B", "B", "B@example.com"));
		studentList.add(new Student("C", "C", "C@example.com"));

		//save these Students.
		System.out.println("Saving all students...");
		studentDAO.saveAll(studentList);

		//get ID for all students.
		System.out.println("Getting ID of all students...");
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	//Created method for the Student object.
	private void createStudent(BasicDAO studentDAO) {
		//Creating the Student object.
		System.out.println("creating the Student object...");
		Student student = new Student("Margarita", "Ostrovskaia", "margarita@example.com");

		//Save the Student object.
		System.out.println("Saving new student object...");
		studentDAO.save(student);

		//Display ID of the saved Student object.
		System.out.println("Student saved, ID: " + student.getId());
	}
}
