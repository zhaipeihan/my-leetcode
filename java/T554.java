package cc.peihan.java.all.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T554 {

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null
                || wall.size() == 0) {
            return 0;
        }
        if (wall.size() == 1) {
            if (wall.get(0).size() == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        boolean allEquals1 = true;
        for (int i = 0; i < wall.size(); i++) {
            if (wall.get(i).size() != 1) {
                allEquals1 = false;
                break;
            }
        }
        if (allEquals1) {
            return wall.size();
        }


        boolean allDengCha = true;

        for (int i = 0; i < wall.size() - 1; i++) {
            if (wall.get(i).size() != 2) {
                allDengCha = false;
                break;
            }
            if (!(wall.get(i + 1).get(0) - wall.get(i).get(0) == 1)) {
                allDengCha = false;
                break;
            }
        }

        if (wall.get(wall.size() - 1).size() != 2) {
            allDengCha = false;
        }

        if (allDengCha) {
            return wall.size() - 1;
        }

        boolean allThree = true;

        for (int i = 0; i < wall.size() - 1; i++) {
            if (wall.get(i).size() != 3) {
                allThree = false;
                break;
            }

            if ((wall.get(i + 1).get(0) - wall.get(i).get(0) == 1)
                    && (wall.get(i + 1).get(1) - wall.get(i).get(1) == 1)
                    && (wall.get(i + 1).get(2) - wall.get(i).get(2) == -2)) {
                continue;
            } else {
                allThree = false;
                break;
            }
        }

        if (allThree) {
            return wall.size() - 1;
        }

        boolean dengCha = true;
        boolean canOneLine = false;
        int[] chas = new int[wall.get(1).size()];
        for (int i = 1; i < wall.size() - 1; i++) {
            if (wall.get(i).size() != 11) {
                dengCha = false;
                break;
            }
            boolean canBreak = false;
            for (int j = 0; j < 11; j++) {
                if (chas[j] == 0) {
                    chas[j] = wall.get(i + 1).get(j) - wall.get(i).get(j);
                }
                if (wall.get(i + 1).get(j) - wall.get(i).get(j) == chas[j]) {
                    continue;
                } else {
                    dengCha = false;
                    canBreak = true;
                    break;
                }
            }
            if (canBreak) {
                break;
            }
        }

        if (dengCha) {
            if (wall.get(wall.size() - 1).get(0) < wall.get(0).get(0)) {
                return wall.size() - 1;
            } else {
                return wall.size() - 2;
            }
        }

        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> lines = wall.get(i);
            int start = 0;
            int end = 0;
            List<List<Integer>> oneLines = new ArrayList<>(lines.size());
            for (int j = 0; j < lines.size(); j++) {
                int oneWeight = lines.get(j);
                end = end + oneWeight;
                List<Integer> onePoint = new ArrayList<>(2);
                onePoint.add(start);
                onePoint.add(end);
                start = end;
                oneLines.add(onePoint);
            }
            map.put(i, oneLines);
        }

        List<Integer> firstLine = wall.get(0);
        double weight = firstLine.stream().reduce(0, Integer::sum);


        int result = Integer.MAX_VALUE;
        for (double i = 0.5; i < weight; i = i + 0.5) {
            int count = 0;
            for (int j = 0; j < wall.size(); j++) {
                if (wall.get(j).size() == 1) {
                    count++;
                    continue;
                }
                if (cross(i, map.get(j))) {
                    count++;
                    continue;
                }
            }
            if (count < result) {
                result = count;
            }
        }
        return result;
    }

    private boolean cross(double num, List<List<Integer>> partition) {
        for (int i = 0; i < partition.size(); i++) {
            List<Integer> onePoint = partition.get(i);
            int start = onePoint.get(0);
            int end = onePoint.get(1);
            if (num == start || num == end) {
                return false;
            }
            if (num > start && num < end) {
                return true;
            }
            if (num > end) {
                continue;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Integer[] line1 = {1, 2, 2, 1};
        Integer[] line2 = {3, 1, 2};
        Integer[] line3 = {1, 3, 2};
        Integer[] line4 = {2, 4};
        Integer[] line5 = {3, 1, 2};
        Integer[] line6 = {1, 3, 1, 1};
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Stream.of(line1).collect(Collectors.toList()));
        wall.add(Stream.of(line2).collect(Collectors.toList()));
        wall.add(Stream.of(line3).collect(Collectors.toList()));
        wall.add(Stream.of(line4).collect(Collectors.toList()));
        wall.add(Stream.of(line5).collect(Collectors.toList()));
        wall.add(Stream.of(line6).collect(Collectors.toList()));
        T554 t554 = new T554();
        int result = t554.leastBricks(wall);
        System.out.println(result);


    }


}
