package org.example.schoool;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void save(@RequestBody School school) {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.getAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
    }
}
