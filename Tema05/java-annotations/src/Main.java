public class Main {

    public static void main(String[] args) {
        Cat firstCat = new Cat();
        firstCat.setAge(2);
        firstCat.setName("Kat");

        System.out.println("firstCat: " + firstCat);

        Cat secondCat = new Cat("Tom", 10);
        System.out.println("secondCat: " + secondCat);

        Cat similarFirstCat = new Cat("Kat", 2);
        System.out.println("similarFirstCat: " + similarFirstCat);
        System.out.println("Are these cats equal [firstCat, similarFirstCat]? " + firstCat.equals(similarFirstCat));
        boolean result = firstCat == similarFirstCat;
        System.out.println("What about == equal? " + result);
    }
}
