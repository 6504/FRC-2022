

package frc.robot.commands.SeqCommands;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class TurnDegrees extends PIDCommand {

    DriveSubsystem drive_subsystem;

    static double kP = 0.05; //DASHBOARD WILL OVERRIDE //originally 1 in the example, .05 when tested
    static final double kI = 0.00; 
    static double kD = 0.03; //DASHBOARD WILL OVERRIDE
    static final double kF = 0.00;
    static final double kTurnToleranceDeg = 3;
    static final double kTurnRateToleranceDegPerS = 3;

    private double turnStartTime;

    // targetAngleDegrees - The angle to turn to
    public TurnDegrees(DriveSubsystem dSubsystem, double targetAngleDegrees) {
        super(  
                new PIDController(kP, kI, kD),

                // Close loop on heading

                dSubsystem::getHeading,

                // Set reference to target

                targetAngleDegrees,

                // Pipe output to turn robot

                output -> dSubsystem.arcadeDrive(0, output),

                // Require the drive

                dSubsystem);
        getController().enableContinuousInput(-180, 180);

        // Set the controller tolerance - the delta tolerance ensures the robot is
        // stationary at the

        // setpoint before it is considered as having reached the reference

        getController().setTolerance(kTurnToleranceDeg, kTurnRateToleranceDegPerS);
        drive_subsystem = dSubsystem;
        turnStartTime = 0;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        //m_driveSubsystem.leftMotorControllerLeader.getEncoder().setPosition(0);
        drive_subsystem.resetAngle();
        getController().setP(SmartDashboard.getNumber("kP for turning", kP));
        getController().setD(SmartDashboard.getNumber("kD for turning", kD));
        turnStartTime = Timer.getFPGATimestamp();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        System.out.println("done | " + drive_subsystem.getHeading());
    }

    @Override
    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - turnStartTime > 4.5) { //Stops after 6 seconds
            return true;
        }
      // End when the controller is at the reference.
      return getController().atSetpoint();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
