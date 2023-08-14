FROM gradle:jdk17-alpine
RUN mkdir /home/app
COPY . /home/app

WORKDIR /home/app

RUN ./gradlew build

WORKDIR /home/app/build/libs

ENTRYPOINT java -jar Prueba-Coppel-0.0.1-SNAPSHOT.jar