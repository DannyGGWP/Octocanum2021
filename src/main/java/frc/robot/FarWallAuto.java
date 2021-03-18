/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FarWallAuto extends SequentialCommandGroup 
{
  /**
   * Creates a new FarWallAuto.
   */
  public FarWallAuto(LiftLift elevator, FasterOctoCanum driveTrain, ShootShoot shooter) 
  {

   //THIS IS FAR LEFT AUTO W/ 5 BALLS, I CAN'T RENAME ANYTHING

    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(
      //drive forward
      new InstantCommand(driveTrain::resetGyro, driveTrain),
      new InstantCommand(driveTrain::resetEncoders, driveTrain),
      new InstantCommand(driveTrain::enableDriveStraight,driveTrain),
      new WaitCommand(0.25),
      new AutoDrive(-0.5,0.0,90000.0, driveTrain),
      //brake
      new InstantCommand(driveTrain::enableBrake, driveTrain),
      new WaitCommand(1),
      new InstantCommand(driveTrain::disableBrake, driveTrain),
      new WaitCommand(1),
      //drive strafe
      new InstantCommand(driveTrain::resetEncoders, driveTrain),
      new InstantCommand(driveTrain::disableTank,driveTrain),
      new InstantCommand(driveTrain::disableDriveStraight,driveTrain),
      new WaitCommand(0.25),
      new AutoDriveMech(0,0.5, 150000, driveTrain),
      //turn straight to shoot
     // new InstantCommand(driveTrain::resetGyro, driveTrain),
      new InstantCommand(driveTrain::resetEncoders, driveTrain),
      new WaitCommand(0.25),
      new TurnToAngle(0, driveTrain, 0.010, 0.00300, 0.0016, 4),
      new AutoDrive(-0.5,0.0,10000.0, driveTrain),
      //SHOOOT
      new InstantCommand(shooter::onWheel,shooter),
      new WaitCommand(0.75),
      new InstantCommand(elevator::elevatorUp, elevator),
      new InstantCommand(shooter::openGate,shooter),
      new WaitCommand(5), 
      new InstantCommand(elevator::elevatorOff, elevator),
      new InstantCommand(shooter::closeGate,shooter),
      new InstantCommand(shooter::offWheel, shooter)
      
    );
  }
}
