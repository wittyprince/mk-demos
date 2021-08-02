package com.mk.demos.mapstruct;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.mk.demos.mapstruct.custom.CustomMapper;
import com.mk.demos.mapstruct.custom.Student;
import com.mk.demos.mapstruct.custom.StudentDto;

/**
 * CustomMapper test
 *
 * @author WangChen
 * Created on 2021/8/2 10:33
 * @since 0.1
 */
public class CustomMapperTest {

    @Test
    public void test1(){
        CustomMapper mapper = CustomMapper.INSTANCE;
        Student student = new Student();
        Date birthDay = new Date(1);
        student.setBirthday(birthDay);
        student.setSchoolTime(LocalDateTime.of(2000, 1, 1, 0, 0, 0));
        student.setGraduationTime(LocalDateTime.of(2003, 1, 1, 0, 0, 0));

        String zoneId = "Asia/Shanghai";
//        String zoneId = "America/Los_Angeles";
        StudentDto studentDto = mapper.toDto(student, zoneId);
        System.out.println(studentDto);
    }
}
