package com.dek.thrift;

import org.apache.thrift.TException;

public class TeacherServiceImpl implements TeacherService.Iface{

    @Override
    public Teacher getByName(String name) throws TeacherException, TException {
        System.out.println("name: " + name);
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("dek");
        teacher.setProfession("code");
        return teacher;
    }

    @Override
    public void save(Teacher teacher) throws TeacherException, TException {
        System.out.println(teacher.getId());
        System.out.println(teacher.getName());
        System.out.println(teacher.getProfession());
    }
}
