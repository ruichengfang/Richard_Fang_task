// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.drive;

@SuppressWarnings("unused")
public class RobotContainer {
  drive drivesystem  = new drive();
  public RobotContainer() {
    configureBindings();
  }
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private void configureBindings() {
    m_driverController.a().whileTrue(drivesystem.driveCommand1(100));
    m_driverController.b().whileTrue(drivesystem.driveCommand1(100));
  }
}
