public class Main {

    public static void main(String[] args) {
        Cat firstCat = new Cat();
        firstCat.setAge(2);
        firstCat.setName("Kat");

        System.out.println(firstCat);

        Cat secondCat = new Cat("Tom", 10);
        System.out.println(secondCat);
    }
}
