📸 WebCam Capture – Захват изображения с веб-камеры 
Простая и удобная утилита для захвата изображения с веб-камеры из командной строки.
Поддерживает выбор устройства, задержку перед съёмкой и настраиваемое имя файла.


🚀 Возможности
Захват кадра – моментальный снимок с веб-камеры.

Выбор устройства – укажите индекс камеры (по умолчанию 0).

Задержка перед съёмкой – установите таймер в секундах.

Настраиваемый выходной файл – сохраняйте в JPG или PNG.

Кроссплатформенность – работает на Windows, Linux, macOS.

Минимальный код – легко расширять и адаптировать.

📖 Использование
Синтаксис (единый для всех версий):

bash
<команда> [опции]
Опции
Опция	Описание
-o, --output <файл>	Имя выходного файла (по умолчанию snapshot.jpg)
-d, --device <N>	Индекс устройства (по умолчанию 0)
-t, --delay <сек>	Задержка перед съёмкой (по умолчанию 0)
-h, --help	Справка
Примеры
bash
# Захватить кадр и сохранить в snapshot.jpg
python webcam.py

# Захватить с задержкой 3 секунды
python webcam.py -t 3

# Сохранить в my_photo.png с устройства 1
python webcam.py -o my_photo.png -d 1
🛠 Установка и запуск
Python
bash
pip install opencv-python
python webcam.py [опции]
C++
bash
sudo apt-get install libopencv-dev   # для Ubuntu
g++ -std=c++11 webcam.cpp -o webcam `pkg-config --cflags --libs opencv4`
./webcam [опции]
Go
bash
go get -u gocv.io/x/gocv
go build webcam.go
./webcam [опции]
JavaScript (Node.js)
bash
npm install node-webcam
node webcam.js [опции]
C#
bash
# Установите Emgu.CV через NuGet (например, dotnet add package Emgu.CV)
csc webcam.cs -r:Emgu.CV.dll -r:Emgu.CV.Bitmap.dll
mono webcam.exe [опции]   # или dotnet run
Ruby
bash
gem install ruby-opencv
ruby webcam.rb [опции]
Java
bash
# Скачайте OpenCV для Java и добавьте в classpath
javac -cp .:opencv-*.jar webcam.java
java -cp .:opencv-*.jar webcam [опции]
🧠 Логика работы
Программа открывает веб-камеру по указанному индексу, ждёт заданную задержку, захватывает один кадр и сохраняет его в файл.
Используются популярные библиотеки для каждого языка:

Python / C++ / Java – OpenCV.

Go – GoCV.

JavaScript – node-webcam.

C# – Emgu.CV.

Ruby – ruby-opencv.

✨ Дополнительные фичи
Автоматическое определение камеры – если устройство не открывается, программа сообщает об ошибке.

Цветной вывод – сообщения об успехе и ошибках выделены.

Минимальные зависимости – легко устанавливаются через пакетные менеджеры.

📂 Состав репозитория
Язык	Файл	Статус
Python	webcam.py	✅
C++	webcam.cpp	✅
Go	webcam.go	✅
JavaScript	webcam.js	✅
C#	webcam.cs	✅
Ruby	webcam.rb	✅
Java	webcam.java	✅
🤝 Вклад в проект
Приветствуются улучшения:

Поддержка видео-потока.

Графический интерфейс.

Добавление фильтров.

Создавайте Issues и Pull Requests.

📜 Лицензия
MIT License – свободное использование, модификация и распространение.

📂 Исходный код
Первая строка каждого файла – его имя. Скопируйте блок целиком и сохраните в соответствующий файл.
