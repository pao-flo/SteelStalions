package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class TurnLeftAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalTurnLeftAction(){
    mAutoDrive.outMotoresAuto(-0.3, -0.3, -0.3, -0.3);
    //checar signos
  }
}