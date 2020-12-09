package myPackage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class ProductClient implements ProductRep {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProduct() {
        return products;
    }


    @Override
    public Product getProduct(int id) {
        if(id < 0 || id > 5){
            System.out.println("Выберите товат от 1 до 5");
            return null;
        }

        for (Product product : products){
            if (id == product.getId())
                return product;
        }
        return null;
    }
}
