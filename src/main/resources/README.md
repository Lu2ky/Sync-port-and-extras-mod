Carpeta src/main/resources
=========================

Descripción
-----------
Contiene recursos que se empaquetan dentro del mod: assets, archivos de configuración y metadata.

Contenido típico
----------------
- `assets/<modid>/textures/` - texturas del mod.
- `assets/<modid>/models/` - modelos JSON.
- `data/<modid>/recipes/`, `loot_tables/`, `tags/` - si hay recursos escritos a mano.
- `META-INF/` - puede contener `mods.toml`, `accesstransformer.cfg`, o configuraciones necesarias.

Plantillas y generación
-----------------------
- `src/main/templates` contiene plantillas (por ejemplo para `mods.toml`) que son procesadas por la tarea `generateModMetadata`.
- La generación de datos por código (data generators) escribe en `src/generated/resources`.

Cómo empacar recursos
---------------------
- Añade assets en las rutas bajo `assets/<modid>/...` y asegúrate de referenciarlos correctamente desde el código (ej.: `ModBlocks` usa nombres de recursos que deben existir aquí).

