.PHONY: build run clean test

build:
	./mvnw clean package -DskipTests

run:
	./mvnw spring-boot:run

clean:
	./mvnw clean

test:
	./mvnw test
