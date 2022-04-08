

package frc.robot.commands.SeqCommands;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class DriveDistance extends CommandBase {

    private final DriveSubsystem m_driveSubsystem;
    private final double m_distance;

    public DriveDistance(DriveSubsystem dSubsystem, double distance) {

        m_driveSubsystem = dSubsystem;
        m_distance = distance;

        addRequirements(m_driveSubsystem);    
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_driveSubsystem.leftMotorControllerLeader.getEncoder().setPosition(0);
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_distance > 0)
        {
            m_driveSubsystem.arcadeDrive(.4,0);
        }
        else
        {
            m_driveSubsystem.arcadeDrive(-.4,0);
        }
        //m_driveSubsystem.motorController4.getPIDController().setReference(m_distance, ControlType.kPosition);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.arcadeDrive(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        
        //wheel circumference: 18.84
        //-8.5 positions per rev
        if (m_distance > 0)
        {
            if (m_driveSubsystem.leftMotorControllerLeader.getEncoder().getPosition() < m_distance){

                return false;
            } else {
                return true;
            }
        } else {
            if (m_driveSubsystem.leftMotorControllerLeader.getEncoder().getPosition() > m_distance){
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
