# webcam.py
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import cv2
import argparse
import time
import sys

def main():
    parser = argparse.ArgumentParser(description="Захват изображения с веб-камеры")
    parser.add_argument('-o', '--output', default='snapshot.jpg', help='Выходной файл')
    parser.add_argument('-d', '--device', type=int, default=0, help='Индекс камеры')
    parser.add_argument('-t', '--delay', type=int, default=0, help='Задержка в секундах')
    args = parser.parse_args()

    cap = cv2.VideoCapture(args.device)
    if not cap.isOpened():
        print("Ошибка: не удалось открыть камеру", file=sys.stderr)
        sys.exit(1)

    if args.delay > 0:
        print(f"Ожидание {args.delay} секунд...")
        time.sleep(args.delay)

    ret, frame = cap.read()
    cap.release()

    if not ret:
        print("Ошибка: не удалось захватить кадр", file=sys.stderr)
        sys.exit(1)

    cv2.imwrite(args.output, frame)
    print(f"✅ Изображение сохранено в {args.output}")

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\nПрервано пользователем.")
        sys.exit(0)
