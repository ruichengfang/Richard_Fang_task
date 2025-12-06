// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.candrive;


@SuppressWarnings("unused")
public class RobotContainer {
  drive drivesystem  = new drive();
  candrive candrivesystem  = new candrive();
  public RobotContainer() {
    configureBindings();
  }
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private void configureBindings() {
    m_driverController.leftBumper().onTrue(drivesystem.driveCommandvelocity(10));
    m_driverController.rightBumper().onTrue(drivesystem.driveCommandvelocity(0));
    m_driverController.leftBumper().onTrue(candrivesystem.driveCommand1(0.5));
    m_driverController.rightBumper().onTrue(candrivesystem.driveCommand1(0));
  }
}
