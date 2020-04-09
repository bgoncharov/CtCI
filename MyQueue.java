import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNew, stackOld;

    public MyQueue() {
        stackNew = new Stack<T>();
        stackOld = new Stack<T>();
    }

    public int size() {
        return stackNew.size() + stackOld.size();
    }

    public void add(T value) {
        stackNew.push(value);
    }

    private void shiftStacks() {
        if (stackOld.isEmpty()) {
            while(!stackNew.isEmpty()) {
                stackOld.push(stackNew.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOld.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOld.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> superStack = new MyQueue<Integer>();

        for (int i = 0; i < 20; i += 2) {
            superStack.add(i);
        }
        System.out.println(superStack.size());
        System.out.println(superStack.peek());

        System.out.println("-----------------");

        System.out.println(superStack.remove());
        System.out.println(superStack.remove());
        System.out.println(superStack.size());
        System.out.println(superStack.peek());
    }
}
