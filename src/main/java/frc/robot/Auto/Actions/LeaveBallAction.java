package frc.robot.Auto.Actions;

import frc.robot.subsystems.Intake;

public class LeaveBallAction{
  Intake mIntake = new Intake();
  
  public void finalLeaveBallAction(){
    mIntake.eatAuto(0.4);
  }
}