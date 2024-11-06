package frc.robot.ControlBoard;

import edu.wpi.first.wpilibj.XboxController;

public class Control {
    //Hardware
    XboxController driver;
    //Logica
    double tolerance;
    //Constructor
    public Control(){
        driver = new XboxController(0);
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
}