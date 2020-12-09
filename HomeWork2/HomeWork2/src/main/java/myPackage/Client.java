package myPackage;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Magazin.class);
        Cart cart = context.getBean("cart", Cart.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);


        System.out.println("Список товаров: ");
        for (Product product : productRepository.getProduct()){
            System.out.println(product.toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите add ID, чтобы добавть в корзину. " + "\n"
                            +"del ID, для удаления." + "\n"
                            +"show для отображения товара в корзине." + "\n"
                            +"exit для выхода.");
        while (true) {
            String comand = scanner.nextLine();


            if (comand.startsWith("add")){
                String mass[] = comand.split(" ",2);
                cart.addProduct(Integer.parseInt(mass[1]));
            }
            if(comand.startsWith("del")){
                String mass[] = comand.split(" ", 2);
                cart.delProduct(Integer.parseInt(mass[1]));
            }
            if(comand.startsWith("show")){
                cart.getProduct();
            }
            if(comand.equals("exit")){
                break;
            }
        }

    }
}
