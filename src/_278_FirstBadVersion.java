class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}

class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (!isBadVersion(mid)) {
                start = mid;
            } else  {
                end = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        } else  {
            return end;
        }
    }
}

