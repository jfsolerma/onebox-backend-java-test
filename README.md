# onebox-backend-java-test
One Box Technical Backend Test

Springboot REST-API for shop management -Feature Cart Management

For deploy use Java 17 or 19 (Maven)

SWAGGER URL (Testing)
http://localhost:8080/shop/swagger-ui/#/cart-controller

Interface:

http://localhost:8080/shop/swagger-ui/#/cart-controller/createCustomerUsingPOST

Params: 
  addProductToCart:
        {
          ID, [Products]
        }
  newCart:
        {
          ID, [Products]
        }

http://localhost:8080/shop/swagger-ui/#/cart-controller/getCustomerUsingGET
Params: ID


http://localhost:8080/shop/swagger-ui/#/cart-controller/deleteCustomerUsingDELETE
Params: ID
