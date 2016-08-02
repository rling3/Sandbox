package test;

import java.util.Random;

public class Test {












    // arraycopy performance time
    private void arrayCopyPerfTest() {

        int[] lengths = new int[] { 10000, 50000, 125000, 250000 };
        int[] loops = new int[] { 1000, 5000, 10000, 20000 };

        for (int length : lengths) {
            for (int loop : loops) {

                Object[] list1 = new Object[length];
                Object[] list2 = new Object[length];

                for (int k = 0; k < 100; k++) {
                    System.arraycopy(list1, 0, list2, 0, list1.length);
                }

                int[] len = new int[loop];
                int[] ofs = new int[loop];

                Random rnd = new Random();
                for (int k = 0; k < loop; k++) {
                    len[k] = rnd.nextInt(length);
                    ofs[k] = rnd.nextInt(length - len[k]);
                }

                long n = System.nanoTime();
                for (int k = 0; k < loop; k++) {
                    System.arraycopy(list1, ofs[k], list2, ofs[k], len[k]);
                }
                n = System.nanoTime() - n;
                System.out.print("length: " + length);
                System.out.print("\tloop: " + loop);
                System.out.print("\truntime [ms]: " + n / 1000000);
                System.out.println();
            }
        }
    }
}

