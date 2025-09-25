# Alerti - App Móvil de Recordatorios

Una aplicación móvil Android moderna para gestión de recordatorios y alarmas, desarrollada con Material Design 3 y arquitectura nativa. (Solo maquetación)

## 📱 Descripción

Alerti es una aplicación de recordatorios que permite a los usuarios gestionar sus alarmas de manera intuitiva. La app incluye funcionalidades de autenticación, gestión de perfil y configuración de recordatorios personalizados.

## ✨ Características Principales

- **🔐 Autenticación completa**: Login y registro de usuarios
- **⏰ Gestión de alarmas**: Crear, editar y configurar recordatorios
- **👤 Perfil de usuario**: Cambio de contraseña y gestión de datos personales  
- **🎨 Material Design 3**: Interfaz moderna siguiendo las últimas guidelines de Google
- **📱 Diseño responsivo**: Adaptado para diferentes tamaños de pantalla
- **🔄 Navegación fluida**: Implementación con Navigation Components

## 🚀 Pantallas Disponibles

| Pantalla | Descripción |
|----------|------------|
| **Login** | Inicio de sesión de usuarios existentes |
| **Registro** | Creación de nuevas cuentas con validación |
| **Lista de Alarmas** | Vista principal con todos los recordatorios |
| **Detalle de Alarma** | Información completa de cada recordatorio |
| **Configuración de Alarma** | Ajustes y personalización de alarmas |
| **Cambio de Contraseña** | Actualización segura de credenciales |

## 🛠️ Tecnologías y Herramientas

- **Lenguaje**: Kotlin
- **SDK**: Android 35 (mínimo Android 24 - Android 7.0)
- **Arquitectura**: MVVM con Navigation Components
- **UI**: Material Design 3
- **Navegación**: Navigation Component + Bottom Navigation

### 📦 Dependencias Principales

```kotlin
- Kotlin 2.0.21
- Material Design 3: 1.12.0
- Navigation Components: 2.9.4
- ConstraintLayout: 2.2.1
- AndroidX Core: 1.16.0
```

## 🔧 Componentes Personalizados

El proyecto incluye componentes UI reutilizables:

- **`CustomTextFieldView`**: Campo de texto con manejo inteligente de placeholders largos
- **`CustomButtonView`**: Botones con variantes primary/secondary
- **`CustomDropdownView`**: Selector desplegable personalizado
- **`SuccessDialogFragment`**: Diálogo de confirmación reutilizable

## 🚀 Cómo Ejecutar el Proyecto

### 📦 APK Pre-compilado (Opción Rápida)

Si solo quieres probar la aplicación, hay un **APK listo para instalar** en la raíz del proyecto:
- `app.apk` - Instálalo directamente en tu dispositivo Android
- Requiere Android 7.0 (API 24) o superior
- Habilita "Fuentes desconocidas" en la configuración de tu dispositivo

### Prerrequisitos para Desarrollo

- **Android Studio**: Hedgehog (2023.1.1) o superior
- **Java Development Kit (JDK)**: 11 o superior
- **Android SDK**: API 35

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone [URL-DEL-REPOSITORIO]
   cd Alerti_Movil
   ```

2. **Abrir en Android Studio**
   - Abre Android Studio
   - Selecciona "Open an Existing Project"
   - Navega hasta la carpeta `Alerti_Movil` y selecciónala

3. **Sincronizar dependencias**
   - Android Studio automáticamente detectará el proyecto
   - Haz clic en "Sync Now" cuando aparezca la notificación
   - Espera a que se descarguen todas las dependencias

4. **Configurar dispositivo**
   
   **Opción A - Emulador:**
   - Ve a `Tools > AVD Manager`
   - Crea un nuevo dispositivo virtual con API 24 o superior
   - Recomendado: Pixel 6 con Android 14 (API 34)

   **Opción B - Dispositivo físico:**
   - Habilita "Opciones de desarrollador" en tu dispositivo Android
   - Activa "Depuración USB"
   - Conecta el dispositivo via USB

5. **Ejecutar la aplicación**
   - Haz clic en el botón "Run" (▶️) en Android Studio
   - O usa el atajo `Shift + F10`
   - Selecciona tu dispositivo/emulador de destino

### 🔍 Verificar Instalación

Si todo está configurado correctamente, deberías ver:
- La pantalla de login como pantalla inicial
- Navegación fluida entre pantallas
- Botones y campos de texto funcionando correctamente

## 📁 Estructura del Proyecto

```
app/src/main/
├── java/com/example/alerti/
│   ├── MainActivity.kt                 # Actividad principal
│   ├── LoginFragment.kt               # Pantalla de login
│   ├── RegisterFragment.kt            # Pantalla de registro  
│   ├── AlarmListFragment.kt           # Lista de alarmas
│   ├── AlarmDetailFragment.kt         # Detalle de alarma
│   ├── AlarmSettingsFragment.kt       # Configuración de alarma
│   ├── ChangePasswordFragment.kt      # Cambio de contraseña
│   ├── CustomTextFieldView.kt         # Campo de texto personalizado
│   ├── CustomButtonView.kt            # Botón personalizado
│   ├── CustomDropdownView.kt          # Dropdown personalizado
│   └── SuccessDialogFragment.kt       # Diálogo de éxito
├── res/
│   ├── layout/                        # Layouts XML
│   ├── values/                        # Colores, strings, estilos
│   └── navigation/                    # Gráfico de navegación
└── AndroidManifest.xml
```

## 🎨 Diseño y UX

- **Tema**: Material Design 3 con colores personalizados
- **Tipografía**: Sans-serif con jerarquía clara
- **Navegación**: Bottom Navigation + Fragment-based

## 📋 Notas Importantes

- **Permisos**: No requiere permisos especiales del sistema
- **Almacenamiento**: Actualmente usa datos de prueba (sin persistencia)

## 🤝 Contribuciones

Este es un proyecto académico de maquetación y prototipado de UX. El enfoque principal está en la implementación visual y la experiencia de usuario.

## 📄 Licencia

Proyecto académico - Universidad de los Andes

---

**Versión**: 1.0  
**Última actualización**: Diciembre 2024

