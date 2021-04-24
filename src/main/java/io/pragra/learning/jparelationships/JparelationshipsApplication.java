package io.pragra.learning.jparelationships;

import io.pragra.learning.jparelationships.Service.StudentService;
import io.pragra.learning.jparelationships.entities.ReviewPK;
import io.pragra.learning.jparelationships.entities.Reviews;
import io.pragra.learning.jparelationships.entities.Student;
import io.pragra.learning.jparelationships.entities.StudentPermit;
import io.pragra.learning.jparelationships.repo.StudentPermitRepo;
import io.pragra.learning.jparelationships.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

@SpringBootApplication
public class JparelationshipsApplication {

    @Autowired
    private StudentService service;
    public static void main(String[] args) {SpringApplication.run(JparelationshipsApplication.class, args); }

    @Bean
    CommandLineRunner runner(){
        return args-> {
            StudentPermit permit = StudentPermit.builder().permitName("Permanent Resident").build();
            Student student= Student.builder().name("Lovepreet Singh").permit(permit).build();
            service.createStudent(student);
            service.createStudent(Student.builder()
                    .name("Gagandeep")
                    .permit(StudentPermit.builder().permitName("Work Permit").build())
                    .reviewsList(Arrays.asList(
                            Reviews.builder().reviewPK(new ReviewPK(81,92)).programName("Java").reviewText("Excellent").build(),
                            Reviews.builder().reviewPK(new ReviewPK(90,78)).programName("Qa").reviewText("Extra Better").build()
                    ))
                    .build());
            service.createStudent(Student.builder()
                    .name("Raminder")
                    .permit(StudentPermit.builder().permitName("Work Permit2").build())
                    .reviewsList(Arrays.asList(
                            Reviews.builder().reviewPK(new ReviewPK(15,27)).programName("Elite").reviewText("Great").build(),
                            Reviews.builder().reviewPK(new ReviewPK(11,62)).programName("C++").reviewText("Better").build()
                    ))
                    .build());
            service.createStudent(Student.builder()
                    .name("Bikram")
                    .permit(StudentPermit.builder().permitName("Work Permit6").build())
                    .reviewsList(Arrays.asList(
                            Reviews.builder().reviewPK(new ReviewPK(1,2)).programName("Inter").reviewText("Excellent").build(),
                            Reviews.builder().reviewPK(new ReviewPK(3,4)).programName("FA").reviewText("Extra Better").build()
                    ))
                    .build());
            Student byId = service.findById(3);
            try{
            byId.getPermit().setPermitName("adsjhjcadbhjhdmcjhghjgjgfneruhjkkjfjskjnkesgkjhjnmkacnjcsanbdjacjnj");
            byId.setName("You");
            service.updateStudent(byId);}
            catch (Exception ex){

            }

        };
    }
}
