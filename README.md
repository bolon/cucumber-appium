# cucumber-appium
Using cucumber-jvm &amp; Appium to automate app test. Build tools using Gradle

# Pre-req
* Add gradle to system/user path
* Appium installed in local machine
* Connected device *WARNING* If using emulator make sure architecture emulator is arm.
* Make sure ``adb`` can be executed from anywhere
* Create new folder in root project with name ``apk_res`` and put apk in there
* Create ``environment.properties`` file containings these :

```
#device | for now only Android. set as Android
device = [Android/IOS] 
platformName = [Android/IOS]
deviceName = [Device_name] | use command "adb devices" for android

#launching
apk_name = [apk_name_that_stored_in_folder_apk_res]
pkg_name = [pkg_name_here] | eg : com.test.cucumber

#credential
valid_mail = [valid_mail_here]
valid_pwd = [valid_pwd_here]
```

# How to run
1. Go to root project
2. Run this command ``gradle cucumber``

# Note
See this [link](https://github.com/cucumber/cucumber-jvm/tree/master/examples/java-gradle) for more info about working with cucumber & gradle
