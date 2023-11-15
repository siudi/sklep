package pl.gornik;

import pl.gornik.model.Book;
import pl.gornik.model.Disc;
import pl.gornik.model.Product;
import pl.gornik.model.Toy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Koszyk {
    public static void main(String[] args) {

        Book book1 = new Book("Pan Tadeusz", 25, 49.0, "Adam Mickiewicz");
        Book book2 = new Book("Zemsta", 8, 30.0, "Aleksander Fredro");
        Book book3 = new Book("Balladyna", 21, 35.0, "Juliusz Słowacki");
        Book book4 = new Book("Quo Vadis", 19, 47.0, "Henryk Sienkiewicz");

        Disc disc1 = new Disc("MTV Unplugged", 10, 39.99, "Lady Pank");
        Disc disc2 = new Disc("Heavy Horses", 14, 60.99, "Jethro Tull");
        Disc disc3 = new Disc("1967-1970 Blue Album", 16, 109.99, "The Beatles");
        Disc disc4 = new Disc("Pride", 20, 22.99, "Garvey Rea");

        Toy toy1 = new Toy("Pajacyk", 20, 9.99, 5);
        Toy toy2 = new Toy("Ukulele", 10, 13.99, 7);
        Toy toy3 = new Toy("Lego", 9, 59.99, 8);
        Toy toy4 = new Toy("Piłka", 15, 5.99, 4);

        List<Product> products = new ArrayList<>();
        products.add(book1);
        products.add(book2);
        products.add(book3);
        products.add(book4);

        products.add(disc1);
        products.add(disc2);
        products.add(disc3);
        products.add(disc4);

        products.add(toy1);
        products.add(toy2);
        products.add(toy3);
        products.add(toy4);

        for (Product element : products) {
            element.displayProduct();
        }

        double shopMoney = 0;
        for (Product element1 : products) {
            shopMoney = element1.countPrice() + shopMoney;
        }
        System.out.println("Wartość sklepu to: " + (int) shopMoney + "zł");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz produkt do koszyka");
        String userProduct = scanner.nextLine();
        System.out.println("Podaj ilosc");
        int userNumberOfProducts = scanner.nextInt();
        scanner.nextLine();


        List<Product> basket = new ArrayList<>();

        for (Product product : products) {
            if (userProduct.equals(product.getTitle())) {
                basket.add(new Product(userProduct, userNumberOfProducts, product.getPrice()));
                product.setQuantity(product.getQuantity() - userNumberOfProducts);
            }
        }

        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product kolejnyElement = itr.next();
            if (kolejnyElement.getQuantity() == 0) {
                itr.remove();
            }
        }

        for (Product element : products) {
            element.displayProduct();
        }


        boolean isNextNumber = true;

        while (isNextNumber) {
            System.out.println("Czy chcesz kontynuowac zakupy? Napisz 'tak', 'nie','koszyk'");
            String nextProduct = scanner.nextLine();
            if (nextProduct.contains("tak")) {

                System.out.println("Podaj kolejny produkt:");
                String userProduct1 = scanner.nextLine();
                System.out.println("Podaj ilosc kolejnego produktu:");
                int userNumberOfProducts1 = scanner.nextInt();
                scanner.nextLine();

                for (Product product : products) {
                    if (userProduct1.equals(product.getTitle())) {
                        basket.add(new Product(userProduct1, userNumberOfProducts1, product.getPrice()));
                        product.setQuantity(product.getQuantity() - userNumberOfProducts1);
                    }
                }


                while (itr.hasNext()) {
                    Product kolejnyElement = itr.next();
                    if (kolejnyElement.getQuantity() == 0) {
                        System.out.println("usun obiekt");
                        itr.remove();
                    }
                }
                System.out.println("test");
                for (Product element : products) {
                    element.displayProduct();
                }


            } else if (nextProduct.contains("koszyk")) {
                double basketMoney = 0;
                System.out.println("Twój koszyk");
                for (Product basketProduct : basket) {
                    basketMoney += basketProduct.countPrice();
                    basketProduct.displayBasketProduct();
                }
                System.out.println("Wartość koszyka: " + (int) basketMoney + "zł");
                System.out.println();

                System.out.println("Czy chcesz złożyc zamówienie? Napisz 'tak' lub 'nie'");
                String userOrder = scanner.nextLine();
                if (userOrder.contains("tak")) {
                    double orderMoney = 0;
                    for (Product basketProduct : basket) {
                        orderMoney += basketProduct.countPrice();
                    }
                    System.out.println("Twoje zamówienie zostało zrealizowane. Cena zamówienia to: " + (int) orderMoney + "zł");
                    break;
                } else System.out.println("Twoje zamówienie nie zostało zrealizowane");


            } else isNextNumber = false;


        }


//        double basketMoney = 0;
//        for(Product basketProduct : basket){
//            basketProduct.displayBasketProduct();
//            basketMoney = basketProduct.countPrice() + basketMoney;
//        }
//        System.out.println("Wartość koszyka: " + (int)basketMoney + "zł");


    }
}
