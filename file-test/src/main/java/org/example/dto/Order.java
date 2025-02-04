package org.example.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 订单实体类
 * @author lixiang
 */
@Data
public class Order {

    /**
     * 订单金额
     */
    private int amount;

    /**
     * 积分
     */
    private int score;

    /**
     * 规则匹配后的插入的结果
     */
    private List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Order o1 = new Order();
        o1.getResultList().add("1");


        Order o2 = new Order();
        o2.getResultList().add("2");

        Order o3 = new Order();

        System.out.println(o1.getResultList() + "|" + o2.getResultList() + "|" + o3.getResultList());
    }
}