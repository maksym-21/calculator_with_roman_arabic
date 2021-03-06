public class Action {

    private final String action;
    private final int a;
    private final int b;

    public Action(String action, int a, int b) {
        this.action = action;
        this.a = a;
        this.b = b;
    }

    public int doing() throws Exception {
        if (a > 10 || a < 0 || b < 0 || b > 10) throw new BoundsOfNumberException("");
        else if (action.equals("+")) {
            return a + b;
        } else if (action.equals("-")) {
            return a - b;
        } else if (action.equals("*")) {
            return a * b;
        } else if (action.equals("/")) {
            return a / b;
        } else throw new Exception();
    }

}

