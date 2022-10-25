FROM java:8
ADD target/User_authentication-1.0.jar User_authentication.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "User_authentication.jar"]
