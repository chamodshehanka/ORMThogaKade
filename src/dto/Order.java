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

import javax.persistence.*;

/**
 * @author chamodshehanka on 10/5/2017
 * @project ORMThogaKade
 **/

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int oid;
    private String orderDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", orderDate='" + orderDate + '\'' +
                ", customer=" + customer +
                '}';
    }

    public Order() {
    }

    public Order(String orderDate, Customer customer) {
        this.orderDate = orderDate;
        this.customer = customer;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
