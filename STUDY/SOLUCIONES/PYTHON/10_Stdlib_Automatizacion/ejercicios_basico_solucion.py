"""
Solucion basico - Stdlib y automatizacion
"""
from collections import Counter, deque


def word_count(texto):
    """Cuenta palabras con Counter."""
    return dict(Counter(texto.split()))


def queue_process(items):
    """Procesa una cola y retorna orden de salida."""
    q = deque(items)
    out = []
    while q:
        out.append(q.popleft())
    return out



def count_chars(texto):
    """Cuenta caracteres con Counter."""
    return Counter(texto)

def main():
    print("count:", word_count("a b a"))
    print("queue:", queue_process([1, 2, 3]))


if __name__ == "__main__":
    main()

