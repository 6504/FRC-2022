

package frc.robot.commands.SeqCommands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeUp extends CommandBase {

    private final IntakeSubsystem m_IntakeSubsystem;

    public IntakeUp(IntakeSubsystem iSubsystem ) {

        m_IntakeSubsystem = iSubsystem;

        addRequirements(m_IntakeSubsystem);    
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_IntakeSubsystem.liftUp(.8);
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
