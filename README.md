# llanquihue-tour

## Descripción general del sistema

Llanquihue Tour App es una aplicación Java orientada a objetos que permite cargar información de clientes, guías turísticos y tours desde un archivo de texto. Los datos se almacenan en colecciones (ArrayList) y pueden ser recorridos y filtrados según distintos criterios, como el tipo de tour, aplicando conceptos de encapsulamiento, composición y manejo de archivos.

## Estructura general del proyecto

```plaintext
📁 src/
├── main/
│   │── ui/          # Clase principal con el método main
│   │── model/       # Clases de dominio (Cliente, GuiaTuristico, Tour)
│   │── data/        # Clase GestorDatos para la lectura del archivo
│   └── resources/
│       └── tour.txt     # Archivo con los datos de clientes, guías y tours

````

---
## Clases e interfaces utilizadas

### Clases

- `ServicioTuristico` (superclase)
- `RutaGastronomica`
- `PaseoLacustre`
- `ExcursionCultural`
- `GestorDatos`
- `GestorEntidades`
- `Main`

### Interfaz

- `Registrable`
----



## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Maferamosp/LlanquihueTourApp.git
```

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA o NetBeans.
2. Ejecutar la clase `Main.java`.
3. Utilizar el menú mostrado mediante `JOptionPane`.
4. Seleccionar una opción para:
    - Crear una Ruta Gastronómica.
    - Crear un Paseo Lacustre.
    - Mostrar las entidades registradas.
    - Salir del programa.
