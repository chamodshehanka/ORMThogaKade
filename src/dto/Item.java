/*
 *  Copyright (C) 2017 Chamod Shehanka - All Rights Reserved
 *  * You may use, distribute and modify this code under the
 *  * terms of the Chamod Shehanka license, which unfortunately won't be
 *  * written for another century.
 *  *
 *  * You should have received a copy of the Chamod Shehanka license with
 *  * this file. If not, please write to: , or visit : http://chamodshehanka.com/
 *
 */

package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author chamodshehanka on 10/5/2017
 * @project ORMThogaKade
 **/
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int iid;
    private String name;
    private double price;
    private int qty;

    @Override
    public String toString() {
        return "Item{" +
                "iid=" + iid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public Item() {
    }

    public Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
