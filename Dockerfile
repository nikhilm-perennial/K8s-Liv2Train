FROM openjdk:8
WORKDIR /usr/app
COPY target/k8s-liv2train.jar /usr/app/
ENTRYPOINT ["java","-jar","k8s-liv2train.jar"]