package stack_JAVA_2;

import java.io.*;
import java.util.*;

public class IDEGAME {
    static class Save {
        String pa;
        Map<String, Integer> map;
        int max;
        int value;
        int index;

        public Save(String pa, HashMap<String, Integer> map, int max) {
            this.pa = pa;
            this.map = map;
            this.max = max;
        }

        public Save(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Stack<Save> stack = new Stack<>();
        Stack<Save> si = new Stack<>();

        boolean isCheck = true;
        int index = 0;

        stack.push(new Save("s", new HashMap<>(), 0));
        while ((input = br.readLine()) != null) {
            String[] s = input.split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("")) {
                    continue;
                }

                if (s[i].equals("(")) {
                    stack.push(new Save("(", new HashMap<>(), 0));
                    index++;
                } else if (s[i].equals(")")) {
                    if (stack.peek().pa.equals("(")) {
                        int pasum = 0;
                        pasum += stack.peek().max;
                        if (!si.isEmpty() && si.peek().index > index) {
                            while (!si.isEmpty()) {
                                pasum += si.pop().value;
                            }
                        }
                        si.push(new Save(pasum * 2, index));
                        stack.pop();
                        index--;
                    } else {
                        isCheck = false;
                    }
                } else if (s[i].equals("{")) {
                    stack.push(new Save("{", new HashMap<>(), 0));
                    index++;
                } else if (s[i].equals("}")) {
                    if (stack.peek().pa.equals("{")) {
                        int pasum = 0;
                        pasum += stack.peek().max;
                        if (!si.isEmpty() && si.peek().index > index) {
                            while (!si.isEmpty()) {
                                pasum += si.pop().value;
                            }
                        }
                        si.push(new Save(pasum * 3, index));
                        stack.pop();
                        index--;
                    } else {
                        isCheck = false;
                    }
                } else if (s[i].equals("[")) {
                    stack.push(new Save("[", new HashMap<>(), 0));
                    index++;
                } else if (s[i].equals("]")) {
                    if (stack.peek().pa.equals("[")) {
                        int pasum = 0;
                        pasum += stack.peek().max;
                        if (!si.isEmpty() && si.peek().index > index) {
                            while (!si.isEmpty()) {
                                pasum += si.pop().value;
                            }
                        }
                        si.push(new Save(pasum * 4, index));
                        stack.pop();
                        index--;
                    } else {
                        isCheck = false;
                    }
                } else {
                    if (!stack.isEmpty()) {
                        if (stack.peek().map.containsKey(s[i])) {
                            stack.peek().map.replace(s[i], stack.peek().map.get(s[i]) + 1);
                            stack.peek().max = Math.max(stack.peek().map.get(s[i]), stack.peek().max);
                        } else {
                            stack.peek().map.put(s[i], 1);
                            stack.peek().max = stack.peek().map.get(s[i]);
                        }
                    }
                }
            }

        }

        if (isCheck) {
            if (!stack.isEmpty() && !si.isEmpty()) {
                int last = stack.pop().max;
                System.out.println(si.peek().value + last);
            }
        } else {
            System.out.println("-1");
        }
    }
}