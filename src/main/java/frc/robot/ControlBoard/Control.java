package frc.robot.ControlBoard;

import edu.wpi.first.wpilibj.XboxController;

public class Control {
    //Hardware
    XboxController driver;
    XboxController mecanisms;
    //Logica
    double tolerance;
    //Constructor
    public Control(){
        driver = new XboxController(0);
        mecanisms = new XboxController(1);
        tolerance = 0.15;
    }
    
    //Funciones
    public double left_X_stick_driver(){
        double xValue = driver.getLeftX();
        if(Math.abs(xValue)<tolerance){xValue=0;}
        return xValue;
    }
    public double left_Y_stick_driver(){
        double yValue = driver.getLeftY();
        if(Math.abs(yValue)<tolerance){yValue=0;}
        return yValue;
    }
    public double right_x_stick_driver(){
        double xValue = driver.getRawAxis(4);
        if (Math.abs(xValue)<tolerance){
            xValue = 0;
        }
        return xValue;
    }
    public double right_y_stick_driver(){
        double yValue = driver.getRawAxis(5);
        if (Math.abs(yValue)<tolerance){
            yValue = 0;
        }
        return yValue;
    }

    public boolean driver_a_button(){
        return driver.getAButton();
    }
    public boolean driver_b_button(){
        return driver.getBButton(); 
    }
    public boolean driver_x_button(){
        return driver.getXButton();
    }
    public boolean driver_y_button(){
        return driver.getYButton();
    }

    public double left_trigger_driver(){
        double tValue = driver.getLeftTriggerAxis();
        if (Math.abs(tValue)<tolerance){
            tValue = 0;
        }
        return tValue;
    }
    public double right_trigger_driver(){
        double tValue = driver.getRightTriggerAxis();
        if (Math.abs(tValue)<tolerance){
            tValue = 0;
        }
        return tValue;
    }
    //mecanismos
    public double left_x_stick_mecanisms(){
        double xValue = mecanisms.getRawAxis(0);
        if (Math.abs(xValue)<tolerance){
            xValue = 0;
        }
        return xValue;
    }
    public double left_y_stick_mecanisms(){
        double yValue = mecanisms.getRawAxis(1);
        if (Math.abs(yValue)<tolerance){
            yValue = 0;
        }
        return yValue;
    }
    public double right_x_stick_mecanisms(){
        double xValue = mecanisms.getRawAxis(4);
        if (Math.abs(xValue)<tolerance){
            xValue = 0;
        }
        return xValue;
    }
    public double right_y_stick_mecanisms(){
        double yValue = mecanisms.getRawAxis(5);
        if (Math.abs(yValue)<tolerance){
            yValue = 0;
        }
        return yValue;
    }

//mecanismos
    public boolean mecanisms_a_button(){
        return mecanisms.getAButton();
    }
    public boolean mecanisms_b_button(){
        return mecanisms.getBButton();
    }
    public boolean mecanisms_x_button(){
        return mecanisms.getXButton();
    }
    public boolean mecanisms_y_button(){
        return mecanisms.getYButton();
    }
    public boolean mecanisms_left_bumper(){
        return mecanisms.getLeftBumper();
    }
    public boolean mecanisms_rigth_bumper(){
        return mecanisms.getRightBumper();
    }

    public double left_trigger_mecanisms(){
        double tValue = mecanisms.getLeftTriggerAxis();
        if (Math.abs(tValue)<tolerance){
            tValue = 0;
        }
        return tValue;
    }
    public double right_trigger_mecanisms(){
        double tValue = mecanisms.getRightTriggerAxis();
        if (Math.abs(tValue)<tolerance){
            tValue = 0;
        }
        return tValue;
    }

}