package seedu.address.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.StorageManager;
import seedu.address.storage.storageAssignments.JsonAssignmentAddressBookStorage;
import seedu.address.storage.storageCourse.JsonCourseAddressBookStorage;
import seedu.address.storage.storageFinance.JsonFinanceAddressBookStorage;
import seedu.address.storage.storageProgress.JsonProgressAddressBookStorage;
import seedu.address.storage.storageStaff.JsonStaffAddressBookStorage;
import seedu.address.storage.storageStudent.JsonStudentAddressBookStorage;

import java.io.IOException;
import java.nio.file.Path;

public class LogicManagerTest {
    private static final IOException DUMMY_IO_EXCEPTION = new IOException("dummy exception");

    @TempDir
    public Path temporaryFolder;

    private Model model = new ModelManager();
    private Logic logic;

    @BeforeEach
    public void setUp() {
        JsonAddressBookStorage addressBookStorage =
                new JsonAddressBookStorage(temporaryFolder.resolve("addressBook.json"));
        JsonStaffAddressBookStorage teacherAddressBookStorage =
                new JsonStaffAddressBookStorage(temporaryFolder.resolve("teacherAddressBook.json"));
        JsonStudentAddressBookStorage studentAddressBookStorage =
                new JsonStudentAddressBookStorage(temporaryFolder.resolve("studentAddressBook.json"));
        JsonFinanceAddressBookStorage financeAddressBookStorage =
                new JsonFinanceAddressBookStorage(temporaryFolder.resolve("FinanceAddressBook.json"));
        JsonCourseAddressBookStorage courseAddressBookStorage =
                new JsonCourseAddressBookStorage(temporaryFolder.resolve("courseAddressBook.json"));
        JsonAssignmentAddressBookStorage assignmentAddressBookStorage =
                new JsonAssignmentAddressBookStorage(temporaryFolder.resolve("assignmentAddressBook.json"));
        JsonProgressAddressBookStorage progressAddressBookStorage =
                new JsonProgressAddressBookStorage(temporaryFolder.resolve("progressAddressBook.json"));

        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(temporaryFolder.resolve("userPrefs.json"));
        StorageManager storage = new StorageManager(addressBookStorage, teacherAddressBookStorage,
                studentAddressBookStorage, financeAddressBookStorage, courseAddressBookStorage, assignmentAddressBookStorage,
                progressAddressBookStorage, userPrefsStorage);
        logic = new LogicManager(model, storage);
    }
    /*
    @Test
    public void execute_invalidCommandFormat_throwsParseException() {
        String invalidCommand = "uicfhmowqewca";
        assertParseException(invalidCommand, MESSAGE_UNKNOWN_COMMAND);
    }

    @Test
    public void execute_commandExecutionError_throwsCommandException() {
        String deleteCommand = "delete 9";
        assertCommandException(deleteCommand, MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void execute_storageThrowsIoException_throwsCommandException() {
        // Setup LogicManager with JsonAddressBookIoExceptionThrowingStub
        JsonAddressBookIoExceptionThrowingStub addressBookStorage =
                new JsonAddressBookIoExceptionThrowingStub(temporaryFolder.resolve("ioExceptionAddressBook.json"));
        JsonTeacherAddressBookIoExceptionThrowingStub teacherAddressBookStorage =
            new JsonTeacherAddressBookIoExceptionThrowingStub(temporaryFolder.resolve("ioExceptionTeacherAddressBook.json"));
        JsonStudentAddressBookIoExceptionThrowingStub studentAddressBookStorage =
            new JsonStudentAddressBookIoExceptionThrowingStub(temporaryFolder.resolve("ioExceptionStudentAddressBook.json"));
        JsonFinanceAddressBookIoExceptionThrowingStub financeAddressBookStorage =
            new JsonFinanceAddressBookIoExceptionThrowingStub(temporaryFolder.resolve("ioExceptionFinanceAddressBook.json"));
        JsonCourseAddressBookIoExceptionThrowingStub courseAddressBookStorage =
            new JsonCourseAddressBookIoExceptionThrowingStub(temporaryFolder.resolve("ioExceptionCourseAddressBook.json"));
        JsonAssignmentAddressBookIoExceptionThrowingStub assignmentAddressBookStorage =
                new JsonAssignmentAddressBookIoExceptionThrowingStub(temporaryFolder.resolve("ioExceptionAssignmentAddressBook.json"));

        JsonUserPrefsStorage userPrefsStorage =
                new JsonUserPrefsStorage(temporaryFolder.resolve("ioExceptionUserPrefs.json"));
        StorageManager storage = new StorageManager(addressBookStorage, teacherAddressBookStorage,
            studentAddressBookStorage, financeAddressBookStorage, courseAddressBookStorage, assignmentAddressBookStorage,userPrefsStorage);
        logic = new LogicManager(model, storage);

        // Execute add command
        String addCommand = AddCommand.COMMAND_WORD + NAME_DESC_AMY + PHONE_DESC_AMY + EMAIL_DESC_AMY
                + ADDRESS_DESC_AMY;
        Person expectedPerson = new PersonBuilder(AMY).withTags().build();
        ModelManager expectedModel = new ModelManager();
        expectedModel.addPerson(expectedPerson);
        String expectedMessage = LogicManager.FILE_OPS_ERROR_MESSAGE + DUMMY_IO_EXCEPTION;

        //assertCommandFailure(addCommand, CommandException.class, expectedMessage, expectedModel);
    }

    @Test
    public void getFilteredPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> logic.getFilteredPersonList().remove(0));
    }

    /**
     * Executes the command and confirms that
     * - no exceptions are thrown <br>
     * - the feedback message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    /*
    private void assertCommandSuccess(String inputCommand, String expectedMessage,
            Model expectedModel) throws CommandException, ParseException {
        CommandResult result = logic.execute(inputCommand);
        assertEquals(expectedMessage, result.getFeedbackToUser());
        assertEquals(expectedModel, model);
    }
    */
    /**
     * Executes the command, confirms that a ParseException is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    /*
    private void assertParseException(String inputCommand, String expectedMessage) {
        assertCommandFailure(inputCommand, ParseException.class, expectedMessage);
    }
    */
    /**
     * Executes the command, confirms that a CommandException is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    /*
    private void assertCommandException(String inputCommand, String expectedMessage) {
        assertCommandFailure(inputCommand, CommandException.class, expectedMessage);
    }
    */
    /**
     * Executes the command, confirms that the exception is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    /*
    private void assertCommandFailure(String inputCommand, Class<? extends Throwable> expectedException,
            String expectedMessage) {
        Model expectedModel = new ModelManager(model.getAddressBook(), model.getTeacherAddressBook(),
            model.getStudentAddressBook(), model.getFinanceAddressBook(), model.getCourseAddressBook(),
                model.getAssignmentAddressBook(), new UserPrefs());
        assertCommandFailure(inputCommand, expectedException, expectedMessage, expectedModel);
    }
    */
    /**
     * Executes the command and confirms that
     * - the {@code expectedException} is thrown <br>
     * - the resulting error message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     * @see #assertCommandSuccess(String, String, Model)
     */
    /*
    private void assertCommandFailure(String inputCommand, Class<? extends Throwable> expectedException,
            String expectedMessage, Model expectedModel) {
        assertThrows(expectedException, expectedMessage, () -> logic.execute(inputCommand));
        assertEquals(expectedModel, model);
    }
    */
    /**
     * A stub class to throw an {@code IOException} when the save method is called.
     */
    /*
    private static class JsonAddressBookIoExceptionThrowingStub extends JsonAddressBookStorage {
        private JsonAddressBookIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
    */
    /**
     * A stub class to throw an {@code IOException} when the save method is called.
     */
    /*
    private static class JsonTeacherAddressBookIoExceptionThrowingStub extends JsonTeacherAddressBookStorage {
        private JsonTeacherAddressBookIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveTeacherAddressBook(ReadOnlyAddressBookGeneric<Teacher> teacherAddressBook, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
    */

    /**
     * A stub class to throw an {@code IOException} when the save method is called.
     */
    /*
    private static class JsonStudentAddressBookIoExceptionThrowingStub extends JsonStudentAddressBookStorage {
        private JsonStudentAddressBookIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveStudentAddressBook(ReadOnlyAddressBookGeneric<Student> teacherAddressBook, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
    */

    /**
     * A stub class to throw an {@code IOException} when the save method is called.
     */
    /*
    private static class JsonFinanceAddressBookIoExceptionThrowingStub extends JsonFinanceAddressBookStorage {
        private JsonFinanceAddressBookIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveFinanceAddressBook(ReadOnlyAddressBookGeneric<Finance> teacherAddressBook, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
    */
    /**
     * A stub class to throw an {@code IOException} when the save method is called.
     */
    /*
    private static class JsonCourseAddressBookIoExceptionThrowingStub extends JsonCourseAddressBookStorage {
        private JsonCourseAddressBookIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveCourseAddressBook(ReadOnlyCourseAddressBook teacherAddressBook, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
    */
    /**
     * A stub class to throw an {@code IOException} when the save method is called.
     */
    /*
    private static class JsonAssignmentAddressBookIoExceptionThrowingStub extends JsonProgressAddressBookStorage {
        private JsonAssignmentAddressBookIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveAssignmentAddressBook(ReadOnlyAssignmentAddressBook assignmentAddressBook, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
    */
}
