import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
fun main(args: Array<String>) {
    val list = arrayListOf(
        Rectangle(5.0, 2.0),
        Circle(2.0),
        Square(5.0),
        Triangle(5.0, 6.0, 7.0)
    )

    println(
        "Фигура с минимальной площадью: ${list.minByOrNull { it.calcArea() }} \n" +
                "Фигура с максимальной площадью: ${list.maxByOrNull { it.calcArea() }} \n" +
                "Фигура с минимальным периметром: ${list.minByOrNull { it.calcPerimeter() }} \n" +
                "Фигура с максимальным периметром: ${list.maxByOrNull { it.calcPerimeter() }} \n" +
                "Сумма площадей: ${list.sumByDouble { it.calcArea() }}"
    )

    ShapeSerializer.encodeToFile("encoded.shape", list)
    val temp = ShapeSerializer.decodeToArrayList("encoded.shape")

    println(
        "Фигура с минимальной площадью: ${temp!!.minByOrNull { it.calcArea() }} \n" +
                "Фигура с максимальной площадью: ${temp.maxByOrNull { it.calcArea() }} \n" +
                "Фигура с минимальным периметром: ${temp.minByOrNull { it.calcPerimeter() }} \n" +
                "Фигура с максимальным периметром: ${temp.maxByOrNull { it.calcPerimeter() }} \n" +
                "Сумма площадей: ${temp.sumByDouble { it.calcArea() }}"
    )
}
