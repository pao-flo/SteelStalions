package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

public class CHASSIS {
    //hardware
    static TalonFX mDriveLeft1; 
    static TalonFX mDriverleft2;
    static TalonFX mDriverright1;
    static TalonFX mDriverright2;
    
    //logica
    double speed;


    double leftspeed;
    double rightspeed;

    double realleftSpeed;
    double realrightSpeed;


    //constructor
    public CHASSIS(){
        mDriveLeft1 = new TalonFX(0);
        mDriverleft2 = new TalonFX(1);
        mDriverright1 = new TalonFX(2);
        mDriverright2 = new TalonFX(3);

        speed = 0;
        realleftSpeed = 0;
        realrightSpeed = 0;
        leftspeed = 0;
        rightspeed = 0;
    }
    //funciones
    public void stop(){
        mDriveLeft1.set(0);
        mDriverleft2.set(0);
        mDriverright1.set(0);
        mDriverright2.set(0);
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
        mDriveLeft1.set(realleftSpeed);
        mDriverleft2.set(realleftSpeed);
        mDriverright1.set(-realrightSpeed);
        mDriverright2.set(-realrightSpeed);
    }
}
   