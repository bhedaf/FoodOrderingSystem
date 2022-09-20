package com.example.sheridanbagelhouseproject;

/*
* @author Fizza Imran  991670304
* @author Freya Bheda  991643368
*
* Description: This is a controller class that has Event listner methods that respond when a perticular
* element is clicked
* modified: 6 Aug 2022
* */

//import statments
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import java.lang.Integer;
public class  SheridanBagelHouseController {

    //fxml  datatype declarations

    @FXML
    private TextField cafetxt;

    @FXML
    private TextField cappuccinotxt;

    @FXML
    private CheckBox chkBlueberry;

    @FXML
    private CheckBox chkButter;

    @FXML
    private CheckBox chkCreamChesse;

    @FXML
    private CheckBox chkPeach;

    @FXML
    private CheckBox chkRaspberry;

    @FXML
    private RadioButton radCafeAuLait;

    @FXML
    private RadioButton radCappuccino;

    @FXML
    private RadioButton radNoCoffee;

    @FXML
    private RadioButton radRegCoffee;

    @FXML
    private RadioButton radWheat;

    @FXML
    private RadioButton radWhite;

    @FXML
    private TextField regulartxt;

    @FXML
    private TextField subtotaltxt;

    @FXML
    private TextField taxtxt;

    @FXML
    private TextField totaltxt;

    @FXML
    private TextField whitetxt;

    @FXML
    private TextField wholetxt;

    @FXML
    private AnchorPane toppingPane;

    @FXML
    private AnchorPane coffeePane;

    @FXML
    private DialogPane errorMessage;
    @FXML
    private TextField errorTxt;
    @FXML
    private DialogPane reciptDialog;
    @FXML
    private TextArea receiptTxt;


    //feilds
    private static double price;
    private static double tax;
    private static double total;
    private static int bagelQuantity;
    private static int coffeeQuantity;
    private static double bagelPrice;
    private static double coffeePrice;
    private static int calculateCounter = 1;


    /*this method enables the toppings and coffee only when a bagel is selected*/
    public void bagelSelectionListner() {
        if (radWhite.isSelected() || radWheat.isSelected()) {
            toppingPane.setDisable(false);
            coffeePane.setDisable(false);
        }
    }

    /*this method checks which bagel is selected and calculates its price, it further calls the
        toppingsSelection() method as many times as a bagel is selected */
    public void bagelSelection() {
        //check if white bagel is selected
        if (radWhite.isSelected()) {
            //check if quantity is not null or empty
            if (whitetxt.getText() != null && whitetxt.getText() != "") {
                try {
                    //check that quantity is more than 0 else throw exception.
                    if (Integer.parseInt(whitetxt.getText()) > 0) {
                        bagelQuantity = Integer.parseInt(whitetxt.getText());
                        bagelPrice = (1.25 * bagelQuantity);
                        price += bagelPrice;
                    } else {
                        //if quantity is less than zero or if the format is wrong, exception will be thrown.
                        throw new RuntimeException();
                    }
                }catch (Exception e) {
                    errorMessageGenrator(); //exception calls another method to display error.
                }
            } else {
                whitetxt.setText("required");  //if no quantity is selected show required.
            }
        } else if (radWheat.isSelected()) { //if whole wheat bagel is selected
            //check if quantity is not null or empty
            if (wholetxt.getText() != null && wholetxt.getText() != "") {
                try {
                    //check that quantity is more than 0 else throw exception.
                    if (Integer.parseInt(wholetxt.getText()) > 0) {
                        bagelQuantity = Integer.parseInt(wholetxt.getText());
                        bagelPrice = (1.50 * bagelQuantity);
                        price += bagelPrice;
                    } else {
                        //if quantity is less than zero or if the format is wrong, exception will be thrown.
                        throw new RuntimeException();
                    }
                } catch (Exception e) {
                    errorMessageGenrator(); //exception calls another method to display error.
                }
            } else {
                wholetxt.setText("required"); //if no quantity is selected show required.
            }
        }
        if (bagelQuantity > 0) {   //calls toppings as many times as the bagel quantity.
            for (int i = 1; i <= bagelQuantity; i++) {
                toppingSelection();
            }
        }
    }

    /* calculates the price of toppings*/
    public void toppingSelection() {
        if (chkBlueberry.isSelected()) {  //if blueberry jam is selected
            price += 0.75;
        }
        if (chkButter.isSelected()) { //if butter is selected
            price += 0.25;
        }
        if (chkCreamChesse.isSelected()) {  //if cream chesse is selected
            price += 0.50;
        }
        if (chkRaspberry.isSelected()) {  //if raspberry jam is selected
            price += 0.75;
        }
        if (chkPeach.isSelected()) {  //if peach jelly is selected
            price += 0.75;
        }
    }


    /*checks which coffee is selected and calculates the price*/
    public void coffeeSelection() {
        //if cappuccino is selected
        if (radCappuccino.isSelected()) {
            //check if quantity is not null or empty
            if (cappuccinotxt.getText() != null && cappuccinotxt.getText() != "") {
                try {
                    //check that quantity is more than 0 else throw exception.
                    if (Integer.parseInt(cappuccinotxt.getText()) > 0) {
                        coffeeQuantity = Integer.parseInt(cappuccinotxt.getText());
                        coffeePrice = (2.00 * coffeeQuantity);
                        price += coffeePrice;
                    } else {
                        //if quantity is less than zero or if the format is wrong, exception will be thrown.
                        throw new RuntimeException();
                    }
                } catch (Exception e) {
                    //exception calls another method to display error.
                    errorMessageGenrator();
                }
            } else {
                cappuccinotxt.setText("required"); //if no quantity is selected show required.
            }
        } else if (radRegCoffee.isSelected()) { //if regular coffee is selected
            //check if quantity is not null or empty
            if (regulartxt.getText() != null && regulartxt.getText() != "") {
                try {
                    //check that quantity is more than 0 else throw exception.
                    if (Integer.parseInt(regulartxt.getText()) > 0) {
                        coffeeQuantity = Integer.parseInt(regulartxt.getText());
                        coffeePrice = (1.25 * coffeeQuantity);
                        price += coffeePrice;
                    } else {
                        //if quantity is less than zero or if the format is wrong, exception will be thrown.
                        throw new RuntimeException();
                    }
                } catch (Exception e) {
                    //exception calls another method to display error.
                    errorMessageGenrator();
                }
            } else {
                regulartxt.setText("required");  //if no quantity is selected show required.
            }
        } else if (radCafeAuLait.isSelected()) {  // if cafe au lait is selected
            //check if quantity is not null or empty
            if (cafetxt.getText() != null && cafetxt.getText() != "") {
                try {
                    //check that quantity is more than 0 else throw exception.
                    if (Integer.parseInt(cafetxt.getText()) > 0) {
                        coffeeQuantity = Integer.parseInt(cafetxt.getText());
                        coffeePrice = (1.75 * coffeeQuantity);
                        price += coffeePrice;
                    } else {
                        //if quantity is less than zero or if the format is wrong, exception will be thrown.
                        errorMessageGenrator();
                    }
                } catch (Exception e) {
                    //exception calls another method to display error.
                    throw new RuntimeException();
                }
            } else {
                cafetxt.setText("required");   //if no quantity is selected show required.
            }
        } else if (radNoCoffee.isSelected()) {  //if no coffee is selcted
            coffeePrice = 0.0;
        }
    }

        //this calculates total price when the calculate button is clicked
        public void calculateButtonListner () {
        /* making sure calculate button does calculate wrong total by letting user add more to price
           each time they click it */
            if (calculateCounter == 1) {
                bagelSelection();
                coffeeSelection();
                //price of bagel + toppings + coffee without tax
                price = Math.round(price * 100.0) / 100.0;
                subtotaltxt.setText(Double.toString(price));

                //total tax
                tax = price * 0.13;
                tax = Math.round(tax * 100.0) / 100.0;
                taxtxt.setText(Double.toString(tax));

                //price after tax
                total = tax + price;
                total = Math.round(total * 100.0) / 100.0;
                totaltxt.setText(Double.toString(total));
                calculateCounter++;
            }
            //guiding user to use reset button if they need to change order details.
            else{
                resetError();
            }
        }

        //this method is executes when reset button is called, it resets the whole form
        // and clears all set data, set everything to empty and brings the form to initial state
        public void resetButtonListner () {

            toppingPane.setDisable(true);
            coffeePane.setDisable(true);
            radWhite.setSelected(false);
            radWheat.setSelected(false);
            radNoCoffee.setSelected(false);
            radRegCoffee.setSelected(false);
            radCappuccino.setSelected(false);
            radCafeAuLait.setSelected(false);
            chkPeach.setSelected(false);
            chkRaspberry.setSelected(false);
            chkButter.setSelected(false);
            chkBlueberry.setSelected(false);
            chkCreamChesse.setSelected(false);
            whitetxt.setText("");
            wholetxt.setText("");
            regulartxt.setText("");
            cappuccinotxt.setText("");
            cafetxt.setText("");
            totaltxt.setText("");
            taxtxt.setText("");
            subtotaltxt.setText("");
            price = 0.0;
            tax = 0.0;
            total = 0.0;
            bagelQuantity = 0;
            coffeeQuantity = 0;
            coffeePrice = 0.0;
            bagelPrice = 0.0;
            calculateCounter = 1;
        }

        //this method closescalculateCounter the window and exits the form
        public void exitButtonListner () {
            Platform.exit();
        }

        //this method genrates a recipt.
        public String getRecipt () {
            return bagelQuantity + " Bagel with toppings:    " + bagelPrice +
                    "\n" + coffeeQuantity + " Coffee:    " + coffeePrice +
                    "\nSubtotal:    " + price +
                    "\ntax:    " + tax +
                    "\nTotal:    " + total;

        }

        //this message dispalys error pop up when the quantity is not right.
        public void errorMessageGenrator (){
            errorMessage.setVisible(true);
            errorTxt.setText("Enter correct amount for quantity");
            resetButtonListner();
        }

        //this message quides the user to use the reset button
        public void resetError(){
            errorMessage.setVisible(true);
            errorTxt.setText("Please reset to make changes and recalculation");
        }

        //this method is used to exit the error message dialog box.
        public void exitErrorMessage(){
            errorMessage.setVisible(false);
        }

        //this message is to exit the receipt pop up
        public void exitReceipt(){reciptDialog.setVisible(false);}

        //this method calls a method of another class to append the recipt to the file and then dispalys
        //it on screen using a pop-up
        public void printToFileListner () {
            PrintController.printToFile(getRecipt());
            reciptDialog.setVisible(true);
            receiptTxt.setText(getRecipt());
        }

        //this method calls a method of another class to print recipt to printer
        public void printToPrinter () {
            PrintController.printToPrinter(getRecipt());
        }
    }
