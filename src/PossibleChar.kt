import org.opencv.core.Point
import org.opencv.core.Rect

data class PossibleChar(var contour:Array<Point>,
                        var rect:Rect,
                        var centerX:Int,
                        var centerY:Int,
                        var dblDiagonalSize:Double,
                        var dblAspectRatio:Double){

    companion object {
        fun sortCharsLeftToRight(char1:PossibleChar, char2:PossibleChar):Boolean{
            return(char1.centerX<char2.centerX)
        }
    }

    override fun equals(other: Any?): Boolean {
        return (other as PossibleChar).contour.contentEquals(this.contour)
    }
}

