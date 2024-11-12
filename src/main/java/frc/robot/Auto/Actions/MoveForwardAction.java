package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class MoveForwardAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalMoveForwardACtion(){
    mAutoDrive.outMotoresAuto(-0.3, -0.3, 0.3, 0.3);
    //checar signos
  }
}