package org.firstinspires.ftc.teamcode.velocityVortex2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

/**
 * Created by rps on 10/27/16.
 */
@Autonomous(name="Test Speed and Accuracy", group="BetaLykos")  // @Autonomous(...) is the other common choice
@Disabled
public class TestSpeedAndAccuracy extends LinearOpMode {
    BetaLykosHardware robot           = new BetaLykosHardware();   // Use betaLykos' hardware
    ElapsedTime elapsedTime = new ElapsedTime();

    public void runOpMode() throws InterruptedException {

        double secs = 0;
         /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Color", "test");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while(opModeIsActive())
        {
            robot.currentPosition = new Position(DistanceUnit.METER,11,5,0,System.currentTimeMillis());
            robot.moveRobotToPositionUsingTime(0,1,.5,false,this);
            while (!gamepad1.a && opModeIsActive())
            {idle();}
        }
//
//        robot.moveRobotToPosition(2, 2, .1, false, this);
//        robot.moveRobotForSeconds(0, 0, 0, this, 2);
//        elapsedTime.reset();
//        robot.moveRobotToPosition(2, 4, .2, true, this);
//        robot.moveRobotToPosition(4, 4, .2, true, this);
//        robot.moveRobotToPosition(4, 2, .2, true, this);
//        robot.moveRobotToPosition(2, 2, .2, true, this);
//        secs = elapsedTime.seconds();
//
//        telemetry.addData("Time", secs);
//        telemetry.update();
//
//            while (!gamepad1.a && opModeIsActive())
//            {idle();}
//
//
//        robot.moveRobotToPosition(2, 2, .1, false, this);
//        robot.moveRobotForSeconds(0, 0, 0, this, 2);
//        elapsedTime.reset();
//        robot.moveRobotToPosition(2, 4, .4, true, this);
//        robot.moveRobotToPosition(4, 4, .4, true, this);
//        robot.moveRobotToPosition(4, 2, .4, true, this);
//        robot.moveRobotToPosition(2, 2, .4, true, this);
//        secs = elapsedTime.seconds();
//
//        telemetry.addData("Time", secs);
//        telemetry.update();
//
//            while (!gamepad1.a && opModeIsActive())
//            {idle();}
//
//
//        robot.moveRobotToPosition(2, 2, .1, false, this);
//        robot.moveRobotForSeconds(0, 0, 0, this, 2);
//        elapsedTime.reset();
//        robot.moveRobotToPosition(2, 4, .6, true, this);
//        robot.moveRobotToPosition(4, 4, .6, true, this);
//        robot.moveRobotToPosition(4, 2, .6, true, this);
//        robot.moveRobotToPosition(2, 2, .6, true, this);
//        secs = elapsedTime.seconds();
//
//        telemetry.addData("Time", secs);
//        telemetry.update();
//
//            while (!gamepad1.a && opModeIsActive())
//            {idle();}
//
//        robot.moveRobotToPosition(2, 2, .1, false, this);
//        robot.moveRobotForSeconds(0, 0, 0, this, 2);
//        elapsedTime.reset();
//        robot.moveRobotToPosition(2, 4, .8, true, this);
//        robot.moveRobotToPosition(4, 4, .8, true, this);
//        robot.moveRobotToPosition(4, 2, .8, true, this);
//        robot.moveRobotToPosition(2, 2, .8, true, this);
//        secs = elapsedTime.seconds();
//
//        telemetry.addData("Time", secs);
//        telemetry.update();
//
//            while (!gamepad1.a && opModeIsActive())
//            {idle();}
//
//        robot.moveRobotToPosition(2, 2, .1, false, this);
//        robot.moveRobotForSeconds(0, 0, 0, this, 2);
//        elapsedTime.reset();
//        robot.moveRobotToPosition(2, 4, 1, true, this);
//        robot.moveRobotToPosition(4, 4, 1, true, this);
//        robot.moveRobotToPosition(4, 2, 1, true, this);
//        robot.moveRobotToPosition(2, 2, 1, true, this);
//        secs = elapsedTime.seconds();
//
//        telemetry.addData("Time", secs);
//        telemetry.update();
//
//            while (!gamepad1.a && opModeIsActive())
//            {idle();}
//        }
    }
}
