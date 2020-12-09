package myPackage;

import java.util.List;

public interface ProductRep {
    List<Product> getProduct();
    Product getProduct(int id);
}