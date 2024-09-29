public class Cat implements IAnimal{

    private String animalName;

    public Cat() {

    }

    public Cat(String animalName) {
        this.animalName = animalName;
    }
    @Override
    public String makeSound() {
        return "Hi, I'm a cat!";
    }

    public String getAnimalName() {
        return animalName;
    }

}
