import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Scramble {


    public static String work(String right,String key){
        String xorResult = xorFunction(right, key);
        List<String> strings = expandFrom48BitTo72Bit(xorResult);
        for (int i=0 ; i<strings.size() ; i++){
            String temp = strings.get(i);
            String firstChar = temp.substring(0, 1);
            String lastChar = temp.substring(temp.length() - 1);
            String row =  firstChar + lastChar;
            String column = temp.substring(1,temp.length()-1);
            strings.set(i,SBox.sBox.get(row).get(column));
        }
        String permutation = permutation(expandTogether(strings));
        return permutation;
    }

    public static String xorFunction(String right,String key){
        String result = "";
        for(int i=0; i<right.length(); i++){
            if(right.charAt(i) == key.charAt(i)) result += "0";
            else result += "1";
        }
        return result;
    }

    public static List<String> expandFrom48BitTo72Bit(String input){
        List<String> stringList = StringManipulater.divideInputToBlocks(input, 6);
        int size = stringList.size();
        for(int i=0 ; i<size ; i+=2){
            stringList.add(xorFunction(stringList.get(i),stringList.get(i+1)));
        }
        return stringList;
    }

    public static String expandTogether(List<String> array){
        return String.join("", array);
    }
    public static String permutation(String input){
        char[] chars = input.toCharArray();
        for (int i=0 ; i<chars.length ; i+=2){
            try{
                char temp = chars[i];
                chars[i] = chars[i+1];
                chars[i+1] = temp;
            }catch (Exception e){ }
        }
        return String.valueOf(chars);
    }
}
