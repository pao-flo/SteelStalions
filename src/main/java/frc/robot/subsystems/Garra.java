package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {

    TalonSRX Garra;

    double velocidad;

    public Garra(){
        Garra = new TalonSRX(Constants.kGarra);
        velocidad = 0;
    }

    public void grab(double Rstick){
        if(Rstick>Constants.kStickTolerance){
            Garra.set(ControlMode.PercentOutput, 0.4);
        }else if(Rstick<-Constants.kStickTolerance){
            Garra.set(ControlMode.PercentOutput, -0.4);
        }else{
            Garra.set(ControlMode.PercentOutput, 0);
        }
    }
    
    public void stop(){
        velocidad=0;
    }
}