package com.library_management.studentLibraryManagement.service;

import com.library_management.studentLibraryManagement.convertor.StudentConvertor;
import com.library_management.studentLibraryManagement.enums.CardStutus;
import com.library_management.studentLibraryManagement.model.Card;
import com.library_management.studentLibraryManagement.model.Student;
import com.library_management.studentLibraryManagement.repository.StudentRepository;
import com.library_management.studentLibraryManagement.requestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public String saveStudent(StudentRequestDto studentRequestDto){
        Student student= StudentConvertor.convertStudentRequestDtoIntoStudent(studentRequestDto);

        if(student==null){
            throw new RuntimeException("student not be saved");
        }
        Card card=new Card();
        card.setCardStutus(CardStutus.ACTIVE);

        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);

        return "Student has been successfully added";
    }

    //get student by id

    public Student getStudentById(int id){
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(!studentOptional.isPresent()){
            throw new RuntimeException("Student not found with id "+id);
        }
        return studentOptional.get();
    }

    public List<Student> getAllStudent(){
        List<Student>studentList=studentRepository.findAll();
        if (studentList.isEmpty()){
            throw  new RuntimeException("no student in student list");
        }
        return studentList;

    }

    public String updateStudentById(int id,StudentRequestDto studentRequestDto){
        Student student=getStudentById(id);
        if(student!=null){
            student.setName(studentRequestDto.getName());
            student.setEmail(studentRequestDto.getEmail());
            student.setMobile(studentRequestDto.getMobile());
            student.setDob(studentRequestDto.getDob());
            student.setAge(studentRequestDto.getAge());
            student.setSemester(studentRequestDto.getSemester());
            student.setGender(studentRequestDto.getGender());
            student.setDepartment(studentRequestDto.getDepartment());
            studentRepository.save(student);
            return "studnet has been successfully updated";
        }else {
            return "student dod not found";
        }
    }

    public String updateStudentSemester(int id,String semester){
        Student student=getStudentById(id);
        if(student!=null){
            student.setSemester(semester);
            studentRepository.save(student);
            return "Semester has been updated";
        }{
            return "student not found";
        }
    }

    public String deleteStudent(int id){
        Student student=getStudentById(id);
        if(student!=null) {
            studentRepository.deleteById(id);
            return "student has been deleted";
        }else {
            return "student not found";
        }
    }

    public Student findStudentByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student;
    }

    public List<Student> findByDepartment(String department){
        List<Student>studentList=studentRepository.findBydepartment(department);
        return studentList;
    }

    public List<Student> findBySemAndDeprt(String semester,String department){
        List<Student> studentList=studentRepository.findBySemesterAndDepartment(semester,department);
        return studentList;
    }

    public List<Student> findBySemOrEmail(String semester,String department){
        List<Student> studentList=studentRepository.findBySemesterOrDepartment(semester,department);
        return studentList;
    }

    public Student findByQuery(String email){
        Student student=studentRepository.getEmailByQuery(email);
        return student;
    }
}
