/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class StackIteratorOuter<T> implements StackInterface<T> {

    private T[] stack;
    private Iterator stackTop;
    private static final int DEFAULT_SIZE = 50;

    public StackIteratorOuter() {
        this(DEFAULT_SIZE);
    }

    public StackIteratorOuter(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[capacity];
        stack = tempStack;
        stackTop = new Iterator(stack);
        stackTop.setNextIndex(stack.length - 1);
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();

        stackTop.setNextIndex(stackTop.getNextIndex() - 1);
        stack[stackTop.getNextIndex()] = newEntry;
    }

    @Override
    public T pop() {
        if (stackTop.hasNext()) {
            T temp = (T) stackTop.next();
            stackTop.remove();
            return temp;
        }
        return null;
    }

    @Override
    public T peek() {
        return stack[stackTop.getNextIndex()];
    }

    @Override
    public boolean isEmpty() {
        return !stackTop.hasNext();
    }

    @Override
    public void clear() {
        stackTop.setNextIndex(stack.length - 1);
        for (int i = stackTop.getNextIndex(); stack[i] != null; i++) {
            stack[i] = null;
        }
    }
    

    public void ensureCapacity() {
        if (stackTop.getNextIndex() == 0) {

            //setting stackTop to the appropriate place in the new stack
            stackTop.setNextIndex((stack.length + 1) / 2);

            //Declaring a temp stack that is twice the size of the current stack.
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[]) new Object[stack.length * 2];

            //copying the current stack to the end of the temp stack.
            System.arraycopy(stack, 0, tempStack, stackTop.getNextIndex(), stack.length);

            //referencing the stack variable to tempStack
            stack = tempStack;
        }
    }
}
