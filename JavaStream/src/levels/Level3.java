package levels;

import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
        String names = teachers.stream().map(teacher -> teacher.getName().toUpperCase()).reduce((name1, name2) -> name1 + "#" + name2).orElse("");

        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream().filter(teacher -> "Java".equals(teacher.getSubject()) && teacher.getSalary() > 80000).collect(Collectors.toSet());

        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream().collect(Collectors.toCollection(() ->new TreeSet<>(Comparator.comparing(Teacher::getName).thenComparing(Teacher::getSalary))));

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Integer, List<Teacher>> map = teachers.stream().collect(Collectors.groupingBy(Teacher::getModule));

        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream().collect(Collectors.toMap(Teacher::getSalary,Teacher::getName,(name1, name2) -> name1 + ", " + name2));

        /* TO DO 6: Afficher les nom des enseignants de chaque module */
        map.forEach((subject, teacherList) -> {
            System.out.println("Subject: " + subject);
            teacherList.forEach(teacher -> System.out.println(teacher.getName()));
        });

    }
}
