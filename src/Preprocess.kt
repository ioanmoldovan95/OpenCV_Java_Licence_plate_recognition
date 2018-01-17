import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

class Preprocess{
    companion object {
        val GAUSSIAN_SMOOTH_FILTER_SIZE = Size(5.0, 5.0)
        val ADAPTIVE_THRESH_BLOCK_SIZE=19;
        val ADAPTIVE_THRESH_WEIGHT=9;


        fun extractValue(imgOriginal: Mat) :Mat{
            val imgHSV = Mat()
            val vectorOfHSVImages = ArrayList<Mat>()
            val imgValue:Mat

            Imgproc.cvtColor(imgOriginal, imgHSV, Imgproc.COLOR_BGR2HSV)
            Core.split(imgHSV, vectorOfHSVImages)
            imgValue = vectorOfHSVImages[2]

            return imgValue
        }

        fun maximizeContrast(imgGrayscale:Mat):Mat{
            val imgTopHat = Mat()
            val imgBlackHat = Mat()
            val imgGrayscalePlusTopHat = Mat()
            val imgGrayscalePlusTopHatMinusBlackHat = Mat()

            val structuringElement = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, Size(3.0, 3.0))
            Imgproc.morphologyEx(imgGrayscale, imgTopHat, 5, structuringElement)
            Imgproc.morphologyEx(imgGrayscale, imgBlackHat, 6, structuringElement)

            Core.add(imgGrayscale, imgTopHat, imgGrayscalePlusTopHat)
            Core.subtract(imgGrayscalePlusTopHat, imgBlackHat, imgGrayscalePlusTopHatMinusBlackHat)
            return imgGrayscalePlusTopHatMinusBlackHat
        }

        fun preprocess(imgOriginal: Mat, imgGrayscale: Mat, imgThresh: Mat) {
            imgGrayscale = extractValue(imgOriginal)


        }

    }
}