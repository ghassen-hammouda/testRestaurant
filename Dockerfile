FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/testRestaurant-1.0.jar testRestaurant-1.0.jar
ENTRYPOINT ["java","-jar","/testRestaurant-1.0.jar"]
