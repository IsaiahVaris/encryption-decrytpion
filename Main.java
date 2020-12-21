package encryptdecrypt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void encrypt(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print((char)(text.charAt(i) + key));
        }
    }
    public static void encryptShift(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            if(!Character.isLetter(text.charAt(i))){
                System.out.println(text.charAt(i));
            } else {

                if(text.charAt(i) >= 65 && text.charAt(i) <= 90){
                    System.out.println((char)((text.charAt(i) + key - 65)%26 + 65));
                } else {
                    System.out.println((char)((text.charAt(i) + key - 97)%26 + 97));
                }

            }
        }
    }

    public static void decrypt(String text, int key) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print((char)(text.charAt(i) - key));
        }
    }

    public static void decryptShift(String text, int key) {

        for (int i = 0; i < text.length(); i++) {
            if(!Character.isLetter(text.charAt(i))){
                System.out.println(text.charAt(i));
            } else {

                if(text.charAt(i) >= 65 && text.charAt(i) <= 90){

                    if (text.charAt(i) - key < 65) {
                        System.out.println((char)((text.charAt(i) - key + 26)  ));
                    } else {
                        System.out.println((char)(text.charAt(i) - key));
                    }

                } else {

                    if (text.charAt(i) - key < 97) {
                        System.out.println((char)((text.charAt(i) - key + 26)  ));
                    } else {
                        System.out.println((char)(text.charAt(i) - key));
                    }

                }

            }
        }
    }

    public static String readFileAsString(String name) throws IOException {
        return new String(Files.readAllBytes(Paths.get(name)));
    }

    public static void encryptToFile(String text, int key, File file) {
        try (FileWriter writer = new FileWriter(file)) {
             for (int i = 0; i < text.length(); i++) {
                writer.write((char)(text.charAt(i) + key));
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
    public static void encryptShiftToFile(String text, int key, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < text.length(); i++) {
                if(!Character.isLetter(text.charAt(i))){
                    writer.write(text.charAt(i));
                } else {
                    if(text.charAt(i) >= 65 && text.charAt(i) <= 90){
                        writer.write((char)((text.charAt(i) + key - 65)%26 + 65));
                    } else {
                        writer.write((char)((text.charAt(i) + key - 97)%26 + 97));
                    }
                }
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }

    }

    public static void decryptToFile(String text, int key, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < text.length(); i++) {
                writer.write((char)(text.charAt(i) - key));
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void decryptShiftToFile(String text, int key, File file) {


        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < text.length(); i++) {
                if(!Character.isLetter(text.charAt(i))){
                    writer.write(text.charAt(i));
                } else {

                    if(text.charAt(i) >= 65 && text.charAt(i) <= 90){

                        if (text.charAt(i) - key < 65) {
                            writer.write((char)((text.charAt(i) - key + 26)  ));
                        } else {
                            writer.write((char)(text.charAt(i) - key));
                        }

                    } else {

                        if (text.charAt(i) - key < 97) {
                            writer.write((char)((text.charAt(i) - key + 26)  ));
                        } else {
                            writer.write((char)(text.charAt(i) - key));
                        }

                    }

                }
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {

        String operation = "enc";
        String text = "";
        int key = 0;
        String fileName = "";
        String source = "";
        String alg = "shift";
        File file = new File("");
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("mode")) {
                operation = args[i + 1];
            }
            if (args[i].contains("-in")) {
                try {
                    text = readFileAsString(args[i + 1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (args[i].contains("data")) {
                source = "data";
                text = args[i + 1];
            }
            if (args[i].contains("-out")) {
                file = new File(args[i + 1]);
            }
            if (args[i].contains("key")) {
                key = Integer.parseInt(args[i + 1]);
            }

            if (args[i].contains("alg")) {
                alg = args[i + 1];
            }
        }

        if ("enc".equals(operation)) {
            if ("data".equals(source)) {
                if (alg.equals("shift")) {
                    encryptShift(text, key);
                } else {
                    encrypt(text, key);
                }
            } else {
                if (alg.equals("shift")) {
                    encryptShiftToFile(text, key, file);
                } else
                encryptToFile(text, key, file);
            }
        } else {
            if ("data".equals(source)) {
                if (alg.equals("shift")) {
                    decryptShift(text, key);
                } else {
                    decrypt(text, key);
                }
            } else {
                if (alg.equals("shift")) {
                    decryptShiftToFile(text, key, file);
                } else {
                    decryptToFile(text, key, file);
                }
            }
        }
    }
}
