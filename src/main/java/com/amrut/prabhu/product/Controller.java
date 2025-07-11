package com.amrut.prabhu.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.security.RolesAllowed;
import java.security.Principal;


@RestController
public class Controller {

    @GetMapping("/product")
    public String getProducts() {
        return "List of Products";
    }

    @GetMapping("/product/{id}")
    //@RolesAllowed({"product_read"})
    public String getUser(@PathVariable("id") String userId) {
        return "User ID: " + userId;
    }

/*     public String greet() {
        return "Hello, welcome to our API!";
    } */
/*     public String getProduct(Principal principal) {
        return "Response from Product Service, User Id:" + principal.getName();
    } */
/*    public String getUser(@PathVariable("id") String userId) {
        return "User ID: " + userId;
    } */
/*     @GetMapping("/products/{category}/{id}")
    public String getProduct(
        @PathVariable("category") String category, 
        @PathVariable("id") String productId
    ) {
        return "Category: " + category + ", Product ID: " + productId;
    } */

}
