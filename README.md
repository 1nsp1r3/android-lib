# Usage
At your project root, create this file `update.cmd`

```
@ECHO OFF

RMDIR /Q /S app\src\main\java\org\inspir3\common\
MKDIR app\src\main\java\org\inspir3\common\

XCOPY /S C:\src\android-lib\org\inspir3\common\file\                 app\src\main\java\org\inspir3\common\file\
XCOPY /S C:\src\android-lib\org\inspir3\common\I3.kt                 app\src\main\java\org\inspir3\common\
XCOPY /S C:\src\android-lib\org\inspir3\common\ForegroundService.kt  app\src\main\java\org\inspir3\common\
XCOPY /S C:\src\android-lib\org\inspir3\common\Binary.kt             app\src\main\java\org\inspir3\common\
XCOPY /S C:\src\android-lib\org\inspir3\common\NotificationHelper.kt app\src\main\java\org\inspir3\common\
```
