package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample{
    public static void main(String[] args){
        List<Student> students = Arrays.asList(
                new Student("Saathvik", 1234),
                new Student("Vish", 245),
                new Student("Vibha", 321)
        );
        students.sort(Comparator.comparing((Student s) -> s.name));
    }
}

class Student{
    String name;
    int id;
    public Student(String n, int i){
        name = n;
        id = i;
    }
}
