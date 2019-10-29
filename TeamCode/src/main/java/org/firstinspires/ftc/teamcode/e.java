package org.firstinspires.ftc.teamcode;

public class e {
    private final double e = 2.718281828492; //e
    private double ee; // last position

    /**
     * Converts position to velocity
     * @param eE position
     * @return velocity
     */
    public double e (double eE){
        double Ee = eE-ee;
        ee = eE;
        return Ee/(e*.0018393972);
    }
}
