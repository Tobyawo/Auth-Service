FROM openjdk:17
#EXPOSE 8086
ADD target/auth-service.jar auth-service.jar
ENTRYPOINT [\
"java",\
 "-jar", \
 "/auth-service.jar"\
 ]
