// entry point of Api
// without this class we cannot recieve requests
package com.programmingtechie.product_service.controller;//Http Layer
//controller talks to Service layer
// because controller only handles request and responses mlosh d3wa b ay logic tany

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // annotation comes from the Spring Web dependency
// helps the class to have the feature of handling the Rest Requests
// values returned from Requests are converted to json (lma byrg3 response )
// "Rest" Api building way using Http methods that uses the 4 methods get,post,put,Delete

@RequestMapping("/api/product")// defines the base url for this controller
// means that all methods fel class da htbd2 b /api/product 3shan mttlghbtsh m3 services tanya zy order w user oddam

//that every method will be performed in this path
@RequiredArgsConstructor


public class ProductController {
    private final ProductService productservice;

    @PostMapping //handles the post action request (create) ,annotation helps in creating a new obj
    @ResponseStatus(HttpStatus.CREATED)// when product is succesfully created it returns "201 CREATED" and the default is 200 OK
    public void createProduct(@RequestBody ProductRequest productrequest){
// request body takes the inp in the http request that is Json type and converts it into java obj

// to actually create the product with the data comes from the client
        //we have to create it by communicating with the service layer
        // because Controller layer only handles respones and requests
// the annotation before the parameter type converts the incoming Body of it from Json to java object
        // we have used a productRequest type object instead of a product directly w da 3shan el clean arch est3mlna dto 3shan n expose w nspecify el atts el ehna awzenha bs msh ay haga ttl3 la
productservice.createproduct(productrequest);
    }
@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<ProductResponse> getProducts(){
 return productservice.getAllProducts();
}
}
