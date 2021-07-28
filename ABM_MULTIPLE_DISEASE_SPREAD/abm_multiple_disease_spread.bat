@REM 
@REM Run AnyLogic Experiment
@REM 
@SET DIR_BACKUP_XJAL=%CD%
@CD /D "%~dp0"
@SET DISK_XJAL=C:
@IF NOT [%SystemDrive%]==[] SET DISK_XJAL=%SystemDrive%
@SET PATH_XJAL="%DISK_XJAL%\Program Files\Java\jre6\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%ProgramFiles%\Java\jre6\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%DISK_XJAL%\Program Files (x86)\Java\jre6\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%ProgramFiles(x86)%\Java\jre6\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%DISK_XJAL%\Program Files\Java\jre7\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%ProgramFiles%\Java\jre7\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%DISK_XJAL%\Program Files (x86)\Java\jre7\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%ProgramFiles(x86)%\Java\jre7\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL="%JAVA_HOME%\bin\java.exe"
@IF NOT EXIST %PATH_XJAL% SET PATH_XJAL=java
%PATH_XJAL% -version:1.6+ -cp com.xj.anylogic.engine.jar;com.xj.anylogic.engine.nl.jar;com.xj.anylogic.engine.al3d.jar;model.jar;com.xj.anylogic.engine.sa.jar;lib/poi-3.6-20091214.jar;lib/poi-ooxml-3.6-20091214.jar;lib/poi-ooxml-schemas-3.6-20091214.jar;lib/xmlbeans-2.3.0.jar;lib/dom4j-1.6.1.jar;lib/geronimo-stax-api_1.0_spec-1.0.jar -Xmx8192m abm_multiple_disease_spread.Simulation %*
@CD /D "%DIR_BACKUP_XJAL%"