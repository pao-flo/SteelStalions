package frc.robot.Auto.Actions;

import frc.robot.subsystems.Intake;

public class GetBallAction{
  Intake mIntake = new Intake();
  
  public void finalGetBallAction(){
    mIntake.eatAuto(-0.4);
  }
}