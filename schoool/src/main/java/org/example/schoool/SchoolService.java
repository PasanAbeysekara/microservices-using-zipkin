package org.example.schoool;

import lombok.RequiredArgsConstructor;
import org.example.schoool.client.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    @Autowired
    private StudentClient client;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(
                School.builder().name("School not found")
                        .email("School not found")
                        .build()
        );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
