package ongeri.japheth.tulaa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TripletSums {

    public TripletSums() {
    }

    public int countTriplets(Set<Integer> distinctIntegers, int sumValue) {
        int count = 0;
        //Sort the distinct values
        List<Integer> sortedDistinctValues = asSortedList(distinctIntegers);
        // Initialize result

        // Every iteration of loop counts triplet with first element as arr[i].
        int n = sortedDistinctValues.size();
        for (int i = 0; i < n - 2; i++) {
            // Initialize other two elements as corner elements of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;
            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more or equal, move right corner to look for smaller values
                if (sortedDistinctValues.get(i) + sortedDistinctValues.get(j) + sortedDistinctValues.get(k) >= sumValue) {
                    k--;
                } else { // Else move left corner
                    // This is important. For current i and j, there can be total k-j third elements.
                    count += (k - j);
                    j++;
                }
            }
        }
        return count;
    }

    //A private method to sort values
    private static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
        List<T> list = new ArrayList<>(c);
        java.util.Collections.sort(list);
        return list;
    }
}
