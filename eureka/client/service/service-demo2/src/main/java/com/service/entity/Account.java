package com.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/12 20:27
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
