<div align="center">
  <h1>HELLO WORLD APPLICATION</h1>
  <p><strong>Aplicación JavaFX con Base de Datos MySQL</strong></p>
</div>

---

## ★ Descripción

**HelloWorldApplication** es una aplicación de escritorio desarrollada en **Java con JavaFX** como interfaz gráfica y **MySQL** como gestor de base de datos. Este proyecto forma parte del primer desafío de programación (**First DIN Challenge**) y demuestra la integración de componentes visuales con almacenamiento persistente de datos.

La aplicación implementa una arquitectura de tres capas (Model-View-Controller) para mantener una separación clara entre la lógica de negocio, la presentación y el acceso a datos.

---

## ★ Tecnologías Utilizadas

| Componente | Tecnología |
|---|---|
| **Lenguaje** | Java 8 |
| **Interfaz Gráfica** | JavaFX 8+ |
| **Base de Datos** | MySQL 8.0 |
| **Conector BD** | MySQL Connector/J 8.0.15 |
| **Build System** | Apache Ant |
| **IDE** | NetBeans |
| **Arquitectura** | MVC (Model-View-Controller) |

---

## ★ Estructura del Proyecto

```
HelloWorld/
├── HelloWorldApplication/
│   ├── src/
│   │   ├── userInterfaceTier/           # Capa de presentación (JavaFX)
│   │   │   └── Application.java         # Clase principal de la aplicación
│   │   ├── logicTier/                   # Capa de lógica de negocio
│   │   │   └── [Clases de lógica]
│   │   ├── dataTier/                    # Capa de acceso a datos
│   │   │   └── [Clases de persistencia]
│   │   └── META-INF/
│   │       └── MANIFEST.MF
│   ├── build/                           # Archivos compilados
│   ├── dist/                            # Distribuciones generadas
│   ├── nbproject/                       # Configuración de NetBeans
│   ├── build.xml                        # Script de compilación Ant
│   ├── manifest.mf                      # Manifiesto del JAR
│   └── mysql-connector-java-8.0.15.jar  # Librería MySQL
├── .gitignore
└── README.md                            # Este archivo
```

---

## ★ Requisitos del Sistema

### ⊹ Software Requerido

- **Java Development Kit (JDK)**: 8 o superior
- **MySQL Server**: 5.7 o superior
- **Apache Ant**: 1.10 o superior
- **NetBeans IDE** (recomendado) o cualquier IDE Java compatible

### ⊹ Dependencias del Proyecto

```
✓ JavaFX SDK 8.0+
✓ MySQL Connector/J 8.0.15
✓ JDK 1.8 (Java 8)
```

---

## ★ Instalación y Configuración

### ⊹ 1. Clonar el Repositorio

```bash
git clone https://github.com/MeylinM/HelloWorld.git
cd HelloWorld
```

### ⊹ 2. Configurar la Base de Datos MySQL

Antes de ejecutar la aplicación, crea la base de datos:

```bash
mysql -u root -p
```

```sql
CREATE DATABASE hello_world_db;
USE hello_world_db;

-- Aquí irían las tablas específicas del proyecto
-- (Éstas deben definirse según los requisitos de tu aplicación)
```

### ⊹ 3. Abrir el Proyecto en NetBeans

1. Abre **NetBeans IDE**
2. Selecciona **File** → **Open Project**
3. Navega a la carpeta `HelloWorld/HelloWorldApplication`
4. Haz clic en **Open Project**

NetBeans detectará automáticamente que es un proyecto Ant y configurará todo.

### ⊹ 4. Configurar la Conexión a Base de Datos

Localiza la clase responsable de la conexión a MySQL (probablemente en `dataTier/`) y actualiza los parámetros:

```java
// Ejemplo de configuración
String url = "jdbc:mysql://localhost:3306/hello_world_db";
String user = "root";
String password = "tu_contraseña";
```

### ⊹ 5. Compilar el Proyecto

Desde la terminal dentro de `HelloWorldApplication/`:

```bash
ant build
```

### ⊹ 6. Ejecutar la Aplicación

```bash
ant run
```

O desde NetBeans: **Run** → **Run Project (F6)**

---

## ★ Arquitectura del Proyecto

El proyecto sigue el patrón **MVC (Model-View-Controller)** dividido en tres capas:

### ⊹ **User Interface Tier (Presentación)**
- Contiene la clase `Application.java` que inicia la aplicación JavaFX
- Define las interfaces gráficas y componentes visuales
- Maneja los eventos de usuario

### ⊹ **Logic Tier (Lógica de Negocio)**
- Procesa la lógica de la aplicación
- Valida datos
- Coordina entre la interfaz y los datos

### ⊹ **Data Tier (Persistencia)**
- Gestiona la conexión con MySQL
- Realiza operaciones CRUD (Create, Read, Update, Delete)
- Traduce objetos Java a operaciones de base de datos SQL

---

## ★ Configuración de Build (Ant)

El archivo `build.xml` contiene las instrucciones de compilación:

```xml
<!-- Compilar el proyecto -->
<target name="build">
  <javac srcdir="src" destdir="build/classes"/>
</target>

<!-- Crear el JAR ejecutable -->
<target name="jar">
  <jar destfile="dist/HelloWorldApplication.jar" basedir="build/classes">
    <manifest>
      <attribute name="Main-Class" value="userInterfaceTier.Application"/>
    </manifest>
  </jar>
</target>
```

---

## ★ Solución de Problemas Comunes

### ⊹ Error: "Cannot find MySQL Connector"
**Solución:** Asegúrate de que `mysql-connector-java-8.0.15.jar` esté en la carpeta `HelloWorldApplication/` y que esté incluido en el classpath del proyecto.

### ⊹ Error: "Connection refused" a MySQL
**Verificar:**
- Que MySQL Server esté corriendo: `mysql -u root -p`
- Que la contraseña sea correcta en el código
- Que la base de datos `hello_world_db` exista

### ⊹ Error: "JavaFX classes not found"
**Solución:** 
1. Asegúrate de tener JavaFX SDK instalado
2. En NetBeans, ve a **Tools** → **Libraries** y verifica que JavaFX esté bien configurado
3. Si es necesario, descarga JavaFX desde [gluonhq.com](https://gluonhq.com/products/javafx/)

### ⊹ Error de compilación en NetBeans
**Solución:**
1. Haz clic derecho en el proyecto
2. Selecciona **Clean and Build**
3. Si persiste, limpia la caché de NetBeans

---

## ★ Estructura de la Base de Datos

MySQL almacena los datos de la aplicación. Estructura esperada:

```sql
-- Tabla de ejemplo (según requisitos del proyecto)
CREATE TABLE ejemplo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## ★ Características Principales

✓ **Interfaz Gráfica JavaFX** - Interfaz moderna y responsiva
✓ **Persistencia en MySQL** - Almacenamiento confiable de datos
✓ **Arquitectura MVC** - Código organizado y mantenible
✓ **Compilación con Ant** - Build automático y multiplataforma
✓ **Fácil de extender** - Estructura clara para agregar nuevas funcionalidades

---

## ★ Próximos Pasos y Mejoras Futuras

- [ ] Implementar validaciones más robustas
- [ ] Agregar pruebas unitarias
- [ ] Optimizar consultas a base de datos
- [ ] Mejorar la interfaz gráfica
- [ ] Agregar autenticación de usuarios
- [ ] Documentación detallada de API

---

## ★ Licencia

Este proyecto ha sido desarrollado como parte del **First DIN Challenge** en un programa de formación profesional de **Desarrollo de Aplicaciones Multiplataforma**.

---

<div align="center">
  <p><strong>Desarrollado por</strong></p>
  <p><a href="https://github.com/MeylinM">@MeylinM</a></p>
  <br>
  <p>📌 <strong>Última actualización:</strong> 2026</p>
</div>
