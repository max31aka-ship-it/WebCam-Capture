// webcam.go
package main

import (
	"flag"
	"fmt"
	"time"
	"gocv.io/x/gocv"
)

func main() {
	var output string
	var device int
	var delay int
	flag.StringVar(&output, "o", "snapshot.jpg", "Выходной файл")
	flag.IntVar(&device, "d", 0, "Индекс камеры")
	flag.IntVar(&delay, "t", 0, "Задержка в секундах")
	flag.Parse()

	webcam, err := gocv.VideoCaptureDevice(device)
	if err != nil {
		fmt.Printf("Ошибка: не удалось открыть камеру: %v\n", err)
		return
	}
	defer webcam.Close()

	if delay > 0 {
		fmt.Printf("Ожидание %d секунд...\n", delay)
		time.Sleep(time.Duration(delay) * time.Second)
	}

	img := gocv.NewMat()
	defer img.Close()
	if ok := webcam.Read(&img); !ok || img.Empty() {
		fmt.Println("Ошибка: не удалось захватить кадр")
		return
	}

	gocv.IMWrite(output, img)
	fmt.Printf("✅ Изображение сохранено в %s\n", output)
}
