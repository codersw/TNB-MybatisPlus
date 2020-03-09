# 基于jdk8镜像
FROM java:8
# 将本地文件夹挂在到当前容器
VOLUME /tmp/require
# 复制文件到容器
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
RUN bash -c 'touch app.jar'
ENV JAVA_OPTS ""
# 声明需要暴露的端口
EXPOSE 8080
# 配置容器启动后执行的命令
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=prod -Dfile.encoding=utf-8 -Djava.security.egd=file:/dev/./urandom -jar app.jar"]
