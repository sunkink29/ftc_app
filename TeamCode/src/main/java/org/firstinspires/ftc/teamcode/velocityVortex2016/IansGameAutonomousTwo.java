package org.firstinspires.ftc.teamcode.velocityVortex2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

/**
 * Created by rps on 12/1/16.
 */


@Autonomous(name="Ian's Game Autonomous Two", group="BetaLykos")
@Disabled
public class IansGameAutonomousTwo extends LinearOpMode {

    /* Declare OpMode members. */
    BetaLykosHardware robot           = new BetaLykosHardware();   // Use betaLykos' hardware

    static final double MINREDBLUEDIFF = 25;
    static final double distanceBetweenButtons = 1;
    static final Position[] redStartPositions = {new Position(DistanceUnit.METER,5,1,0,0), new Position(DistanceUnit.METER,7,1,0,0)};
    static final Position[] redBeacon1 = {new Position(DistanceUnit.METER,2,4,0,0), new Position(DistanceUnit.METER,1,5,0,0), new Position(DistanceUnit.METER,2,5,0,0)};
    static final Position[] redBeacon2 = {new Position(DistanceUnit.METER,2,8,0,0), new Position(DistanceUnit.METER,1,9,0,0), new Position(DistanceUnit.METER,2,9,0,0)};
    static final Position[] redShootingPositions = {new Position(DistanceUnit.METER,3,7,0,0)};
    static final Position[] blueStartPositions = {new Position(DistanceUnit.METER,11,7,0,0), new Position(DistanceUnit.METER,11,5,0,0)};
    static final Position[] blueBeacon1 = {new Position(DistanceUnit.METER,6,10,0,0), new Position(DistanceUnit.METER,7,11,0,0)};
    static final Position[] blueBeacon2 = {new Position(DistanceUnit.METER,2,10,0,0), new Position(DistanceUnit.METER,3,11,0,0)};
    static final int[] startHeading = {90,0};



    int alliance = 0;
    int startPosition = 0;
    int[] questions = new int[5];
    int question8 = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        robot.onRedAlliance = gamepad1.a;
        robot.useDistanceSensorForInitialPosition = true;

        String[] options = {"beacon 1", "beacon 2", "push ball", "shoot", "cornerV", "centerV", "stay"};


        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        while (question8 != 1) {
            telemetry.addData("Alliance", "b = red   x = blue");
            telemetry.update();
            alliance = 0;
            while (alliance == 0) {
                if (gamepad1.b) {
                    alliance = 1;
                    telemetry.addData("Alliance", "Red");
                } else if (gamepad1.x) {
                    alliance = 2;
                    telemetry.addData("Alliance", "Blue");
                }
                idle();
            }
            waitForNoButton();

            telemetry.addData("Start Position", "a = start position 1 b = start position 2");
            telemetry.update();
            startPosition = getInput(2);

            telemetry.addData("Move 1", "g1.a = beacon 1   g1.b = beacon 2   g1.x = push ball g1.y = shoot g2.a = cornerV g2.b = centerV g2.x = stay");
            telemetry.update();
            questions[0] = getInput(7);

            telemetry.addData("Move 2", "g1.a = beacon 1   g1.b = beacon 2   g1.x = push ball g1.y = shoot g2.a = cornerV g2.b = centerV g2.x = stay");
            telemetry.update();
            questions[1] = getInput(7);

            telemetry.addData("Move 3", "g1.a = beacon 1   g1.b = beacon 2   g1.x = push ball g1.y = shoot g2.a = cornerV g2.b = centerV g2.x = stay");
            telemetry.update();
            questions[2] = getInput(7);

            telemetry.addData("Move 4", "g1.a = beacon 1   g1.b = beacon 2   g1.x = push ball g1.y = shoot g2.a = cornerV g2.b = centerV g2.x = stay");
            telemetry.update();
            questions[3] = getInput(7);

            telemetry.addData("Move 5", "g1.a = beacon 1   g1.b = beacon 2   g1.x = push ball g1.y = shoot g2.a = cornerV g2.b = centerV g2.x = stay");
            telemetry.update();
            questions[4] = getInput(7);

            switch (alliance) {
                case 1:
                    telemetry.addData("Alliance", "Red");
                    break;
                case 2:
                    telemetry.addData("Alliance", "Blue");
                    break;
            }
            telemetry.addData("Start Position", startPosition);
            telemetry.addData("Move 1", options[questions[0] - 1]);
            telemetry.addData("Move 2", options[questions[1] - 1]);
            telemetry.addData("Move 3", options[questions[2] - 1]);
            telemetry.addData("Move 4", options[questions[3] - 1]);
            telemetry.addData("Move 5", options[questions[4] - 1]);
            telemetry.addData("Is this correct?", "a = yes b = no");

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            question8 = getInput(2);
        }

        if (alliance == 1) {
            robot.headingOffset = 90;
        }
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
//
//        while (opModeIsActive()) {
//            while (!gamepad1.a) {
//                idle();
//            }
//            while (gamepad1.a){
//                idle();
//            }
//            pressBeaconButton();
//        }
        if (alliance == 1) {
            if (startPosition == 1){
                robot.currentPosition = redStartPositions[0];
            } else if (startPosition == 2){
                robot.currentPosition = redStartPositions[1];
            }
        } else if (alliance == 2) {
            if (startPosition == 1) {
                robot.currentPosition = blueStartPositions[0];
            } else if (startPosition == 2) {
                robot.currentPosition = blueStartPositions[1];
            }
        }
        for (int i = 0; i < questions.length; i++) {
            switch (questions[i]) {

                case 1:
                    beacon1();
                    break;
                case 2:
                    robot.moveRobotToPositionUsingTime(5,2,0.5,false,this);
//                    beacon2();
                    break;
                case 3:
                    //push ball
                    break;
                case 4:
                    shoot();
                    break;
                case 5:
                    //cornerV
                    break;
                case 6:
                    //centerV
                    break;
                case 7:
                    //stay
                    break;
            }
        }
    }

    void beacon1() throws InterruptedException {
        if (alliance == 1) {
            robot.moveRobotToPositionUsingTime(redBeacon1[0].x,redBeacon1[0].y,0.5,false,this);
            lineUpToBeacon();
            robot.currentPosition = redBeacon1[1];
            pressBeaconButton();
            robot.moveTwoRobotToPositionUsingTime(redBeacon1[2].x,redBeacon1[2].y,0.5,false,this);
        } else {
            robot.moveRobotToPositionUsingTime(blueBeacon1[0].x,redBeacon1[0].y,0.5,false,this);
            lineUpToBeacon();
            robot.currentPosition = blueBeacon1[1];
            pressBeaconButton();
            robot.moveTwoRobotToPositionUsingTime(blueBeacon1[0].x,blueBeacon1[0].y,0.5,false,this);
        }
    }

    void beacon2() throws InterruptedException {
        if (alliance == 1) {
            robot.moveRobotToPositionUsingTime(redBeacon2[0].x,redBeacon2[0].y,0.5,false,this);
            lineUpToBeacon();
            robot.currentPosition = redBeacon2[1];
            pressBeaconButton();
            robot.moveTwoRobotToPositionUsingTime(redBeacon2[2].x,redBeacon2[2].y,0.5,false,this);
        } else {
            robot.moveRobotToPositionUsingTime(blueBeacon2[0].x,redBeacon2[0].y,0.5,false,this);
            lineUpToBeacon();
            robot.currentPosition = blueBeacon2[1];
            pressBeaconButton();
            robot.moveTwoRobotToPositionUsingTime(blueBeacon2[0].x,blueBeacon2[0].y,0.5,false,this);
        }
    }

    void lineUpToBeacon() throws InterruptedException {
        robot.moveRobot(.1,0,0,telemetry); // start moving the robot to the right
        while (robot.getODSLightLevel() < .005 && opModeIsActive())  {
            idle();} // wait until the ods sensor sees white
        robot.moveRobot(0,0,0,telemetry);
        robot.turnRobotToHeading(startHeading[alliance - 1],.15,this);
        robot.moveRobot(.05,0,0,telemetry);
        while (robot.getODSLightLevel() >= .005 && opModeIsActive()) {
            idle();
        }
        robot.moveRobot(0,0,0,telemetry);
        robot.moveRobot(-.05,.1,0,telemetry);
        while (robot.getODSLightLevel() < .005 && opModeIsActive())  {
            idle();} // wait until the ods sensor sees white
        robot.moveRobot(0,0,0,telemetry);
        robot.moveRobot(0,.1,0,telemetry);
        while (!robot.touchSensor.isPressed()) {
            idle();
        }
        robot.moveRobot(0,0,0,telemetry);
    }

    void shoot() throws InterruptedException {
        if(alliance == 1) {
            robot.moveRobotToPositionUsingTime(redShootingPositions[0].x, redShootingPositions[0].y,0.5,false,this);
            robot.turnRobotTowardsPoint(redShootingPositions[0].x, redShootingPositions[0].y,.25,this);
        }
    }

    int getInput(int numAnswers) {
        int input = 0;
        while (input == 0) {
            if (gamepad1.a) {
                input = 1;
            } else if (gamepad1.b) {
                input = 2;
            } else if (gamepad1.x && numAnswers >= 3) {
                input = 3;
            } else if (gamepad1.y && numAnswers >= 4) {
                input = 4;
            } else if (gamepad2.a && numAnswers >= 5) {
                input = 5;
            } else if (gamepad2.b && numAnswers >= 6) {
                input = 6;
            } else if (gamepad2.x && numAnswers >= 7) {
                input = 7;
            }
            idle();
        }
        waitForNoButton();
        return input;
    }

    void waitForNoButton() {
        while (gamepad1.a || gamepad1.b || gamepad1.x || gamepad1.y||gamepad2.a||gamepad2.b||gamepad2.x) {
            idle();
        }
    }

    void pressBeaconButton() {
        double diff = robot.sensorRGB.red() - robot.sensorRGB.blue();
        if (alliance == 1) {
            if (diff > MINREDBLUEDIFF) {
                //robot.pressLeftServo();
                telemetry.addData("Left servo","pressed");
                telemetry.addData("Right servo","not pressed");
                telemetry.update();
            } else {
                //robot.pressRightServo();
                telemetry.addData("Left servo","not pressed");
                telemetry.addData("Right servo","pressed");
                telemetry.update();
            }
        } else if (alliance == 2) {
            if (diff > MINREDBLUEDIFF) {
                //robot.pressRightServo();
                telemetry.addData("Left servo","not pressed");
                telemetry.addData("Right servo","pressed");
                telemetry.update();
            } else {
                //robot.pressLeftServo();
                telemetry.addData("Left servo","pressed");
                telemetry.addData("Right servo","not pressed");
                telemetry.update();
            }
        }
    }
}


