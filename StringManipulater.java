import java.util.ArrayList;
import java.util.List;

public abstract class StringManipulater {

    public static List<String> divideInputToBlocks(String input, int howManyBitBlocks){

        List<String> list = new ArrayList<String>();
        int divider = input.length() / howManyBitBlocks;
        for(int i=0 ; i<=divider ; i++){
            try{
                list.add(input.substring(i*howManyBitBlocks,(i+1)*howManyBitBlocks));
            }catch (Exception e){
                if(input.length() % howManyBitBlocks != 0){
                    StringBuilder substring = new StringBuilder(input.substring(i * howManyBitBlocks));
                    for(int j=0 ; j<howManyBitBlocks-substring.length() ; i++){
                        substring.insert(0, "0");
                    }
                    list.add(substring.toString());
                }
            }
        }
        return list;
    }


}
