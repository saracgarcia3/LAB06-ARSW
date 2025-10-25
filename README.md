# 📝​ LAB06- Spring.io, Websockets y ReactJs

Vamos ahora a realizar un tutorial para implementar una aplicación pequeña que implementa un a aplicación Web que utiliza Web Sockets. 

1. Creamos una aplicación java usando maven con el comando:

```java
  mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```
<div style="text-align:center;">
<img width="823" height="342" alt="image" src="https://github.com/user-attachments/assets/eb88eade-527d-49da-98aa-ed9600b2a802" />
</div>

2. Actualizar el pom para utilizar la configuración web-MVC de spring boot, usamos la parte de código que se nos da en el tutorial:

```java
<dependencies>
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-web</artifactId>
 <version>2.3.1.RELEASE</version>
 </dependency>
 </dependencies>
```
<div style="text-align:center;">
<img width="438" height="313" alt="image" src="https://github.com/user-attachments/assets/eb6c727c-0376-4efc-a6d6-dc53f1e2626f" />
</div>

3. Creamos la clase **WSStartApp.java** la cual iniciará el servidor de aplicaciones de Spring:
<div style="text-align:center;">
<img width="636" height="267" alt="image" src="https://github.com/user-attachments/assets/a00da082-cb36-4e0d-ae11-d1cc072cf337" />
</div>

4. Ahora seguimos con la clase **WebController.java** la cual permitirá cargar la configuración mínima Web-MVC:
<div style="text-align:center;">
<img width="672" height="430" alt="image" src="https://github.com/user-attachments/assets/a0baa455-4f4c-4370-bcaa-d6e1b4633b82" />
</div>

5. Creamos el index en la ruta correspondiente e iniciamos la ejecución:
<div style="text-align:center;">
<img width="928" height="469" alt="image" src="https://github.com/user-attachments/assets/64c05c52-5bd1-4f07-8170-10549d8990f1" />
</div>

6. Ahora probamos que el servicio este arriba, http://localhost:8080/index.html:
<div style="text-align:center;">
<img width="546" height="384" alt="image" src="https://github.com/user-attachments/assets/4100fa70-ccd2-47f9-9071-12e0fad5d959" />
</div>

7. Ahora construiremos el EndPoint el servidor con Websockets, creamos la clase **TimerEndpoint.java**:
<div style="text-align:center;">
<img width="1008" height="479" alt="image" src="https://github.com/user-attachments/assets/1925c1e1-7134-49b4-93ef-3a55e12628c4" />
</div>

8. Construimos una clase que emita mensajes desde el servidor, esta es **TimedMessageBroker.java**:
<div style="text-align:center;">
<img width="633" height="411" alt="image" src="https://github.com/user-attachments/assets/a8e15184-a687-45f6-842c-b58160dcf5aa" />
</div>

9. Ahora construimos un componente que nos ayude a configurar el contenedor IoC, sera la clase **WSConfigurator.java**:
<div style="text-align:center;">
<img width="628" height="313" alt="image" src="https://github.com/user-attachments/assets/450fc4d7-35d1-4277-8407-658e79c6d7c1" />
</div>  

10. El siguiete paso es construir el cliente Web:
<div style="text-align:center;">
<img width="621" height="446" alt="image" src="https://github.com/user-attachments/assets/988db213-800c-4850-bf56-bc9fe08566ad" />
</div>  

11. Construimos ahora el componente ReactJS:
<div style="text-align:center;">
<img width="1087" height="565" alt="image" src="https://github.com/user-attachments/assets/1ef28341-9f55-479d-b152-190afb6c15a2" />
</div>  

## ✅​ Pruebas

12. Vamos a coprobar que este funcionando, corremos el comando **mvn spring-boot:run**:
<div style="text-align:center;">
<img width="954" height="445" alt="image" src="https://github.com/user-attachments/assets/bc38bb2b-75cb-414a-bde2-b50920c85548" />
</div>

14. En otra terminal verificamos que el API este bien con el siguiente comando, **curl -i http://localhost:8080/status**:
<div style="text-align:center;">
<img width="919" height="193" alt="image" src="https://github.com/user-attachments/assets/6df1a379-c30c-4c88-9ea6-6d48debb4861" />
</div>

15. Entonces ahora usamos http://localhost:8080/:
<div style="text-align:center;">
<img width="471" height="301" alt="image" src="https://github.com/user-attachments/assets/74942485-554a-4922-946a-71997177e903" />
</div>
