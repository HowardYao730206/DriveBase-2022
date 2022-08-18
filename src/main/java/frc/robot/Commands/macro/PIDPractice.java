// package frc.robot.Commands.macro;

// import edu.wpi.first.math.controller.PIDController;
// import frc.robot.subsystems.Drivetrain;
// import frc.util.commands.MacroCommand;

// public class PIDPractice extends MacroCommand{
    
//     private final Drivetrain drivetrain;
// 	private final double angle;
// 	private double turn;

// 	private final PIDController controller;

// 	public PIDPractice(Drivetrain drivetrain, double angle) {
// 		this.drivetrain = drivetrain;
// 		this.angle = angle;

// 		controller = new PIDController(0.00385, 0, 0.1);
// 		controller.setTolerance(5);

//         addRequirements(drivetrain);
// }

// @Override
// public void initialize() {
//     controller.setSetpoint(drivetrain.getHeading() + angle);
// }

// @Override
// public void execute() {
//     turn = controller.calculate(drivetrain.getHeading(), controller.getSetpoint());
//     drivetrain.arcadeDrive(0, turn);
// }

// @Override
// public boolean isFinished() {
//     return false;
// }

// @Override
// public void end(boolean interrupted) {
//     drivetrain.arcadeDrive(0, 0);
// }
// }
