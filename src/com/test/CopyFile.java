package com.test;
import java.io.*;
import java.nio.file.Paths;

public class CopyFile {
    private static final String FILE_NAME = "PIA23623.tif"; //название файла
    private static final String PATH_FROM = "D:/Tempp/"; //путь к начальному файлу
    private static final File INPUT = new File(String.valueOf(Paths.get(PATH_FROM, FILE_NAME))); //создаем полную ссылку на файл
    private static final File OUTPUT = new File(String.valueOf(Paths.get(System.getProperty("user.home"), FILE_NAME))); //полная ссылка на 2 файл

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        long start = System.currentTimeMillis();
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally { assert is != null; is.close(); assert os != null; os.close();}

        double res = (double) (System.currentTimeMillis() - start) / 1000;
        System.out.printf("Выполнено за %.2f сек.%n", res);
    }

    public static void main(String[] args) throws IOException {
        copyFileUsingStream(INPUT, OUTPUT);
    }
}