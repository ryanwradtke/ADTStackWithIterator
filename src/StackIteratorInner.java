
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class StackIteratorInner<T> implements StackInterface<T> {

    private T[] stack;
    private Iterator stackTop = new Iterator();
    private static final int DEFAULT_SIZE = 50;

     public StackIteratorInner() {
        this(DEFAULT_SIZE);
    }

    public StackIteratorInner(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[capacity];
        stack = tempStack;
        stackTop.nextIndex = stack.length - 1;
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();

        stackTop.nextIndex -= 1;
        stack[stackTop.nextIndex] = newEntry;
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
        return stack[stackTop.nextIndex];
    }

    @Override
    public boolean isEmpty() {
        return !stackTop.hasNext();
    }

    @Override
    public void clear() {
        stackTop.nextIndex = stack.length - 1;
        for(int i = stackTop.nextIndex; stack[i] != null; i++) {
            stack[i] = null;
        }
    }

    public void ensureCapacity() {
        if (stackTop.nextIndex == 0) {

            //setting stackTop to the appropriate place in the new stack
            stackTop.nextIndex = (stack.length + 1) / 2;
            
            //Declaring a temp stack that is twice the size of the current stack.
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[]) new Object[stack.length * 2];

            //copying the current stack to the end of the temp stack.
            System.arraycopy(stack, 0, tempStack, stackTop.nextIndex, stack.length);

            //referencing the stack variable to tempStack
            stack = tempStack;
        }
    }

    private class Iterator<T> implements IteratorInterface<T> {

        private int nextIndex;
        
        @Override
        public boolean hasNext() {
            return stack[nextIndex] != null;
        }

        @Override
        public T next() {
            return (hasNext()) ? (T) stack[nextIndex] : null;
        }

        @Override
        public void remove() {
            stack[nextIndex] = null;
            nextIndex++;
        }

    }
}
