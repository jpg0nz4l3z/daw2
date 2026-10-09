Git — Guía práctica de comandos para el día a día

Guía rápida de los comandos Git más utilizados, con ejemplos prácticos.

1. Configuración inicial
Configurar nombre y email
git config --global user.name "Tu Nombre"
git config --global user.email "tu@email.com"

Ver configuración
git config --list

Configurar el editor
git config --global core.editor "code --wait"

2. Crear o descargar un repositorio
git init

Inicializa un repositorio Git en la carpeta actual.

mkdir mi-proyecto
cd mi-proyecto
git init

git clone

Clona un repositorio existente.

git clone https://github.com/usuario/proyecto.git


Ejemplo:

git clone https://github.com/empresa/backend.git
cd backend

3. Comprobar el estado
git status

Muestra el estado actual del repositorio.

git status


Ejemplo:

On branch main

Changes not staged for commit:
  modified:   app.js


Es recomendable ejecutarlo frecuentemente.

4. Ver cambios
git diff

Muestra cambios que todavía no están en staging.

git diff


Ejemplo:

- const port = 3000;
+ const port = 8080;

git diff --staged

Muestra los cambios preparados para el próximo commit.

git diff --staged

git diff HEAD

Muestra todos los cambios respecto al último commit.

git diff HEAD

5. Añadir cambios al staging
git add archivo

Añade un archivo concreto.

git add app.js

git add .

Añade todos los cambios del directorio actual.

git add .

Añadir varios archivos
git add app.js index.html styles.css

6. Crear commits
git commit

Guarda los cambios que están en staging.

git commit -m "Añadir validación del formulario"


Flujo habitual:

git status
git add .
git commit -m "Corregir validación del formulario"

Buen mensaje de commit
git commit -m "Añadir autenticación con JWT"


Evita mensajes poco descriptivos:

git commit -m "cambios"
git commit -m "cosas"
git commit -m "fix"

7. Ver el historial
git log

Muestra el historial completo.

git log

git log --oneline

Muestra el historial de forma resumida.

git log --oneline


Ejemplo:

a81f3c2 Añadir autenticación
73bd921 Corregir error en login
2f91a42 Crear estructura inicial

git log --oneline --graph --all

Muestra las ramas gráficamente.

git log --oneline --graph --all


Ejemplo:

* a81f3c2 (HEAD -> feature/login) Añadir autenticación
| * 91bc123 (main) Actualizar README
|/
* 73bd921 Corregir configuración

git show

Muestra los cambios realizados en un commit.

git show a81f3c2


Para ver el último commit:

git show HEAD

8. Trabajar con ramas
git branch

Lista las ramas locales.

git branch


Ejemplo:

* main
  feature/login
  feature/payment

Crear una rama
git branch feature/login


Esto crea la rama pero no cambia a ella.

git switch

Cambiar de rama.

git switch feature/login

Crear y cambiar a una rama

Forma recomendada:

git switch -c feature/login


Equivale a:

git branch feature/login
git switch feature/login

git branch -d

Eliminar una rama local.

git branch -d feature/login

git branch -D

Forzar la eliminación de una rama.

git branch -D feature/login


⚠️ Úsalo con cuidado porque puede eliminar trabajo que todavía no hayas integrado.

9. Repositorios remotos
git remote -v

Muestra los repositorios remotos configurados.

git remote -v


Ejemplo:

origin  https://github.com/usuario/proyecto.git (fetch)
origin  https://github.com/usuario/proyecto.git (push)

Añadir un remoto
git remote add origin https://github.com/usuario/proyecto.git

Cambiar la URL del remoto
git remote set-url origin https://github.com/usuario/nuevo-repo.git

10. Descargar cambios
git fetch

Descarga información del remoto sin modificar tu rama actual.

git fetch origin


Ejemplo:

git fetch origin
git log --oneline --all


Es útil para comprobar qué cambios existen en remoto antes de integrarlos.

git pull

Descarga e integra cambios del repositorio remoto.

git pull


También puedes especificar remoto y rama:

git pull origin main

11. Subir cambios
git push

Sube tus commits al repositorio remoto.

git push

Primera vez que subes una rama
git push -u origin feature/login


Después podrás utilizar simplemente:

git push

12. Fusionar ramas
git merge

Integra una rama dentro de otra.

Ejemplo: fusionar feature/login en main.

git switch main
git merge feature/login


Si no existen conflictos, Git realizará la integración automáticamente.

13. Rebase
git rebase

Recoloca tus commits encima de otra rama.

git switch feature/login
git rebase main


Antes:

A---B---C---D  main
     \
      E---F    feature/login


Después:

A---B---C---D---E'---F'  feature/login


⚠️ rebase reescribe el historial. Evita hacer rebase de commits que otras personas estén utilizando en una rama compartida.

14. Deshacer cambios
git restore archivo

Descarta cambios locales de un archivo que todavía no has commiteado.

git restore app.js


⚠️ Los cambios descartados de esta forma pueden ser difíciles de recuperar.

git restore --staged

Saca un archivo del staging sin eliminar sus cambios.

git restore --staged app.js


Por ejemplo:

git add app.js
git restore --staged app.js


El archivo seguirá modificado, pero ya no estará preparado para el commit.

15. Deshacer commits
git revert

Crea un nuevo commit que deshace otro commit.

git revert a81f3c2


Es especialmente recomendable para commits que ya has subido al repositorio remoto.

Ejemplo:

A---B---C---D
        |
        C se revierte

A---B---C---D---E
                |
                E deshace C

git reset --soft

Deshace el último commit pero mantiene los cambios en staging.

git reset --soft HEAD~1

git reset --mixed

Deshace el último commit y saca los cambios del staging.

git reset --mixed HEAD~1


También es el comportamiento por defecto:

git reset HEAD~1

git reset --hard

Deshace el commit y elimina los cambios.

git reset --hard HEAD~1


⚠️ Mucho cuidado con --hard: puedes perder trabajo.

16. Guardar trabajo temporalmente
git stash

Guarda temporalmente cambios sin crear un commit.

git stash


Ejemplo:

# Estás trabajando en una funcionalidad
git status

# Necesitas cambiar de rama
git stash

git switch main

# Más tarde vuelves
git switch feature/login
git stash pop

git stash list

Muestra los stashes existentes.

git stash list


Ejemplo:

stash@{0}: WIP on feature/login
stash@{1}: WIP on feature/payment

git stash pop

Recupera el último stash y lo elimina de la lista.

git stash pop

git stash apply

Recupera un stash pero lo mantiene guardado.

git stash apply stash@{0}

git stash drop

Elimina un stash.

git stash drop stash@{0}

17. Eliminar y mover archivos
git rm

Elimina un archivo y registra la eliminación en Git.

git rm archivo.txt


Después:

git commit -m "Eliminar archivo antiguo"

git mv

Mueve o renombra un archivo.

git mv antiguo.js nuevo.js


Después:

git commit -m "Renombrar módulo"

18. Buscar dentro del proyecto
git grep

Busca texto dentro de los archivos controlados por Git.

git grep "TODO"


Otro ejemplo:

git grep "console.log"

19. Saber quién modificó una línea
git blame

Muestra qué commit modificó cada línea de un archivo.

git blame app.js


Ejemplo:

a81f3c2 (Ana García 2026-09-16) const port = 8080;
73bd921 (Juan Pérez 2026-09-15) const host = "localhost";


Es muy útil para investigar el origen de un cambio.

20. Tags y versiones
git tag

Lista los tags existentes.

git tag

Crear un tag
git tag v1.0.0

Crear un tag anotado
git tag -a v1.0.0 -m "Versión 1.0.0"

Subir un tag
git push origin v1.0.0


O todos los tags:

git push --tags

21. Limpiar archivos no controlados
git clean -n

Muestra qué archivos eliminaría sin eliminarlos.

git clean -n

git clean -f

Elimina archivos no controlados por Git.

git clean -f


⚠️ Utilízalo con cuidado.

22. Comparar ramas
Ver diferencias entre dos ramas
git diff main..feature/login

Ver commits que están en una rama pero no en otra
git log main..feature/login

Ver commits locales que todavía no has subido
git log origin/main..HEAD

Ver commits remotos que todavía no tienes
git log HEAD..origin/main

23. Ramas remotas
Ver ramas remotas
git branch -r

Ver todas las ramas
git branch -a

Ver información de seguimiento
git branch -vv


Ejemplo:

* feature/login  a81f3c2 [origin/feature/login] Añadir login
  main           91bc123 [origin/main] Actualizar README

24. El flujo de trabajo diario

Un flujo habitual para empezar una tarea:

# Actualizar main
git switch main
git pull

# Crear rama
git switch -c feature/nuevo-login

# Trabajar en el código...

# Revisar cambios
git status
git diff

# Preparar cambios
git add .

# Revisar exactamente lo que vas a commitear
git diff --staged

# Crear commit
git commit -m "Añadir formulario de login"

# Subir rama
git push -u origin feature/nuevo-login


Después puedes crear un Pull Request / Merge Request.

Cuando la rama se haya integrado:

git switch main
git pull

git branch -d feature/nuevo-login

25. Flujo rápido

Cuando ya tienes experiencia y sabes exactamente qué has cambiado:

git status
git add .
git commit -m "Descripción del cambio"
git push

26. Flujo con varios cambios

Supongamos que has modificado:

src/login.js
src/user.js
README.md


Puedes revisar:

git status
git diff


Añadir solamente el código:

git add src/login.js src/user.js


Comprobar:

git diff --staged


Crear el commit:

git commit -m "Implementar autenticación de usuarios"


Después puedes crear otro commit para el README:

git add README.md
git commit -m "Actualizar documentación de autenticación"


Y finalmente:

git push

27. Resolver un conflicto de merge

Si haces:

git merge feature/login


y Git encuentra un conflicto:

CONFLICT (content): Merge conflict in src/login.js


Primero:

git status


Abre el archivo conflictivo. Encontrarás algo parecido a:

<<<<<<< HEAD
const timeout = 3000;
=======
const timeout = 5000;
>>>>>>> feature/login


Decides qué código quieres conservar y eliminas los marcadores:

const timeout = 5000;


Después:

git add src/login.js
git commit


Si quieres cancelar el merge:

git merge --abort

28. Resolver un conflicto durante rebase

Si ocurre durante un rebase:

git status


Corriges el archivo y después:

git add src/login.js
git rebase --continue


Para cancelar todo el rebase:

git rebase --abort

29. Recuperar trabajo perdido
git reflog

Muestra movimientos anteriores de HEAD.

git reflog


Ejemplo:

a81f3c2 HEAD@{0}: commit: Añadir login
73bd921 HEAD@{1}: checkout: moving from main to feature/login
91bc123 HEAD@{2}: commit: Actualizar README


Es uno de los comandos más útiles cuando accidentalmente haces un reset, rebase, etc.

Por ejemplo:

git reflog


Encuentras:

a81f3c2 HEAD@{5}


Puedes recuperar ese estado creando una rama:

git branch recuperacion a81f3c2

30. Comandos que conviene memorizar
Comando	Para qué sirve
git status	Ver estado del repositorio
git add	Añadir cambios al staging
git commit	Crear un commit
git push	Subir cambios
git pull	Descargar e integrar cambios
git fetch	Descargar cambios sin integrarlos
git clone	Clonar un repositorio
git switch	Cambiar de rama
git branch	Gestionar ramas
git merge	Fusionar ramas
git rebase	Reorganizar el historial
git diff	Ver diferencias
git log	Ver historial
git stash	Guardar cambios temporalmente
git restore	Descartar/restaurar cambios
git revert	Deshacer un commit mediante otro commit
git reset	Mover HEAD y deshacer commits
git tag	Crear versiones
git reflog	Recuperar estados anteriores
31. Chuleta rápida
# CONFIGURACIÓN
git config --global user.name "Nombre"
git config --global user.email "email"

# CREAR / CLONAR
git init
git clone URL

# ESTADO
git status

# CAMBIOS
git diff
git diff --staged

# STAGING
git add archivo
git add .

# COMMIT
git commit -m "Mensaje"

# HISTORIAL
git log
git log --oneline
git log --oneline --graph --all
git show COMMIT

# RAMAS
git branch
git branch nombre
git switch nombre
git switch -c nombre
git branch -d nombre

# REMOTO
git remote -v
git fetch
git pull
git push

# MERGE
git merge rama

# REBASE
git rebase main

# DESHACER
git restore archivo
git restore --staged archivo
git revert COMMIT
git reset --soft HEAD~1
git reset --mixed HEAD~1
git reset --hard HEAD~1

# STASH
git stash
git stash list
git stash pop
git stash apply

# ARCHIVOS
git rm archivo
git mv antiguo nuevo

# BÚSQUEDA
git grep "texto"
git blame archivo

# TAGS
git tag
git tag v1.0.0
git push --tags

# RECUPERACIÓN
git reflog

32. La regla mental de Git

Puedes pensar en Git como cuatro zonas:

┌─────────────────┐
│   Working Tree   │
│   tus archivos   │
└────────┬────────┘
         │ git add
         ▼
┌─────────────────┐
│     Staging      │
│ cambios a guardar│
└────────┬────────┘
         │ git commit
         ▼
┌─────────────────┐
│ Local Repository │
│    commits       │
└────────┬────────┘
         │ git push
         ▼
┌─────────────────┐
│ Remote Repository│
│ GitHub / GitLab  │
└─────────────────┘


Y para traer cambios:

Remote
  │
  │ git fetch
  ▼
Local


o directamente:

Remote
  │
  │ git pull
  ▼
Local + integración


La secuencia fundamental que conviene memorizar es:

git status
git add .
git commit -m "Descripción del cambio"
git push


Para trabajo con ramas:

git switch main
git pull
git switch -c feature/mi-tarea

# trabajar...

git add .
git commit -m "Implementar mi tarea"
git push -u origin feature/mi-tarea



Ver las ramas remotas
git branch -r

Te mostrará algo como:

origin/main
origin/develop
origin/feature/login

Traerte/actualizar todas las ramas remotas
git fetch --all

Esto descarga la información de las ramas remotas, pero no crea automáticamente ramas locales.

Crear una rama local a partir de una remota
Por ejemplo, para origin/develop:

git switch -c develop --track origin/develop

A partir de ahí tendrás una rama local develop vinculada a origin/develop.

Puedes comprobarlo con:

git branch -a

que mostrará tanto las locales como las remotas.

Resumen: git fetch --all → actualiza las ramas remotas; git switch -c ... --track ... → te crea la rama local para trabajar en ella.

git push origin -d nombre-de-la-rama
git branch -d nombre-de-la-rama
git fetch --prune

### subir rama al repo
git push --set-upstream origin test1



# Inicializa Git en tu carpeta (si no lo habías hecho antes)
git init

# Prepara todos tus archivos
git add .

# Guarda los cambios localmente con un mensaje
git commit -m "primer commit"

# Asegúrate de que tu rama principal se llame main
git branch -M main

# Conecta tu repositorio local con el enlace de GitHub (reemplaza la URL por la tuya)
git remote add origin https://github.com

# Sube tus archivos por primera vez
git push -u origin main