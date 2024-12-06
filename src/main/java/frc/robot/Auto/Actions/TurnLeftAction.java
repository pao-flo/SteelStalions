package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class TurnLeftAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalTurnLeftAction(double angle, double desiredAngle){
    if (angle<desiredAngle) {
       mAutoDrive.outMotoresAuto(-0.3, -0.3, -0.3, -0.3);
    }else
    mAutoDrive.outMotoresAuto(0, 0, 0, 0);
    //checar signos
  }
}