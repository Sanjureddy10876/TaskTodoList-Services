# TaskTodoList-Services

This is the backend for the TaskTodo Management application, built using spring boot

Features
-Create, update, delete tasks  
-Mark tasks as completed  
-Swagger API documentation  

Technologies i have used to write services
Spring boot
i have used Spring data Jpa for database operation
i have used MySQL for database.
i have imported swagger dependency in pom.xml for Swagger api documentation

-- integartion steps
i have create entity package and in that i have created entity class i have defined values which are needed and written getters and setters methods 
i have created service layer and writen what are needed methods for the requirement and last i have created controller class and i have written all the
needed methods like post,get etc and for security layer i have added Securityconfig class and every api will pass from it if we give access from here this class.
and for checking api's are working or not i have used postman tool.

after writing all services then i have implemented swagger and from http://localhost:8080/swagger-ui/index.html#/ : here i used to take api's and integrated in frontedn.
