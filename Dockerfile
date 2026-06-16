# Multi-stage build for the Spring Boot backend. Targets Java 25 (matches pom.xml).
# Note: the local transformers embedding model (~90MB ONNX) is fetched on first use,
# so the running container needs outbound internet on first startup.
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY . .
RUN mvn -q -B -DskipTests package

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Heap is sized as a % of the *container* limit (set mem_limit in compose), not the host's RAM.
# 60% (not 75%) because the ONNX/DJL embedding runtime uses significant OFF-HEAP native memory on
# top of the heap; the remaining ~40% covers native, metaspace, thread stacks, direct buffers and
# code cache. Overriding heap? Set JAVA_OPTS. `exec` keeps java as PID 1 so it gets SIGTERM for
# graceful shutdown.
ENV JAVA_OPTS="-XX:MaxRAMPercentage=60 -XX:InitialRAMPercentage=40"
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]
