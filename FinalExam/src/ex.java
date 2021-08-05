import java.io.*;
import java.util.*;

public class ex {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String output = convert(str);
        System.out.println(output);
        System.out.println(calc(output));
    }
    static long calc(String str) {
        Stack<String> stack = new Stack<String>();
        String input[] = str.trim().split(" ");
        long a=0,b=0,sum=0;
        for(int i =0;i<input.length;i++) {
            String ch = input[i];
            if(ch.equals("+")) {
                b=Long.parseLong(stack.pop());
                a=Long.parseLong(stack.pop());
                sum = a+b;
                stack.push(Long.toString(sum));
            } else if (ch.equals("-")) {
                 b=Long.parseLong(stack.pop());
                a=Long.parseLong(stack.pop());
                sum = (a-b);
                stack.push(Long.toString(sum));
            }else if (ch.equals("*")) {
                 b=Long.parseLong(stack.pop());
                a=Long.parseLong(stack.pop());
                sum = (a*b);
                stack.push(Long.toString(sum));
            }else if (ch.equals("/")) {
                 b=Long.parseLong(stack.pop());
                a=Long.parseLong(stack.pop());
                sum = (a/b);
                stack.push(Long.toString(sum));
            }else if (ch.equals("%")) {
                 b=Long.parseLong(stack.pop());
                a=Long.parseLong(stack.pop());
                sum = (a%b);
                stack.push(Long.toString(sum));
            }else if (ch.equals("^")) {
                 b=Long.parseLong(stack.pop());
                a=Long.parseLong(stack.pop());
                sum = Math.round(Math.pow(a,b));
                stack.push(Long.toString(sum));
            } else {
                stack.push(ch);
            }
        }
        return Long.parseLong(stack.pop());
    }
    static String convert(String str) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        str = str.trim();
        for(int i =0;i<str.length();i++) {
            char ch = str.charAt(i);
            int p = priority(ch);
            if(ch!=' ') {
            if(ch=='^' || ch=='*'||ch=='+'||ch=='-'||ch=='%'||ch=='/') {
                while(!stack.isEmpty() && priority(stack.peek()) >= p) {
                    sb.append(stack.pop()+" ");
                }
                stack.push(ch);
            } else if(ch=='(') {
                stack.push(ch);
            } else if(ch==')') {
                while(!stack.isEmpty() && priority(stack.peek()) > priority('(')) {
                    sb.append(stack.pop() + " ");
                }
                stack.pop();
            } else {
                sb.append(ch + " ");
            }
        }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        return sb.toString();
    }
    
    static int priority(char ch) {
        if(ch=='^') {
            return 3;
        } else if(ch == '*' || ch=='/' || ch=='*') {
            return 2;
        } else if(ch=='+'||ch=='-') {
            return 1;
        } else if(ch=='(' || ch==')') {
            return 0;
        } else {
            return -1;
        }
    }
}