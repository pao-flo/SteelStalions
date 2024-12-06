package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class MoveForwardAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalMoveForwardAction(){
    mAutoDrive.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
    //checar signos
  }
}