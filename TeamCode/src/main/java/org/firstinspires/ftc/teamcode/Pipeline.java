package org.firstinspires.ftc.teamcode;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect2d;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Pipeline extends OpenCvPipeline {
    private Scalar mean = new Scalar(0,0,0);

    private boolean isYellow;


    @Override
    public Mat processFrame(Mat input) {

        Point point1 = new Point(
                input.cols()/4,
                input.rows()/4);
        Point point2 = new Point(
                input.cols()*(3f/4f),
                input.rows()*(3f/4f));
        Rect2d rect = new Rect2d(point1, point2);

        Mat interest = input.submat((int)rect.x, (int)(rect.x+rect.width), (int)rect.y, (int)(rect.y+rect.height));
        mean = Core.mean(interest);
        Scalar black = new Scalar(0,0,0);
        Scalar yellow = new Scalar(252, 223, 3);

        double distToBlack = Math.abs(mean.val[0] - black.val[0]) +
                Math.abs(mean.val[1] - black.val[1]) + Math.abs(mean.val[2] - black.val[2]);

        double distToYellow = Math.abs(mean.val[0] - yellow.val[0]) +
                Math.abs(mean.val[1] - yellow.val[1]) + Math.abs(mean.val[2] - yellow.val[2]);

        Scalar color;

        if (distToBlack < distToYellow){
            color = black;
            isYellow = false;
        }
        else {
            color = yellow;
            isYellow = true;
        }

        Imgproc.rectangle(
                input,
                point1,
                point2,
                color , 4);

        return input;
    }

    public Scalar getMean(){
        return mean;
    }

    public boolean isYellow(){
        return isYellow;
    }
}
