package cc.peihan.java.all.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T554_2 {


    public int leastBricks(List<List<Integer>> wall) {

        int minCross = Integer.MAX_VALUE;

//        按照每一行来扫描

        for (int i = 0; i < wall.size(); i++) {

            // weight 是累加到目前扫描到累加值，
            int weight = 0;
//            扫描每一个缝隙
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                weight += wall.get(i).get(j);

                int cross = 0;
                //计算在该缝隙下穿过的砖块数
                for (int k = 0; k < wall.size(); k++) {
                    //自己当前行不遍历
                    if (k == i) {
                        continue;
                    }

                    List<Integer> oneLine = wall.get(k);

                    int rollWeight = 0;

                    // 计算是否穿过当前行
                    for (int p = 0; p < oneLine.size(); p++) {
                        if (rollWeight >= weight) {
                            break;
                        }
                        rollWeight += oneLine.get(p);
                    }
//                    如果rollweight >  weight ，说明穿过了砖块
                    if (rollWeight > weight) {
                        cross++;
                    }
                }

                if (cross < minCross) {
                    minCross = cross;
                }

            }
        }
        return minCross == Integer.MAX_VALUE ? wall.size() : minCross;
    }


    public static void main(String[] args) {
//        Integer[] line1 = {1, 2, 2, 1};
//        Integer[] line2 = {3, 1, 2};
//        Integer[] line3 = {1, 3, 2};
//        Integer[] line4 = {2, 4};
//        Integer[] line5 = {3, 1, 2};
//        Integer[] line6 = {1, 3, 1, 1};

        Integer[] line1 = {1};
        Integer[] line2 = {1};
        Integer[] line3 = {1};

        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Stream.of(line1).collect(Collectors.toList()));
        wall.add(Stream.of(line2).collect(Collectors.toList()));
        wall.add(Stream.of(line3).collect(Collectors.toList()));
//        wall.add(Stream.of(line4).collect(Collectors.toList()));
//        wall.add(Stream.of(line5).collect(Collectors.toList()));
//        wall.add(Stream.of(line6).collect(Collectors.toList()));

        T554_2 t554_2 = new T554_2();
        int result = t554_2.leastBricks(wall);
        System.out.println(result);
    }


}
