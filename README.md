# DAT153 Oblig 3
## Task
Save your data (and load it when the app starts again later)! Decide on how you want store the data (names & pictures) that we add from the app. We'll use Android Room DAOsLinks to an external site. (also see Ch. 68 "An Android Room Database..." in Smyth's "Android studio 4. 0 development essentials"). Encapsulate the data necessary for the quiz (i.e. all images, the current image and correct answer and alternative wrong choices for the current question) in a subclass of a ViewModel. Make sure that when rotating your phone during a quiz the current question and score are not lost! (Room, LiveData ,and ViewModel for extra reading)Links to an external site.
Write test-cases using Espresso for your app! At least have the following test cases: 
clicking a button in the main-menu takes you to the right sub-activity (i.e. to the Quiz or the Database; testing one button is enough);
is the score updated correctly in the quiz (submit right/wrong answer and check if the score is correct afterwards);
a test that checks that the number of registered pictures/persons is correct after adding/deleting an entry. For adding, use Intent Stubbing to return some image data (e.g. from the resource-folder) without any user interaction.
Write your Espresso test classes (in other words, do not use the Espresso Test Recorder) so that they directly address each activity under test. In other words, don't write all tests for the main activity and then have your test case click the main menu buttons to reach an activity. Note that you may have to change the structure of your app a bit so that you actually have access to internal state of your app (e.g., the score) from the unit test. 

Use Gradle either from the command line or through Android Studio's Gradle tool window to install and run the test-cases, so that we can closely observe the steps that are necessary. We can use for example additional command-line options for more information: ./gradlew connectedAndroidTest --info
Note that the output of --info various between operating systems. If you can't figure out the detailed steps that gradle is doing, use https://developer.android.com/studio/test/command-lineLinks to an external site. to run your tests from the commandline. Which APKs are used during testing? You can use the open-source tool apktool decode /path/to/the.apk to inspect their contents. Write your interpretation of the output in the README-file in your repo.
## Testing
## MainMenuTest
### Test to open quiz
#### Description
This test checks if clicking the "Quiz" button in MainActivity navigates to QuizActivity
#### Steps:
1. Launch MainActivity.
2. Intercept the intent to start QuizActivity.
3. Click on the "Quiz" button.
4. Checks if the QuizActivity is launched.
#### Expected Result:
QuizActivity is successfully launched

#### Implementation:
- Method: testToOpenQuizActivity()
- Class: MainMenuTest
- File: MainMenuTest.java

![image](https://github.com/Willhub23/TheQuizApp/assets/89257272/d0705f5b-9998-42bb-ae3b-d7829f99fa02)

## EntryAddAndDeleteTest
### Test to add and delete entry in gallery
#### Test case: testAddingEntry()
#### Description
This test verifies the functionality of adding a new entry in the NewEntryActivity
#### Steps:
1. Launch NewEntryActivity.
2. Checks the inital size of the storage list.
3. Mock the action of selecting an image from the device storage.
4. Click on the image to choose that image.
5. Writes the name of the image in the input field.
6. Click on the save button to save image.
7. Verify that the size of the entry list has increased by one.

#### Expected Result:
After adding a new entry, the size of the entry list should increase by one.

#### Implementation:
- Method: testAddingEntry()
- Class: EntryAddAndDeleteTest
- File: EntryAddAndDeleteTest.java
