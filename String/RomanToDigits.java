import java.util.HashMap;
/*  I            1
  IV           4
  V            5
  IX           9
  X            10
  XL           40
  L            50
  XC           90
  C            100
  CD           400
  D            500
  CM           900 
  M            1000
*/


class RomanToDigits{
    static HashMap<String, Integer> map;

    RomanToDigits(){
        map = new HashMap<String, Integer>();
        populateRomanConvertor();
    }

    static void populateRomanConvertor(){
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    static boolean isTwoStringPossible(char s){
        if( s == 'I' || s == 'X' || s == 'C')
            return true;
        else 
            return false;
    }

    static int romanConverter(String s){
        String temp = "";
        int iter = 0, len = s.length(), sum=0;

        while(iter < len){
            temp = "" + s.charAt(iter);
            if(iter+1 < len){
                if(isTwoStringPossible(s.charAt(iter)) && map.containsKey(temp+s.charAt(iter+1))){
                    iter++;
                    sum = sum + map.get(temp+s.charAt(iter));
                }
                else 
                    sum = sum+map.get(temp);
            }
            else 
                sum = sum + map.get(temp);
            iter++;
        }
        return sum;
    }


    public static void main(String[] args){
        RomanToDigits rd = new RomanToDigits();
        String s = "MCMIV";
        System.out.println(romanConverter(s));
    }
}