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

package services;

import core.SessionFactoryUtil;
import dto.Customer;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author chamodshehanka on 10/7/2017
 * @project ORMThogaKade
 **/
public class CustomerServices {
    private static SessionFactory sessionfactory;

    public static boolean addCustomer(Customer customer){
        sessionfactory= SessionFactoryUtil.getSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = null;

        try{
            transaction=session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    public static Customer serchICusstomer(String name){
        sessionfactory=SessionFactoryUtil.getSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = null;

        try{
            transaction=session.beginTransaction();
            Criteria studentlist=session.createCriteria(Customer.class).add(Restrictions.eq("cname", name));
            List<Customer> customerlist=studentlist.list();
            for(Customer cus : customerlist){
                transaction.commit();
                return cus;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }

    public static boolean UpdateCustomer(Customer customer){
        sessionfactory=SessionFactoryUtil.getSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = null;

        try{
            transaction=session.beginTransaction();
            Criteria serchstudent=session.createCriteria(Customer.class).add(Restrictions.eq("cname", customer.getCustomerName()));
            List<Customer> customerlist=serchstudent.list();
            for (Customer ustomer : customerlist) {
                ustomer.setCustomerName(customer.getCustomerName());
                ustomer.setContactNo(customer.getContactNo());
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    public static boolean Delecustomer(String name){
        sessionfactory=SessionFactoryUtil.getSessionFactory();
        sessionfactory=SessionFactoryUtil.getSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = null;

        try{
            transaction=session.beginTransaction();
            Criteria studentlist=session.createCriteria(Customer.class).add(Restrictions.eq("cname", name));
            List<Customer> clist=studentlist.list();
            for(Customer cust : clist){
                session.delete(cust);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }

    public static List<Customer> viewAllCustomer(){

        sessionfactory=SessionFactoryUtil.getSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = null;

        try{
            transaction=session.beginTransaction();
            List<Customer> stdList=session.createQuery("from Customer").list();
            transaction.commit();
            return stdList;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
}}
