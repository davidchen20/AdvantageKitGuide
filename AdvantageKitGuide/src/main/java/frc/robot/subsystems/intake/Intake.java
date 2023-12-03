// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final MotorControllerIO pivot;
  private final MotorControllerIO roller;
  private final MotorControllerIOInputsAutoLogged pInputs = new MotorControllerIOInputsAutoLogged();
  private final MotorControllerIOInputsAutoLogged rInputs = new MotorControllerIOInputsAutoLogged();
  
  /** Creates a new Intake. */
  public Intake(MotorControllerIO pivot, MotorControllerIO roller) {
    this.pivot = pivot;
    this.roller = roller;
  }

  @Override
  public void periodic() {
    pivot.updateInputs(pInputs);
    roller.updateInputs(rInputs);

    Logger.processInputs("Intake Pivot", pInputs);
    Logger.processInputs("Intake Rollers", rInputs);
    // This method will be called once per scheduler run
  }

  public void runRollers(double velocity) {
    roller.setVelocity(velocity);
  }

  public void stopRollers() {
    roller.stop();
  }

  public void stopPivot() {
    pivot.stop();
  }

  public void setPosition(double position) {
    pivot.setPosition(position);

    Logger.recordOutput("Intake Target", position);
  }
}
