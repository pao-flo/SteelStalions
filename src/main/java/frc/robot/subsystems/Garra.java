
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Garra extends SubsystemBase {

    CANSparkMax Garra;

    public Garra(){
        Garra = new CANSparkMax(Constants.kGarra, MotorType.kBrushless);
    }

    public void grab(double Rstick){
        if(Math.abs(Rstick)>Constants.kStickTolerance){
            Garra.set(Rstick*0.3);
        }else{
            Garra.set(0);
        }
    }
    
    public void stop(){
        Garra.set(0);
    }
}