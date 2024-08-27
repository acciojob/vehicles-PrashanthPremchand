package com.driver;

public class F1 extends Car {

    public F1(String name, boolean isManual) {
        //Use arbitrary values for parameters which are not mentioned
        super(name, 4, 2, 6,isManual, "Automatic", 2);
    }

    public void accelerate(int rate){
        int newSpeed = 0; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        newSpeed = super.getCurrentSpeed() + rate;
        if(newSpeed < 0) newSpeed = 0;
        if(newSpeed == 0) {
            //Stop the car, set gear as 1
            super.stop();
            super.setCurrentGear(1);
        }
        //for all other cases, change the gear accordingly
        else if(newSpeed <= 50) super.setCurrentGear(1);
        else if(newSpeed <= 100) super.setCurrentGear(2);
        else if(newSpeed <= 150) super.setCurrentGear(3);
        else if(newSpeed <= 200) super.setCurrentGear(4);
        else if(newSpeed <= 250) super.setCurrentGear(5);
        else super.setCurrentGear(6);
        if(newSpeed > 0) {
            super.changeSpeed(newSpeed, getCurrentDirection());
        }
    }
}
