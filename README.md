# SpringBootProject

### PostController
#### Count endpoint
```
curl --location --request GET 'http://localhost:8080/posts/users/unique'
```
#### Updated User List endpoint
```
curl --location --request PATCH 'http://localhost:8080/posts/4' \
--header 'Content-Type: application/json' \
--data-raw ' {
        "title":"1800Flowers",
        "body":"1800Flowers"
    }'
```
#### Sorted List endpoint
```
curl --location --request GET 'http://localhost:8080/posts?sort=true'
```
