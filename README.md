![mobdev_test logo](https://raw.githubusercontent.com/moizest89/mobdev_test/master/app/src/main/res/drawable-hdpi/logo.png)

# MobDev - Prueba Tecnica

Este es un repositorio que muestra el prouecto para la prueba tecnica en MobDev como Android Developer

##Descripcion

Haciendo uso de la API publica [Dog Api] (https://dog.ceo/dog-api/), realiza lo siguinte:

- Crear una app que muestre una lista de las razas de perros disponibles  /api/breeds/list

- Al seleccionar una raza se deben mostrar las imágenes asociadas a dicha raza
/api/breed/{breed name}/images


##Solucion

Se creo una [aplicacion](https://github.com/moizest89/mobdev_test/blob/master/external/app-release.apk?raw=true) sencilla con 3 Activities

 - Splash
 - Lista de Razas
 - Lista de imagenes por raza

![image_app](https://raw.githubusercontent.com/moizest89/mobdev_test/master/external/app_view.png)

Se creo una aplicacion sencilla con 3 Activities

 - [MVP](https://www.wikiwand.com/en/Model%E2%80%93view%E2%80%93presenter)
 
En el proyecto se utilizaron las siguintes librerias:

- [Retrofit](http://square.github.io/retrofit/)
- [Okhttp3](https://github.com/square/okhttp/tree/master/okhttp/src/main/java/okhttp3)
- [Butterknife](http://jakewharton.github.io/butterknife/)
- [Picasso] (http://square.github.io/picasso/)
- [Junit] (https://mvnrepository.com/artifact/junit/junit)
- [Mockito](http://site.mockito.org/)


