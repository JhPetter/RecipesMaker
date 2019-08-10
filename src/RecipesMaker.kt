val options = listOf("Selecciona la opción deseada", "1. Hacer una receta", "2. Ver mis recetas", "3. Salir")
val ingredients =
    listOf(
        "1. Agua",
        "2. Leche",
        "3. Carne",
        "4. Verduras",
        "5. Frutas",
        "6. Cereal",
        "7. Huevos",
        "8. Aceite",
        "9. Regresar opciones"
    )
val recipes = ArrayList<String>()

fun main(arg: Array<String>) {
    configApp()
}

fun configApp() {
    showOptions(options)
    validateInputOption()
}

fun validateInputOption() {
    when (readLine()) {
        "1" -> {
            val recipeNumber = recipes.size.plus(1)
            recipes.add("Recipe $recipeNumber: \n")
            validateIngredients(recipeNumber)
        }
        "2" -> {
            showOptions(recipes)
            configApp()
        }
        "3" -> {
            println("Gracias por usar este software")
        }
        else -> {
            print("No existe esa opcion, porfavor ingresa una valdia. \n")
            configApp()
        }
    }
}

fun validateIngredients(recipeNumber: Int) {
    showOptions(ingredients)
    createRecipe(recipeNumber)
}

fun createRecipe(recipeNumber: Int) {
    var exit = false
    val keyInput = readLine()
    var value = ""
    ingredient@ for (ingredient in ingredients) {
        if (keyInput == "9") {
            exit = true
            break@ingredient
        }
        if (keyInput == ingredient.first().toString()) {
            value = ingredient
            break@ingredient
        }
    }
    if (value.isEmpty() && exit.not()) {
        print("No existe esa opcion, porfavor ingresa una valdia. \n")
    } else {
        if (recipes.size > 0)
            recipes[recipeNumber - 1] = "${recipes[recipeNumber - 1]} $value \n"
    }
    if (exit)
        configApp()
    else
        validateIngredients(recipeNumber)
}

fun showOptions(list: List<String>) {
    for (option in list) {
        println(option)
    }
}