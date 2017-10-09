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

import java.io.Serializable;

/**
 * @author chamodshehanka on 10/7/2017
 * @project ORMThogaKade
 **/
public class OrderDetail_PK implements Serializable{

    private int oid;
    private int iid;

    public OrderDetail_PK() {

    }

    public OrderDetail_PK(int oid, int iid) {
        this.oid = oid;
        this.iid = iid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }
}
