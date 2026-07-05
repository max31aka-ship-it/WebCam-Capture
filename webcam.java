// webcam.java
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class webcam {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String output = "snapshot.jpg";
        int device = 0, delay = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o") && i+1 < args.length) output = args[++i];
            else if (args[i].equals("-d") && i+1 < args.length) device = Integer.parseInt(args[++i]);
            else if (args[i].equals("-t") && i+1 < args.length) delay = Integer.parseInt(args[++i]);
            else if (args[i].equals("-h") || args[i].equals("--help")) {
                System.out.println("Usage: java webcam [-o output] [-d device] [-t delay]");
                return;
            }
        }

        VideoCapture cap = new VideoCapture(device);
        if (!cap.isOpened()) {
            System.err.println("Ошибка: не удалось открыть камеру");
            System.exit(1);
        }

        if (delay > 0) {
            System.out.println("Ожидание " + delay + " секунд...");
            try { Thread.sleep(delay * 1000); } catch (InterruptedException e) {}
        }

        Mat frame = new Mat();
        if (cap.read(frame)) {
            Imgcodecs.imwrite(output, frame);
            System.out.println("✅ Изображение сохранено в " + output);
        } else {
            System.err.println("Ошибка: не удалось захватить кадр");
            System.exit(1);
        }
        cap.release();
    }
}
