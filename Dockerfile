FROM openjdk:17

WORKDIR /app

COPY target/RoomReservation-0.0.1-SNAPSHOT.jar /app

EXPOSE 8085

CMD ["java", "-jar" , "RoomReservation-0.0.1-SNAPSHOT.jar"]