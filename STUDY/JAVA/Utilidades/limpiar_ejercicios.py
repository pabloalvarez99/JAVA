#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script para limpiar ejercicios de Java
Elimina TODO el código de implementación, dejando solo:
- Comentarios e instrucciones completas
- Imports necesarios
- Declaración de clases principales
- TODOs y estructura básica
"""

import os
import sys

def limpiar_ejercicio(numero):
    """
    Limpia un ejercicio eliminando TODO el código excepto comentarios
    """
    archivo = f"Ejercicio{numero}.java"

    if not os.path.exists(archivo):
        print(f"  ⚠ {archivo} no existe, saltando...")
        return False

    try:
        with open(archivo, 'r', encoding='utf-8') as f:
            lineas = f.readlines()
    except Exception as e:
        print(f"  ❌ Error leyendo {archivo}: {e}")
        return False

    nuevo_contenido = []
    dentro_comentario_bloque = False
    encontro_clase_principal = False

    for linea in lineas:
        linea_strip = linea.strip()

        # Detectar inicio de comentario de bloque
        if '/*' in linea:
            dentro_comentario_bloque = True

        # Mantener TODO dentro de comentarios de bloque
        if dentro_comentario_bloque:
            nuevo_contenido.append(linea)
            if '*/' in linea:
                dentro_comentario_bloque = False
            continue

        # Mantener imports
        if linea_strip.startswith('import ') or linea_strip.startswith('package '):
            nuevo_contenido.append(linea)
            continue

        # Mantener comentarios de línea (instrucciones)
        if linea_strip.startswith('//'):
            nuevo_contenido.append(linea)
            continue

        # Mantener líneas vacías
        if not linea_strip:
            nuevo_contenido.append(linea)
            continue

        # Detectar clase principal (solo la primera)
        if f'public class Ejercicio{numero}' in linea and not encontro_clase_principal:
            nuevo_contenido.append(linea)
            nuevo_contenido.append('    // TODO: Lee las instrucciones arriba y escribe TODO el código\n')
            nuevo_contenido.append('    // TODO: Implementa todas las clases, métodos y lógica necesaria\n')
            nuevo_contenido.append('}\n')
            encontro_clase_principal = True
            break

    # Si no encontramos la clase principal, mantener solo comentarios
    if not encontro_clase_principal:
        nuevo_contenido.append(f'\n// TODO: Crea la clase public class Ejercicio{numero}\n')
        nuevo_contenido.append('// TODO: Implementa todo según las instrucciones\n')

    # Escribir archivo limpio
    try:
        with open(archivo, 'w', encoding='utf-8') as f:
            f.writelines(nuevo_contenido)
        print(f"  ✓ {archivo} limpiado exitosamente")
        return True
    except Exception as e:
        print(f"  ❌ Error escribiendo {archivo}: {e}")
        return False

def main():
    """Función principal"""
    print("=" * 70)
    print("  LIMPIADOR DE EJERCICIOS JAVA - Elimina TODO el código")
    print("=" * 70)
    print()
    print("Este script eliminará TODO el código de implementación de los")
    print("ejercicios 16-36, dejando SOLO los comentarios e instrucciones.")
    print()
    print("Después de ejecutar este script, tendrás que escribir el 100%")
    print("del código tú mismo, basándote en las instrucciones.")
    print()

    # Verificar cuántos archivos existen
    ejercicios_existentes = []
    for num in range(16, 37):
        if os.path.exists(f"Ejercicio{num}.java"):
            ejercicios_existentes.append(num)

    if not ejercicios_existentes:
        print("❌ No se encontraron ejercicios (16-36) en este directorio")
        return

    print(f"Ejercicios encontrados: {len(ejercicios_existentes)}")
    print(f"  Rango: Ejercicio{min(ejercicios_existentes)} a Ejercicio{max(ejercicios_existentes)}")
    print()

    # Confirmar
    respuesta = input("¿Deseas continuar con la limpieza? (s/n): ")

    if respuesta.lower() not in ['s', 'si', 'y', 'yes']:
        print("\n❌ Operación cancelada por el usuario")
        return

    print()
    print("Limpiando ejercicios...")
    print()

    exitosos = 0
    fallidos = 0

    for num in ejercicios_existentes:
        if limpiar_ejercicio(num):
            exitosos += 1
        else:
            fallidos += 1

    print()
    print("=" * 70)
    print("  LIMPIEZA COMPLETADA")
    print("=" * 70)
    print(f"  ✓ Exitosos: {exitosos}")
    if fallidos > 0:
        print(f"  ❌ Fallidos: {fallidos}")
    print()
    print("Ahora todos los ejercicios contienen SOLO comentarios e instrucciones.")
    print("¡Es hora de programar! Escribe el 100% del código tú mismo.")
    print()

if __name__ == "__main__":
    main()
