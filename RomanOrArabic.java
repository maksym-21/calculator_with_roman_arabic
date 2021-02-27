import java.util.HashMap;
import java.util.Map;

public class RomanOrArabic {

    private final String a;
    private final String b;
    private int aa = 0;
    private int bb = 0;

    private static Map<String,Integer> roman = new HashMap<>();

    static {
        roman.put("|",1);
        roman.put("I",1);

        roman.put("||",2);
        roman.put("II",2);

        roman.put("|||",3);
        roman.put("III",3);

        roman.put("|V",4);
        roman.put("IV",4);

        roman.put("V",5);
        roman.put("v",5);

        roman.put("V|",6);
        roman.put("VI",6);
        roman.put("v|",6);
        roman.put("vI",6);

        roman.put("V||",7);
        roman.put("VII",7);
        roman.put("v||",7);
        roman.put("vII",7);

        roman.put("V|||",8);
        roman.put("VIII",8);
        roman.put("v|||",8);
        roman.put("vIII",8);

        roman.put("|X",9);
        roman.put("IX",9);
        roman.put("|x",9);
        roman.put("Ix",9);

        roman.put("X",10);
        roman.put("x",10);
    }

    public RomanOrArabic(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getRomanChar(int a){
        String fifty = "L";
        String oneH = "C";

        if (a<11 && a>0){
            for (String abc : roman.keySet()) {
                if (roman.get(abc)==a) return abc;
            }
        }
        else if (a==50) return fifty;
        else if (a==100) return oneH;
        else {
            StringBuilder s = new StringBuilder();

            int input = a;

            if (input < 0){
                input*=-1;
                s.append("-");
            }
            while (input >= 90) {
                s.append("XC");
                input -= 90;
            }
            while (input >= 50) {
                s.append("L");
                input -= 50;
            }
            while (input >= 40) {
                s.append("XL");
                input -= 40;
            }
            while (input >= 10) {
                s.append("X");
                input -= 10;
            }
            while (input >= 9) {
                s.append("IX");
                input -= 9;
            }
            while (input >= 5) {
                s.append("V");
                input -= 5;
            }
            while (input >= 4) {
                s.append("IV");
                input -= 4;
            }
            while (input >= 1) {
                s.append("I");
                input -= 1;
            }

            return s.toString();
            }
            return null;
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
