package frc.robot.Commands.Persistent;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Drivetrain;
import frc.util.Util;
import frc.util.commands.PersistentCommand;

/**
 * A PersistentCommand that controls the drivetrain of the robot using the
 * primary joysticks. 
 **/
public class Drive extends PersistentCommand {
  private final Drivetrain drivetrain;
  private final Joystick leftJoystick, rightJoystick;

  public Drive(final Drivetrain drivetrain, final Joystick leftJoystick, final Joystick rightJoystick) {
    this.drivetrain = drivetrain;
    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
  
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    double speed = Util.deadband(0.1, leftJoystick.getY());
    double turn = Util.deadband(0.1, rightJoystick.getX());
    drivetrain.arcadeDrive(speed, Math.signum(turn) * -turn * turn);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

}