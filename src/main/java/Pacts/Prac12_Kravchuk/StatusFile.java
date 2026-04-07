package Pacts.Prac12_Kravchuk;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class StatusFile {

    public static void updateStatus(Path file, long index, byte status) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "rw");
             FileChannel channel = raf.getChannel()) {

            // Запис байта
            ByteBuffer writeBuffer = ByteBuffer.allocate(1);
            writeBuffer.put(status);
            writeBuffer.flip();
            channel.position(index);
            channel.write(writeBuffer);

            // Читання байта для перевірки
            ByteBuffer readBuffer = ByteBuffer.allocate(1);
            channel.position(index);
            channel.read(readBuffer);
            readBuffer.flip();

            byte readBack = readBuffer.get();
            System.out.println("Записано: " + status + " | Зчитано: " + readBack);
        }
    }
}






