package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {

    TalonSRX Garra;
    CANSparkMax Arm;

    public Garra(){
        Garra = new TalonSRX(Constants.kGarra);
        Arm = new CANSparkMax(Constants.kArm, MotorType.kBrushless);
    }

    public void grab(double Rstick){
        if(Math.abs(Rstick)>Constants.kStickTolerance){
            Garra.set(ControlMode.PercentOutput, Rstick);
        }else{
            Garra.set(ControlMode.PercentOutput, 0);
        }
    }

    public void moveArm(double Lstick){
        if(Math.abs(Lstick)>Constants.kStickTolerance){
            Arm.set(Lstick);
        }else{
            Arm.set(0);
        }
    }
    
    public void stop(){
        Garra.set(ControlMode.PercentOutput, 0);
        Arm.set(0);
    }
}