import CtCILibrary.AssortedMethods;

import java.util.EmptyStackException;

public class ThreeInOne {

    private int numberOfStacks = 3;
    private int stackCap;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCap = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return(values[indexOfTop(stackNum)]);
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCap;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCap;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getStackValues(int stackNum) {
        int[] items = new int[sizes[stackNum]];
        for (int i = 0; i < items.length; i++) {
            items[i] = values[stackNum * stackCap + i];
        }
        return items;
    }

    public static void printStacks(ThreeInOne stacks) {
        System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
    }

    public static void main(String [] args) throws Exception  {
        ThreeInOne stacks = new ThreeInOne(4);
        printStacks(stacks);
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);
    }
}
