/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cory
 */
import java.util.*;

public class Main {

    public static int val = 0;

    public boolean stacker2(String string) {
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < string.length(); i++) {

            if (i + 1 < string.length() && i > 0) {
                if (string.charAt(i + 1) == string.charAt(i));

            }
            if (temp.empty() || temp.peek() != string.charAt(i)) {
                if (temp.empty()) {
                    us();
                }
                temp.push(string.charAt(i));

            } else {
                temp.pop();
            }
        }

        if (temp.empty()) {
            return true;
        } else {
            return false;
        }
    }

    int chcount(char chm, String string) {
        int c = 0;
        for (char ch : string.toCharArray()) {
            if (ch == chm) {
                c++;

            }
        }
        return c;
    }

    boolean lazy(String string) {
        String temp = string;
        int c;

        for (char alpha = 'a'; alpha <= 'z'; alpha++) {
            c = 0;
            for (char ch : temp.toCharArray()) {
                if (ch == alpha) {
                    c++;

                }
            }

            if (c > 2) {
                return false;
            }
        }
        return true;
    }

    public void us() {
        val++;
    }

    public int stacker3(String string) {
        String temp;
        Main.val = 0;

        int num;
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        int i;

        if (string.length() % 2 == 1) {
            return 0;
        }
        if (string.length() == 2) {
            if (string.charAt(0) == string.charAt(1)) {
                return 1;
            } else {
                return 0;
            }
        }

        if (lazy(string) && stacker2(string)) {
            return 1;
        }
        stacker2(string);
        num = val;

        for (i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i + 1) == string.charAt(i) && i + 1 < string.length() / 2) {
                if (chcount(string.charAt(i + 1), string) > 3 && num > 1) {
                    flag2 = true;
                }
            }
            int leng = string.length();

            if (string.charAt(leng - 2 - i) == string.charAt(leng - 1 - i) && leng - i - 2 >= leng / 2) {
                if (chcount(string.charAt(leng - 1 - i), string) > 3 && num > 1) {
                    flag2 = true;
                }
            }

            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                temp = string.substring(i, string.length() - i);
                flag3 = stacker2(temp);
                break;
            }
            if (string.charAt(i + 1) == string.charAt(i) && i + 1 < string.length() / 2) {
                flag4 = true;
            }

        }

        if (i == string.length() / 2 && stacker2(string)) {
            flag = true;
        }
        System.out.println(i + " " + flag + " " + flag2 + " " + flag3 + " " + flag4 + " ");

        if ((flag3 && flag2) || (flag && flag2)) {
            return 2;
        } else if (flag3 || flag) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer tokenizer;
        String line = null;
        int cases;
        int bob = 0;
        tokenizer = new StringTokenizer(scanner.nextLine());
        cases = Integer.parseInt(tokenizer.nextToken());

        Main tester = new Main();
        for (int runs = 1; runs <= cases; runs++) {

            line = scanner.nextLine();

            bob = tester.stacker3(line); //bob = tester.stacker(line, 0, org, 1);

            if (bob == 0) {
                System.out.println("Case " + runs + ": Invalid");
            } else if (bob == 1) {
                System.out.println("Case " + runs + ": Valid, Unique");
            } else {
                System.out.println("Case " + runs + ": Valid, Multiple");
            }

        }
    }

}
