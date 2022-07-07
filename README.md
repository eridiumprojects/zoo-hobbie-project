# Interview REST API Service

A spring boot REST web service that allows the basic CRUD operations as well as searching by title or category.
Added Authentication and Authorization via the Spring Security module.

## User

#### Register a new user

`POST /register`

__Request body__:
```
{
   "username": "<string>",
   "password": "<string>"
}
```

__Response body__:
```
{
   "username": "<string>"
}
```

## Animal

#### Get an animal by animalId

`GET /v1/api/animals/{{animalId}}`

#### Get animals by userId

`GET /v1/api/animals/{{userId}}/animals`

#### Create an animal

`POST /v1/api/animals`

__Request body__:
```
{
   "species": "<string>", INPUT-FORMAT: FROM ANIMALS-GUIDE: [Cat || Dog || Mouse || Tiger || Bear]
   "birth": <string>, // INPUT-FORMAT: ["DD.MM.YYYY"]
   "sex": <string>, // INPUT-FORMAT: [Male || Female]
   "name": <string>, // INPUT-FORMAT: NAME OF ANIMAL
   "host": <string> // INPUT-FORMAT: NAME OF USER
}
```

__Response body__:
```
{
   "id": "<Long>",
   "species": "<string>,
   "birth": <string>,
   "sex": <string>,
   "name": <string>
}
```

#### Delete an animal by animalId

`DELETE /v1/api/animals/delete/{{animalId}}`

#### Update an animal by animalId and details

`PUT /v1/api/animals/update/{{animalId}}`

__Request body__:
```
{
   "name": "<string>", //INPUT-FORMAT: NEW NAME OF ANIMAL
   "host": "<string>" //INPUT-FORMAT: NEW NAME OF USER
}
```

