package com.zc.towerdefense;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class MySolution {
    public static class Route {
        static class Location {
            public int row;
            public int column;

            public Location(int row, int column) {
                this.row = row;
                this.column = column;
            }

            @Override
            public String toString() {
                return "(" + row + "," + column + ")";
            }
        }

        private char[][] map; // 地图
        private int row; // 输入坐标行
        private int column; // 输入坐标列

        /**
         * 复制地图
         *
         * @param map
         * @return
         */
        public static char[][] copyMap(char[][] map) {
            char[][] copied = new char[map.length][];
            for (int i = 0; i < map.length; i++) {
                copied[i] = new char[map[i].length];
                for (int j = 0; j < map[i].length; j++) copied[i][j] = map[i][j];
            }
            return copied;
        }

        /**
         * 打印地图
         *
         * @param map
         */
        public static void printMap(char[][] map) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j]);
                    System.out.print(' ');
                }
                System.out.println();
            }
        }

        /**
         * 工厂方法
         *
         * @param inputStream
         * @return
         * @throws Exception
         */
        public static Route fromInputStream(InputStream inputStream) throws Exception {
            Scanner scanner = new Scanner(inputStream);
            int m = scanner.nextInt();
            if (0 >= m) throw new Exception(String.format("row error: %d", m));
            int n = scanner.nextInt();
            if (0 >= n) throw new Exception(String.format("column error: %d", m));
            scanner.nextLine();
            char map[][] = new char[m][n];
            for (int i = 0; i < m; i++) {
                String values[] = scanner.nextLine().split(" ");
                if (n != values.length) throw new Exception(String.format("column length error: %d", values.length));
                map[i] = new char[n];
                for (int j = 0; j < n; j++) map[i][j] = values[j].charAt(0);
            }
            m = scanner.nextInt();
            n = scanner.nextInt();
            return new Route(map, m, n);
        }

        /**
         * 获取地图
         *
         * @return
         */
        public char[][] getMap() {
            return map;
        }

        /**
         * 获取行
         *
         * @return
         */
        public int getRow() {
            return this.row;
        }

        /**
         * 获取列
         *
         * @return
         */
        public int getColumn() {
            return this.column;
        }

        /**
         * 默认构造方法
         */
        public Route() {
        }

        /**
         * 构造方法
         *
         * @param map    地图
         * @param row    输入行
         * @param column 输入列
         */
        public Route(char[][] map, int row, int column) {
            this.map = map;
            this.row = row;
            this.column = column;
        }

        /**
         * 检查是否有通路
         *
         * @return
         */
        public boolean check() {
            if ('*' == this.map[0][0]) return false; // 检查初始点
            // 阻挡赋值
            char[][] copied = copyMap(this.map);
            copied[this.row][this.column] = '*';
            Route.printMap(copied); // 打印地图
            // 开始寻路
            final int maxRow = copied.length;
            final int maxColumn = copied[0].length;
                Stack<Location> locationStack = new Stack();
            locationStack.push(new Location(0, 0)); // 放入起始点
            while (!locationStack.empty()) {
                Location cur = locationStack.pop(); // 获取当前点
                System.out.println(cur); // 打印当前点
                // 可以继续往右走
                if (cur.column < maxColumn - 1 && '-' == copied[cur.row][cur.column + 1])
                    locationStack.push(new Location(cur.row, cur.column + 1));
                // 可以继续往下走
                if (cur.row < maxRow - 1 && '-' == copied[cur.row + 1][cur.column])
                    locationStack.push(new Location(cur.row + 1, cur.column));
                if (cur.row == maxRow - 1 && cur.column == maxColumn - 1) return true; // 找到了出口
            }
            return false;
        }
    }

    /**
     * 测试
     *
     * @param inputStream
     * @throws Exception
     */
    public static void test(InputStream inputStream) throws Exception {
        Route route = Route.fromInputStream(inputStream);
        System.out.printf("%d %d %s\n", route.getRow(), route.getColumn(), route.check() ? "Yes" : "No");
    }

    public static void main(String[] args) throws Exception {
        // 模拟数据
        System.out.println("案例一");
        test(new ByteArrayInputStream(("3 4\n" +
                "- - - -\n" +
                "- * - -\n" +
                "- * - -\n" +
                "0 1").getBytes()));
        System.out.println("案例二");
        test(new ByteArrayInputStream(("3 4\n" +
                "- - - -\n" +
                "- * - -\n" +
                "- * - -\n" +
                "1 2").getBytes()));
        System.out.println("案例三");
        test(new ByteArrayInputStream(("3 4\n" +
                "- - - -\n" +
                "- * - -\n" +
                "- * - -\n" +
                "1 3").getBytes()));
        System.out.println("案例四");
        test(new ByteArrayInputStream(("3 4\n" +
                "- - - -\n" +
                "- * - -\n" +
                "- * - -\n" +
                "2 0").getBytes()));
    }
}
