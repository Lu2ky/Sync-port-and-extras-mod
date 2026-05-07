Carpeta src
===========

Descripción
-----------
La carpeta `src` contiene todo el código fuente, recursos y artefactos generados del mod.

Estructura relevante dentro de `src`:

- `src/main/java` - Código fuente Java del mod.
- `src/main/resources` - Recursos estáticos que se empaquetan en el mod (assets, archivos de datos, `mods.toml`, etc.).
- `src/generated/resources` - Salida de la generación de datos (data gen). Esta carpeta se crea al ejecutar la tarea `runData` o `runData` equivalente.

Uso y buenas prácticas
----------------------
- Mantén el código fuente en `src/main/java` y los recursos en `src/main/resources`.
- No añadas manualmente archivos generados en `src/generated/resources` al control de versiones a menos que sea intencional.
- Si necesitas regenerar recursos (loot tables, recetas, etc.), ejecuta la tarea `runData` con el wrapper de Gradle: `./gradlew runData` o en Windows `./gradlew.bat runData`.

Si necesitas documentación más detallada por paquete (por ejemplo `com/luky/syncextra`), revisa `src/main/java/README.md`.

