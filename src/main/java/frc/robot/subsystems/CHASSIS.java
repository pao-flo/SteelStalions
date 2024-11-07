package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;

public class Chassis {
    //hardware
    static TalonSRX mDriveLeft1; 
    static TalonSRX mDriverLeft2;
    static TalonSRX mDriverRight1;
    static TalonSRX mDriverRight2;
    
    //logica
    double speed;


    double leftspeed;
    double rightspeed;

    double realleftSpeed;
    double realrightSpeed;


    //constructor
    public Chassis(){
        mDriveLeft1 = new TalonSRX(Constants.kDriveLeft1);
        mDriverLeft2 = new TalonSRX(Constants.kDriveLeft2);
        mDriverRight1 = new TalonSRX(Constants.kDriveRight1);
        mDriverRight2 = new TalonSRX(Constants.kDriveRight2);

        speed = 0;
        realleftSpeed = 0;
        realrightSpeed = 0;
        leftspeed = 0;
        rightspeed = 0;
    }
    //funciones
    public void stop(){
        mDriveLeft1.set(ControlMode.PercentOutput, 0);
        mDriverLeft2.set(ControlMode.PercentOutput, 0);
        mDriverRight1.set(ControlMode.PercentOutput, 0);
        mDriverRight2.set(ControlMode.PercentOutput, 0);
    }
    public void avanzar(double yinput, double xinput){
        if(yinput<0){
            rightspeed = yinput+xinput;
            leftspeed = yinput-xinput;
        }
        else{
            rightspeed = yinput-xinput;
            leftspeed = yinput+xinput;
        }
        realleftSpeed = leftspeed;
        realrightSpeed = rightspeed;
        mDriveLeft1.set(ControlMode.PercentOutput, realleftSpeed);
        mDriverLeft2.set(ControlMode.PercentOutput, realleftSpeed);
        mDriverRight1.set(ControlMode.PercentOutput, -realrightSpeed);
        mDriverRight2.set(ControlMode.PercentOutput, -realrightSpeed);
    }
}
   