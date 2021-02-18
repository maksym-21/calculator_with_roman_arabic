import java.util.HashMap;
import java.util.Map;

public class roman_or_arabic {
    private String a;
    private String b;
    private int aa = 0;
    private int bb = 0;

    private static Map<String,Integer> roman = new HashMap<>();
    
    static {
        roman.put("|",1);
        roman.put("||",2);
        roman.put("|||",3);
        roman.put("|V",4);
        roman.put("|v",4);
        roman.put("V",5);
        roman.put("v",5);
        roman.put("V|",6);
        roman.put("v|",6);
        roman.put("V||",7);
        roman.put("v||",7);
        roman.put("V|||",8);
        roman.put("v|||",8);
        roman.put("|X",9);
        roman.put("|x",9);
        roman.put("X",10);
        roman.put("x",10);
    }
    
    public String getRomanChar(int a){
        String one = "|";
        String ten = "X";
        String five = "V";
        String fifty = "L";
        String oneh = "C";

        if (a<11){
            for (String abc : roman.keySet()) {
                if (roman.get(abc)==a) return abc;
            }
        }
        else if (a==50) return fifty;
        else if (a==100) return oneh;
        else {
            String s = "";
            int input = a;
            while (input >= 90) {
                s += "XC";
                input -= 90;
            }
            while (input >= 50) {
                s += "L";
                input -= 50;
            }
            while (input >= 40) {
                s += "XL";
                input -= 40;
            }
            while (input >= 10) {
                s += "X";
                input -= 10;
            }
            while (input >= 9) {
                s += "IX";
                input -= 9;
            }
            while (input >= 5) {
                s += "V";
                input -= 5;
            }
            while (input >= 4) {
                s += "IV";
                input -= 4;
            }
            while (input >= 1) {
                s += "I";
                input -= 1;
            }

            return s;
        }
        return null;
    }

    public roman_or_arabic(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public boolean ifArabic(){
        try {
            aa = Integer.parseInt(a);
            bb = Integer.parseInt(b);
            return true;
        }
        catch (Exception exception){
            return false;
        }
    }

    public void init(){

        aa = roman.get(a);
        bb = roman.get(b);
    }

    public boolean ifRoman() {
        boolean bool = false;

        for (String string : roman.keySet()){
            if (string.equals(a)) bool = true;
        }
        
        if (bool){
            for (String st:roman.keySet()) {
                if (st.equals(b)) {
                    init();
                    return true;
                }
            }
        }
        return false;
    }

    public int getAa() {
        return aa;
    }

    public int getBb() {
        return bb;
    }
}
