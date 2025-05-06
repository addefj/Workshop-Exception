package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exeption.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List <String> lastNames = null;

        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);


        //non-existing names
        System.out.println("Trying with a non-existing female firstname");
        try {
            nameService.addFemaleFirstName("Ebba");
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("Trying with a non-existing male firstname");
        try {
            nameService.addMaleFirstName("Viggo");
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("Trying with a non-existing lastname");
        try {
            nameService.addLastName("Gustafsson");
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");

        //already existing names
        System.out.println("Trying with an existing female firstname");
        try {
            nameService.addFemaleFirstName("Alice");
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("Trying with an existing male firstname");
        try {
            nameService.addMaleFirstName("Viggo");
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("Trying with an existing lastname");
        try {
            nameService.addLastName("Gustafsson");
        } catch (DuplicateNameException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------");

        System.out.println("Testing to generate random person");
        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

	}

}
