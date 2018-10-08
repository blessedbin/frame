FROM registry.cn-hangzhou.aliyuncs.com/aliware2018/debian-jdk8:latest
ADD frame-auth.jar app.jar
#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=dev"]
EXPOSE 8082