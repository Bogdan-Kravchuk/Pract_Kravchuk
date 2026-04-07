package Pacts.Prac12_Kravchuk;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class InboxArchiver {
        public static void archiveTmpFiles(Path inbox, Path archive) throws IOException {
            if (!Files.exists(archive)) {
                Files.createDirectories(archive);
            }

            // Шукаємо лише файли з розширенням .tmp
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
                for (Path entry : stream) {
                    Path target = archive.resolve(entry.getFileName());
                    Files.move(entry, target, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Архівовано: " + entry.getFileName());
                }
            }
        }
    }

