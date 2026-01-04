"""
Solucion - Integracion - Tipos y colecciones
"""

def word_counts(text):
    """Cuenta palabras y retorna dict."""
    counts = {}
    for word in text.split():
        counts[word] = counts.get(word, 0) + 1
    return counts


def top_words(counts, n):
    """Retorna top n palabras ordenadas."""
    return sorted(counts.items(), key=lambda kv: (-kv[1], kv[0]))[:n]

