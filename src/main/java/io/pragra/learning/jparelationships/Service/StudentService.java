package io.pragra.learning.jparelationships.Service;

import io.pragra.learning.jparelationships.entities.ReviewPK;
import io.pragra.learning.jparelationships.entities.Reviews;
import io.pragra.learning.jparelationships.entities.Student;
import io.pragra.learning.jparelationships.entities.StudentPermit;
import io.pragra.learning.jparelationships.repo.ReviewRepo;
import io.pragra.learning.jparelationships.repo.StudentPermitRepo;
import io.pragra.learning.jparelationships.repo.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo repo;
    private final StudentPermitRepo studentPermitRepo;
    private final ReviewRepo reviewRepo;


    @Transactional
    public Student createStudent(Student student){
        student.getReviewsList().stream().forEach(reviewRepo::save);
        return this.repo.save(student);

    }


    public Student updateStudent(Student student){
        Optional<Reviews> byId = reviewRepo.findById(new ReviewPK(1, 2));
        byId.get().setProgramName("How are you");
        reviewRepo.save(byId.get());
        return repo.save(student);
    }
    public Student findById(Integer id){



        return repo.findById(id).get();
    }

    public boolean deleteStudent(Integer id){
        Optional<Student> byId = repo.findById(id);
        if(byId.isPresent()){
            repo.delete(byId.get());
            return true;
        }
        return false;
    }
/**  @Transactional
    public void runCode(){
        StudentPermit p = StudentPermit.builder().permitName("Work Permit").build();
        Student student = Student.builder().name("Lovepreet").FunnyName("Labhi").permit(p).build();

        System.out.println(studentPermitRepo.save(p));
        System.out.println(repo.save(student));
        Optional<Student> byId = repo.findById(2);
        byId.ifPresent(System.out::println);
        byId.map(s->s.getPermit()).ifPresent(System.out::println);
    }**/
}
