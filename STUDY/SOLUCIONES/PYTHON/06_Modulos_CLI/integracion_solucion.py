"""
Solucion - Integracion - Modulos y CLI
"""
import argparse


def build_cli():
    parser = argparse.ArgumentParser()
    sub = parser.add_subparsers(dest="cmd")
    add = sub.add_parser("add")
    add.add_argument("titulo")
    ls = sub.add_parser("list")
    ls.add_argument("--hechas", action="store_true")
    return parser


def parse_cli(argv=None):
    """Parsea argv y retorna args."""
    parser = build_cli()
    return parser.parse_args(argv)

