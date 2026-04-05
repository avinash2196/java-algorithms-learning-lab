@REM Maven Wrapper script for Windows
@REM Downloads Maven automatically if not present locally.

@echo off
setlocal

set MAVEN_WRAPPER_JAR=.mvn\wrapper\maven-wrapper.jar
set MAVEN_WRAPPER_PROPERTIES=.mvn\wrapper\maven-wrapper.properties

if not exist "%MAVEN_WRAPPER_JAR%" (
    for /f "tokens=2 delims==" %%i in ('findstr wrapperUrl "%MAVEN_WRAPPER_PROPERTIES%"') do set WRAPPER_URL=%%i
    powershell -Command "Invoke-WebRequest -Uri '%WRAPPER_URL%' -OutFile '%MAVEN_WRAPPER_JAR%'"
)

for /f "tokens=2 delims==" %%i in ('findstr distributionUrl "%MAVEN_WRAPPER_PROPERTIES%"') do set DISTRIBUTION_URL=%%i

if defined JAVA_HOME (
    set JAVA_CMD=%JAVA_HOME%\bin\java.exe
) else (
    set JAVA_CMD=java
)

"%JAVA_CMD%" -jar "%MAVEN_WRAPPER_JAR%" --distributionUrl "%DISTRIBUTION_URL%" %*
