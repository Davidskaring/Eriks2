import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundUndo implements IAudioManager{
    @Override
    public void playSound() {
        try {
            // Hitta ljudfilen i resursmappen
            URL soundURL = getClass().getResource("/resources/perfect-fart.wav");
            if (soundURL == null) {
                return;
            }

            // Öppna ljudströmmen
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Förbered för uppspelning
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();

            // Läs buffertar och spela upp ljudet
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            // Stäng linjen när uppspelningen är klar
            line.drain();
            line.close();
            audioInputStream.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}