namespace java com.dek.thrift

typedef i16 short
typedef i32 int
typedef i64 long


struct Teacher {
    1: optional long id;
    2: optional string name;
    3: optional string profession;
}

exception TeacherException {
    1: optional string message;
    2: optional string callStack;
    3: optional long time;
}

service TeacherService {
    Teacher getByName(1: required string name) throws (1: TeacherException teacherException),
    void save(1: required Teacher teacher) throws (1: TeacherException teacherException)
}