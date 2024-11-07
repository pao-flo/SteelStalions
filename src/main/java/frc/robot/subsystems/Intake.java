package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake {

    TalonSRX intake;
    double velocidad;

    public Intake(){
        intake = new TalonSRX(0);
        velocidad = 0;
    }
    public void eat(double Rstick){
        if(Rstick>0){
            intake.set(ControlMode.PercentOutput, 0.4);
        }else if(Rstick<0){
            intake.set(ControlMode.PercentOutput, -0.4);
        }else{
            intake.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public void stop(){
        velocidad=0;
    }
}   
