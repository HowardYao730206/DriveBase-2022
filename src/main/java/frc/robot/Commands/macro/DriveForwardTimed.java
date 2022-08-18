package frc.robot.Commands.macro;

import frc.robot.subsystems.Drivetrain;
import frc.util.commands.MacroCommand;
import edu.wpi.first.wpilibj.Timer;


public class DriveForwardTimed extends MacroCommand {
    
    private final Drivetrain drivetrain;
    private final double speed;
    private final double seconds;
    private final Timer timer;

    public DriveForwardTimed(Drivetrain drivetrain, double speed, double seconds) {
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.seconds = seconds;
        timer = new Timer();

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speed, 0); 
    }

    @Override
    public boolean isFinished() {
        if (timer.get() >= seconds) {
            return true;
        }
        else {
            return false;
        }
    }

}