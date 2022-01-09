package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

@Autonomous(name = "Motor Checker", group = "Tests")
public class MotorChecker extends LinearOpMode {
    public void runOpMode() {
        DcMotor fl = hardwareMap.get(DcMotor.class, "0");
        DcMotor fr = hardwareMap.get(DcMotor.class, "1");
        DcMotor rl = hardwareMap.get(DcMotor.class, "2");
        DcMotor rr = hardwareMap.get(DcMotor.class, "3");

        fr.setDirection(REVERSE);


        waitForStart();

        if (opModeIsActive()) {
            fl.setPower(1);
            sleep(1000);
            fl.setPower(0);
            fr.setPower(1);
            sleep(1000);
            fr.setPower(0);
            rl.setPower(1);
            sleep(1000);
            rl.setPower(0);
            rr.setPower(1);
            sleep(1000);
            rr.setPower(0);
        }
    }
}
