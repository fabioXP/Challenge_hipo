# API PERSONA

_Basic API REST with Spring Boot and POSTGRESQL_
-------------

## ROUTES

**api/v1/newperson**

_Creates a new person_

example of body:
```
{
  "name":"Fabio Pierdominici",
  "age":21,
  "gender":"male"
}
```
_this also associates a id unique with each person_


**api/v1/delete/people-{id}**

_It deletes a person_

It uses the id of the person as a **param** to delete. Example:
```
..api/v1/delete/people-ab09cbb2-e016-4dd5-b106-14b8b2302dba
```

**api/v1/people**
_Shows all people in the database, it does not needs for a body_

**api/v1/people-{id}**
_Shows the person with the corresponding id use as a **param**. Example_

```
..api/v1/people-ab09cbb2-e016-4dd5-b106-14b8b2302dba
```

**api/v1/update/person-{id}**

_Updates the data from an already existing person_
Url example:
```
..api/v1/update/person-ab09cbb2-e016-4dd5-b106-14b8b2302dba
```

Body example:
```
{
  "name":"Fabio Pierdominici",
  "age":21,
  "gender":"male"
}
```
_The id in the url is necessary to identify the person to update, all fields in the body are optional_

## Swagger

**/swagger**

_It shows a JSON with all the define methods_

**/swagger-ui.html

_Swagger UI basic_


