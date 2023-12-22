// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final CompressorIO compressor;
  private final DoubleSolenoidIO brake;
  private final PivotIO pivot;
  private final CompressorIOInputsAutoLogged cInputs = new CompressorIOInputsAutoLogged();
  private final DoubleSolenoidIOInputsAutoLogged dsInputs = new DoubleSolenoidIOInputsAutoLogged();
  private final PivotIOInputsAutoLogged pInputs = new PivotIOInputsAutoLogged();

  public Arm(CompressorIO compressor, DoubleSolenoidIO brake, PivotIO pivot) {
    this.compressor = compressor;
    this.brake = brake;
    this.pivot = pivot;
  }

  @Override
  public void periodic() {
    compressor.updateInputs(cInputs);
    brake.updateInputs(dsInputs);
    pivot.updateInputs(pInputs);

    Logger.processInputs("Compressor", cInputs);
    Logger.processInputs("Double Solenoid", dsInputs);
    Logger.processInputs("Pivot", pInputs);
  }

  public void setPosition(double position) {
    brake.deactivate();
    pivot.setPosition(position);
    brake.activate();

    Logger.recordOutput("Intake Target", position);
  }

  public void stop() {
    pivot.stop();
  }

  public void activateBrake() {
    brake.activate();
  }

  public void deactivateBrake() {
    brake.deactivate();
  }

  public void toggleCompressor() {
    compressor.toggleCompressor();
  }
}
