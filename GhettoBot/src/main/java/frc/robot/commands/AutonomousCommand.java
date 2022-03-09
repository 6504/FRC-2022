// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutonomousCommand extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    private final DriveSubsystem m_driveSubsystem;
    private final IntakeSubsystem m_IntakeSubsystem;

    private enum States { MoveForward, Stop1,IntakeOut, IntakeOff, MoveBackward, Stop2};

    private States curState = States.MoveForward;

    public AutonomousCommand(DriveSubsystem dSubsystem, IntakeSubsystem iSubsystem ) {

        m_driveSubsystem = dSubsystem;
        m_IntakeSubsystem = iSubsystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    double startTime;

    double intakeOutStartTime;

    boolean done = false;

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_driveSubsystem.motorController4.getEncoder().setPosition(0);
        startTime = Timer.getFPGATimestamp();
        curState = States.MoveForward;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //wheel circumference: 18.84
        //-8.5 positions per rev
        if (m_driveSubsystem.motorController4.getEncoder().getPosition() < 18){
            m_driveSubsystem.arcadeDrive(.4,0);
        } else {
            m_driveSubsystem.arcadeDrive(0,0);
            done = true;
        }

        /*SmartDashboard.putString("Auto State", curState.toString());

        if(curState == States.MoveForward)
        {
            if (m_driveSubsystem.motorController4.getEncoder().getPosition() > -0.01){
                m_driveSubsystem.arcadeDrive(-.3,0);
            } else {
                curState = States.Stop1;
            }   
        } else if (curState == States.Stop1){
            m_driveSubsystem.arcadeDrive(0,0);
            curState = States.IntakeOut;
            intakeOutStartTime = Timer.getFPGATimestamp();
        } else if (curState == States.IntakeOut){
            m_IntakeSubsystem.intakeOut();
            if (Timer.getFPGATimestamp() - intakeOutStartTime > 1)
            {
                curState = States.IntakeOff;
            }
        } else if (curState == States.IntakeOff){
            m_IntakeSubsystem.intakeOff();
            m_driveSubsystem.motorController4.getEncoder().setPosition(0);
        } else if (curState == States.MoveBackward){
            if (m_driveSubsystem.motorController4.getEncoder().getPosition() < 40.6){
                m_driveSubsystem.arcadeDrive(.4,0);
            } else {
                curState = States.Stop2;
            }
        } else if (curState == States.Stop2){
            m_driveSubsystem.arcadeDrive(0,0);
        }*/
        
        /*
        double autoTimeElapsed = Timer.getFPGATimestamp() - startTime;
        if(autoTimeElapsed < 1.5){//run for 3 sec
            m_driveSubsystem.arcadeDrive(-.4,0);//move forward 
        }
        else if(autoTimeElapsed < 7){//run for 4 sec
            m_driveSubsystem.arcadeDrive(0,0);//stop moving
        //    m_IntakeSubsystem.intakeOut();//shoot ball
        }
        
        else if(autoTimeElapsed < 9){//run for 1 sec
            m_IntakeSubsystem.intakeOff();//turn off intake3
        }
        else if(autoTimeElapsed < 13){//run for 5 sec
            m_driveSubsystem.arcadeDrive(.5,0);//Move back  
        }*/
       
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        //return false;
        /*if( Timer.getFPGATimestamp() > startTime + 5)
        {
            return true;
        }
        else{
            return false;
        }*/
        return done;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
