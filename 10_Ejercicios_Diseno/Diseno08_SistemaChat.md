# EJERCICIO DISENO #8: Sistema de Chat
**Dificultad: ⭐⭐⭐⭐**

## Requerimientos

Disenar un sistema de chat en tiempo real:

1. **Usuarios**
   - Username unico
   - Estado: Online, Offline, Ausente
   - Lista de contactos/amigos

2. **Mensajes**
   - Texto, imagen, archivo
   - Timestamp
   - Estados: Enviado, Entregado, Leido

3. **Conversaciones**
   - Chat 1 a 1
   - Chat grupal (multiples usuarios)
   - Historial de mensajes

4. **Funcionalidades**
   - Notificaciones de nuevo mensaje
   - "Escribiendo..." indicator
   - Busqueda en historial

---

## PARTE 1: Tu Diseno

### 1.1 Mensajes polimorficos
```
MensajeTexto vs MensajeImagen vs MensajeArchivo

Herencia, Interfaz, o Composicion?
_______________
```

### 1.2 Chat 1-1 vs Grupal
```
Misma clase Conversacion o clases separadas?
_______________
```

---

## PARTE 2: Solucion Propuesta (NO MIRAR ANTES)

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum EstadoUsuario { ONLINE, OFFLINE, AUSENTE }
enum EstadoMensaje { ENVIADO, ENTREGADO, LEIDO }
enum TipoMensaje { TEXTO, IMAGEN, ARCHIVO }

class Usuario {
    private String id;
    private String username;
    private EstadoUsuario estado;
    private Set<String> contactos = new HashSet<>();
    private LocalDateTime ultimaConexion;

    public Usuario(String username) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.estado = EstadoUsuario.OFFLINE;
    }

    public void conectar() {
        estado = EstadoUsuario.ONLINE;
        ultimaConexion = LocalDateTime.now();
    }

    public void desconectar() {
        estado = EstadoUsuario.OFFLINE;
        ultimaConexion = LocalDateTime.now();
    }

    public void agregarContacto(String usuarioId) {
        contactos.add(usuarioId);
    }

    // getters...
}

// Clase base para mensajes
abstract class Mensaje {
    protected String id;
    protected String remitenteId;
    protected String conversacionId;
    protected LocalDateTime timestamp;
    protected EstadoMensaje estado;

    public Mensaje(String remitenteId, String conversacionId) {
        this.id = UUID.randomUUID().toString();
        this.remitenteId = remitenteId;
        this.conversacionId = conversacionId;
        this.timestamp = LocalDateTime.now();
        this.estado = EstadoMensaje.ENVIADO;
    }

    public void marcarEntregado() {
        if (estado == EstadoMensaje.ENVIADO) {
            estado = EstadoMensaje.ENTREGADO;
        }
    }

    public void marcarLeido() {
        estado = EstadoMensaje.LEIDO;
    }

    public abstract TipoMensaje getTipo();
    public abstract String getPreview(); // Para mostrar en lista

    // getters...
}

class MensajeTexto extends Mensaje {
    private String contenido;

    public MensajeTexto(String remitenteId, String conversacionId, String contenido) {
        super(remitenteId, conversacionId);
        this.contenido = contenido;
    }

    @Override
    public TipoMensaje getTipo() { return TipoMensaje.TEXTO; }

    @Override
    public String getPreview() {
        return contenido.length() > 50 ?
            contenido.substring(0, 47) + "..." : contenido;
    }

    public String getContenido() { return contenido; }
}

class MensajeImagen extends Mensaje {
    private String urlImagen;
    private String caption;

    public MensajeImagen(String remitenteId, String conversacionId,
                        String urlImagen, String caption) {
        super(remitenteId, conversacionId);
        this.urlImagen = urlImagen;
        this.caption = caption;
    }

    @Override
    public TipoMensaje getTipo() { return TipoMensaje.IMAGEN; }

    @Override
    public String getPreview() { return "[Imagen] " + (caption != null ? caption : ""); }
}

class MensajeArchivo extends Mensaje {
    private String nombreArchivo;
    private String urlArchivo;
    private long tamanoBytes;

    public MensajeArchivo(String remitenteId, String conversacionId,
                         String nombre, String url, long tamano) {
        super(remitenteId, conversacionId);
        this.nombreArchivo = nombre;
        this.urlArchivo = url;
        this.tamanoBytes = tamano;
    }

    @Override
    public TipoMensaje getTipo() { return TipoMensaje.ARCHIVO; }

    @Override
    public String getPreview() { return "[Archivo] " + nombreArchivo; }
}

class Conversacion {
    private String id;
    private String nombre; // null para chat 1-1
    private Set<String> participantes;
    private List<Mensaje> mensajes = new ArrayList<>();
    private Map<String, LocalDateTime> ultimaLectura = new HashMap<>();
    private boolean esGrupo;

    // Chat 1-1
    public Conversacion(String usuario1, String usuario2) {
        this.id = UUID.randomUUID().toString();
        this.participantes = new HashSet<>(Set.of(usuario1, usuario2));
        this.esGrupo = false;
    }

    // Chat grupal
    public Conversacion(String nombre, Set<String> participantes) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.participantes = new HashSet<>(participantes);
        this.esGrupo = true;
    }

    public void agregarMensaje(Mensaje mensaje) {
        if (!participantes.contains(mensaje.getRemitenteId())) {
            throw new IllegalStateException("Usuario no es participante");
        }
        mensajes.add(mensaje);
    }

    public void marcarLeido(String usuarioId) {
        ultimaLectura.put(usuarioId, LocalDateTime.now());

        // Marcar mensajes como leidos (excepto los propios)
        for (Mensaje m : mensajes) {
            if (!m.getRemitenteId().equals(usuarioId)) {
                m.marcarLeido();
            }
        }
    }

    public int getMensajesNoLeidos(String usuarioId) {
        LocalDateTime ultima = ultimaLectura.getOrDefault(usuarioId, LocalDateTime.MIN);
        return (int) mensajes.stream()
            .filter(m -> m.getTimestamp().isAfter(ultima))
            .filter(m -> !m.getRemitenteId().equals(usuarioId))
            .count();
    }

    public Mensaje getUltimoMensaje() {
        return mensajes.isEmpty() ? null : mensajes.get(mensajes.size() - 1);
    }

    public List<Mensaje> buscarMensajes(String texto) {
        return mensajes.stream()
            .filter(m -> m instanceof MensajeTexto)
            .map(m -> (MensajeTexto) m)
            .filter(m -> m.getContenido().toLowerCase().contains(texto.toLowerCase()))
            .map(m -> (Mensaje) m)
            .toList();
    }

    public void agregarParticipante(String usuarioId) {
        if (!esGrupo) {
            throw new IllegalStateException("No se puede agregar a chat 1-1");
        }
        participantes.add(usuarioId);
    }
}

// Observador para notificaciones
interface ChatObserver {
    void onNuevoMensaje(Mensaje mensaje, Conversacion conversacion);
    void onUsuarioEscribiendo(String usuarioId, String conversacionId);
    void onCambioEstado(Usuario usuario);
}

class SistemaChat {
    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<String, Conversacion> conversaciones = new HashMap<>();
    private List<ChatObserver> observers = new ArrayList<>();

    // Mapa de conversaciones por usuario para acceso rapido
    private Map<String, Set<String>> conversacionesPorUsuario = new HashMap<>();

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        conversacionesPorUsuario.put(usuario.getId(), new HashSet<>());
    }

    public Conversacion iniciarChat(String usuario1, String usuario2) {
        // Verificar si ya existe conversacion entre ellos
        String existente = encontrarConversacion1a1(usuario1, usuario2);
        if (existente != null) {
            return conversaciones.get(existente);
        }

        Conversacion conv = new Conversacion(usuario1, usuario2);
        conversaciones.put(conv.getId(), conv);

        conversacionesPorUsuario.get(usuario1).add(conv.getId());
        conversacionesPorUsuario.get(usuario2).add(conv.getId());

        return conv;
    }

    public Conversacion crearGrupo(String nombre, Set<String> participantes) {
        Conversacion grupo = new Conversacion(nombre, participantes);
        conversaciones.put(grupo.getId(), grupo);

        for (String p : participantes) {
            conversacionesPorUsuario.get(p).add(grupo.getId());
        }

        return grupo;
    }

    public void enviarMensaje(Mensaje mensaje) {
        Conversacion conv = conversaciones.get(mensaje.getConversacionId());
        conv.agregarMensaje(mensaje);

        // Notificar observadores
        for (ChatObserver obs : observers) {
            obs.onNuevoMensaje(mensaje, conv);
        }

        // Marcar como entregado para usuarios online
        for (String participante : conv.getParticipantes()) {
            if (!participante.equals(mensaje.getRemitenteId())) {
                Usuario u = usuarios.get(participante);
                if (u.getEstado() == EstadoUsuario.ONLINE) {
                    mensaje.marcarEntregado();
                }
            }
        }
    }

    public void notificarEscribiendo(String usuarioId, String conversacionId) {
        for (ChatObserver obs : observers) {
            obs.onUsuarioEscribiendo(usuarioId, conversacionId);
        }
    }

    public List<Conversacion> getConversacionesDeUsuario(String usuarioId) {
        return conversacionesPorUsuario.get(usuarioId).stream()
            .map(conversaciones::get)
            .sorted((c1, c2) -> {
                Mensaje m1 = c1.getUltimoMensaje();
                Mensaje m2 = c2.getUltimoMensaje();
                if (m1 == null) return 1;
                if (m2 == null) return -1;
                return m2.getTimestamp().compareTo(m1.getTimestamp());
            })
            .toList();
    }

    private String encontrarConversacion1a1(String u1, String u2) {
        Set<String> convsU1 = conversacionesPorUsuario.get(u1);
        Set<String> convsU2 = conversacionesPorUsuario.get(u2);

        for (String convId : convsU1) {
            if (convsU2.contains(convId)) {
                Conversacion conv = conversaciones.get(convId);
                if (!conv.isEsGrupo()) {
                    return convId;
                }
            }
        }
        return null;
    }

    public void agregarObserver(ChatObserver observer) {
        observers.add(observer);
    }
}
```

### Patrones Aplicados
- **Observer**: Notificaciones en tiempo real
- **Template Method (implicit)**: Mensaje.getPreview()
- **Factory Method**: Podria crear mensajes via factory

### Extensiones
- Mensajes de voz
- Reacciones a mensajes
- Mensajes citados
- Encriptacion E2E
- Mensajes que desaparecen
