package frc.robot.Commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.util.commands.AutonRoutine;
import frc.robot.Commands.macro.DriveForwardTimed;
import frc.robot.Commands.macro.PIDPractice;

public class autonPractice extends AutonRoutine {
    public autonPractice(Drivetrain drivetrain) {
        addCommands(
            new SequentialCommandGroup(
                
                new DriveForwardTimed(drivetrain, 0.5, 10.0)

                // new PIDPractice(drivetrain,90)
            )
        );
    }
}