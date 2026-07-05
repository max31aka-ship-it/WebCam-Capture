// webcam.cpp
#include <opencv2/opencv.hpp>
#include <iostream>
#include <unistd.h>

using namespace cv;
using namespace std;

int main(int argc, char** argv) {
    string output = "snapshot.jpg";
    int device = 0, delay = 0;

    for (int i = 1; i < argc; ++i) {
        string arg = argv[i];
        if (arg == "-o" && i+1 < argc) output = argv[++i];
        else if (arg == "-d" && i+1 < argc) device = stoi(argv[++i]);
        else if (arg == "-t" && i+1 < argc) delay = stoi(argv[++i]);
        else if (arg == "-h" || arg == "--help") {
            cout << "Usage: webcam [-o output] [-d device] [-t delay]" << endl;
            return 0;
        }
    }

    VideoCapture cap(device);
    if (!cap.isOpened()) {
        cerr << "Ошибка: не удалось открыть камеру" << endl;
        return 1;
    }

    if (delay > 0) {
        cout << "Ожидание " << delay << " секунд..." << endl;
        sleep(delay);
    }

    Mat frame;
    cap >> frame;
    if (frame.empty()) {
        cerr << "Ошибка: не удалось захватить кадр" << endl;
        return 1;
    }

    imwrite(output, frame);
    cout << "✅ Изображение сохранено в " << output << endl;
    return 0;
}
