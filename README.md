# 🎲 S501-_Spring_Framework_Avançat_amb_WebFlux

Proyecto API REST para un juego de Blackjack de un jugador contra el dealer, desarrollado con Spring Boot y WebFlux.

---

## 📋 Descripción

Esta API implementa la lógica básica del juego Blackjack para un solo jugador. Permite crear partidas, gestionar turnos (pedir carta, plantarse), y ver el estado del juego.

Está desarrollado usando:

- ☕ Java 21
- 🚀 Spring Boot con WebFlux (programación reactiva)
- 🗄️ Persistencia en MongoDB y MySQL (reactivos)
- 📚 Documentación Swagger para probar los endpoints
- ✅ Testing con JUnit y Mockito
- 🛠️ Manejo global de excepciones

---

## 🎯 Funcionalidades principales

- ➕ Crear una nueva partida asociada a un jugador
- 🃏 Pedir carta (hit)
- ✋ Plantarse (stand)
- 🔍 Consultar estado del juego
- 🗃️ Persistencia reactiva en MongoDB y MySQL
- ⚠️ Control de errores y validaciones básicas

---

## 🛠️ Tecnologías usadas

- ☕ Java 21
- 🚀 Spring Boot 3.x con WebFlux
- 🍃 MongoDB reactive driver
- 🔗 R2DBC con MySQL para persistencia reactiva
- 🧪 JUnit 5 + Mockito para testing
- 📖 Swagger/OpenAPI para documentación REST

---

## 🚀 Cómo ejecutar el proyecto

### ⚙️ Prerrequisitos

- ☕ Java 21 instalado
- 🐳 Docker (opcional, para bases de datos o dockerizar la app)
- 🍃 MongoDB y 🐬 MySQL corriendo local o remoto
- 💻 IDE recomendado: IntelliJ IDEA / VS Code

### ▶️ Pasos para arrancar

1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/blackjack-api.git
```
```bash
cd blackjack-api
```

2. Configurar las conexiones a las bases de datos en application.yml (MongoDB y MySQL)

3. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

4. Acceder a Swagger UI para probar endpoints:

```bash
http://localhost:8080/swagger-ui.html
```

## 🧪 Testing
Para ejecutar los tests:

```bash
./mvnw test
```

## 📂 Estructura básica del proyecto

- controller - Endpoints REST

- service - Lógica de negocio

- repository - Persistencia reactiva

- model - Entidades y DTOs

- exception - Manejo de errores personalizados

## 🐳 Dockerización y uso de la imagen Docker

### Construir la imagen localmente

Si quieres construir la imagen Docker de la API desde el código fuente:

```bash
# En la raíz del proyecto (donde está el Dockerfile)
docker build -t jusep83/blackjack-blackjack-api:latest .
```
Ejecutar el proyecto con Docker Compose (localmente)
Para levantar la API junto con las bases de datos MongoDB y MySQL usando Docker Compose:

```bash
docker-compose up -d
```
Esto levantará los tres contenedores y la app estará disponible en:

```bash
http://localhost:8080/swagger-ui.html
```
Tambien disponible con frontend sencillo en:
```bash
http://localhost:8080/index.html
```
Parar y eliminar los contenedores y volúmenes
```bash
docker-compose down -v
```
Descargar y ejecutar la imagen Docker de la API (sin build)

Si solo quieres usar la imagen ya publicada en Docker Hub y levantar la API (requiere que tengas las bases de datos corriendo y accesibles):

```bash
docker pull jusep83/blackjack-blackjack-api:latest
```
```bash
docker run -p 8080:8080 --env SPRING_PROFILES_ACTIVE=docker --network blackjack-net jusep83/blackjack-blackjack-api:latest
```
Asegúrate de que las bases de datos MongoDB y MySQL estén accesibles desde el contenedor (pueden estar en otros contenedores en la misma red Docker).

👤 Autor
Josep1983

📄 Licencia
MIT
