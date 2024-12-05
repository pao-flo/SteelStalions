package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class TurnRightAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalTurnRightAction(){
    mAutoDrive.outMotoresAuto(0.3, 0.3, 0.3, 0.3);
    //checar signos
  }
}