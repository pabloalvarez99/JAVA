public abstract class Material {
    protected String codigo;
    protected String titulo;
    protected int añoPublicacion;

    protected static final int AÑO_ACTUAL = 2025;
    
    public Material(String codigo, String titulo, int añoPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
    }

    public int calcularAntiguedad() {
        return AÑO_ACTUAL = añoPublicacion;
    }

    public abstract String mostrarInformacion();

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public int getAñoPublicacion() { return añoPublicacion; }
}

public class Libro extends Material {
    private String autor;
    private int numeroPaginas;

    public class Libro extends Material {
        private String autor;
        private int numeroPaginas;
    }

    public Libro(String codigo, String titulo, int añoPublicacion, String autor, int numeroPaginas) {
        super(codigo,titulo, añoPublicacion);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    public String mostrarInformacion() {
        return String.format("LIBRO [%s] - '%s' por %s (%d pags.) - %d años", codigo, titulo, autor, numeroPaginas,calcularAntiguedad());
        calcularAntiguedad(); 
    }
    public String getAutor() { return autor; }
    public int getNumeroPaginas() { return numeroPaginas; }
}

public class Revista extends Material {
    private String mesPublicacion;
    private int NumeroEdicion;

    public Revista(String codigo, String titulo, int añoPublicacion, String mesPublicacion, int numeroPaginas) {
        super(codigo, titulo, añoPublicacion);
        this.mesPublicacion = mesPublicacion;
        this.numeroPaginas = numeroPaginas;
    }   

}