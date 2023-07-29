// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSubsystem extends SubsystemBase {

  private final TalonFX intakeMotor = new TalonFX(0);
  DoubleSolenoid intakeMechanism = new DoubleSolenoid(null, 1, 2);
  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotor(double Speed){
    intakeMotor.set(TalonFXControlMode.PercentOutput,Speed);
  }

  public void moveSolenoidForward(){
      intakeMechanism.set(DoubleSolenoid.Value.kForward);
  }
  public void moveSolenoidBackwards(){
    intakeMechanism.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
