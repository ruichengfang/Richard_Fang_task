package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;

@SuppressWarnings("unused")
public class drive {
    private final TalonFX motor1 = new TalonFX(Constants.driveconstants.motor1id);
    private final TalonFX motor2 = new TalonFX(Constants.driveconstants.motor2id);
    private final TalonFX motor3 = new TalonFX(Constants.driveconstants.motor3id);
    private final TalonFX motor4 = new TalonFX(Constants.driveconstants.motor4id);

    private final MotionMagicVoltage motor1request = new MotionMagicVoltage(0.0);
    private final MotionMagicVoltage motor2request = new MotionMagicVoltage(0.0);
    private final MotionMagicVoltage motor3request = new MotionMagicVoltage(0.0);
    private final MotionMagicVoltage motor4request = new MotionMagicVoltage(0.0);

    private final VoltageOut motor1voltage = new VoltageOut(0.0);
    private final VoltageOut motor2voltage = new VoltageOut(0.0);
    private final VoltageOut motor3voltage = new VoltageOut(0.0);
    private final VoltageOut motor4voltage = new VoltageOut(0.0);

    public drive() {
        var motorConfigs = new TalonFXConfiguration();

        motorConfigs.Slot0.kS = 0.14;
        motorConfigs.Slot0.kV = 0.0;
        motorConfigs.Slot0.kA = 0;
        motorConfigs.Slot0.kP = 5;
        motorConfigs.Slot0.kI = 0;
        motorConfigs.Slot0.kD = 0;

        motorConfigs.MotionMagic.MotionMagicAcceleration = 100; // Acceleration is around 40 rps/s
        motorConfigs.MotionMagic.MotionMagicCruiseVelocity = 200; // Unlimited cruise velocity
        motorConfigs.MotionMagic.MotionMagicExpo_kV = 0.12; // kV is around 0.12 V/rps
        motorConfigs.MotionMagic.MotionMagicExpo_kA = 0.1; // Use a slower kA of 0.1 V/(rps/s)
        motorConfigs.MotionMagic.MotionMagicJerk = 0; // Jerk is around 0

        motorConfigs.Slot0.GravityType = GravityTypeValue.Arm_Cosine;
        motorConfigs.Slot0.StaticFeedforwardSign = StaticFeedforwardSignValue.UseClosedLoopSign;

        motor1.getConfigurator().apply(motorConfigs);
        motor2.getConfigurator().apply(motorConfigs);
        motor3.getConfigurator().apply(motorConfigs);
        motor4.getConfigurator().apply(motorConfigs);
    }

    public void setMotors(double pos) {
        motor1.setControl(motor1request.withPosition(pos));
        motor2.setControl(motor2request.withPosition(pos));
        motor3.setControl(motor3request.withPosition(pos));
        motor4.setControl(motor4request.withPosition(pos));
    }

    public void setMotorsv(double v) {
        motor1.setControl(motor1voltage.withOutput(v));
    }
    //-------------------------------------------------------------------------------------------------
    //Command
    public Command driveCommand1(double v){
        return Commands.startEnd(
            () -> {
                motor1.setControl(motor1request.withPosition(v));    
        },
        ()->{
            motor1.setControl(motor1request.withPosition(-v)); 
        }
        );
        
    }

    public Command driveCommand2(double v){
        return Commands.startEnd(
            () -> {
                motor2.setControl(motor1request.withPosition(v));    
        },
        ()->{
            motor2.setControl(motor1request.withPosition(-v)); 
        }
        );
        
    }
}
