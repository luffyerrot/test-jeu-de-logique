Pour compiler le programme avec intellij idea,
il faut aller dans l'onglet fichier choisir "Projet Structure" puis dans la fenêtre qui vien de s'ouvrir aller dans "Artifacts",
ensuite cliquer sur le "+" (plus) et selectionner JAR puis "from modules with dependencies", apres cela il faut choisir la Main class
"main" puis cliquer sur OK.
Enfin il faut cliquer sur Appliquer puis OK, de retour sur l'interface d'intellij il faut aller dans l'onglet Build puis "Build Artifacts" et séléctionner build dans action.

Pour lancer le programme il faut lancer l'invite de commande puis aller dans le dossier ou se trouve le fichier .jar glisser le fichier config.properties et le fichier log4j.xml,
ensuite dans l'invite de commande il faut taper "cd out/artifacts/..." jusqu'au chemin du .jar ensuite, il faut taper "java -jar le_nom_du_jar.jar" et lancer.