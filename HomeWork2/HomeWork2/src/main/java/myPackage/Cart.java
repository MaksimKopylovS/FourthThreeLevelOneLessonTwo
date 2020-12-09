package myPackage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Cart{

    private ProductRep productRep;
    private ProductRep productClient;

    public Cart(ProductRepository productRepository, ProductClient productClient){
        this.productRep = productRepository;
        this.productClient = productClient;
    }

        public void addProduct(int id){
            if(id < 0 || id > 5){
                System.out.println("Выберите товат от 1 до 5");
                return;
            }
            for (Product product : productRep.getProduct()){
                if(id == product.getId()){
                    productClient.getProduct().add(product);
                    return;
                }
            }
        }

    public void delProduct(int id){
        for (Product product : productRep.getProduct()){
            if(id == product.getId()){
                productClient.getProduct().remove(product);
            }
        }

    }

    public void getProduct(){
        for(Product product : productClient.getProduct()){
            System.out.println(product.toString());
        }
    }
}
