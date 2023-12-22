// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface PivotIO {
    @AutoLog
    public static class PivotIOInputs {
        public double pivotPosition = 0.0;
        public double pivotVelocity = 0.0;

        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;
    }

    public default void updateInputs(PivotIOInputs inputs) {}

    public default void setPosition(double position) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}
