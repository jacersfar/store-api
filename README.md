# store-api
This project is the implementation of the third step (Rest Api for a book store with Spring MVC and JPA: Hibernate) of the practical exercice, realized by JACER SFAR.
# Steps to Run the project
1. Create MySQL Data base
2. Go to WebContent/WEB-INF/main-servlet.xml
3. Search bean configuration in main-servlet.xml file with an ID: dataSource
4. Update the bean with your MySQL configuration (PORT, USERNAME, PASSWORD, DATA BASE NAME).
5. Update Maven dependencies
6. Add maven dependencies to the web deployment properties (Right click on project > Deploymnet Assembly > Add.. > Java Build path entries > Maven dependencies > apply & close)
7. Add Apache tomcat Server (V7.0 adviced)
8. Run on server.
9. Once running Please test it with POSTMAN (be careful with how you formate your Requests body In JSON) and to check routes Check the package org.eclipse.controllers
