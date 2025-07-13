# 🎲 Blackjack Reactive API

API REST reactiva para un juego de Blackjack un jugador vs dealer, desarrollada con Spring Boot WebFlux.

---

## 📋 Descripción general

Esta aplicación implementa la lógica básica de Blackjack para un único jugador contra la banca. Ofrece:

- **Creación de partidas** y gestión de estados.  
- **Acciones de juego**: pedir carta (*hit*), plantarse (*stand*).  
- **Persistencia reactiva** en **MySQL** (jugadores) y **MongoDB** (partidas).  
- **Manejo global de excepciones** con un `GlobalExceptionHandler`.  
- **Documentación automática de la API** con Swagger/OpenAPI.  
- **Pruebas unitarias** con JUnit 5 y Mockito.  

---

## 🎯 Requisitos cubiertos

1. **Implementación básica** con Spring WebFlux (controladores y servicios reactivos).  
2. **Gestión de excepciones global** mediante `@ControllerAdvice`.  
3. **Configuración dual de bases de datos**: R2DBC MySQL y MongoDB reactivo.  
4. **Pruebas** de al menos un controlador y un servicio.  
5. **Swagger UI** para documentación y prueba de endpoints.  

---

## 🚀 Uso local

### ⚙️ Prerrequisitos

- Java 21  
- Maven  
- Docker (opcional para bases de datos)  

### ▶️ Ejecución sin Docker

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Jusep1983/blackjack-api.git
   ```
   ```bash
   cd blackjack-api
   ```
Ajusta src/main/resources/application.yml con tus credenciales de MySQL y MongoDB locales.

Ejecuta:

```bash
./mvnw spring-boot:run
```
Abre Swagger UI:


http://localhost:8080/swagger-ui/index.html

Accede al frontend:

http://localhost:8080/index.html

### 🐳 Ejecución con Docker Compose

Construye y levanta contenedores:

```bash
docker-compose up -d --build
```
La API y Swagger estarán en:

   http://localhost:8080/swagger-ui/index.html

   http://localhost:8080/index.html

Para parar (sin borrar volúmenes):

```bash

docker-compose stop
```
Para reiniciar contenedores parados:

```bash
docker-compose start
```
Para detener y eliminar contenedores y volúmenes:

```bash

docker-compose down -v
```
## 🔧 Despliegue en Render
Conecta tu repo de GitHub a Render.

Define variables de entorno en Render (Environment):

```env
SPRING_PROFILES_ACTIVE=docker
SPRING_R2DBC_URL=<tu_URL_R2DBC>
SPRING_R2DBC_USERNAME=<usuario>
SPRING_R2DBC_PASSWORD=<password>
SPRING_DATA_MONGODB_URI=<tu_URI_MongoDB>
```
Render detecta application-docker.yml y usa esas variables.

Haz manual deploy y prueba en:

```arduino
https://<tu-app>.onrender.com/swagger-ui/index.html
```
Mi aplicacion estara disponibvle para probar ya desplegada en:

- Web mediante frontend sencillo:
  
https://s501-blackjack-api.onrender.com/index.html

- Swagger:
  
https://s501-blackjack-api.onrender.com/swagger-ui/index.html#/

## 📜 Endpoints principales

| Método | Endpoint               | Descripción                  |
|--------|------------------------|------------------------------|
| POST   | `/game/new`            | Crear nueva partida          |
| GET    | `/game/{id}`           | Detalles de una partida      |
| POST   | `/game/{id}/play`      | Realizar jugada en partida   |
| DELETE | `/game/{id}/delete`    | Borrar partida               |
| GET    | `/ranking`             | Obtener ranking de jugadores |
| PUT    | `/player/{playerId}`   | Cambiar nombre de jugador    |


## 🧪 Pruebas
Ejecuta todos los tests:

```bash
./mvnw test
```

## 🐳 Imagen Docker pública
Docker Hub

Ejecutar sin build:

```bash
docker pull jusep83/blackjack-blackjack-api:latest
```
```bash
docker run -p 8080:8080 --env-file .env jusep83/blackjack-blackjack-api:latest
```
## 📁 Estructura del proyecto


```text
.
├── Dockerfile                                # Imagen de la API para Docker
├── docker-compose.yml                        # Orquestación de la API + MySQL + MongoDB
├── README.md                                 # Documentación del proyecto
├── pom.xml                                   # Dependencias del proyecto Maven
├── .dockerignore                             # Archivos que Docker debe ignorar
├── .gitignore                                # Archivos ignorados por Git
│
├── src
│   └── main
│       ├── java
│       │   └── com.jusep1983.blackjack
│       │       ├── config                    # Configuración general
│       │       ├── controller                # Controladores REST (GameController, PlayerController, etc.)
│       │       ├── dto                       # DTOs para entrada y salida
│       │       ├── enums                     # Enumeraciones: tipos de jugada, estado del juego...
│       │       ├── exception                 # Excepciones personalizadas y GlobalExceptionHandler
│       │       ├── model                     # Entidades (Player, Game, Card, etc.)
│       │       ├── repository                # Interfaces de persistencia (Mongo y MySQL reactivos)
│       │       ├── response                  # Clases de respuesta estructurada (opcional)
│       │       ├── service                   # Interfaces e implementaciones de lógica de negocio
│       │       └── BlackjackApplication.java # Clase principal con el método `main`
│       │
│       └── resources
│           ├── static
│           │   └── index.html                # Frontend embebido muy básico
│           ├── application.yml               # Config local (localhost)
│           ├── application-docker.yml        # Config para entorno Docker o Render
│           └── application.properties        # (vacío o no usado)
│
└── test
    └── java
        └── com.jusep1983.blackjack
            ├── service                       # Tests de PlayerService, GameService, etc.
            └── controller                    # Tests de PlayerController, GameController...
```

## 👤 Autor
Josep1983

## 📄 Licencia
MIT
