1. Скачиваем apk-файл для Wildberries.ru, это, например, можно сделать с помощью сервера apkcombo.com, перейдя по ссылке: https://apkcombo.com/wildberries/com.wildberries.ru/download/apk

2. В нашем случае (версия приложения на 18 января 2024 года) скачается файл с именем: "Wildberries_6.4.5001_apkcombo.com.apk"

3. Скачиваем Appium Server: https://github.com/appium/appium-desktop/releases/download/v1.22.3-4/Appium-Server-GUI-windows-1.22.3-4.zip

4. Установить плагин Selenium в Idea.

5. Запускаем эмулятор android.

6. В терминале даем команду "adb devices" и копируем идентификатор эмулятора. В моем примере идентификатор эмулятора - emulator-5554, если команда adb в терминале недоступна, скачайте и установите android platform tools.

7. Устанавливаем значение переменной окружения (environment variable) JAVA_HOME, в моем случае - это папка "C:\Program Files\Java\jdk-21".

8.  Устанавливаем значение переменной окружения (environment variable) ANDROID_HOME, в моем случае - это папка "C:\Users\adele\AppData\Local\Android\Sdk".

9. Если у вас идентификатор эмулятора отличается от моего, то в файле BaseConfig.java, на строке №32 поменяйте соответствующее значение.

10. К шагу №2, у меня apk файл расположен в файловой системе по пути "C:\Testing\apk\Wildberries_6.4.5001_apkcombo.com.apk", если у вас этот файл расположен по другому пути, в файле BaseConfig.java, на строке №40 поменяйте соответствующее значение.

11. К шагу №3, распаковываем архив, и запускаем  программу "Appium Server GUI.exe".

12. Запускаем Idea, открываем в ней папку проекта WildberriesAppiumTest, либо забираем проект прямо из Github, по ссылке "git@github.com:adeleluck/appium-ui-test.git".

13. В Idea идем в файл ShoppingBasketTest.java и запускаем этот тест на выполнение (Shift + F10 для Windows).

В репозитории в папке video находится демонстрация выполнения тестов на моем компьютере.
В репозитории в папке testing-scenarios находится файл с решением первого задания.

