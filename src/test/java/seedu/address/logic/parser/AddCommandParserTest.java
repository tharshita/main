package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_FISH;
import static seedu.address.logic.commands.CommandTestUtil.GOAL_DESC_GRAIN;
import static seedu.address.logic.commands.CommandTestUtil.GOAL_DESC_PROTEIN;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_GOAL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TIME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_FISH;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.TIME_DESC_TURKEY_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.TIME_DESC_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_GRAIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GOAL_PROTEIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_FISH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIME_FISH;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalRecipes.TURKEY_SANDWICH;
import static seedu.address.testutil.TypicalRecipes.FISH;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.goal.Goal;
import seedu.address.model.recipe.Email;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.Time;
import seedu.address.testutil.RecipeBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    /* todo: after refactoring add command
    @Test
    public void parse_allFieldsPresent_success() {
        Recipe expectedRecipe = new RecipeBuilder(FISH).withGoals(VALID_GOAL_GRAIN).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_GRAIN, new AddCommand(expectedRecipe));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_TURKEY_SANDWICH + NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_GRAIN, new AddCommand(expectedRecipe));

        // multiple times - last time accepted
        assertParseSuccess(parser, NAME_DESC_FISH + TIME_DESC_TURKEY_SANDWICH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_GRAIN, new AddCommand(expectedRecipe));

        // multiple emails - last email accepted
        assertParseSuccess(parser, NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_TURKEY_SANDWICH + EMAIL_DESC_FISH
                + GOAL_DESC_GRAIN, new AddCommand(expectedRecipe));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_GRAIN, new AddCommand(expectedRecipe));

        // multiple goals - all accepted
        Recipe expectedRecipeMultipleGoals = new RecipeBuilder(FISH).withGoals(VALID_GOAL_GRAIN, VALID_GOAL_PROTEIN)
                .build();
        assertParseSuccess(parser, NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_PROTEIN + GOAL_DESC_GRAIN, new AddCommand(expectedRecipeMultipleGoals));
    }*/

    /* todo: after refactoring add command
    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero goals
        Recipe expectedRecipe = new RecipeBuilder(TURKEY_SANDWICH).withGoals().build();
        assertParseSuccess(parser, NAME_DESC_TURKEY_SANDWICH + TIME_DESC_TURKEY_SANDWICH + EMAIL_DESC_TURKEY_SANDWICH,
                new AddCommand(expectedRecipe));
    }*/

    /* todo: after refactoring add command
    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH, expectedMessage);

        // missing time prefix
        assertParseFailure(parser, NAME_DESC_FISH + VALID_TIME_FISH + EMAIL_DESC_FISH, expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_FISH + TIME_DESC_FISH + VALID_EMAIL_FISH, expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_FISH + VALID_TIME_FISH + VALID_EMAIL_FISH, expectedMessage);
    }*/

    /* todo: after refactoring add command
    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_PROTEIN + GOAL_DESC_GRAIN, Name.MESSAGE_CONSTRAINTS);

        // invalid time
        assertParseFailure(parser, NAME_DESC_FISH + INVALID_TIME_DESC + EMAIL_DESC_FISH
                + GOAL_DESC_PROTEIN + GOAL_DESC_GRAIN, Time.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_FISH + TIME_DESC_FISH + INVALID_EMAIL_DESC
                + GOAL_DESC_PROTEIN + GOAL_DESC_GRAIN, Email.MESSAGE_CONSTRAINTS);

        // invalid goal
        assertParseFailure(parser, NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + INVALID_GOAL_DESC + VALID_GOAL_GRAIN, Goal.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + TIME_DESC_FISH + EMAIL_DESC_FISH,
                Name.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_FISH + TIME_DESC_FISH + EMAIL_DESC_FISH
                + GOAL_DESC_PROTEIN + GOAL_DESC_GRAIN,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }*/
}
