package javacode;

import java.util.Iterator;
import java.util.List;

public class Solution341_FlatNestList {

}


interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> mMestedList;

    NestedIterator nest;
    int i = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        mMestedList = nestedList;
    }

    @Override
    public Integer next() {

        if (mMestedList.get(i).isInteger()) {
            nest = null;
            return mMestedList.get(i++).getInteger();
        } else {
            return nest.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (i >= mMestedList.size()) {
            return false;
        } else if (mMestedList.get(i).isInteger()) {
            return true;
        } else {
            if (nest == null) {
                nest = new NestedIterator(mMestedList.get(i).getList());
            }
            if (!nest.hasNext()) {
                nest = null;
                i++;
                return hasNext();
            } else {
                return true;
            }

        }
    }
}
