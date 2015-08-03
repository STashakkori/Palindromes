import java.util.Stack;

/**
 *
 * Created by STashakkori on 7/13/15.
 */
public class PalidromesMain {

    String[] potentials = new String[]{
            "aabb",
            "aaba",
            "abba",
            "bbbb",
            "baab",
            "aaab",
            "baaa",
            "aaaa",
            "aaa",
            "bbb",
            "aba",
            "bab",
            "cabc",
            "abcdba"
    };

    /**
     *  Main method ::
     *
     * @param args
     */
    public static void main(String[] args) {
        PalidromesMain main = new PalidromesMain();
        System.out.println(":: simple method ::");
        for (String s : main.potentials) System.out.println(s + " : " + main.isPalindromeSimple(s));
        System.out.println();
        System.out.println(":: stack method ::");
        for (String s : main.potentials) System.out.println(s + " : " + main.isPalindromeWithStack(s));
        System.out.println();
        System.out.println(":: recursive method ::");
        for (String s : main.potentials) System.out.println(s + " : " + main.isPalindromeRecursive(s, 0, s.length() - 1));
    }


    /**
     *  isPalindromeSimple
     */
    public boolean isPalindromeSimple(String tested) {
        boolean isPalindrome = true;
        for (int i = 0, j = tested.length() - 1; i < tested.length() / 2; i++, j--) {
            if (tested.charAt(i) != tested.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    /**
     *  isPalindromeWithStack
     */
    public boolean isPalindromeWithStack(String tested) {
        Stack<Character> stack = new Stack<Character>();
        boolean isPalindrome = true;
        for (int i = 0; i < tested.length(); i++) {
            stack.push(tested.charAt(i));
        }
        for (int i = 0; i < tested.length(); i++) {
            if (tested.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    /**
    *  isPalindromeRecursive
    */
    public boolean isPalindromeRecursive(String tested, int i, int j) {
        if(i <= j) {
            if(tested.charAt(i) != tested.charAt(j)) return false;
            else return isPalindromeRecursive(tested, i + 1, j - 1);
        }
        return true;
    }
}
