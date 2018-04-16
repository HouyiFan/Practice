public class BB_1D_XiaoXiaoLe {
    //要实现一个一维的消消乐，也就是多于三个连续的元素要删掉，要考虑级联输入(1,2,2,2,1)要输出(1,1)
    //输入(1,2,2,2,1,1)要输出(). from: 1point3acres.com/bbs
    //输入(1,2,2,2,1,1,3,3,3,1)要输出(1)，因为消除三个2的时候，三个1放到了一起被消掉了。所以最后的1留下来了
    //一开始问我打算输入输出用啥type，说string。然后问要in-place，于是改array。又问删除复杂度是多少能不能更快一点，
    //于是换成链表。

    public static void eliminateContinuous(int[] nums) {
        int l = 0;
        //        List<Integer> list = new ArrayList<Integer>();
        //        for (int num : nums) {
        //            list.add(num);
        //        }
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (l - 2 < 0 || nums[i] != nums[l - 1] || nums[i] != nums[l - 2]) {
                nums[l++] = nums[i];
                //                continue;
            } else {
                l = l - 2;
            }
        }

        for (i = 0; i < l - 1; i++) {
            System.out.print(nums[i]);
            System.out.print(",");
        }
        if (l != 0) {
            System.out.print(nums[l - 1]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        eliminateContinuous(new int[] { 1, 2, 2, 1, 1, 3, 3, 3, 1 });
        System.out.println();
        eliminateContinuous(new int[] { 1, 2, 2, 2, 1 });
        System.out.println();
        eliminateContinuous(new int[] { 1, 2, 2, 2, 1, 3, 3, 3, 1 });
        System.out.println();
        eliminateContinuous(new int[] { 1, 1, 2, 2, 1, 2, 1, 3, 3, 3, 1 });

    }

}
