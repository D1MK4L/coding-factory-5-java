package gr.aueb.cf.ch20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class main {
//Products array
    private static final List<Product> products = Arrays.asList(
            new Product(1,"Helmet of Endurance",1200,2),
            new Product(2,"Potion of Healing",40,9),
            new Product(3,"Wand of Magic Missiles",140,4),
            new Product(4,"Darts +2",5,200),
            new Product(5,"Scroll of Hold Person",350,4)
    );
//Main
    public static void main(String[] args) {
        for(Product product:products){
            System.out.println(product);
        }

        System.out.println();
        getById(products, 3); //filter by Product id
        System.out.println();
        plentyQuantity(products, 3); // filter what is less than the given quantity
        System.out.println();
        getByPrice(products, 8); //filter by what is less by the given price
        System.out.println();
        //get all the items from the given id and above
        checkAndPrintProducts(products, product -> product.getId() >= 4, System.out::println);
        System.out.println();

        printProducts(getFilteredProduct(products, product -> product.getId()>=3),
                product -> Product.pullProduct(product));
        System.out.println();
        printProducts(getFilteredProduct(products, product -> product.getPrice()>=300),
                product -> Product.pullProduct(product));
        System.out.println();
        printProducts(getFilteredProduct(products, product -> product.getQuantity()>=6),
                product -> Product.pullProduct(product));

    }


//Methods
    public static void printProducts(List<Product> products, Consumer<Product> consumer) {
        for (Product product : products) {
            consumer.accept(product);
        }
    }

    public static List<Product> getFilteredProduct(List<Product> products, Predicate<Product> filter){
        List<Product> filteredProduct =new ArrayList<>();
        for (Product product: products){
            if (filter.test(product)){
                filteredProduct.add(product);
            }
        }
        return filteredProduct;
    }

    public static void getById(List<Product> products,long id){
        for (Product product:products){
            if (product.getId()==id){
                System.out.printf("-This %s is an excellent choice for your Quest\n"+
                        "but we only have %d of those!\n",product.getTitle(),product.getQuantity());
            }
        }
    }

    public static void plentyQuantity(List<Product> products, int quantity){
        for (Product product:products){
            if (product.getQuantity()<=quantity){
                System.out.printf("-We have a full stock of %s\n"+
                                "are you sure you wanna get all %d of them?\n"+
                                "I can fix yah,for the price of %.2f silver coins each!\n",product.getTitle(),
                        product.getQuantity(),product.getPrice());
            }
        }
    }

    public static void getByPrice(List<Product> products, double price){
        for(Product product: products){
            if(product.getPrice()<= price){
                System.out.printf("-Ok! I see you are sort on coins so the only offer\n"+
                        "i can do for ya is this %s for the price of %.2f silver,take it \n"+
                        "while we still got %d of them!\n",product.getTitle(),
                        product.getPrice(),product.getQuantity());
            }
        }
    }

    public static void checkAndPrintProducts(List<Product> products, Predicate<Product> filter, Consumer<Product> consumer) {
        products.forEach(teacher -> {
            if (filter.test(teacher)) {
                consumer.accept(teacher);
            }
        });
    }
}


