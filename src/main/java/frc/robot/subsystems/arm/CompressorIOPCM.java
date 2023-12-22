// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class CompressorIOPCM implements CompressorIO{
    private final Compressor compressor;

    public CompressorIOPCM(int module) {
        compressor  = new Compressor(module, PneumaticsModuleType.CTREPCM);
    }

    @Override
    public void updateInputs(CompressorIOInputs inputs) {
        inputs.isOn = compressor.isEnabled();

        inputs.compressorPressure = compressor.getPressure();
    }

    @Override
    public void toggleCompressor() {
        if (compressor.isEnabled()) {
            compressor.disable();
        } else {
            compressor.enableDigital();
        }
        
    }
}
