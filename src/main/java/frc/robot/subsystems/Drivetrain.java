package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax;
//import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import com.revrobotics.CANSparkMax;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * A Subsystem used to control the talons and sensors to drive the robot.
 */
public class Drivetrain extends SubsystemBase {
	private final WPI_TalonSRX frontLeftTalon = new WPI_TalonSRX(RobotMap.Drivetrain.FRONT_LEFT_TALON
     );
     private final WPI_TalonSRX frontRightTalon = new WPI_TalonSRX(RobotMap.Drivetrain.FRONT_RIGHT_TALON
     );
     private final WPI_TalonSRX backLeftTalon = new WPI_TalonSRX(RobotMap.Drivetrain.BACK_LEFT_TALON
     );
     private final WPI_TalonSRX backRightTalon = new WPI_TalonSRX(RobotMap.Drivetrain.BACK_RIGHT_TALON
     );

	//  private final ADIS16470_IMU imu = new ADIS16470_IMU();

	private final DifferentialDrive differentialDrive = new DifferentialDrive(frontLeftTalon, frontRightTalon);


	public Drivetrain() {
		configMotorControllers();
	}

	public void stop() {
		differentialDrive.stopMotor();
	}

	public void arcadeDrive(double speed, double turn) {
		differentialDrive.arcadeDrive(speed, turn, false);
	}

	public void tankDrive(double left, double right) {
		differentialDrive.tankDrive(left, right);
	}

	// public double getHeading() {
	// 	return Math.IEEEremainder(imu.getAngle(), 360) * (Constants.Drivetrain.GYRO_REVERSED ? -1.0 : 1.0);
	// }


	private void configMotorControllers() {
		backLeftTalon.follow(frontLeftTalon);
		backRightTalon.follow(frontRightTalon);

		frontLeftTalon.setInverted(true);
		frontRightTalon.setInverted(false);

		backLeftTalon.setInverted(true);
		backRightTalon.setInverted(false);
	}

}
