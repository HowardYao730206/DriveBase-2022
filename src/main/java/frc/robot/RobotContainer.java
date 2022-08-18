package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.Commands.Persistent.BlingBling;
// import frc.robot.Commands.Persistent.ClimbArmManual;
 import frc.robot.Commands.Persistent.Drive;
// import frc.robot.Commands.Persistent.FeedManual;
// import frc.robot.Commands.Persistent.RollIntakeManual;
import frc.robot.Commands.auton.autonPractice;
// // import frc.robot.Commands.auton.ThreeBall;
// // import frc.robot.Commands.auton.TwoBallLeft;
// // import frc.robot.Commands.auton.TwoBallRight;
// // import frc.robot.Commands.auton.ZeroBall;
// import frc.robot.Commands.instant.ActuateClimb;
// import frc.robot.Commands.instant.ToggleCompressor;
// import frc.robot.Commands.instant.ToggleIntake;
// import frc.robot.Commands.macro.Shoot;
// import frc.robot.subsystems.Climber;
 import frc.robot.subsystems.Drivetrain;
// import frc.robot.subsystems.Feeder;
// import frc.robot.subsystems.Intake;
// import frc.robot.subsystems.LEDStrip;
// import frc.robot.subsystems.PCH;
// import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public final class RobotContainer {
	private final Drivetrain drivetrain = new Drivetrain();
	// private final PCH pch = new PCH();
	// private final Climber climber = new Climber();
	// private final Intake intake = new Intake();
	// private final Shooter shooter = new Shooter();
	// private final Feeder feeder = new Feeder();
	// private final LEDStrip ledStrip = new LEDStrip();

	private final Joystick leftJoystick = new Joystick(0);
	private final Joystick rightJoystick = new Joystick(1);
	private final XboxController gamepad = new XboxController(2);

	private final Command runAuton = new autonPractice(drivetrain);
	/*private final Command twoBallRight = new TwoBallRight(drivetrain, intake, feeder, shooter);
	private final Command twoBallLeft = new TwoBallLeft(drivetrain, intake, feeder, shooter);
	private final Command zeroBall = new ZeroBall(drivetrain);
	private final Command threeBall = new ThreeBall(drivetrain, intake, feeder, shooter);*/
	SendableChooser<Command> chooser = new SendableChooser<>();  


	public RobotContainer() {
		configureButtonBindings();

		chooser.addOption("Howard", runAuton);
		/*chooser.addOption("0-ball", zeroBall);
		chooser.addOption("2-ball, human player", twoBallRight);
		chooser.setDefaultOption("2-ball, NOT human player", twoBallLeft);
		chooser.addOption("BIG BALLS", threeBall);*/
		SmartDashboard.putData(chooser);
	}

	/**
	 * Use this method to define your button->command mappings.  Buttons can be
	 * created by instantiating a {@link GenericHID} or one of its subclasses
	 * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and
	 * then passing it to a
	 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
		drivetrain.setDefaultCommand(new Drive(drivetrain, leftJoystick, rightJoystick));
		// new JoystickButton(gamepad, 4).whenPressed(new ToggleCompressor(pch, gamepad));
		// new JoystickButton(gamepad, 6).whenPressed(new ActuateClimb(climber, true));
		// new JoystickButton(gamepad, 5).whenPressed(new ActuateClimb(climber, false));
		// new JoystickButton(gamepad, 3).whenPressed(new ToggleIntake(intake));
		// new JoystickButton(gamepad, 2).whenHeld(new Shoot(shooter));
		// shooter.setDefaultCommand(new RollShooterManual(shooter, gamepad));
		// feeder.setDefaultCommand(new FeedManual(feeder, gamepad));
		// intake.setDefaultCommand(new RollIntakeManual(intake, gamepad));
		// ledStrip.setDefaultCommand(new BlingBling(ledStrip, shooter));
		// 	climber.setDefaultCommand(new ClimbArmManual(climber, gamepad));
	}
	public Command getAutonomousCommand() {
			return chooser.getSelected();
	}
}
