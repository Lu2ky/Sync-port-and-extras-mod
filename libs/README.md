Carpeta libs
===========

Descripción
-----------
La carpeta `libs` suele contener jars locales que el proyecto puede referenciar sin descargarlos desde repositorios remotos. En este proyecto hay archivos jar utilizados como dependencias en `build.gradle`.

Notas importantes
-----------------
- Si el `build.gradle` referencia jars dentro de `libs/` (por ejemplo `bookshelf-neoforge-...jar`), asegúrate de mantener esas versiones si necesitas reproducir el entorno de build del autor original.
- No subas a control de versiones jars grandes si el repositorio lo prohíbe; en su lugar documenta qué dependencias externas son necesarias.

Cómo usar
--------
- Para añadir una dependencia local, pon el JAR en `libs/` y referencia con `files('libs/nombre.jar')` en `build.gradle`.

