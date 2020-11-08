public abstract class Key {

    public static String getKeyFromMasterKey(String masterKey,boolean isEven){
        String temp = "";
        for (int i=0; i<masterKey.length(); i+=2){
            if (isEven){
                temp += masterKey.charAt(i);
            }else{
                temp += masterKey.charAt(i+1);
            }
        }
        return temp;
    }
    public static String leftCircularShift(String input){
        String temp = input.substring(0, 1);
        return input.substring(1) + temp;
    }
}
