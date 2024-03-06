package com.camargo;

import java.util.*;
import java.util.stream.Collectors;

public class Driver {

    public static void main(String[] args) {
        /*var p1 = new Person(18, "Andre");
        var p2 = new Person(25, "Bianca");

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);

        Collections.sort(persons);

        System.out.println(persons);*/

        /*String aula1 = "Modelando a classe Aula";
        String aula2 = "Conhecendo mais de listas";
        String aula3 = "Trabalhando com Cursos e Sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);

        Collections.sort(aulas);
        System.out.println("Depois de ordenado:");
        System.out.println(aulas);*/

        var defaultPerson = new Person(0, "Ninguem");

        var mapPersons = new HashMap<Integer, Person>();

        mapPersons.put(1, new Person(21, "Jorge"));
        mapPersons.put(2, new Person(54, "Sandra"));
        mapPersons.put(2, new Person(54, "Tulio"));

        System.out.println(mapPersons.keySet());
        System.out.println(mapPersons.values());
        System.out.println(mapPersons.entrySet());

        System.out.println(mapPersons.getOrDefault(4, defaultPerson));

        mapPersons.replaceAll((key, oldPerson) ->
            new Person(oldPerson.age + 10, oldPerson.name + " Santos"));

        System.out.println(mapPersons.entrySet());

        List<Person> listOfPersons = Arrays.asList(
                new Person(12, "Leticia"),
                new Person(18, "Pedro"),
                new Person(25, "Ana"));

       List<Person> listPersonsAbove18 = listOfPersons
               .stream()
               .filter(person -> person.age >= 18 )
               .collect(Collectors.toList());

        System.out.println("\n\n");
        System.out.println(listPersonsAbove18);

        System.out.println("\n\n");
        listPersonsAbove18.forEach(System.out::println);

    }

}

class Person implements Comparable<Person>{
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
       return this.name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
