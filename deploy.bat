@echo off
set APP_NAME=ETU003344
set SRC_DIR=src
set WEB_DIR=src\webapp
set BUILD_DIR=build
set LIB_DIR=lib
set WEB1_DIR=web 
set TOMCAT_WEBAPPS="C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
set SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar
set MYSQL_API_JAR=%LIB_DIR%\mysql-connector-j-8.1.0.jar
set CLASS_NAME=main.main

REM Suppression et recréation du dossier temporaire
if exist %BUILD_DIR% rmdir /s /q %BUILD_DIR%
mkdir %BUILD_DIR%\WEB-INF\classes

REM Compilation des fichiers Java avec le JAR des Servlets
dir /s /b %SRC_DIR%\*.java > sources.txt
javac -cp "%SERVLET_API_JAR%;%MYSQL_API_JAR%" -d %BUILD_DIR%\WEB-INF\classes @sources.txt
del sources.txt

REM Copier les fichiers web
xcopy %WEB_DIR% %BUILD_DIR% /E /I /Y
xcopy %WEB1_DIR% %BUILD_DIR% /E /I /Y

REM Copier le driver MySQL dans WEB-INF/lib pour l'inclure dans le .war
mkdir %BUILD_DIR%\WEB-INF\lib
copy %MYSQL_API_JAR% %BUILD_DIR%\WEB-INF\lib\

REM Copier tous les JARs présents dans %LIB_DIR% vers WEB-INF/lib
for %%f in (%LIB_DIR%\*.jar) do (
    copy "%%f" %BUILD_DIR%\WEB-INF\lib\
)

REM Création du fichier .war dans le dossier build
cd %BUILD_DIR%
jar -cvf %APP_NAME%.war *
cd ..

REM Déploiement vers Tomcat
copy %BUILD_DIR%\%APP_NAME%.war %TOMCAT_WEBAPPS%

echo Déploiement terminé. Redémarrez Tomcat si nécessaire.

REM Exécution de la classe main après déploiement
echo Exécution de %CLASS_NAME%...
java -cp "%BUILD_DIR%\WEB-INF\classes;%SERVLET_API_JAR%;%MYSQL_API_JAR%" %CLASS_NAME%
if %ERRORLEVEL% NEQ 0 (
    echo Erreur lors de l'exécution de %CLASS_NAME%. Vérifiez le package ou les dépendances.
    pause
    exit /b %ERRORLEVEL%
)

echo Exécution de main terminée.
pause
