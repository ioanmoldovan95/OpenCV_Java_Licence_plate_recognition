import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

public class MainClass {

    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    static void modifyMat(Mat mat){
        Mat mr2=mat.row(2);
        mr2.setTo(new Scalar(3));
    }

    public static void main(String[] args){
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat mat = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        Mat mr1 = mat.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = mat.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCv data: \n" + mat.dump());
        modifyMat(mat);
        System.out.println("OpenCv data modified: \n" + mat.dump());

    }


}
