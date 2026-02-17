"""
Progresivos - 12_Proyecto_Integrador (Python2)
20 ejercicios progresivos para el projecto integrador.
"""


def progresivos():
    tasks = [
        {"id": 1, "titulo": "Diseño de agenda", "descripcion": "modelo de datos"},
        {
            "id": 2,
            "titulo": "CRUD básico",
            "descripcion": "crear, leer, actualizar, eliminar",
        },
        {"id": 3, "titulo": "Persistencia simple", "descripcion": "guardar en JSON"},
        {
            "id": 4,
            "titulo": "Búsqueda de contactos",
            "descripcion": "buscar por nombre",
        },
        {"id": 5, "titulo": "Filtrado por etiqueta", "descripcion": "ventas, amigos"},
        {"id": 6, "titulo": "Ordenar contactos", "descripcion": "ordena por nombre"},
        {"id": 7, "titulo": "Favoritos", "descripcion": "marcar contactos favoritos"},
        {"id": 8, "titulo": "Interfaz de consola", "descripcion": "menus simples"},
        {"id": 9, "titulo": "Importación de datos", "descripcion": "leer de archivo"},
        {"id": 10, "titulo": "Exportación", "descripcion": "exportar a JSON/CSV"},
        {"id": 11, "titulo": "Pruebas", "descripcion": "unitarias para el modelo"},
        {"id": 12, "titulo": "Patrones de diseño", "descripcion": "Strategy/Visitor"},
        {"id": 13, "titulo": "Integración con API", "descripcion": "mock API"},
        {"id": 14, "titulo": "UIT simple", "descripcion": "mock UI"},
        {"id": 15, "titulo": "Documentación", "descripcion": "README para el proyecto"},
        {"id": 16, "titulo": "Errores comunes", "descripcion": "manejo de errores"},
        {"id": 17, "titulo": "Rendimiento", "descripcion": "optimizar dobles bucles"},
        {"id": 18, "titulo": "Manejo de fechas", "descripcion": "timestamps"},
        {"id": 19, "titulo": "Datos de prueba", "descripcion": "generar datos fake"},
        {"id": 20, "titulo": "Resumen final", "descripcion": "recapitulación"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
