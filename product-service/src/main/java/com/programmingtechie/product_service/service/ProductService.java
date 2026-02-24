// Elservice layer gowaha el buisness logic bta3 el project , elhagat el elproject by3mlha bzbt
// decouples controller from the repository , hya el bttklm m3 el repo wt2olha eh el yt3ml fel Db , cntrlr->service->repos
// Service connects between the controler that handles the Http and the repos that handles db



package com.programmingtechie.product_service.service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.model.Product;
import com.programmingtechie.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
/* annotation defines that this class is a buisness service component
lma bn attatch el annotation di bel class kda bn3arrafo k spring bean that is controlled by spring and stored inside the Spring Container
Spring Container-> memory box holds all managed objects by Spring (beans)
whowa da el inversion of control en spring hya el btcontrol object creation and its life cycle

* */
@Slf4j//Simple Logging Facade for java
/*
lombok annotation  btsa3ed yaany zy msdg btaaked b3d el process ma btkhls fel logging

  */
public class ProductService {
    private final ProductRepository productrepository;
    // private 3shan mfish ay class tany y access 3leha gher product service
    // final y3ny once enny 3mlt lel object initialize fel constructor m2drsh aghyro w da tbaan mohemm 3shan el repository mttghyrsh f ay waat l enha lazm tkon consistent
    //this is called Injection: eni bzwd el class bel objects el hya mhtagaha 3shan tsa3dha
    // already ana 3ndy producrepository bean fa b inject it to Product service (DI)
    // whya kda dependency 3shan product service depends on product repos
    // bean life cycle: when app starts it creates prodrepos bean and prodservice bean , Spring sees that serv needs repos , it injects repos into service, and stores service inside container


public void createproduct(ProductRequest productRequest){
    Product product = Product.builder()
            .name(productRequest.getName())
            .price(productRequest.getPrice())
            .description(productRequest.getDescription())
            .build();
    // this is called mapping, bawageh eldata el gatly fmkan mo3yn eni ahotha f fields el product el hyt3mlo create
    //productrequest -> Api layer object
    // product -> da el hyt7att fel db f3ln

Product savedproduct= productrepository.save(product);//-> inserts this product in MongoDb ,if Id exists ->updates, if not creates a new document;

log.info("product {}  saved successfully",savedproduct.getId());
}

    public List<ProductResponse> getAllProducts() {
List<Product> products = productrepository.findAll();// find all di function calls mongo db and gets all product documents that returns List of product

products.stream().map(this::mapToProductResponse).toList();
// Convers each product-> product Response by the map func
return products.stream().map(this::mapToProductResponse).toList();
// returns list of productresponse objs el hya el controller hyhawwelha l json aslun

}

    private ProductResponse mapToProductResponse(Product product) {
    // helper function that converts from product to productresponse by taking the required atts from product and put it in the new created productresponse

return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .description(product.getDescription())
        .build();

}
}
