<h5>home-koval-party</h4>
,,
<h2>Hi there</h2>

<h3>To run the application with database you need to have Docker installed on your pc</h3>

use command `docker compose up`

to see the available endpoints you should open `http://localhost:8080/swagger-ui/index.html#/`

There are two predefined users:<br><br>
role "EDITOR":

```
{
  "username": "editor",
  "password": "123"
}
```

role "USER":

```
{
  "username": "user",
  "password": "123"
}
```

use it in auth endpoint
