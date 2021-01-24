package com.example.oskar.universities.datagenerator;

import com.example.oskar.universities.entity.FieldOfStudy;
import com.example.oskar.universities.entity.Grade;
import com.example.oskar.universities.entity.Student;
import com.example.oskar.universities.entity.University;
import com.example.oskar.universities.service.FieldOfStudyService;
import com.example.oskar.universities.service.StudentService;
import com.example.oskar.universities.service.UniversityService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class DataGenerator {

    private final UniversityService universityService;
    private final StudentService studentService;
    private final FieldOfStudyService fieldOfStudyService;

    private List<String> cities;

    private List<String> names;

    private List<String> surnames;

    private List<String> fields;

    private List<String> streets;

    private List<String> uniNameSuffixes;

    private List<String> streetSuffixes;

    List<University> unis;

    Random generator;

    public DataGenerator(UniversityService universityService, StudentService studentService, FieldOfStudyService fieldOfStudyService){
        File citiesFile = new File("src/main/resources/static/uscities.txt");
        cities = importData(citiesFile);

        File namesFile = new File("src/main/resources/static/names.txt");
        names = importData(namesFile);

        File surnamesFile = new File("src/main/resources/static/surnames.txt");
        surnames = importData(surnamesFile);

        File fieldsFile = new File("src/main/resources/static/academicfields.txt");
        fields = importData(fieldsFile);

        File streetsFile = new File("src/main/resources/static/allstreets.txt");
        streets = importData(streetsFile);

        uniNameSuffixes = new ArrayList<>();
        streetSuffixes = new ArrayList<>();

        uniNameSuffixes.add(" University");
        uniNameSuffixes.add(" Institute of Technology");
        uniNameSuffixes.add(" Community College");
        uniNameSuffixes.add(" University of Technology");

        streetSuffixes.add(" Rd. ");
        streetSuffixes.add(" Av.");
        streetSuffixes.add(" St. ");

        unis = new ArrayList<>();

        generator = new Random();
        this.universityService = universityService;
        this.studentService = studentService;
        this.fieldOfStudyService = fieldOfStudyService;
    }

    public void generateData(){
        for(int i=0; i<15; i++){
            University uni = new University();
            String city = cities.get(generator.nextInt(cities.size()));
            String street = streets.get(generator.nextInt(streets.size()));
            uni.setName(city + uniNameSuffixes.get(generator.nextInt(uniNameSuffixes.size())));
            uni.setAddress(street + streetSuffixes.get(generator.nextInt(streetSuffixes.size())) + (generator.nextInt(50)+1) + ", " + city);
            uni.setEmail("contact@" + uni.getName().replace(" ", "").toLowerCase() + ".edu");
            uni.setPhone(getRandomPhone());
            unis.add(uni);
        }

        for(University uni : unis){
            universityService.add(uni);

            List<FieldOfStudy> uniFields = new ArrayList<>();
            List<Student> uniStudents = new ArrayList<>();

            for(int i=0; i<50; i++){
                FieldOfStudy field = new FieldOfStudy();
                field.setNameOfStudyField(fields.get(generator.nextInt(fields.size())));
                field.setStudentsLimit(generator.nextInt(25)+5);
                LocalDate date = LocalDate.of(generator.nextInt(12)+2010, generator.nextInt(2)*7 + 3, 1);
                field.setStartDate(date);
                field.setUniversityId(uni.getId());
                uniFields.add(field);
                fieldOfStudyService.add(field);
            }

            for(int i=0; i<100; i++){
                Student student = new Student();
                student.setFirstName(names.get(generator.nextInt(names.size())));
                student.setLastName(surnames.get(generator.nextInt(surnames.size())));
                student.setEmail(student.getFirstName().toLowerCase()+student.getLastName().toLowerCase() + "@email.com");
                student.setPhone(getRandomPhone());
                student.setAge(generator.nextInt(40)+18);
                if(generator.nextBoolean())
                    student.setGender(Student.Gender.FEMALE);
                else
                    student.setGender(Student.Gender.MALE);

                int rand = generator.nextInt(100);
                if(rand < 75)
                    student.setStudentStatus(Student.StudentStatus.ACTIVE);
                else if(rand < 90)
                    student.setStudentStatus(Student.StudentStatus.INACTIVE);
                else if(rand < 98)
                    student.setStudentStatus(Student.StudentStatus.DEANS_LEAVE);
                else
                    student.setStudentStatus(Student.StudentStatus.SUSPENDED);

                student.setFieldsOfStudy(new ArrayList<>());
                student.setGrades(new ArrayList<>());

                for(int j=0; j< generator.nextInt(15)+10; j++){
                    String fieldId = uniFields.get(generator.nextInt(uniFields.size())).getId();
                    student.getFieldsOfStudy().add(fieldId);
                    student.getGrades().add(new Grade(fieldId, (generator.nextInt(5)+6)*0.5));
                }

                uniStudents.add(student);
                studentService.add(student);
            }

            uni.setFieldsOfStudy(new ArrayList<>());
            uni.setStudentsList(new ArrayList<>());

            for(FieldOfStudy f : uniFields){
                uni.getFieldsOfStudy().add(f.getId());
            }

            for(Student s : uniStudents){
                uni.getStudentsList().add(s.getId());
            }

            universityService.update(uni);
        }
    }

    private List<String> importData(File file) {
        List<String> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                data.add(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String getRandomPhone(){
        Random generator = new Random();

        return "555"+(generator.nextInt(899999)+100000);
    }

}
