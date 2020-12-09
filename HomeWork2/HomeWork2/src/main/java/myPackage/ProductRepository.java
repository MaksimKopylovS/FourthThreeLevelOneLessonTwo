package myPackage;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(scopeName = "singleton")
public class ProductRepository implements ProductRep {

    private List<Product> product;

    @PostConstruct
    public void init(){
        product = new ArrayList<>();
        product.add(new Product(1, "Kartoshka", 111));
        product.add(new Product(2, "Ogurchiki", 222));
        product.add(new Product(3, "Pomidorki", 333));
        product.add(new Product(4, "Arbuz", 444));
        product.add(new Product(5, "Ananas", 555));
    }

    public List<Product> getProduct(){
        return Collections.unmodifiableList(product);
    }

    public Product getProduct(int id){
        for (Product product : product){
            if (id == product.getId())
                return product;
        }
        return null;
    }
}
