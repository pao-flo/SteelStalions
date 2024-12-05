package frc.robot.Auto.Actions;

import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Intake;

public class MoveAndEatAction{
  Chassis mAutoDrive = new Chassis();
  Intake mIntake = new Intake();
  
  public void finalMoveAndEatAction(){
    mAutoDrive.outMotoresAuto(-0.3, -0.3, 0.3, 0.3);
    mIntake.eatAuto(0.4);
    //checar signos
  }
}