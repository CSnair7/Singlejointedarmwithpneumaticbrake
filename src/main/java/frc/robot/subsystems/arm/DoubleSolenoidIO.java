// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface DoubleSolenoidIO {
    @AutoLog
    public static class DoubleSolenoidIOInputs {
        public boolean isOn = false;
    }

    public default void updateInputs(DoubleSolenoidIOInputs inputs) {}

    public default void activate() {}

    public default void deactivate() {}
}
