
import java.util.List;

public class BBMcrypt {

    public static void main(String[] args) {

        Argument.setTags(args);
        SBox.create();
        Boolean isEnc = Argument.getMethod().equals("enc");

        // Read input and Key files ......
        Argument.readInputKeyFiles(Argument.getInput_file(), Argument.getKey_file());
        String text = Argument.getText();
        String key = Argument.getKey();
        List<String> blocks = StringManipulater.divideInputToBlocks(text, 96);

        /* MODE PART */
        if(Argument.getMode().equals("ECB")){
            for (int i=0 ; i<blocks.size(); i++) {
                String result = E.work(key, blocks.get(i), isEnc);
                blocks.set(i,result);
            }
        }else if(Argument.getMode().equals("CBC")){
            String c0 = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
            if(isEnc){
                for (int i=0 ; i<blocks.size(); i++){
                    String plainText;
                    if(i==0){
                        plainText = Scramble.xorFunction(blocks.get(i),c0);
                    }else{
                        plainText = Scramble.xorFunction(blocks.get(i),blocks.get(i-1));
                    }
                    String cipherText = E.work(key, plainText, true);
                    blocks.set(i,cipherText);
                }
            }else{
                for(int i=blocks.size()-1; i>=0 ; i--){
                    String result = E.work(key, blocks.get(i), false);
                    String plainText;
                    if(i!=0){
                        plainText = Scramble.xorFunction(result, blocks.get(i - 1));
                    }else{
                        plainText = Scramble.xorFunction(result,c0);
                    }
                    blocks.set(i,plainText);
                }
            }
        }else if(Argument.getMode().equals("OFB")) {
            String x0 = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
            for (int i = 0; i < blocks.size(); i++) {
                x0 = E.work(key, x0, true);
                String result = Scramble.xorFunction(blocks.get(i), x0);
                blocks.set(i, result);
            }
        }
        String result = Scramble.expandTogether(blocks);
        Argument.write(Argument.getOutput_file(), result);
    }
}
