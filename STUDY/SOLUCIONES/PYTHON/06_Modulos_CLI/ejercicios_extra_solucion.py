"""
Solucion - Modulos y CLI (extra)
"""
import argparse


def build_parser():
    parser = argparse.ArgumentParser()
    sub = parser.add_subparsers(dest="cmd")
    add = sub.add_parser("add")
    add.add_argument("--titulo", required=True)
    ls = sub.add_parser("list")
    ls.add_argument("--hechas", action="store_true")
    return parser


def parse_key_value(items):
    """Convierte ['a=1', 'b=2'] a dict."""
    res = {}
    for item in items:
        if "=" not in item:
            continue
        key, value = item.split("=", 1)
        if key:
            res[key] = value
    return res


def add_global_args(parser):
    """Agrega flags --verbose y --config."""
    parser.add_argument("--verbose", action="store_true")
    parser.add_argument("--config")
    return parser


def build_echo_parser():
    """Parser para comando echo con flag --upper."""
    parser = argparse.ArgumentParser()
    parser.add_argument("text")
    parser.add_argument("--upper", action="store_true")
    return parser


def run_echo(text, upper=False):
    """Retorna texto, en mayusculas si upper."""
    return text.upper() if upper else text



def parse_list(text):
    """Convierte "a, b, c" en lista limpia."""
    if not text:
        return []
    return [part.strip() for part in text.split(",") if part.strip()]


def normalize_flags(flags):
    """Normaliza flags a minusculas sin duplicados."""
    seen = set()
    out = []
    for flag in flags:
        key = flag.strip().lower()
        if key and key not in seen:
            seen.add(key)
            out.append(key)
    return out

def main(argv=None):
    parser = build_parser()
    args = parser.parse_args(argv)
    print("cmd:", args.cmd)


if __name__ == "__main__":
    main(["add", "--titulo", "leer"])

