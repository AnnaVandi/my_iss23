package unibo.appl1.common;

public interface IRobot {
    String doStep();
    String goHome();
    RobotResponse[] doBoundaryWalk();
    String moveForward();
    String moveBackwad();
    String turnLeft();
    String turnRight();
}
