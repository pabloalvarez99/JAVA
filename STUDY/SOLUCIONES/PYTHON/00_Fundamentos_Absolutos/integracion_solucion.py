"""
Solucion Integracion - 00 Fundamentos Absolutos
Mini proyecto integrador: Agenda de Contactos

Este proyecto integra todos los conceptos aprendidos:
- Variables y tipos de datos
- Condicionales y bucles
- Listas y diccionarios
- Funciones
- Manejo de archivos (simulado)
- Validaciones
"""

from datetime import datetime


class Contacto:
    """Representa un contacto en la agenda."""

    def __init__(self, nombre, telefono, email="", notas=""):
        self.nombre = nombre
        self.telefono = telefono
        self.email = email
        self.notas = notas
        self.fecha_creacion = datetime.now()
        self.favorito = False

    def __str__(self):
        fav = " (Favorito)" if self.favorito else ""
        return f"{self.nombre}{fav} - {self.telefono}"

    def to_dict(self):
        """Convierte el contacto a diccionario."""
        return {
            "nombre": self.nombre,
            "telefono": self.telefono,
            "email": self.email,
            "notas": self.notas,
            "favorito": self.favorito,
            "fecha_creacion": self.fecha_creacion.isoformat(),
        }


class Agenda:
    """Gestiona una coleccion de contactos."""

    def __init__(self):
        self.contactos = []
        self.cargar_datos_ejemplo()

    def cargar_datos_ejemplo(self):
        """Carga datos de ejemplo para demostracion."""
        datos_ejemplo = [
            ("Ana Garcia", "555-0101", "ana@email.com", "Trabajo"),
            ("Carlos Lopez", "555-0102", "carlos@email.com", "Amigo"),
            ("Maria Rodriguez", "555-0103", "", "Familia"),
            ("Juan Perez", "555-0104", "juan@email.com", "Cliente"),
            ("Laura Martinez", "555-0105", "laura@email.com", "Trabajo"),
        ]

        for nombre, telefono, email, notas in datos_ejemplo:
            contacto = Contacto(nombre, telefono, email, notas)
            if nombre in ["Ana Garcia", "Laura Martinez"]:
                contacto.favorito = True
            self.contactos.append(contacto)

    def agregar_contacto(self, nombre, telefono, email="", notas=""):
        """Agrega un nuevo contacto a la agenda."""
        if not nombre or not telefono:
            return False, "Nombre y telefono son obligatorios"

        # Verificar si ya existe
        for c in self.contactos:
            if c.nombre.lower() == nombre.lower():
                return False, "El contacto ya existe"

        nuevo = Contacto(nombre, telefono, email, notas)
        self.contactos.append(nuevo)
        return True, "Contacto agregado exitosamente"

    def buscar_contacto(self, termino):
        """Busca contactos por nombre o telefono."""
        resultados = []
        termino_lower = termino.lower()

        for contacto in self.contactos:
            if termino_lower in contacto.nombre.lower() or termino in contacto.telefono:
                resultados.append(contacto)

        return resultados

    def eliminar_contacto(self, nombre):
        """Elimina un contacto por nombre."""
        for i, contacto in enumerate(self.contactos):
            if contacto.nombre.lower() == nombre.lower():
                del self.contactos[i]
                return True, "Contacto eliminado"
        return False, "Contacto no encontrado"

    def marcar_favorito(self, nombre):
        """Marca o desmarca un contacto como favorito."""
        for contacto in self.contactos:
            if contacto.nombre.lower() == nombre.lower():
                contacto.favorito = not contacto.favorito
                estado = "favorito" if contacto.favorito else "no favorito"
                return True, f"Contacto marcado como {estado}"
        return False, "Contacto no encontrado"

    def obtener_favoritos(self):
        """Retorna todos los contactos favoritos."""
        return [c for c in self.contactos if c.favorito]

    def obtener_por_categoria(self, categoria):
        """Filtra contactos por categoria/notas."""
        return [c for c in self.contactos if categoria.lower() in c.notas.lower()]

    def listar_todos(self):
        """Retorna todos los contactos ordenados por nombre."""
        return sorted(self.contactos, key=lambda c: c.nombre)

    def total_contactos(self):
        """Retorna el numero total de contactos."""
        return len(self.contactos)

    def exportar_a_string(self):
        """Exporta todos los contactos a formato texto."""
        lineas = ["=== AGENDA DE CONTACTOS ===", ""]

        for contacto in self.listar_todos():
            lineas.append(f"Nombre: {contacto.nombre}")
            lineas.append(f"Telefono: {contacto.telefono}")
            lineas.append(f"Email: {contacto.email or 'No especificado'}")
            lineas.append(f"Notas: {contacto.notas or 'Sin notas'}")
            lineas.append(f"Favorito: {'Si' if contacto.favorito else 'No'}")
            lineas.append("-" * 40)

        return "\n".join(lineas)


def mostrar_menu():
    """Muestra el menu principal."""
    print("\n" + "=" * 40)
    print("      AGENDA DE CONTACTOS")
    print("=" * 40)
    print("1. Ver todos los contactos")
    print("2. Agregar nuevo contacto")
    print("3. Buscar contacto")
    print("4. Eliminar contacto")
    print("5. Marcar como favorito")
    print("6. Ver favoritos")
    print("7. Filtrar por categoria")
    print("8. Exportar agenda")
    print("9. Estadisticas")
    print("0. Salir")
    print("=" * 40)


def ejecutar_demostracion():
    """Ejecuta una demostracion completa del sistema."""
    agenda = Agenda()

    print("\n" + "=" * 60)
    print("DEMOSTRACION DEL SISTEMA DE AGENDA")
    print("=" * 60)

    # 1. Mostrar todos los contactos
    print("\n1. CONTACTOS EXISTENTES:")
    print("-" * 40)
    for i, contacto in enumerate(agenda.listar_todos(), 1):
        print(f"{i}. {contacto}")

    # 2. Agregar nuevo contacto
    print("\n2. AGREGAR NUEVO CONTACTO:")
    exito, mensaje = agenda.agregar_contacto(
        "Pedro Sanchez", "555-0106", "pedro@email.com", "Nuevo cliente"
    )
    print(f"   Resultado: {mensaje}")

    # 3. Buscar contacto
    print("\n3. BUSCAR CONTACTO 'ana':")
    resultados = agenda.buscar_contacto("ana")
    for contacto in resultados:
        print(f"   Encontrado: {contacto}")

    # 4. Marcar favorito
    print("\n4. MARCAR 'Pedro Sanchez' COMO FAVORITO:")
    exito, mensaje = agenda.marcar_favorito("Pedro Sanchez")
    print(f"   Resultado: {mensaje}")

    # 5. Ver favoritos
    print("\n5. CONTACTOS FAVORITOS:")
    favoritos = agenda.obtener_favoritos()
    for contacto in favoritos:
        print(f"   [FAV] {contacto}")

    # 6. Filtrar por categoria
    print("\n6. CONTACTOS DE TRABAJO:")
    trabajo = agenda.obtener_por_categoria("Trabajo")
    for contacto in trabajo:
        print(f"   [WORK] {contacto}")

    # 7. Estadisticas
    print("\n7. ESTADISTICAS:")
    print(f"   Total de contactos: {agenda.total_contactos()}")
    print(f"   Favoritos: {len(agenda.obtener_favoritos())}")
    print(f"   Familia: {len(agenda.obtener_por_categoria('Familia'))}")
    print(f"   Trabajo: {len(agenda.obtener_por_categoria('Trabajo'))}")

    # 8. Exportar
    print("\n8. VISTA PREVIA DE EXPORTACION:")
    print("-" * 40)
    vista_previa = agenda.exportar_a_string().split("\n")[:10]
    for linea in vista_previa:
        print(f"   {linea}")
    print("   ...")

    print("\n" + "=" * 60)
    print("DEMOSTRACION COMPLETADA")
    print("=" * 60)


def main():
    """Funcion principal interactiva."""
    print("AGENDA DE CONTACTOS - PROYECTO INTEGRADOR")
    print("Este proyecto demuestra todos los conceptos aprendidos:")
    print("- Variables, condicionales, bucles")
    print("- Listas, diccionarios, funciones")
    print("- Clases y objetos")
    print("- Validaciones y manejo de datos")

    ejecutar_demostracion()


if __name__ == "__main__":
    main()
