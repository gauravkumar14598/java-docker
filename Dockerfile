FROM amazoncorretto:17

WORKDIR /app

# COPY . .

RUN javac SplitTree.java

CMD ["java", "SplitTree"]