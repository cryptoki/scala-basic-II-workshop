import section7.Section7._

val boiledWater = boilWater(Water(temperature=52))
boiledWater.onSuccess( {
case water => println("Yeah")
})