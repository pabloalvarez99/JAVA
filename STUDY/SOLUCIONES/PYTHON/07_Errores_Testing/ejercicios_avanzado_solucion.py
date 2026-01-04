"""
Solucion avanzado - Errores y testing
"""

def collect_errors(validators, data):
    """Ejecuta validadores y retorna lista de errores."""
    errores = []
    for fn in validators:
        try:
            fn(data)
        except Exception as exc:
            errores.append(str(exc))
    return errores


def validate_user(user):
    """Valida campos y retorna lista de errores."""
    def validar_nombre(u):
        if not u.get("nombre"):
            raise ValueError("nombre vacio")

    def validar_edad(u):
        edad = u.get("edad", -1)
        if edad < 0 or edad > 120:
            raise ValueError("edad invalida")

    return collect_errors([validar_nombre, validar_edad], user)



def validate_types(user, schema):
    """Valida tipos segun schema y retorna lista de errores."""
    errores = []
    for key, tipo in schema.items():
        if key not in user:
            errores.append(f"falta {key}")
            continue
        if not isinstance(user[key], tipo):
            errores.append(f"tipo invalido {key}")
    return errores

def main():
    user = {"nombre": "", "edad": -1}
    print("errores:", validate_user(user))


if __name__ == "__main__":
    main()

