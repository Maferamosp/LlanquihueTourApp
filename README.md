# llanquihue-tour

## Descripción general del sistema

Llanquihue Tour App es una aplicación Java orientada a objetos que permite cargar información de clientes, guías turísticos y tours desde un archivo de texto. Los datos se almacenan en colecciones (ArrayList) y pueden ser recorridos y filtrados según distintos criterios, como el tipo de tour, aplicando conceptos de encapsulamiento, composición y manejo de archivos.

## Estructura general del proyecto

```plaintext
📁 src/
├── ui/          # Clase principal con el método main
├── model/       # Clases de dominio (Cliente, GuiaTuristico, Tour)
├── data/        # Clase GestorDatos para la lectura del archivo
📁 resources/
├── tour.txt     # Archivo con los datos de clientes, guías y tours

````

---


## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Maferamosp/LlanquihueTourApp.git
```

2. Abre el proyecto en IntelliJ IDEA.

3. Ejecuta el archivo `Main.java` desde el paquete `ui`.

4. Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).
