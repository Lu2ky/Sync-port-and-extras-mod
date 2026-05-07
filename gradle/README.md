Carpeta gradle
==============

Descripción
-----------
Contiene la configuración del wrapper de Gradle y archivos relacionados con la infraestructura del build.

Contenido
--------
- `wrapper/gradle-wrapper.properties` y `wrapper/gradle-wrapper.jar` - mantienen la versión del wrapper que permite ejecutar `./gradlew` sin tener Gradle instalado globalmente.

Qué debes saber
----------------
- No modifiques la versión del wrapper sin comprender el impacto en el proyecto. Para actualizar el wrapper usa la tarea `gradle wrapper --gradle-version x.y.z` o el equivalente con el wrapper si es necesario.

