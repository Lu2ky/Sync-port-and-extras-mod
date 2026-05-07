Carpeta src/main
================

Descripción
-----------
`src/main` contiene las fuentes y recursos que se empaquetan en el mod final.

Contenido principal
-------------------
- `src/main/java` - Código fuente Java.
- `src/main/resources` - Recursos del mod: `assets/`, archivos de idioma, `mods.toml`, `pack.mcmeta`, `META-INF` y plantillas usadas por `generateModMetadata`.
- `src/main/templates` - Plantillas utilizadas para generar metadata del mod (tarea `generateModMetadata`).

Tareas útiles
------------
- `generateModMetadata`: transforma plantillas en metadata del mod y coloca el resultado en `build/generated/sources/modMetadata`. Esta tarea está integrada en el flujo de IDE para que el metadata sea visible.

Consejos
-------
- Mantén separados los recursos que escribes a mano (`src/main/resources`) de los generados (`src/generated/resources`).
- Usa las utilidades de data generation si vas a crear recetas/loot/tags automáticos.