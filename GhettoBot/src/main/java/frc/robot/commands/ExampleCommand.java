

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ExampleCommand extends CommandBase {

    private final DriveSubsystem m_driveSubsystem;
    private final IntakeSubsystem m_IntakeSubsystem;

    public ExampleCommand(DriveSubsystem dSubsystem, IntakeSubsystem iSubsystem ) {

        m_driveSubsystem = dSubsystem;
        m_IntakeSubsystem = iSubsystem;

        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
       
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
