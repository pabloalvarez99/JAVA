"""
Ejercicios extra - Modulos y CLI
"""
import argparse


def build_parser():
    parser = argparse.ArgumentParser()
    sub = parser.add_subparsers(dest="cmd")
    add = sub.add_parser("add")
    # TODO: agrega argumento "--titulo"
    ls = sub.add_parser("list")
    # TODO: agrega flag "--hechas"
    return parser


def parse_key_value(items):
    """Convierte ['a=1', 'b=2'] a dict."""
    # TODO: ignora items sin '='
    return {}


def add_global_args(parser):
    """Agrega flags --verbose y --config."""
    # TODO: implementa la logica
    return parser


def build_echo_parser():
    """Parser para comando echo con flag --upper."""
    # TODO: implementa la logica
    return argparse.ArgumentParser()


def run_echo(text, upper=False):
    """Retorna texto, en mayusculas si upper."""
    # TODO: implementa la logica
    return ""



def parse_list(text):
    """Convierte "a, b, c" en lista limpia."""
    # TODO: implementa la logica
    return []


def normalize_flags(flags):
    """Normaliza flags a minusculas sin duplicados."""
    # TODO: implementa la logica
    return []

def main(argv=None):
    parser = build_parser()
    args = parser.parse_args(argv)
    print("cmd:", args.cmd)


if __name__ == "__main__":
    main(["add", "--titulo", "leer"])

