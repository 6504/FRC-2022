

package frc.robot.commands.SeqCommands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeDown extends CommandBase {

    private final IntakeSubsystem m_IntakeSubsystem;
    private final double intakeStartTime;

    public IntakeDown(IntakeSubsystem iSubsystem ) {

        m_IntakeSubsystem = iSubsystem;

        addRequirements(m_IntakeSubsystem);    
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        intakeStartTime = Timer.getFPGATimestamp()
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_IntakeSubsystem.liftDown(.5);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_intakeSubsystem.holdLiftPos();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - intakeStartTime > 5) { //Stops after 5 seconds
            return true;
        }
        if (m_intakeSubsystem.atLowerLimit) { //Stops once reaches upper limit
            return true;
        }
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
