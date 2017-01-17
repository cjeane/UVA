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

    class Node {

        char alpha;
        Node left = null;
        Node right = null;

        Node(char x) {
            alpha = x;
        }

        public String solve() {
            String ans = "";
            Queue<Node> list = new LinkedList<>();
            Stack<Character> checked = new Stack<>();
            list.add(this);

            while (!list.isEmpty()) {
                Node cur = list.remove();
                checked.push(cur.alpha);

                if (cur.left != null) {
                    list.add(cur.left);
                }
                if (cur.right != null) {
                    list.add(cur.right);
                }

                while (!checked.isEmpty()) {
                    ans = ans + checked.pop();
                }
            }

            return ans;
        }
    }

    public Node tree(Stack<Character> stack) {
        char c = stack.pop();

        if (Character.isUpperCase(c)) {
            Node left;
            Node right;       
            Node ret = new Node(c);
            ret.left = tree(stack);
            ret.right = tree(stack);
            return ret;
        } else {
            return new Node(c);
        }
        
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String line;
        char[] input;
        char c;
        Node btree;
        Main tester = new Main();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            input = line.toCharArray();
            stack = new Stack<Character>();
            
            for (int j = 0; j < input.length; j++) {
                stack.push(input[j]);
            }
            btree = tester.tree(stack);
            
            System.out.println(btree.solve());
        }
        sc.close();
    }

}
