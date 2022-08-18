package frc.robot;

public class Constants {
    public static final class PCH {
        public static final double NORMALIZED_SUPPLY_VOLTAGE = 0; //TODO: Figure out the value
    }

    public static final class Drivetrain {
        public static final double TURN_kP = 0.00385;
        public static final double TURN_kI = 0;
        public static final double TURN_kD = 0.1;

        public static final double TOLERANCE = 5;
        public static final double RATE_TOLERANCE = 0.5;

        public static final boolean GYRO_REVERSED = true;

    }

    public static final class Shooter {
        public static double MAX_RPM = 4500;
        public static double TARGET_RPM = 3900;

        public static double P = 0;
        public static double I = 0;
        public static double D = 0;
        // public static double FF = 0.000205;
        public static double FF = 0.000205;

        public static int CURRENT_STALL_LIMIT = 30;
        public static int CURRENT_FREE_LIMIT = 30;
    }

    public static final class Climber {//min: -1.696402 max:
        public static double MAX_HEIGHT = 23;
        public static double MIN_HEIGHT = 0;
        public static double INCHES_TO_TICKS = 64/55/Math.PI*2048*8.5;
    }
}
