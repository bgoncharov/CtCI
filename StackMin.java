import java.util.Stack;

public class StackMin extends Stack<Integer> {
    Stack<Integer> s2;

    public StackMin() {
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }

    public static void main (String[] args) {
        StackMin stack = new StackMin();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}