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

package view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Customer;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import services.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 10/5/2017
 * @project ORMThogaKade
 **/

public class PlaceOrderFormController implements Initializable{

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXComboBox cbxSelectedCustomer;

    @FXML
    private JFXTextField txtOrderDate;

    @FXML
    private JFXTextField txtOrderPriority;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXComboBox cbxSelectedItem;

    @FXML
    private JFXTextField txtOrderQty;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private Label txtTotal;

    @FXML
    private JFXButton btnConfirmOrder;

    @FXML
    private JFXButton btnAddCustomer;

    @FXML
    private JFXButton btnUpdateCustomer;

    @FXML
    private JFXButton btnDeleteCustomer;

    @FXML
    private JFXButton btnAddOrder;

    @FXML
    private JFXComboBox cbxSelectedCustomerPNO;

    @FXML
    private JFXComboBox cbxSelectedOrderPNO;

    private ArrayList<String> selectedItemList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxSelectedItem();
        setTodayDate();
    }

    @FXML
    private void addCustomerAction(){
        String customerName=txtCustomerName.getText();
        String customerAddress=txtCustomerAddress.getText();
        int customerTel= Integer.parseInt(txtContactNo.getText());

        System.out.println(customerName+" "+customerAddress+" "+customerTel);
        Customer customer=new Customer(customerName,customerTel);
        boolean addCustomer=CustomerServices.addCustomer(customer);

        if (addCustomer){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStyleClass().add("myDialog");
            alert.setTitle("Customer Add");
            alert.setHeaderText("This is an infomation dialog");
            alert.setContentText("Customer has being added sucessfully!!");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStyleClass().add("myDialog");
            alert.setTitle("Customer Add");
            alert.setHeaderText("This is an error dialog");
            alert.setContentText("OOPs there is an error adding customer");
            alert.showAndWait();
        }
    }

    @FXML
    private void searchCustomer(){
        Customer searchCustomerName=CustomerServices.serchICusstomer(txtCustomerName.getText());

        if (searchCustomerName !=null){
            txtContactNo.setText(String.valueOf(searchCustomerName.getContactNo()));
        }
    }

    private void comboBoxSelectedItem(){
        cbxSelectedItem.getItems().addAll("");
    }

    private void setTodayDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String todayDate=dateFormat.format(date);

        txtOrderDate.setText(todayDate);
    }

    private void setCbxSelectedCustomer(){
        cbxSelectedCustomer.getItems().addAll(CustomerServices.viewAllCustomer());
    }
}
