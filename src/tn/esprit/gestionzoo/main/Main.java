package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {
        // Création des zoos
        Zoo zoo1 = new Zoo("Safari Park", "Paris");
        Zoo zoo2 = new Zoo("Jungle Park", "Lyon");

        // Création des animaux
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 4, true);
        Animal giraffe = new Animal("Giraffidae", "Melman", 7, false);
        Animal elephant = new Animal("Elephantidae", "Dumbo", 10, false);

        // Ajout d'animaux aux zoos
        zoo1.addAnimal(lion);
        zoo1.addAnimal(tiger);
        zoo1.addAnimal(giraffe);

        zoo2.addAnimal(elephant);

        // Affichage des animaux de chaque zoo
        zoo1.displayAnimals();
        zoo2.displayAnimals();

        // Suppression d'un animal
        zoo1.removeAnimal(tiger);
        zoo1.displayAnimals();

        // Vérification si le zoo 1 est plein
        System.out.println("Le zoo 1 est plein ? " + zoo1.isZooFull());

        // Comparaison des zoos pour voir lequel a le plus d'animaux
        Zoo biggerZoo = Zoo.comparerZoo(zoo1, zoo2);
        if (biggerZoo != null) {
            System.out.println("Le zoo avec le plus d'animaux est : " + biggerZoo.getName());
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux.");
        }
    }
}
