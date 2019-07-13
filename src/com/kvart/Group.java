package com.kvart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Group {

    private String nameCourse;
    private String startDate;
    private int sumLessons;
    private int lessonsInWeek;
    private List<Persons> studentList;

    {
        studentList = new ArrayList<>();
        Persons persons;
        try (BufferedReader br = new BufferedReader(new FileReader("list.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                persons = new Persons(currentLine);
                studentList.add(persons);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
    }

    public Group(String nameCourse, String startDate, int sumLessons, int lessonsInWeek) {
        this.nameCourse = nameCourse;
        this.startDate = startDate;
        this.sumLessons = sumLessons;
        this.lessonsInWeek = lessonsInWeek;
    }

    public String nameGroup() {
        return nameCourse + " " + startDate;
    }

    public Date lastWeek () {

        int week = sumLessons / lessonsInWeek;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        try {
            date = df.parse(startDate);

        } catch (ParseException e) {
            System.out.println("Неверная дата");
        }

        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, week - 1);

        DateFormat dfWeek = new SimpleDateFormat("EEEE", Locale.US);
        String monday = "Monday";

        String lastDate;
        while (true) {
            lastDate = dfWeek.format(calendar.getTime());
            if (lastDate.equals(monday)) {
                break;
            } else {
                calendar.add(Calendar.DAY_OF_WEEK, -1);
            }
        }

        return calendar.getTime();
    }

    public void getStudentList () {
        String student;
        for (int i = 0; i < studentList.size(); i++) {
            student = ". " + studentList.get(i).toString();
            System.out.println((i + 1) + student);
        }
    }

    public void addStudent (String student) {
        Persons persons = new Persons(student);
        studentList.add(persons);
    }

    public String presenceStudent (String surname) {

        String surnameGroup;
        for (int i = 0; i < studentList.size(); i++) {
            surnameGroup = studentList.get(i).getSurname();
            if (surnameGroup.equals(surname)) {
                return "Такой студент есть";
            }
        }

        return "Такого студента нет";
    }

    public void removeStudent (String surname) {

        String surnameGroup;
        for (int i = 0; i < studentList.size(); i++) {
            surnameGroup = studentList.get(i).getSurname();
            if (surnameGroup.equals(surname)) {
                studentList.remove(i);
            }
        }

    }

    public void removeStudent (int i) {
        studentList.remove(i - 1);

    }

    public void addStudentAndGroup (String student, List group) {
        Persons persons = new Persons(student);
        studentList.add(persons);
        group.add(nameGroup());
    }
}
