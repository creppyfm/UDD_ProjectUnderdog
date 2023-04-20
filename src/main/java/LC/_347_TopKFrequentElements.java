package LC;

import java.util.*;

public class _347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] intArr = new int[9];

    }

    public static List<Integer> topKFrequentElements (int[] nums, int k) {
        List<Integer> returnList = new ArrayList<>();
        List<Record> recordList = new ArrayList<>();
        Map<Integer, Integer> valToOccurrences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int value = nums[i];

            if (!valToOccurrences.containsKey(value)) {
                valToOccurrences.put(value, 1);
            } else {
                count = valToOccurrences.get(value) + 1;
                valToOccurrences.put(value, count);
            }
        }

        for (Map.Entry<Integer, Integer> kvPair : valToOccurrences.entrySet()) {
            Record record = new Record(kvPair.getKey(), kvPair.getValue());
            recordList.add(record);
        }

        Collections.sort(recordList);

        for (int i = 0; i < k; i++) {
            returnList.add(recordList.get(i).key);
        }
        return returnList;
    }

    public static record Record (int key, int value) implements Comparable<Record> {

        @Override
        public int compareTo(Record that) {
            return Integer.compare(that.value, this.value);
        }
    }

}


/*
*
* Given an integer array nums and an integer k,
* return the k most frequent elements. You may return the answer in any order.
* */
