import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;

public class WorkFile {
    public static void main(String[] args) {
        String textContent = """
                Uzalud trud
                dzaba vam sve
                nista od titule
                """;
        try(FileWriter file = new FileWriter("text.txt")){
            file.write(textContent);
            System.out.println("File has been written");
        }catch(IOException e){
            System.out.println("Could not write file");

        }

        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String songPath = "src\\DesingericaCcokolada.wav";
        File file = new File(songPath);
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip()) {
            
            clip.open(audioStream);
            clip.start();
            
            // Čekaj da se zvuk odssvira do kraja
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio format nije podržan: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Greška pri čitanju fajla: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Audio linija nije dostupna: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Reprodukcija prekinuta: " + e.getMessage());
        }
        finally{
            System.out.println("Byeee!!!");
        }


    
    }
}
