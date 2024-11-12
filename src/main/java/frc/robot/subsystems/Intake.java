package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake {

    TalonSRX intake;

    public Intake(){
        intake = new TalonSRX(Constants.kIntake);
    }
    
    public void eat(double Rtrigger, double Ltrigger){
        if(Rtrigger>Constants.kStickTolerance){
            intake.set(ControlMode.PercentOutput, Rtrigger);
        }else if(Ltrigger>Constants.kStickTolerance){
            intake.set(ControlMode.PercentOutput, -Ltrigger);
        }else{
            intake.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public void stop(){
        intake.set(ControlMode.PercentOutput, 0);
    }
}   
