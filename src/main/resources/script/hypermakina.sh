#!/bin/sh
SERVICE_NAME=HyperMakina

SCRIPT_BIN="${BASH_SOURCE-$0}"
SCRIPT_BIN="$(dirname "${SCRIPT_BIN}")"
SCRIPT_HOME="$(cd "${SCRIPT_BIN}/.."; pwd)"
LIB_PATH=$SCRIPT_HOME/libs

PATH_TO_JAR=$LIB_PATH/hypermars_mis-0.0.1-SNAPSHOT.jar
PID_PATH_NAME=$SCRIPT_HOME/bin/pid/hypermslk.pid
TEMP_PATH_DIR=$SCRIPT_HOME/tmp
PATH_PROP=file:$SCRIPT_HOME/config/application.yml
PATH_LOGGING=$SCRIPT_HOME/config/logback-spring.xml
JAVA_OPTS="-Xms512m -Xmx1024m"
APP_PROFILE=local

case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java $JAVA_OPTS -Dspring.profiles.active=$APP_PROFILE -jar $PATH_TO_JAR -Dspring.config.location=$PATH_PROP -Dlogging.config=$PATH_LOGGING $TEMP_PATH_DIR 2>> /dev/null >> /dev/null &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            nohup java $JAVA_OPTS -Dspring.profiles.active=$APP_PROFILE  -jar $PATH_TO_JAR $TEMP_PATH_DIR 2>> /dev/null >> /dev/null &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac