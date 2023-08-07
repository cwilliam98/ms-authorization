FROM openjdk:11
RUN mkdir -p /opt/app
WORKDIR /opt/app
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -Pk8s
EXPOSE 8081
ENTRYPOINT ["java","-jar","/opt/app/target/api-gateway.jar"]
