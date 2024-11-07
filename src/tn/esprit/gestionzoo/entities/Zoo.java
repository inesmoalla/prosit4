package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages = 25;
    private int animalCount;

    public Zoo(String name, String city) {
        setName(name); // Utilisation du setter pour vérifier le nom
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    // Setter pour le nom avec vérification
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Le nom du zoo ne peut pas être vide. Nom défini par défaut.");
            this.name = "Zoo par défaut";
        } else {
            this.name = name;
        }
    }

    // Méthode pour ajouter un animal avec vérification si le zoo est plein
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter de nouveaux animaux.");
            return false;
        }

        if (searchAnimal(animal.getName()) != -1) {
            System.out.println("Cet animal existe déjà dans le zoo.");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Les animaux du zoo " + name + " :");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    private int searchAnimal(String name) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal.getName());
        if (index == -1) {
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) {
            return z1;
        } else if (z1.animalCount < z2.animalCount) {
            return z2;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                ", animalCount=" + animalCount +
                '}';
    }
}
