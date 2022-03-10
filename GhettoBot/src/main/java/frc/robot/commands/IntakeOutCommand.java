

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeOutCommand extends CommandBase {

    private final IntakeSubsystem m_IntakeSubsystem;

    public IntakeOutCommand(IntakeSubsystem iSubsystem ) {

        m_IntakeSubsystem = iSubsystem;

        addRequirements(m_IntakeSubsystem);    
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_IntakeSubsystem.intakeOut();
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
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
