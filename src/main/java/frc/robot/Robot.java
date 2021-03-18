/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.Faults;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.PWM;
//import edu.wpi.first.wpilibj.PWMSparkMax;
//import edu.wpi.first.wpilibj.PWMSpeedController;
//import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  /** 
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  */
  
  public static OI m_oi;
  //public static FasterOctoCanum m_oi.driveTrain;
  Faults _faults = new Faults();
  public boolean m_compressorButtonFlag = false;

  public static Compressor compressor = new Compressor(52);
 // public static LightDriveCAN m_lightDrive = new LightDriveCAN(); 
  public Command m_autoCommand; 
 // public PWM m_pwm;
 // public PWMTalonSRX m_pwmSpeed;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    m_oi = new OI(); 
    //m_oi.driveTrain = new FasterOctoCanum();
    SmartDashboard.putBoolean("TANK?: ", false);
    SmartDashboard.putBoolean("Compressor on?", false);
    
    _faults = new Faults();
   // m_pwm = new PWM(0);
  //  m_pwmSpeed = new PWMTalonSRX(0);
    compressor.start();   
    SmartDashboard.putBoolean("Compressor on?", true); 
    m_oi.driveTrain.disableFieldOriented();
    //m_oi.lightStrips.setLights();
    SmartDashboard.putString("Auto Chooser", RobotMap.autoChooser);
    m_oi.blinker.lightOn(0.67);
  //  m_lightDrive.SetColor(1, Color.CYAN);
    //m_lightDrive.Update();

    /** 
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    */
    //driveTrain.enableDriveStraight();
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    //m_lightDrive.SetColor(1, Color.CYAN);
    //m_lightDrive.SetColor(2, Color.CYAN);
    //m_lightDrive.SetColor(3, Color.CYAN);
    //m_lightDrive.SetColor(4, Color.CYAN);
 //   m_lightDrive.Update();
    SmartDashboard.putNumber("Enc Count", m_oi.driveTrain.getEncPos());
    SmartDashboard.putBoolean("Out Of Phase:",_faults.SensorOutOfPhase);
    // SmartDashboard.putNumber("Enc Direction", )
    SmartDashboard.putNumber("Sensor Vel: Front Left", m_oi.driveTrain.m_frontLeft.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Sensor Pos: Front Left", m_oi.driveTrain.m_frontLeft.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Front Left", m_oi.driveTrain.m_frontLeft.getMotorOutputPercent());
    SmartDashboard.putNumber("Sensor Vel: Front Right", m_oi.driveTrain.m_frontRight.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Sensor Pos: Front RIght", m_oi.driveTrain.m_frontRight.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Front Right", m_oi.driveTrain.m_frontRight.getMotorOutputPercent());
    SmartDashboard.putNumber("Sensor Vel: Back Left", m_oi.driveTrain.m_backLeft.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Sensor Pos: Back Left", m_oi.driveTrain.m_backLeft.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Back Left", m_oi.driveTrain.m_backLeft.getMotorOutputPercent());
    SmartDashboard.putNumber("Sensor Vel:  Back Right", m_oi.driveTrain.m_backRight.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Sensor Pos:  Back Right", m_oi.driveTrain.m_backRight.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Back Right", m_oi.driveTrain.m_backRight.getMotorOutputPercent());
    SmartDashboard.putBoolean("Out Of Phase: Front Left", _faults.SensorOutOfPhase);
    CommandScheduler.getInstance().run();
  }
  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() 
  {
   // m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    //System.out.println("Auto selected: " + m_autoSelected);
    //driveTrain.enableDropDrive();
    //driveTrain.enableDriveStraight();
    //driveTrain.enableFieldOriented();

    m_autoCommand = m_oi.getAutonomousCommand(); 
    if (m_autoCommand != null) {
      m_autoCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    /*
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
    */
    SmartDashboard.putNumber("Sensor Vel: Front Left", m_oi.driveTrain.m_frontLeft.getSelectedSensorVelocity());
   SmartDashboard.putNumber("Sensor Pos: Front Left", m_oi.driveTrain.m_frontLeft.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Front Left", m_oi.driveTrain.m_frontLeft.getMotorOutputPercent());
    SmartDashboard.putNumber("Sensor Vel: Front Right", m_oi.driveTrain.m_frontRight.getSelectedSensorVelocity());
   SmartDashboard.putNumber("Sensor Pos: Front RIght", m_oi.driveTrain.m_frontRight.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Front Right", m_oi.driveTrain.m_frontRight.getMotorOutputPercent());
    SmartDashboard.putNumber("Sensor Vel: Back Left", m_oi.driveTrain.m_backLeft.getSelectedSensorVelocity());
   SmartDashboard.putNumber("Sensor Pos: Back Left", m_oi.driveTrain.m_backLeft.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Back Left", m_oi.driveTrain.m_backLeft.getMotorOutputPercent());
    SmartDashboard.putNumber("Sensor Vel:  Back Right", m_oi.driveTrain.m_backRight.getSelectedSensorVelocity());
   SmartDashboard.putNumber("Sensor Pos:  Back Right", m_oi.driveTrain.m_backRight.getSelectedSensorPosition());
    SmartDashboard.putNumber("Out %: Back Right", m_oi.driveTrain.m_backRight.getMotorOutputPercent());
    SmartDashboard.putBoolean("Out Of Phase: Front Left", _faults.SensorOutOfPhase);
  }
  @Override
  public void teleopInit() {
    if (m_autoCommand != null) {
      m_autoCommand.cancel();
    }
    m_oi.driveTrain.disableDriveStraight();
    m_oi.driveTrain.disableTank();
    m_oi.elevatorSubsystem.offTake();
    m_oi.hangBoi.armOff();
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    m_oi.blinker.periodic();
   // m_oi.blinker.lightOn(-0.99);
    // m_pwm.setRaw(8);
    //  m_pwmSpeed.setSpeed(-0.5);
    /*if(m_oi.compressorButton.get() && !m_compressorButtonFlag)
    {
      m_compressorButtonFlag = true;
      if(compressor.enabled())
      {
        compressor.stop();
        SmartDashboard.putBoolean("Compressor on?", false);
      }
      else {
        compressor.start();
        SmartDashboard.putBoolean("Compressor on?", true);
      }
    }
    else if(!m_oi.compressorButton.get() && m_compressorButtonFlag)
    {
      m_compressorButtonFlag = false;
    }*/

 
  }
 
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {

  }
}
