/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class Iterator<T> implements IteratorInterface<T> {

    private int nextIndex;
    private T[] stack;

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public Iterator(T[] stack) {
        this.stack = stack;
    }

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
