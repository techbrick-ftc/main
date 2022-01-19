package org.firstinspires.ftc.teamcode.opmodes;

import static org.firstinspires.ftc.teamcode.libs.Globals.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.libs.AutoImport;

@Autonomous(name="R5 - RedAutoWarehouseDeep", group="redAuto")
public class RedAutoWarehouseDeep extends AutoImport {

    public RedAutoWarehouseDeep() { super(65, 5, 68, 215, 158, 215); } // change

    public void runOpMode() {
        super.runOpMode();

        if (opModeIsActive()) {
            // Goes to the shipping hub and delivers based on the team element position
            // 1 is added to elementPosition because height's 0 is ground level, not the first layer
            setArm(elementPosition + 1, 1);
            sleep(1000);
            slauto.drive(47, -12, 0, 0.75, this);
            deposit(true);

            // Does a little shimmy if it is in the highest goal, as it needs a bit of help to drop
            sleep(500);
            if (elementPosition == 2) {
                shimmy(0.8, 1, 100);
            } else {
                sleep(200);
            }

            deposit(false);

            // Goes into the warehouse
            slauto.drive(60, 0, 0, 0.5, 0, this, false, true);
            slauto.drive(65, 15, 0, 0.5, 3000, this, false, false);
            slauto.drive(65, 35, 0, 0.5, 3000, this, false, false);
            slauto.drive(40, 35, 0, 0.5, this);

            // Lowers arm
            setArm(0, 1);

            while (timer.seconds() < 30) {
                sleep(100);
            }

            stopCamera();
        }
    }
}
