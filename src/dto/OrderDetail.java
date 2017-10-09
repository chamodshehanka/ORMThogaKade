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
public class OrderDetail {
    private int orderQty;
    private double orderPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false))
    private Order orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "iid",referencedColumnName = "iid",insertable = false,updatable = false))
    private Item item;
    @EmbeddedId
    private OrderDetail_PK orderDetail_pk;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderQty=" + orderQty +
                ", orderPrice=" + orderPrice +
                ", orders=" + orders +
                ", item=" + item +
                ", orderDetail_pk=" + orderDetail_pk +
                '}';
    }

    public OrderDetail() {
    }

    public OrderDetail(int orderQty, double orderPrice, Order orders, Item item, OrderDetail_PK orderDetail_pk) {
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;
        this.orders = orders;
        this.item = item;
        this.orderDetail_pk = orderDetail_pk;
    }
}
