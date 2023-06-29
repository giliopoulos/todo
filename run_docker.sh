#!/bin/sh

docker run \
--name=todo_app_db \
--env=POSTGRES_DB=todo \
--env=POSTGRES_USER=leapforward \
--env=POSTGRES_PASSWORD=leapforward \
--env=LANG=en_US.utf8 \
--env=PGDATA=/var/lib/postgresql/data \
--volume=/var/lib/postgresql/data \
-p 5432:5432 \
--runtime=runc \
-d postgres:latest
