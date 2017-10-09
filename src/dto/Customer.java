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
import java.util.List;

/**
 * @author chamodshehanka on 10/5/2017
 * @project ORMThogaKade
 **/

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String customerName;
    private int contactNo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", customerName='" + customerName + '\'' +
                ", contactNo=" + contactNo +
                ", orders=" + orders +
                '}';
    }

    public Customer() {
    }

    public Customer(String customerName, int contactNo) {
        this.customerName = customerName;
        this.contactNo = contactNo;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
