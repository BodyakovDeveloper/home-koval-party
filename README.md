# home-koval-party

<h1>Hi there</h1>

<h3>To run the application with database you need to have Docker installed on your pc</h3>

use command `docker compose up`

to see the availiable endpoints you should open `http://localhost:8080/swagger-ui/index.html#/`

There are two predefined users:
  role "editor": <br>
    `{ <br>
      "username": "editor", <br>
      "password": "123" <br>
    }`<br>
  role "user": <br>
    `{ <br>
      "username": "user", <br>
      "password": "123" <br>
    }`<br>
use it in auth endpoint
