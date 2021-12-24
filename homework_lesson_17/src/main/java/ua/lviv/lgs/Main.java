package ua.lviv.lgs;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		
		UniversityService universityService = context.getBean(UniversityService.class);
		

		List<University> universitiesList = new ArrayList<>();
		universitiesList.add(new University("Kyiv National University", 13, 18000, "Kyiv"));
		universitiesList.add(new University("Lviv National University", 12, 16900, "Lviv"));
    	universitiesList.add(new University("Rivne National University", 19, 18000, "Rivne"));
		universitiesList.add(new University("Lutsk National University", 15, 7700, "Lutsk"));
		universitiesList.add(new University("Harkiv National University", 12, 7500, "Harkiv"));
		
     	universityService.createAll(universitiesList);
		
		System.out.println(universityService.findById(1));

		System.out.println(universityService.findByNumberOfStudents(18000));
		
		University university = universityService.findByName("Rivne National University");
		university.setNumberOfFaculties(11);
		universityService.update(university);

		universityService.findAll().stream().forEach(System.out::println);
		
		universityService.deleteById(3);
	}
}
