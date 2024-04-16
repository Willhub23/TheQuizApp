.class public Lcom/example/thequizapp/MainMenuTest;
.super Ljava/lang/Object;
.source "MainMenuTest.java"


# annotations
.annotation runtime Lorg/junit/runner/RunWith;
    value = Landroidx/test/runner/AndroidJUnit4;
.end annotation


# instance fields
.field private mainActivityScenario:Landroidx/test/core/app/ActivityScenario;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/test/core/app/ActivityScenario<",
            "Lcom/example/thequizapp/MainActivity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic lambda$testButtonClickOpensQuizActivity$0(Lcom/example/thequizapp/QuizActivity;)V
    .locals 0
    .param p0, "activity"    # Lcom/example/thequizapp/QuizActivity;

    .line 36
    return-void
.end method


# virtual methods
.method public setUp()V
    .locals 1
    .annotation runtime Lorg/junit/Before;
    .end annotation

    .line 21
    const-class v0, Lcom/example/thequizapp/MainActivity;

    invoke-static {v0}, Landroidx/test/core/app/ActivityScenario;->launch(Ljava/lang/Class;)Landroidx/test/core/app/ActivityScenario;

    move-result-object v0

    iput-object v0, p0, Lcom/example/thequizapp/MainMenuTest;->mainActivityScenario:Landroidx/test/core/app/ActivityScenario;

    .line 22
    return-void
.end method

.method public tearDown()V
    .locals 1
    .annotation runtime Lorg/junit/After;
    .end annotation

    .line 26
    iget-object v0, p0, Lcom/example/thequizapp/MainMenuTest;->mainActivityScenario:Landroidx/test/core/app/ActivityScenario;

    invoke-virtual {v0}, Landroidx/test/core/app/ActivityScenario;->close()V

    .line 27
    return-void
.end method

.method public testButtonClickOpensQuizActivity()V
    .locals 4
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 31
    sget v0, Lcom/example/thequizapp/R$id;->quizButton:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Landroidx/test/espresso/ViewAction;

    .line 32
    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v2

    const/4 v3, 0x0

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 33
    const-class v0, Lcom/example/thequizapp/QuizActivity;

    invoke-static {v0}, Landroidx/test/core/app/ActivityScenario;->launch(Ljava/lang/Class;)Landroidx/test/core/app/ActivityScenario;

    move-result-object v0

    .line 34
    .local v0, "quizActivityScenario":Landroidx/test/core/app/ActivityScenario;, "Landroidx/test/core/app/ActivityScenario<Lcom/example/thequizapp/QuizActivity;>;"
    new-instance v1, Lcom/example/thequizapp/MainMenuTest$$ExternalSyntheticLambda0;

    invoke-direct {v1}, Lcom/example/thequizapp/MainMenuTest$$ExternalSyntheticLambda0;-><init>()V

    invoke-virtual {v0, v1}, Landroidx/test/core/app/ActivityScenario;->onActivity(Landroidx/test/core/app/ActivityScenario$ActivityAction;)Landroidx/test/core/app/ActivityScenario;

    .line 37
    return-void
.end method
