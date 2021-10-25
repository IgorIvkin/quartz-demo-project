# Quartz Cluster Mode

This small project illustrates how to work with Quartz in cluster mode.
Quartz is a advanced scheduling library that allows to setup scheduled
tasks based on crontab, calendar and other types of scheduling.

It can use JDBC to store the task related information to the database
of choice. Moreover, it supports cluster mode that allows Quartz to use
distributed lock system.

## How it works?

First Quartz prepares the database schema. It uses the file `quarts/quartz_schema.sql`
located in the classpath (our case is folder `resources/quartz`). This script
executes everytime new instance of service based on Quartz is up. So take care
to not drop or delete something there.

Second Quartz provides a strong **Spring Boot** integration. You have to define
`Job`-classes implementing a `Job` interface, beans describing `JobDetail` connecting
to this job and beans describing `Trigger`. Trigger beans contain scheduling
settings defining a behaviour of your application.

When restarted the service will replay the tasks that was overdue because of restarting
or service crush.