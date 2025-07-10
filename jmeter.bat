@echo off
set JM_LAUNCH=ApacheJMeter.jar
set JM_START=%JM_LAUNCH%
java -jar "%~dp0%JM_START%" %*
