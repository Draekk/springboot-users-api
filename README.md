# Spring Boot Users API

Este proyecto es una aplicación que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar usuarios. Cada usuario tiene información personal, una cuenta de usuario y una dirección. En lugar de una base de datos, la aplicación utiliza listas para simular el almacenamiento de datos.

## Requisitos

- Java 17
- Postman

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Draekk/springboot-users-api.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd springboot-users-api
   ```
3. Compila y ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

## Uso

Puedes usar Postman para interactuar con la API. A continuación se detallan las rutas disponibles y cómo usarlas.

### Rutas

- **Crear un usuario**

  - **URL:** `/api/user/add`
  - **Método:** `POST`
  - **Cuerpo de la solicitud:**
    ```json
    {
      "dni": "un dni o identificacion",
      "name": "un nombre",
      "lastname": "un apellido",
      "email": "correo@example.com",
      "username": "unusuario",
      "password": "unacontraseña",
      "street": "una calle",
      "city": "una ciudad",
      "country": "un pais"
    }
    ```

- **Obtener todos los usuarios**

  - **URL:** `/api/user/list`
  - **Método:** `GET`

- **Obtener un usuario por ID**

  - **URL:** `/api/users/id/{id}`
  - **Método:** `GET`

- **Obtener un usuario por DNI**

  - **URL:** `/api/users/dni`
  - **Método:** `GET`
  - **Cuerpo de la solicitud:**
    ```json
    {
      "dni": "un dni o identificacion"
    }
    ```

- **Obtener un usuario por Nombre**

  - **URL:** `/api/users/name`
  - **Método:** `GET`
  - **Cuerpo de la solicitud:**
    ```json
    {
      "name": "un nombre"
    }
    ```

- **Actualizar un usuario**

  - **URL:** `/api/users/edit/{id}`
  - **Método:** `PUT`
  - **Cuerpo de la solicitud:**
    ```json
    {
      "dni": "un dni o identificacion",
      "name": "un nombre",
      "lastname": "un apellido",
      "email": "correo@example.com",
      "username": "unusuario",
      "password": "unacontraseña",
      "street": "una calle",
      "city": "una ciudad",
      "country": "un pais"
    }
    ```

- **Eliminar un usuario**
  - **URL:** `/api/users/destroy/{id}`
  - **Método:** `DELETE`

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue para discutir cualquier cambio importante antes de realizarlo.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
