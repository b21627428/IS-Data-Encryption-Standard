import java.util.ArrayList;
import java.util.List;

public abstract class E {

    public static String work(String key,String text,Boolean isEnc){
        List<String> blocks = StringManipulater.divideInputToBlocks(text, 48);
        String result = "";
        if(isEnc){
            for (int i=0; i<10 ; i++){
                key = Key.leftCircularShift(key);
                String keyFromMasterKey = Key.getKeyFromMasterKey(key, i % 2 == 0);
                String scrambleResult = Scramble.work(blocks.get(1), keyFromMasterKey);
                String xorResult = Scramble.xorFunction(scrambleResult, blocks.get(0));
                blocks.set(0,blocks.get(1));
                blocks.set(1,xorResult);
            }
            result = Scramble.expandTogether(blocks);
        }else {
            List<String> keys = new ArrayList<>();
            for(int i=0 ; i<10 ; i++){
                key = Key.leftCircularShift(key);
                String keyFromMasterKey = Key.getKeyFromMasterKey(key, i % 2 == 0);
                keys.add(keyFromMasterKey);
            }
            for (int i=0 ; i<10 ; i++){
                String scrambleResult = Scramble.work(blocks.get(0), keys.get(keys.size() - i - 1));
                String xorResult = Scramble.xorFunction(scrambleResult, blocks.get(1));
                blocks.set(1,blocks.get(0));
                blocks.set(0,xorResult);
            }
            result = Scramble.expandTogether(blocks);
        }
        return result;
    }
}
