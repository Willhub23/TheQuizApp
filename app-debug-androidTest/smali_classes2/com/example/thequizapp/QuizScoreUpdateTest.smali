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

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Landroidx/test/ext/junit/rules/ActivityScenarioRule;

    const-class v1, Lcom/example/thequizapp/QuizActivity;

    invoke-direct {v0, v1}, Landroidx/test/ext/junit/rules/ActivityScenarioRule;-><init>(Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/example/thequizapp/QuizScoreUpdateTest;->activityScenarioRule:Landroidx/test/ext/junit/rules/ActivityScenarioRule;

    return-void
.end method

.method private selectCorrectAnswer()V
    .locals 4

    .line 44
    sget v0, Lcom/example/thequizapp/R$id;->button1:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Landroidx/test/espresso/ViewAction;

    const/4 v2, 0x0

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 45
    return-void
.end method

.method private selectIncorrectAnswer()V
    .locals 4

    .line 49
    sget v0, Lcom/example/thequizapp/R$id;->button2:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Landroidx/test/espresso/ViewAction;

    const/4 v2, 0x0

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 50
    return-void
.end method


# virtual methods
.method public testScoreUpdateForCorrectAnswer()V
    .locals 2
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 25
    invoke-direct {p0}, Lcom/example/thequizapp/QuizScoreUpdateTest;->selectCorrectAnswer()V

    .line 28
    sget v0, Lcom/example/thequizapp/R$id;->scoreTextView:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    .line 29
    const-string v1, "Points: 1/1"

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withText(Ljava/lang/String;)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/assertion/ViewAssertions;->matches(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewAssertion;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 30
    return-void
.end method

.method public testScoreUpdateForIncorrectAnswer()V
    .locals 2
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 35
    invoke-direct {p0}, Lcom/example/thequizapp/QuizScoreUpdateTest;->selectIncorrectAnswer()V

    .line 38
    sget v0, Lcom/example/thequizapp/R$id;->scoreTextView:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    .line 39
    const-string v1, "Points: 0/1"

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withText(Ljava/lang/String;)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/assertion/ViewAssertions;->matches(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewAssertion;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 40
    return-void
.end method
