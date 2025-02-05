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
        return studentOptional.get();
    }

    public List<Student> getAllStudent(){
        List<Student>studentList=studentRepository.findAll();
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
            student.setDepartmet(studentRequestDto.getDepartment());
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
}
