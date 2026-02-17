"""
Progresivos - 11_Datos_Visualizacion (Python2)
20 ejercicios progresivos de visualizacion de datos.
"""


def progresivos():
    tasks = [
        {"id": 1, "titulo": "Plot básico", "descripcion": "plt.plot([1,2,3], [4,5,6])"},
        {"id": 2, "titulo": "Barras", "descripcion": "plt.bar(...)"},
        {"id": 3, "titulo": "Histograma", "descripcion": "plt.hist([1,2,2,3])"},
        {"id": 4, "titulo": "Scatter", "descripcion": "plt.scatter(x,y)"},
        {"id": 5, "titulo": "Pie chart", "descripcion": "plt.pie(...)"},
        {"id": 6, "titulo": "Subplots", "descripcion": "plt.subplots"},
        {"id": 7, "titulo": "Tema de colores", "descripcion": "set_color"},
        {"id": 8, "titulo": "Guardar figura", "descripcion": "plt.savefig('fig.png')"},
        {"id": 9, "titulo": "Ajustes de eje", "descripcion": "set_xlim/set_ylim"},
        {"id": 10, "titulo": "Etiquetas", "descripcion": "xlabel/ylabel"},
        {"id": 11, "titulo": "Leyenda", "descripcion": "plt.legend()"},
        {"id": 12, "titulo": "Formato de salida", "descripcion": "save as pdf"},
        {"id": 13, "titulo": "Live plotting (conceptual)", "descripcion": "animación"},
        {"id": 14, "titulo": "Datos reales", "descripcion": "leer CSV"},
        {"id": 15, "titulo": "Dashboards simples", "descripcion": "stacked charts"},
        {"id": 16, "titulo": "Pandas plotting", "descripcion": "df.plot()"},
        {"id": 17, "titulo": "Interactividad", "descripcion": "mplcursors"},
        {"id": 18, "titulo": "Normalización de datos", "descripcion": "scikit-learn"},
        {"id": 19, "titulo": "Tema 3D", "descripcion": "mpl_toolkits"},
        {
            "id": 20,
            "titulo": "Resumen visualizacion",
            "descripcion": "revisar conceptos",
        },
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
