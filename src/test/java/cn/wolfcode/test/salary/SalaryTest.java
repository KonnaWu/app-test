package cn.wolfcode.test.salary;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryTest {

    private static final int WORK_HOURS_IN_MONTH = 200;
    private static final int WORK_HOURS_BOUND = 10;
    private static final BigDecimal OVER_TIME_SCALE = new BigDecimal("1.5");
    private static final BigDecimal OVER_TIME_COST = new BigDecimal("4.00");

    @Test
    public void test() {
        BigDecimal s1 = caleSalary(new BigDecimal("1000"), 9);
        System.out.println(s1);
        BigDecimal s2 = caleSalary(new BigDecimal("2500"), 11);
        System.out.println(s2);
        BigDecimal s3 = caleSalary(new BigDecimal("1000"), 15);
        System.out.println(s3);
    }

    public BigDecimal caleSalary(BigDecimal salary, int overTime) {
        BigDecimal hourSalary = salary.divide(new BigDecimal(WORK_HOURS_IN_MONTH), 2, RoundingMode.HALF_UP);
        BigDecimal overTimeCost = new BigDecimal("0.00");
        if (overTime <= 0) {
            return salary;
        }
        if (overTime - WORK_HOURS_BOUND <= 0) {
            // 当加班时间在10小时以内,加班时薪为正常时薪的1.5倍
            BigDecimal overTimeHourCost = hourSalary.multiply(OVER_TIME_SCALE);
            overTimeCost = overTimeHourCost.multiply(new BigDecimal(overTime));
        } else {
            int time = overTime - WORK_HOURS_BOUND;
            BigDecimal timeCost = OVER_TIME_COST.multiply(new BigDecimal(time));
            // 当加班时间在10小时以内,加班时薪为正常时薪的1.5倍
            BigDecimal overTimeHourCost = hourSalary.multiply(OVER_TIME_SCALE);
            overTimeCost = overTimeHourCost.multiply(new BigDecimal(WORK_HOURS_BOUND)).add(timeCost);
        }
        return salary.add(overTimeCost);
    }
}
