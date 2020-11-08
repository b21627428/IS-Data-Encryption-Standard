
import java.io.*;
import java.util.Base64;
import java.util.HashMap;


public abstract class Argument {

    /* File okuma , SBox, E modülü Test Etme (Decryption) , Modelara Göre Yazma ) */

    private static HashMap<String,String> tags;
    // private static HashMap<String,String> files;
    private static String method;
    private static String mode;
    private static String Text;
    private static String Key;
    private static String input_file;
    private static String key_file;
    private static String output_file;


    public static boolean setTags(String args[]) {
        try{
            tags = new HashMap<>();
            method = args[0];
            for (int i=1 ; i < args.length ; i = i+2){
                tags.put(args[i],args[i+1]);
            }
//            System.out.println(tags);
//            setMode(tags.get("-M"));
            mode = tags.get("-M");
            input_file = tags.get("-I");
            key_file = tags.get("-K");
            output_file = tags.get("-O");
            // read();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public static void readInputKeyFiles(String input_file_path, String key_file_path){

        // Reading input file
        File inputFile = new File(input_file_path);
        try{
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String st;
            String text = "";
            while((st = br.readLine())!= null){
                text += st;
            }
            br.close();
            // Text is here
            Text = text;

        }catch (Exception e){
            e.printStackTrace();
        }

        // Decryption base64 file to obtain
        File encKeyfile = new File(key_file_path);
        try{
            BufferedReader br = new BufferedReader(new FileReader(encKeyfile));
            String st;
            String key = "";
            while((st = br.readLine())!= null){
                byte[] decKeyBytes = Base64.getDecoder().decode(st);
                key += new String(decKeyBytes);
            }
            br.close();
            // Key is here
            Key = key;
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void write( String output_file_path, String result){

        File file = new File(output_file_path);

        try{
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(result);
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static HashMap<String, String> getTags() {
        return tags;
    }

    public static void setTags(HashMap<String, String> tags) {
        Argument.tags = tags;
    }


    public static String getMethod() {
        return method;
    }

    public static void setMethod(String method) {
        Argument.method = method;
    }

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        Argument.mode = mode;
    }

    public static String getText(){
        return Text;
    }

    public static String getKey(){
        return Key;
    }

    public static String getInput_file(){
        return input_file;
    }

    public static String getKey_file(){
        return key_file;
    }

    public static String getOutput_file(){
        return output_file;
    }
}
