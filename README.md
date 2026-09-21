#CICD-1 / Lab1 / Order Service

<--Architecture Diagram-->

Browser / Swagger

+ --> Catalog Service: Port 8081 --> temp Product List<>
+ --> Order Service: Port 8082 --> temp order List<>

Seperate GitHub repositorys
Separate open pull requests

<--End-->

Inside the order service, productId refers to the product owned by Catalog but their is no network call that exists yet
