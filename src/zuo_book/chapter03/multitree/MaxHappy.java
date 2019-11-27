package zuo_book.chapter03.multitree;

import java.util.List;

/**
 * 多叉树 派对的最大快乐值
 */
public class MaxHappy {
    static class Employee {
        int happy;
        List<Employee> subEmployee;

        public Employee(int happy, List<Employee> subEmployee) {
            this.happy = happy;
            this.subEmployee = subEmployee;
        }
    }

    static class ReturnType {
        int yesHeadMax;
        int noHeadMax;

        public ReturnType(int yesHeadMax, int noHeadMax) {
            this.yesHeadMax = yesHeadMax;
            this.noHeadMax = noHeadMax;
        }
    }

    //以X 为头结点的子树
    public static ReturnType process(Employee X) {
        int yesX = X.happy;
        int noX = 0;
        if (X.subEmployee == null) {
            return new ReturnType(yesX, noX);
        }
        for (Employee next :
                X.subEmployee) {
            ReturnType subInfo = process(next);
            yesX += subInfo.noHeadMax;
            noX += Math.max(subInfo.yesHeadMax, subInfo.noHeadMax);
        }
        return new ReturnType(yesX, noX);
    }

    public static int getMaxHappy(Employee boss) {
        ReturnType allInfo = process(boss);
        return Math.max(allInfo.yesHeadMax, allInfo.noHeadMax);
    }


}
