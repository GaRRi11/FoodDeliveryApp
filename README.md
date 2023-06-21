# Food Delivery App

With that API you can connect user and business to each other. I use Spring security to secure endpoints via jwt token. After authentication user gets jwt token with that token he or she can send requests to API. Data is transferred in JSON format. After registration user can set up his profile: upload his credit card info and address. API also checks if credit card info is valid if it's not then gives an exception. after setting the profile he will be able to choose a product, choose which address and credit card he wants to use, and put the order. API also has an ADMIN role. ADMIN can add products to the products list and modify or delete them. he also can see all the users and their order details. 

# Technologies used

• [Java](https://www.java.com) Java programming language

• Spring Boot: Most famous framework for building server applications on java

• Spring Security: One of the most important part of Spring ecosystem to secure API endpoints

• Spring Data JPA: For mapping Java objects to a relational database and relate models to each other.

• PostgresSQL: Very popular and battle tested Relational type of database

• Hibernate: Most popular JPA implementation. Battle tested framework to work with databases from java.



in API most important part is Spring Data JPA which gave me the opportunity to relate models to each other there is a relationships diagram of those models:


![my diagram](https://github.com/GaRRi11/FoodDeliveryApp/assets/101354276/4bfbe3b9-7da5-482c-93bf-55f458d7cd1c)
