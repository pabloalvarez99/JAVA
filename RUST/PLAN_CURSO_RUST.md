# PLAN COMPLETO: Curso Practico de Rust

## Vision General

Crear un curso practico de Rust siguiendo la estructura del proyecto JAVA1.
**Total: ~98 ejercicios + guias + proyectos (~130 archivos)**
**Tiempo estimado: 60-80 horas**

---

## Estructura de Carpetas

```
RUST/
├── 01_Fundamentos/           (10 ejercicios)
├── 02_Ownership_Borrowing/   (10 ejercicios) ← CRITICO
├── 03_Structs_Enums/         (8 ejercicios)
├── 04_Pattern_Matching/      (6 ejercicios)
├── 05_Traits_Generics/       (8 ejercicios)
├── 06_Colecciones/           (8 ejercicios)
├── 07_Manejo_Errores/        (6 ejercicios)
├── 08_Iteradores_Closures/   (8 ejercicios)
├── 09_Modulos_Cargo/         (6 ejercicios)
├── 10_Concurrencia/          (8 ejercicios)
├── 11_Proyectos_Complejos/   (10 proyectos)
├── 12_Ejercicios_Debug/      (10 ejercicios)
├── README.md
├── PLAN_CURSO_RUST.md
└── CHEAT_SHEET_RUST.md
```

---

## Detalle por Carpeta

### 01_Fundamentos (10 ejercicios) - 4-5 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 01 | ejercicio01_variables.rs | Variables y Mutabilidad | * |
| 02 | ejercicio02_tipos_escalares.rs | i32, f64, bool, char | * |
| 03 | ejercicio03_tipos_compuestos.rs | Tuplas y Arrays | ** |
| 04 | ejercicio04_funciones.rs | Funciones y Expresiones | ** |
| 05 | ejercicio05_control_flujo.rs | if/else | ** |
| 06 | ejercicio06_loops.rs | loop, while, for | *** |
| 07 | ejercicio07_strings.rs | String y &str | *** |
| 08 | ejercicio08_slices.rs | Slices | *** |
| 09 | ejercicio09_input.rs | Input del Usuario | *** |
| 10 | ejercicio10_calculadora.rs | Mini Proyecto | **** |

**Archivos adicionales:** README.md

---

### 02_Ownership_Borrowing (10 ejercicios) - 6-8 horas ★ CRITICO

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 11 | ejercicio11_ownership_basics.rs | Ownership Basics | *** |
| 12 | ejercicio12_move_semantics.rs | Move Semantics | *** |
| 13 | ejercicio13_clone_copy.rs | Clone vs Copy | **** |
| 14 | ejercicio14_referencias_inmutables.rs | &T | **** |
| 15 | ejercicio15_referencias_mutables.rs | &mut T | **** |
| 16 | ejercicio16_reglas_borrowing.rs | Reglas de Borrowing | ***** |
| 17 | ejercicio17_lifetimes_basicos.rs | Lifetimes Basicos | ***** |
| 18 | ejercicio18_lifetime_elision.rs | Lifetime Elision | ****** |
| 19 | ejercicio19_dangling_references.rs | Dangling References | ***** |
| 20 | ejercicio20_text_analyzer.rs | Mini Proyecto | ****** |

**Archivos adicionales:** README.md, GUIA_OWNERSHIP.md

---

### 03_Structs_Enums (8 ejercicios) - 4-5 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 21 | ejercicio21_definir_structs.rs | Definir Structs | *** |
| 22 | ejercicio22_metodos_impl.rs | Metodos con impl | **** |
| 23 | ejercicio23_tuple_structs.rs | Tuple Structs | *** |
| 24 | ejercicio24_enums_basicos.rs | Enums Basicos | **** |
| 25 | ejercicio25_enums_con_datos.rs | Enums con Datos | ***** |
| 26 | ejercicio26_option.rs | Option<T> | ***** |
| 27 | ejercicio27_result.rs | Result<T, E> | ***** |
| 28 | ejercicio28_inventario.rs | Mini Proyecto | ****** |

**Archivos adicionales:** README.md

---

### 04_Pattern_Matching (6 ejercicios) - 3-4 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 29 | ejercicio29_match_basico.rs | match Basico | **** |
| 30 | ejercicio30_destructuring_structs.rs | Destructuring Structs | ***** |
| 31 | ejercicio31_destructuring_enums.rs | Destructuring Enums | ***** |
| 32 | ejercicio32_guards.rs | Guards en match | ***** |
| 33 | ejercicio33_if_let_while_let.rs | if let y while let | ***** |
| 34 | ejercicio34_parser_json.rs | Mini Proyecto | ****** |

**Archivos adicionales:** README.md

---

### 05_Traits_Generics (8 ejercicios) - 5-6 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 35 | ejercicio35_generics_funciones.rs | Generics en Funciones | ***** |
| 36 | ejercicio36_generics_structs.rs | Generics en Structs | ***** |
| 37 | ejercicio37_definir_traits.rs | Definir Traits | ***** |
| 38 | ejercicio38_implementar_traits.rs | Implementar Traits | ****** |
| 39 | ejercicio39_trait_bounds.rs | Trait Bounds | ****** |
| 40 | ejercicio40_traits_derivables.rs | Debug, Clone, etc | ***** |
| 41 | ejercicio41_trait_objects.rs | dyn Trait | ******* |
| 42 | ejercicio42_notificaciones.rs | Mini Proyecto | ******* |

**Archivos adicionales:** README.md, GUIA_TRAITS.md

---

### 06_Colecciones (8 ejercicios) - 4-5 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 43 | ejercicio43_vec_basico.rs | Vec<T> Basico | **** |
| 44 | ejercicio44_vec_avanzado.rs | Vec<T> Avanzado | ***** |
| 45 | ejercicio45_string_str.rs | String vs &str | ***** |
| 46 | ejercicio46_hashmap.rs | HashMap<K, V> | ***** |
| 47 | ejercicio47_hashset.rs | HashSet<T> | ***** |
| 48 | ejercicio48_btree.rs | BTreeMap y BTreeSet | ****** |
| 49 | ejercicio49_vecdeque.rs | VecDeque | ****** |
| 50 | ejercicio50_word_counter.rs | Mini Proyecto | ****** |

**Archivos adicionales:** README.md

---

### 07_Manejo_Errores (6 ejercicios) - 3-4 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 51 | ejercicio51_panic_vs_result.rs | panic! vs Result | **** |
| 52 | ejercicio52_operador_question.rs | Operador ? | ***** |
| 53 | ejercicio53_propagacion_errores.rs | Propagacion | ***** |
| 54 | ejercicio54_custom_errors.rs | Custom Error Types | ****** |
| 55 | ejercicio55_thiserror_anyhow.rs | Crates de errores | ****** |
| 56 | ejercicio56_file_parser.rs | Mini Proyecto | ******* |

**Archivos adicionales:** README.md, GUIA_ERRORES.md

---

### 08_Iteradores_Closures (8 ejercicios) - 4-5 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 57 | ejercicio57_closures_basicos.rs | Closures Basicos | ***** |
| 58 | ejercicio58_fn_fnmut_fnonce.rs | Fn, FnMut, FnOnce | ****** |
| 59 | ejercicio59_iterator_trait.rs | Iterator Trait | ****** |
| 60 | ejercicio60_map_filter_fold.rs | map, filter, fold | ****** |
| 61 | ejercicio61_collect_turbofish.rs | collect y turbofish | ****** |
| 62 | ejercicio62_iteradores_custom.rs | Iteradores Custom | ******* |
| 63 | ejercicio63_lazy_evaluation.rs | Lazy Evaluation | ******* |
| 64 | ejercicio64_data_pipeline.rs | Mini Proyecto | ******* |

**Archivos adicionales:** README.md

---

### 09_Modulos_Cargo (6 ejercicios) - 3-4 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 65 | ejercicio65_modulos_mod.rs | Modulos y mod | **** |
| 66 | ejercicio66_visibilidad_pub.rs | Visibilidad (pub) | ***** |
| 67 | ejercicio67_use_reexports.rs | use y re-exports | ***** |
| 68 | ejercicio68_cargo_toml.rs | Cargo.toml | ***** |
| 69 | ejercicio69_tests.rs | cargo test | ****** |
| 70 | ejercicio70_cli_tool/ | Mini Proyecto CLI | ******* |

**Archivos adicionales:** README.md, GUIA_CARGO.md

---

### 10_Concurrencia (8 ejercicios) - 6-8 horas

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 71 | ejercicio71_threads.rs | std::thread | ****** |
| 72 | ejercicio72_move_closures.rs | Move con Closures | ****** |
| 73 | ejercicio73_channels.rs | Channels (mpsc) | ******* |
| 74 | ejercicio74_mutex.rs | Mutex<T> | ******* |
| 75 | ejercicio75_arc.rs | Arc<T> | ******* |
| 76 | ejercicio76_rwlock.rs | RwLock<T> | ******** |
| 77 | ejercicio77_send_sync.rs | Send y Sync | ******** |
| 78 | ejercicio78_web_scraper.rs | Mini Proyecto | ******** |

**Archivos adicionales:** README.md, GUIA_CONCURRENCIA.md

---

### 11_Proyectos_Complejos (10 proyectos) - 15-20 horas

| # | Archivo | Proyecto | Conceptos |
|---|---------|----------|-----------|
| P01 | proyecto01_todo_cli.md | CLI Todo App | Args, File I/O, Serde |
| P02 | proyecto02_http_server.md | HTTP Server | Networking, Threads |
| P03 | proyecto03_minigrep.md | Grep Clone | CLI, Error handling |
| P04 | proyecto04_markdown_parser.md | Markdown Parser | Pattern matching |
| P05 | proyecto05_kvdb.md | Database Key-Value | HashMap, Persistence |
| P06 | proyecto06_chat_server.md | Chat Server | Async, Channels |
| P07 | proyecto07_json_parser.md | JSON Parser | Recursion, Enums |
| P08 | proyecto08_build_system.md | Build System Mini | Modules, Graphs |
| P09 | proyecto09_allocator.md | Memory Allocator | Unsafe, Pointers |
| P10 | proyecto10_web_api.md | Web API REST | Actix/Axum |

**Archivos adicionales:** README.md

---

### 12_Ejercicios_Debug (10 ejercicios) - 4-5 horas

| # | Archivo | Bug Type | Dificultad |
|---|---------|----------|------------|
| D01 | debug01_ownership.rs | Ownership Violations | *** |
| D02 | debug02_borrow_checker.rs | Borrow Checker Errors | **** |
| D03 | debug03_lifetimes.rs | Lifetime Mismatches | ***** |
| D04 | debug04_type_inference.rs | Type Inference Fails | *** |
| D05 | debug05_trait_bounds.rs | Trait Bound Missing | **** |
| D06 | debug06_move_after_use.rs | Move After Use | **** |
| D07 | debug07_deadlock.rs | Deadlock Detection | ****** |
| D08 | debug08_iterator.rs | Iterator Invalidation | ***** |
| D09 | debug09_unsafe.rs | Unsafe Memory Bugs | ******* |
| D10 | debug10_async.rs | Async Runtime Issues | ****** |

**Archivos adicionales:** README.md

---

## Guias Principales a Crear

| Archivo | Ubicacion | Contenido |
|---------|-----------|-----------|
| GUIA_OWNERSHIP.md | 02_Ownership/ | El concepto mas importante |
| GUIA_TRAITS.md | 05_Traits/ | Sistema de tipos |
| GUIA_ERRORES.md | 07_Errores/ | Manejo idiomatico |
| GUIA_CONCURRENCIA.md | 10_Concurrencia/ | Fearless concurrency |
| GUIA_CARGO.md | 09_Modulos/ | Ecosystem |
| CHEAT_SHEET_RUST.md | RUST/ | Referencia rapida |

---

## Progreso Actual

### Completado
- [x] Estructura de carpetas creada
- [x] README.md principal
- [x] 01_Fundamentos/README.md
- [x] ejercicio01_variables.rs
- [x] ejercicio02_tipos_escalares.rs
- [x] ejercicio03_tipos_compuestos.rs
- [x] ejercicio04_funciones.rs

### Pendiente
- [ ] ejercicio05 - ejercicio10 (01_Fundamentos)
- [ ] Toda la carpeta 02_Ownership_Borrowing
- [ ] Toda la carpeta 03_Structs_Enums
- [ ] Toda la carpeta 04_Pattern_Matching
- [ ] Toda la carpeta 05_Traits_Generics
- [ ] Toda la carpeta 06_Colecciones
- [ ] Toda la carpeta 07_Manejo_Errores
- [ ] Toda la carpeta 08_Iteradores_Closures
- [ ] Toda la carpeta 09_Modulos_Cargo
- [ ] Toda la carpeta 10_Concurrencia
- [ ] Toda la carpeta 11_Proyectos_Complejos
- [ ] Toda la carpeta 12_Ejercicios_Debug
- [ ] CHEAT_SHEET_RUST.md
- [ ] Guias adicionales

---

## Resumen de Archivos

| Tipo | Cantidad |
|------|----------|
| Ejercicios .rs | 98 |
| README.md | 13 |
| Guias .md | 6 |
| Proyectos .md | 10 |
| **TOTAL** | ~127 |

---

## Orden de Implementacion Recomendado

1. **Fase 1:** Terminar 01_Fundamentos (6 ejercicios restantes)
2. **Fase 2:** 02_Ownership (10 ejercicios + guia) - CRITICO
3. **Fase 3:** 03_Structs y 04_Pattern (14 ejercicios)
4. **Fase 4:** 05_Traits y 06_Colecciones (16 ejercicios + guia)
5. **Fase 5:** 07_Errores y 08_Iteradores (14 ejercicios + guia)
6. **Fase 6:** 09_Modulos y 10_Concurrencia (14 ejercicios + 2 guias)
7. **Fase 7:** 11_Proyectos (10 specs)
8. **Fase 8:** 12_Debug (10 ejercicios)
9. **Fase 9:** CHEAT_SHEET_RUST.md

---

## Notas

- Cada ejercicio incluye: objetivo, instrucciones, salida esperada, bonus, solucion
- Los mini proyectos al final de cada carpeta integran todos los conceptos
- Las guias son documentos extensos con ejemplos y explicaciones profundas
- Los ejercicios de debug tienen codigo roto que el estudiante debe arreglar
