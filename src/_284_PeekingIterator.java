import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> mIterator;
    private Integer peekNum;
    private boolean hasNext = true;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        mIterator = iterator;
        next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasNext) {
            return peekNum;
        } else {
            return null;
        }

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext) {
            return null;
        }
        Integer next = peekNum;
        if (mIterator.hasNext()) {
            peekNum = mIterator.next();
        } else {
            hasNext = false;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}