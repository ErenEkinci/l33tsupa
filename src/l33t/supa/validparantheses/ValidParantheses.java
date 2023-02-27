package l33t.supa.validparantheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        var s = "[([[]])][{{}}]{()}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map<Character,Character> ps =  new HashMap<>()
        {
            {
                put('{','}');
                put('(',')');
                put('[',']');
            }
        };

        Stack<Character> stack = new Stack<>();
        stack.push('a');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(ps.containsKey(c)){
                stack.push(ps.get(c));
            }else if(c == stack.peek()){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.size() == 1;
    }
}
