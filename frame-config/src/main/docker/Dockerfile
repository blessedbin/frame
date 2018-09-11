FROM registry.cn-hangzhou.aliyuncs.com/aliware2018/debian-jdk8:latest
# 创建数据卷挂载点
VOLUME /tmp
ADD frame-config-server.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 7001
ENTRYPOINT ["java","-jar","/app.jar"]