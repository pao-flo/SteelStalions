package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Chassis {
    //hardware
    public AHRS navx;
    public double angle;

    //-----------------------características---------------------//
    //Hardware
    TalonSRX Right1;
    TalonSRX Right2;
    TalonSRX Left1;
    TalonSRX Left2;
    
    //Variables de logica
    double velocidad;
    double rightSpeed;
    double leftSpeed;
    double realRightSpeed;
    double realLeftSpeed;


    //constructor
    public Chassis(){
        Right1 = new TalonSRX(Constants.kDriveRight1);
        Right2 = new TalonSRX(Constants.kDriveRight2);
        Left1 = new TalonSRX(Constants.kDriveLeft1);
        Left2 = new TalonSRX(Constants.kDriveLeft2);
        //cosas que iniciamos
        velocidad=0;
        realLeftSpeed=0;
        realRightSpeed=0;

        /*try{
            navx = new AHRS(SPI.Port.kMXP);
            Timer.delay(0.5);
            navx.reset();
            Timer.delay(0.5);
        }
        catch(Exception e){
            System.out.println("navx not working");
        }*/
    }

    public void avanzar(double yInput, double xInput){
        if(yInput>0){
            rightSpeed = yInput + xInput;
            leftSpeed = yInput - xInput;
            }else{
            rightSpeed = yInput + xInput;
            leftSpeed = yInput - xInput;
            }
    
            if(Math.abs(realRightSpeed)>Math.abs(rightSpeed)){
                realRightSpeed = realRightSpeed - 0.05;
            }else if(Math.abs(realRightSpeed)<Math.abs(rightSpeed)){
                realRightSpeed = realRightSpeed + 0.05;
            }else{
                realRightSpeed = rightSpeed;
            }
    
            //cosas de la funcion
            Right1.set(ControlMode.PercentOutput, rightSpeed);
            Right2.set(ControlMode.PercentOutput, rightSpeed);
            Left1.set(ControlMode.PercentOutput, -leftSpeed);
            Left2.set(ControlMode.PercentOutput, -leftSpeed);
    }

    public void outMotoresAuto( double left1, double left2, 
    double right1, double right2 ){
      Left1.set(ControlMode.PercentOutput, left1);
      Left2.set(ControlMode.PercentOutput, left2);
      Right1.set(ControlMode.PercentOutput, right1);
      Right2.set(ControlMode.PercentOutput, right2);
    }

    public void stop(){
        Left1.set(ControlMode.PercentOutput, 0);
        Left2.set(ControlMode.PercentOutput, 0);
        Right1.set(ControlMode.PercentOutput, 0);
        Right2.set(ControlMode.PercentOutput, 0);
    }

    public void outputTelemetry(){
        //SmartDashboard.putNumber("navx angle", navx.getAngle());
    }
}
   