# -------- BUILDER --------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# 1. Copy only the pom.xml first (to leverage cache)
COPY pom.xml .

# 2. Pre-download dependencies and plugins
RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline -B

# 3. Copy the rest of the project
#COPY src ./src
COPY src /app/src
COPY pom.xml /app


# 4. Build the jar (with cached .m2)
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests

# -------- RUNNER --------
FROM openjdk:21-jdk AS runner

WORKDIR /app

COPY --from=builder /app/target/billing-services-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]
