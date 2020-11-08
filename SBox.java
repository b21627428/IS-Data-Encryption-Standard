import java.util.HashMap;

public abstract class SBox {

    public static HashMap<String, HashMap<String,String>> sBox = new HashMap<>();

    public static void create(){
        sBox.put("00",createFirstRow());
        sBox.put("01",createSecondRow());
        sBox.put("10",createThirdRow());
        sBox.put("11",createFourthRow());
    }
    public static HashMap<String,String> createFirstRow(){
        HashMap<String,String> firstRow = new HashMap<String,String>();
        firstRow.put("0000","0010");
        firstRow.put("0001","1100");
        firstRow.put("0010","0100");
        firstRow.put("0011","0001");
        firstRow.put("0100","0111");
        firstRow.put("0101","1010");
        firstRow.put("0110","1011");
        firstRow.put("0111","0110");
        firstRow.put("1000","1000");
        firstRow.put("1001","0101");
        firstRow.put("1010","0011");
        firstRow.put("1011","1111");
        firstRow.put("1100","1101");
        firstRow.put("1101","0000");
        firstRow.put("1110","1110");
        firstRow.put("1111","1001");
        return firstRow;
    }
    public static HashMap<String,String> createSecondRow(){
        HashMap<String,String> secondRow = new HashMap<String,String>();
        secondRow.put("0000","1110");
        secondRow.put("0001","1011");
        secondRow.put("0010","0010");
        secondRow.put("0011","1100");
        secondRow.put("0100","0100");
        secondRow.put("0101","0111");
        secondRow.put("0110","1101");
        secondRow.put("0111","0001");
        secondRow.put("1000","0101");
        secondRow.put("1001","0000");
        secondRow.put("1010","1111");
        secondRow.put("1011","1010");
        secondRow.put("1100","0011");
        secondRow.put("1101","1001");
        secondRow.put("1110","1000");
        secondRow.put("1111","0110");
        return secondRow;
    }
    public static HashMap<String,String> createThirdRow(){
        HashMap<String,String> thirdRow = new HashMap<String,String>();
        thirdRow.put("0000","0100");
        thirdRow.put("0001","0010");
        thirdRow.put("0010","0001");
        thirdRow.put("0011","1011");
        thirdRow.put("0100","1010");
        thirdRow.put("0101","1101");
        thirdRow.put("0110","0111");
        thirdRow.put("0111","1000");
        thirdRow.put("1000","1111");
        thirdRow.put("1001","1001");
        thirdRow.put("1010","1100");
        thirdRow.put("1011","0101");
        thirdRow.put("1100","0110");
        thirdRow.put("1101","0011");
        thirdRow.put("1110","0000");
        thirdRow.put("1111","1110");
        return thirdRow;
    }
    public static HashMap<String,String> createFourthRow(){
        HashMap<String,String> fourthRow = new HashMap<String,String>();
        fourthRow.put("0000","1011");
        fourthRow.put("0001","1000");
        fourthRow.put("0010","1100");
        fourthRow.put("0011","0111");
        fourthRow.put("0100","0001");
        fourthRow.put("0101","1110");
        fourthRow.put("0110","0010");
        fourthRow.put("0111","1101");
        fourthRow.put("1000","0110");
        fourthRow.put("1001","1111");
        fourthRow.put("1010","0000");
        fourthRow.put("1011","1001");
        fourthRow.put("1100","1010");
        fourthRow.put("1101","0100");
        fourthRow.put("1110","0101");
        fourthRow.put("1111","0011");
        return fourthRow;
    }

}
