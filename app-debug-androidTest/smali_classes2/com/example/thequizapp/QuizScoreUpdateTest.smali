.class public Lcom/example/thequizapp/QuizScoreUpdateTest;
.super Ljava/lang/Object;
.source "QuizScoreUpdateTest.java"


# annotations
.annotation runtime Lorg/junit/runner/RunWith;
    value = Landroidx/test/runner/AndroidJUnit4;
.end annotation


# instance fields
.field public activityScenarioRule:Landroidx/test/ext/junit/rules/ActivityScenarioRule;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/test/ext/junit/rules/ActivityScenarioRule<",
            "Lcom/example/thequizapp/QuizActivity;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/junit/Rule;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Landroidx/test/ext/junit/rules/ActivityScenarioRule;

    const-class v1, Lcom/example/thequizapp/QuizActivity;

    invoke-direct {v0, v1}, Landroidx/test/ext/junit/rules/ActivityScenarioRule;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/example/thequizapp/QuizScoreUpdateTest;->activityScenarioRule:Landroidx/test/ext/junit/rules/ActivityScenarioRule;

    return-void
.end method

.method private selectRandomAnswer()V
    .locals 6

    .line 41
    sget v0, Lcom/example/thequizapp/R$id;->button1:I

    sget v1, Lcom/example/thequizapp/R$id;->button2:I

    sget v2, Lcom/example/thequizapp/R$id;->button3:I

    filled-new-array {v0, v1, v2}, [I

    move-result-object v0

    .line 44
    .local v0, "answerButtonIds":[I
    new-instance v1, Ljava/util/Random;

    invoke-direct {v1}, Ljava/util/Random;-><init>()V

    array-length v2, v0

    invoke-virtual {v1, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    .line 47
    .local v1, "randomIndex":I
    aget v2, v0, v1

    invoke-static {v2}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v2

    invoke-static {v2}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Landroidx/test/espresso/ViewAction;

    const/4 v4, 0x0

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v2, v3}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 48
    return-void
.end method


# virtual methods
.method public testScoreUpdateInQuizActivity()V
    .locals 2
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 28
    invoke-direct {p0}, Lcom/example/thequizapp/QuizScoreUpdateTest;->selectRandomAnswer()V

    .line 30
    sget v0, Lcom/example/thequizapp/R$id;->scoreTextView:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    .line 31
    const-string v1, "Points: 1/1"

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withText(Ljava/lang/String;)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/assertion/ViewAssertions;->matches(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewAssertion;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 34
    invoke-direct {p0}, Lcom/example/thequizapp/QuizScoreUpdateTest;->selectRandomAnswer()V

    .line 35
    sget v0, Lcom/example/thequizapp/R$id;->scoreTextView:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    .line 36
    const-string v1, "Points: 0/1"

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withText(Ljava/lang/String;)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/assertion/ViewAssertions;->matches(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewAssertion;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 37
    return-void
.end method
