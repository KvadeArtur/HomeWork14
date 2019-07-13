package com.kvart;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Дз14
        Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
        - название курса
        - дата старта занятий
        - суммарное количество занятий
        - количество занятий в неделю
        - список учащихся типа Person

        Написать методы:
        - метод который выдает название группы на основе даты старта и названия курса
        - метод который выдает дату старта последней недели курса
        - печатает список студентов с порядковыми номерами
        - добавить студента
        - узнать если ли студент с такой фамилией в группе
        - удалить студента по фамилии или по номеру

        1.2* У студента есть список групп в которых он учится.
        При добавлении студента в группу у него прописывается эта группа в списке.
         */

        Group group = new Group("Intro Java", "22.05.2019", 16, 2);

        System.out.println("Название группы: " + group.nameGroup());

        System.out.println("Начало последней учебной недели: " + group.lastWeek());

        //Список группы
        System.out.println();
        group.getStudentList();

        //Добавить студента
        System.out.println();
        group.addStudent("Дмитрий Карабута");
        group.getStudentList();

        //Проверка присутствия студента
        System.out.println();
        System.out.println(group.presenceStudent("Кваде"));

        //Удаление студента
        System.out.println();
        group.removeStudent("Карабута");
        group.removeStudent(6);
        group.getStudentList();

        //Список груп
        System.out.println();
        List<String> listGroupDmitry = new ArrayList<>();
        listGroupDmitry.add("FrontEnd 16.06.2019");
        listGroupDmitry.add("Python 07.07.2019");

        group.addStudentAndGroup("Дмитрий Карабута", listGroupDmitry);

        group.getStudentList();
        System.out.println("\n" + listGroupDmitry);


    }
}
