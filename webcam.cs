// webcam.cs
using System;
using Emgu.CV;
using Emgu.CV.CvEnum;

class WebcamCapture
{
    static void Main(string[] args)
    {
        string output = "snapshot.jpg";
        int device = 0, delay = 0;

        for (int i = 0; i < args.Length; i++)
        {
            if (args[i] == "-o" && i+1 < args.Length) output = args[++i];
            else if (args[i] == "-d" && i+1 < args.Length) device = int.Parse(args[++i]);
            else if (args[i] == "-t" && i+1 < args.Length) delay = int.Parse(args[++i]);
            else if (args[i] == "-h" || args[i] == "--help")
            {
                Console.WriteLine("Usage: webcam [-o output] [-d device] [-t delay]");
                return;
            }
        }

        using (var capture = new VideoCapture(device))
        {
            if (!capture.IsOpened)
            {
                Console.Error.WriteLine("Ошибка: не удалось открыть камеру");
                Environment.Exit(1);
            }

            if (delay > 0)
            {
                Console.WriteLine($"Ожидание {delay} секунд...");
                System.Threading.Thread.Sleep(delay * 1000);
            }

            using (var frame = capture.QueryFrame())
            {
                if (frame == null)
                {
                    Console.Error.WriteLine("Ошибка: не удалось захватить кадр");
                    Environment.Exit(1);
                }
                frame.Save(output);
                Console.WriteLine($"✅ Изображение сохранено в {output}");
            }
        }
    }
}
