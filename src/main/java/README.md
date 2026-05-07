Carpeta src/main/java
=====================

Descripción
-----------
Contiene el código Java del mod, organizado por paquetes. El paquete principal es `com.luky.syncextra`.

Estructura destacada
--------------------
- `com.luky.syncextra` - clase principal del mod y puntos de entrada (`SyncExtra`, `SyncExtraClient`).
- `com.luky.syncextra.registry` - registros y helpers para `Blocks`, `Items`, `BlockEntities`, `Menus`, etc. Ej.: `ModBlocks.java`, `ModItems.java`.
- `com.luky.syncextra.client` - código y eventos específicos del cliente (render, pantallas).
- `com.luky.syncextra.datagen` - generadores de datos (data generators) si existen.
- `com.luky.syncextra.custom` - implementaciones personalizadas de bloques/objetos (por ejemplo `TestBlock`, `CloneoditaLamp`).
- `com.luky.syncextra.component` - componentes o sistemas de datos del mod.

Puntos de entrada
------------------
- `SyncExtra` - clase anotada con `@Mod` que registra los registries (blocks, items, etc.) y listeners de lifecycle.
- `SyncExtraClient` - registro de inicialización del lado cliente (pantallas y cliente específico).

Cómo entender el registro de elementos
-------------------------------------
Este proyecto utiliza la abstracción `DeferredRegister`/`DeferredBlock` de NeoForge para registrar contenido. Revisa `ModBlocks.java` y `ModItems.java` para ver ejemplos de cómo se registran bloques y sus `BlockItem` correspondientes.

Consejos para desarrollo
-----------------------
- Para añadir un bloque nuevo, crea la clase del bloque en `custom/`, registra en `ModBlocks` y añade assets/texturas en `src/main/resources/assets/<modid>/textures`.
- Para cambios del lado cliente (renders, pantallas), colócalos en `client/` y regístralos condicionalmente usando checks `FMLEnvironment.dist.isClient()` si es necesario.

