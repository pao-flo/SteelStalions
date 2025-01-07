package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class TurnRightAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalTurnRightAction(double angle, double desiredAngle){
    if(angle>desiredAngle){ 
      mAutoDrive.outMotoresAuto(0.5, 0.5, 0.5, 0.5);
    }else
      mAutoDrive.outMotoresAuto(0, 0, 0, 0);
    //checar signos
  }
}