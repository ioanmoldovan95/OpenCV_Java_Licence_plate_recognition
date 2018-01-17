import org.opencv.core.Mat
import org.opencv.core.RotatedRect

data class PossiblePlate(var imgPlate:Mat, var imgGrayscale:Mat, var imgThresh:Mat, var rrLocationOfPlateInScene:RotatedRect, var strChars:String){

    companion object {
        fun sortDescendingByNumberOfChars( possiblePlate1:PossiblePlate,  possiblePlate2:PossiblePlate):Boolean{
            return(possiblePlate1.strChars.length>possiblePlate2.strChars.length)
        }
    }
}