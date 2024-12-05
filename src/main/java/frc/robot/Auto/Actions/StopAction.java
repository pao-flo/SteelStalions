package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;

public class StopAction{
  Chassis mAutoDrive = new Chassis();
  
  public void finalStopAction(){
    mAutoDrive.outMotoresAuto(0, 0, 0, 0);
    //checar signos
  }
}