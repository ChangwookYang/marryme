FROM openjdk:17
ARG JAR_FILE=build/libs/marryme.jar
COPY ${JAR_FILE} ./marryme.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "./marryme.jar"]