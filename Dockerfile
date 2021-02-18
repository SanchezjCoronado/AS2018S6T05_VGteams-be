FROM openjdk:11.0.9.1-jre-buster

#ENV POSTGRE_URL ${POSTGRE_URL}
#ENV POSTGRE_USER ${POSTGRE_USER}
#ENV POSTGRE_PASSWORD ${POSTGRE_PASSWORD}

ADD /build/libs/vgteams-v0.0.1.jar vg-teams.jar
EXPOSE 8284

ENTRYPOINT [ "sh", "-c", "java -Duser.timezone=GMT-5 -jar /vg-teams.jar" ]
