package com.cayro;

import java.rmi.dgc.VMID;

public class Solution {
    public static int counter = 0;

    public long firstBadVersion(int lastVersion) {
        int firstVersion = 1;

        long decider = deciderIterative(firstVersion, lastVersion);

        System.out.println("Counter: " + counter);
        return decider;
    }

    private int decider(int firstVersion, int lastVersion) {
        int midVersion = (firstVersion + lastVersion) / 2;

        if (firstVersion == lastVersion) {
            return lastVersion;
        }

        if (isBadVersion(midVersion)) {
            if (firstVersion + 1 == midVersion) {
                if (midVersion == 2) {
                    return isBadVersion(1) ? 1 : 2;
                }
                return midVersion;
            }
            return decider(firstVersion, midVersion);
        } else {
            if (lastVersion - 1 == midVersion) {
                return lastVersion;
            }
            return decider(midVersion, lastVersion);
        }
    }

    private int deciderIterative(long firstVersion, long lastVersion) {

        while (true) {
            long midVersion = (firstVersion + lastVersion) / 2;

            if (firstVersion == lastVersion) {
                return (int) lastVersion;
            }

            if (isBadVersion((int) midVersion)) {
                if (firstVersion + 1 == midVersion) {
                    if (midVersion == 2) {
                        return isBadVersion(1) ? 1 : 2;
                    }
                    return (int) midVersion;
                }
                lastVersion = midVersion;
            } else {
                if (lastVersion - 1 == midVersion) {
                    return (int) lastVersion;
                }
                firstVersion = midVersion;
            }
        }
    }

    public int firstBadVersion2(int n) {
        return test(1, n);
    }

    public int firstBadVersion3(int n) {
        int lo = 1;
        int hi = n;

        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            if (isBadVersion(mid)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    public int test(int low, int high) {

        if (low >= high) {
            return low;
        }

        int mid = low + ((high - low) / 2);
        return (isBadVersion(mid)) ? test(low, mid) : test(mid + 1, high);
    }

    private boolean isBadVersion(int n) {
        counter += 1;
        return n >= 1_073_741_823;
    }
}
