// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class IntakeCommand extends CommandBase {

  private final IntakeSubsystem intakeSubsystem;
  private final double speed;

  public IntakeCommand(IntakeSubsystem intakeSubsystem, double speed) {
    this.intakeSubsystem = intakeSubsystem;
    this.speed = speed;
    addRequirements(intakeSubsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    intakeSubsystem.moveSolenoidForward();
    SmartDashboard.putString("STATUS", "INTAKE PREPEARING");
    withTimeout(.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setMotor(speed);
    SmartDashboard.putString("STATUS","INTAKE ACTIVE");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setMotor(0);
    withTimeout(.2);
    intakeSubsystem.moveSolenoidBackwards();
    SmartDashboard.putString("STATUS", "INTAKE ON STANDBY");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
