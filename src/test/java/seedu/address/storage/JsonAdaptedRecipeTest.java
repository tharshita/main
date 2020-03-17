package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedRecipe.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalRecipes.GRILLED_SANDWICH;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Step;
import seedu.address.model.recipe.Time;

public class JsonAdaptedRecipeTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_TIME = "+651234";
    private static final String INVALID_STEP = "";
    private static final String INVALID_GOAL = "#friend";
    private static final String VALID_NAME = GRILLED_SANDWICH.getName().toString();
    private static final String VALID_TIME = GRILLED_SANDWICH.getTime().toString();
    private static final List<JsonAdaptedIngredient> VALID_INGREDIENTS = GRILLED_SANDWICH.getIngredients().stream()
            .map(JsonAdaptedIngredient::new)
            .collect(Collectors.toList());
    private static final List<JsonAdaptedStep> VALID_STEP = GRILLED_SANDWICH.getSteps().stream()
            .map(JsonAdaptedStep::new).collect(Collectors.toList());
    private static final List<JsonAdaptedGoal> VALID_GOALS = GRILLED_SANDWICH.getGoals().stream()
            .map(JsonAdaptedGoal::new)
            .collect(Collectors.toList());
    private static final List<JsonAdaptedStep> INVALID_STEPS = new ArrayList<>(VALID_STEP);
    private static final List<JsonAdaptedGoal> INVALID_GOALS = new ArrayList<>(VALID_GOALS);

    @Test
    public void toModelType_validRecipeDetails_returnsRecipe() throws Exception {
        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(GRILLED_SANDWICH);
        assertEquals(GRILLED_SANDWICH, recipe.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedRecipe recipe =
                new JsonAdaptedRecipe(INVALID_NAME, VALID_TIME, VALID_INGREDIENTS, VALID_STEP, VALID_GOALS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(null, VALID_TIME, VALID_INGREDIENTS, VALID_STEP, VALID_GOALS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
    }

    @Test
    public void toModelType_invalidTime_throwsIllegalValueException() {
        JsonAdaptedRecipe recipe =
                new JsonAdaptedRecipe(VALID_NAME, INVALID_TIME, VALID_INGREDIENTS, VALID_STEP, VALID_GOALS);
        String expectedMessage = Time.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
    }

    @Test
    public void toModelType_nullTime_throwsIllegalValueException() {
        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(VALID_NAME, null, VALID_INGREDIENTS, VALID_STEP, VALID_GOALS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Time.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
    }

    @Test
    public void toModelType_invalidStep_throwsIllegalValueException() {
        INVALID_STEPS.add(new JsonAdaptedStep(INVALID_STEP));
        JsonAdaptedRecipe recipe =
                new JsonAdaptedRecipe(VALID_NAME, VALID_TIME, VALID_INGREDIENTS, INVALID_STEPS, VALID_GOALS);
        String expectedMessage = Step.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
    }

    @Test
    public void toModelType_nullStep_throwsIllegalValueException() {
        JsonAdaptedRecipe recipe = new JsonAdaptedRecipe(VALID_NAME, VALID_TIME, VALID_INGREDIENTS, null, VALID_GOALS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Step.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, recipe::toModelType);
    }

    @Test
    public void toModelType_invalidGoals_throwsIllegalValueException() {
        INVALID_GOALS.add(new JsonAdaptedGoal(INVALID_GOAL));
        JsonAdaptedRecipe recipe =
                new JsonAdaptedRecipe(VALID_NAME, VALID_TIME, VALID_INGREDIENTS, VALID_STEP, INVALID_GOALS);
        assertThrows(IllegalValueException.class, recipe::toModelType);
    }

}
