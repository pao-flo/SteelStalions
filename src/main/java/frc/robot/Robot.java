package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.ControlBoard.Control;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Garra;
import frc.robot.subsystems.Leds;
import frc.robot.subsystems.Leds.State;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Auto.Actions.CorrectAction;
//Auto
import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveBackAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Actions.TurnLeftAction;
import frc.robot.Auto.Actions.TurnRightAction;
import frc.robot.Auto.Actions.LeaveBallAction;
import frc.robot.Auto.Actions.MoveAndEatAction;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public AHRS navx;
  double angle;

  Chassis mChassis;
  Intake mIntake;
  Garra mGarra;
  Leds mLeds;
  AddressableLED m_led;
  AddressableLEDBuffer m_ledBuffer;
  Control mControl;

  //Inicialización acciones autónomo
  GetTimeAction mAutoTimer = new GetTimeAction();
  MoveForwardAction mMoveForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  TurnLeftAction mTurnLeftAction = new TurnLeftAction();
  TurnRightAction mTurnRightAction = new TurnRightAction();
  MoveBackAction mMoveBackAction = new MoveBackAction();
  LeaveBallAction mLeaveBallAction = new LeaveBallAction();
  MoveAndEatAction mMoveAndEatAction = new MoveAndEatAction();
  CorrectAction mCorrectAction = new CorrectAction();

  private static final int PDH_CAN_ID = 1;
  private static final int NUM_PDH_CHANNELS = 24;

  PowerDistribution m_pdh = new PowerDistribution(PDH_CAN_ID,ModuleType.kRev);


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_pdh.setSwitchableChannel(true);
    m_pdh.clearStickyFaults();

    mChassis = new Chassis();
    mIntake = new Intake();
    mGarra = new Garra();
    mControl = new Control();
    mLeds = new Leds();

    try{
      navx = new AHRS(SPI.Port.kMXP);
      Timer.delay(1);
      navx.reset();
      Timer.delay(1);
    }
    catch(Exception e){
      System.out.println("navx not working");
    }
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
   mLeds.SetState(State.Disable);
  }

  @Override
  public void disabledPeriodic() {
    mChassis.outputTelemetry();
  }

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    mAutoTimer.autoRelativeTimeControl();
    //angle = navx.getAngle();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    mLeds.SetState(State.Auto);
    mAutoTimer.autoAbsoluteTimeControl(); 
    double difTime = mAutoTimer.getAbsoluteTimer()-mAutoTimer.getRelativeTimer();
    double angle = navx.getPitch();
    SmartDashboard.putNumber("angle", angle);
    /*if(angle<90){
      mTurnRightAction.finalTurnRightAction();
    }else mStopAction.finalStopAction();*/
    if(difTime>0 && difTime<2.4){
      mMoveForwardAction.finalMoveForwardAction();
    }else if(difTime>2.4 && difTime<3.5){
      mLeaveBallAction.finalLeaveBallAction();
    }
    /*else if(difTime>2 && difTime<3){
      mTurnLeftAction.finalTurnLeftAction(Math.abs(angle), 90);
    }else if(difTime>3 && difTime<5){
      mMoveForwardAction.finalMoveForwardAction();
    }else if(difTime>5 && difTime<6){
      mTurnLeftAction.finalTurnLeftAction(Math.abs(angle), 175);
    }else if(difTime>6 && difTime<9){
      mMoveForwardAction.finalMoveForwardAction();
    }else if(difTime>9 && difTime<9.5){
      mLeaveBallAction.finalLeaveBallAction();
    }/*else if(difTime>9.5 && difTime<10.5){
      mMoveBackAction.finalMoveBackACtion();
    }else if(difTime>10.5 && difTime<11.5){
      mTurnRightAction.finalTurnRightAction(angle,10);
    }else if(difTime>11.5 && difTime<15.5){
      mMoveForwardAction.finalMoveForwardAction();
    }else if(difTime>15.5 && difTime<16.5){
      mTurnRightAction.finalTurnRightAction();
    }else if(difTime>5.18 && difTime<6.98){
      mMoveAndEatAction.finalMoveAndEatAction();
    */else mStopAction.finalStopAction();

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic(){
    mLeds.SetState(State.Teleop);
    m_pdh.setSwitchableChannel(false);
    mChassis.avanzar(mControl.left_Y_stick_driver(),mControl.right_x_stick_driver());
    mIntake.eat(mControl.right_trigger_mecanisms(), mControl.left_trigger_mecanisms());
    mGarra.grab(mControl.left_x_stick_mecanisms());

    //double angle = mChassis.navx.getYaw();
    //SmartDashboard.putNumber("angle", angle);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
