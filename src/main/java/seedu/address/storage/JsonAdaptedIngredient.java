package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ingredient.Grain;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.IngredientType;
import seedu.address.model.ingredient.Other;
import seedu.address.model.ingredient.Protein;
import seedu.address.model.ingredient.Vegetable;

/**
 * Jackson-friendly version of {@link Ingredient}.
 */
class JsonAdaptedIngredient {

    private final String ingredientName;
    private final double quantity;
    private final IngredientType ingredientType;

    /**
     * Constructs a {@code JsonAdaptedIngredient} with the given {@code ingredientName}, {@code quantity} and {@code type}.
     */
    @JsonCreator
    public JsonAdaptedIngredient(String ingredientDetails) {
        String[] details = ingredientDetails.split(",");
        this.ingredientName = details[0].trim();
        this.quantity = Double.parseDouble(details[1].trim());
        String type = details[2].trim();
        switch (type) {
            case "vegetable":
                this.ingredientType = IngredientType.VEGETABLE;
                break;
            case "protein":
                this.ingredientType = IngredientType.PROTEIN;
                break;
            case "grain":
                this.ingredientType = IngredientType.GRAIN;
                break;
            case "other":
                this.ingredientType = IngredientType.OTHER;
                break;
            default:
                System.out.println("Error: ingredient type does not belong to one of the categories");
                this.ingredientType = null;
        }

    }


    /*
     @JsonCreator
    public JsonAdaptedIngredient(@JsonProperty("grain") String grains,
                                 @JsonProperty("vegetable") String vegetables,
                                 @JsonProperty("protein") String proteins,
                                 @JsonProperty("other") String others) {

        if (!grains.isBlank()) {
            String[] grainDetail = grains.split(",");
            ingredientName = grainDetail[0].trim();
            quantity = Double.parseDouble(grainDetail[1].trim());
            ingredientType = IngredientType.GRAIN;

        } else if (!vegetables.isBlank()) {
            String[] vegeDetail = vegetables.split(",");
            ingredientName = vegeDetail[0].trim();
            quantity = Double.parseDouble(vegeDetail[1].trim());
            ingredientType = IngredientType.VEGETABLE;

        } else if (!proteins.isBlank()) {
            String[] proteinDetail = vegetables.split(",");
            ingredientName = proteinDetail[0].trim();
            quantity = Double.parseDouble(proteinDetail[1].trim());
            ingredientType = IngredientType.PROTEIN;

        } else {
            String[] otherDetail = others.split(",");
            ingredientName = otherDetail[0].trim();
            quantity = Double.parseDouble(otherDetail[1].trim());
            ingredientType = IngredientType.OTHER;
        }
     */
    /**
     * Converts a given {@code Ingredient} into this class for Jackson use.
     */
    public JsonAdaptedIngredient(Ingredient source) {
        ingredientName = source.ingredientName;
        quantity = source.getQuantity();
        ingredientType = source.ingredientType;
    }

    @JsonValue
    public String getIngredient() {
        return ingredientName + ",  " + quantity + ", " + ingredientType.value;
    }

    /**
     * Converts this Jackson-friendly adapted goal object into the model's {@code Goal} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted goal.
     * @return
     */
    public Ingredient toModelType() throws IllegalValueException {
        if (!Ingredient.isValidIngredientName(ingredientName)) {
            throw new IllegalValueException(Ingredient.MESSAGE_CONSTRAINTS);
        }
        switch (ingredientType) {
        case GRAIN:
            return new Grain(ingredientName, quantity);
        case VEGETABLE:
            return new Vegetable(ingredientName, quantity);
        case PROTEIN:
            return new Protein(ingredientName, quantity);
        case OTHER:
            return new Other(ingredientName, quantity);
        default:
            System.out.println("Error: ingredient type not instantiated");
        }
        return null;
    }

}
