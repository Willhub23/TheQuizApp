.class public Lcom/example/thequizapp/EntryCountTest;
.super Ljava/lang/Object;
.source "EntryCountTest.java"


# annotations
.annotation runtime Lorg/junit/runner/RunWith;
    value = Landroidx/test/runner/AndroidJUnit4;
.end annotation


# instance fields
.field private newEntryActivityScenario:Landroidx/test/core/app/ActivityScenario;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/test/core/app/ActivityScenario<",
            "Lcom/example/thequizapp/NewEntryActivity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setUp()V
    .locals 1
    .annotation runtime Lorg/junit/Before;
    .end annotation

    .line 31
    invoke-static {}, Landroidx/test/espresso/intent/Intents;->init()V

    .line 32
    const-class v0, Lcom/example/thequizapp/NewEntryActivity;

    invoke-static {v0}, Landroidx/test/core/app/ActivityScenario;->launch(Ljava/lang/Class;)Landroidx/test/core/app/ActivityScenario;

    move-result-object v0

    iput-object v0, p0, Lcom/example/thequizapp/EntryCountTest;->newEntryActivityScenario:Landroidx/test/core/app/ActivityScenario;

    .line 33
    return-void
.end method

.method public tearDown()V
    .locals 1
    .annotation runtime Lorg/junit/After;
    .end annotation

    .line 37
    iget-object v0, p0, Lcom/example/thequizapp/EntryCountTest;->newEntryActivityScenario:Landroidx/test/core/app/ActivityScenario;

    invoke-virtual {v0}, Landroidx/test/core/app/ActivityScenario;->close()V

    .line 38
    invoke-static {}, Landroidx/test/espresso/intent/Intents;->release()V

    .line 39
    return-void
.end method

.method public testAddingEntry()V
    .locals 5
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 43
    invoke-static {}, Landroidx/test/espresso/intent/matcher/IntentMatchers;->anyIntent()Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/intent/Intents;->intending(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/intent/OngoingStubbing;

    move-result-object v0

    new-instance v1, Landroid/app/Instrumentation$ActivityResult;

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    const/4 v3, -0x1

    invoke-direct {v1, v3, v2}, Landroid/app/Instrumentation$ActivityResult;-><init>(ILandroid/content/Intent;)V

    invoke-virtual {v0, v1}, Landroidx/test/espresso/intent/OngoingStubbing;->respondWith(Landroid/app/Instrumentation$ActivityResult;)V

    .line 46
    sget v0, Lcom/example/thequizapp/R$id;->button_add_image:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    const/4 v1, 0x1

    new-array v2, v1, [Landroidx/test/espresso/ViewAction;

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v3

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-virtual {v0, v2}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 47
    sget v0, Lcom/example/thequizapp/R$id;->edit_text_name:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    new-array v2, v1, [Landroidx/test/espresso/ViewAction;

    const-string v3, "Entry Name"

    invoke-static {v3}, Landroidx/test/espresso/action/ViewActions;->typeText(Ljava/lang/String;)Landroidx/test/espresso/ViewAction;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v0, v2}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 49
    sget v0, Lcom/example/thequizapp/R$id;->button_save:I

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    new-array v1, v1, [Landroidx/test/espresso/ViewAction;

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 50
    return-void
.end method

.method public testDeletingEntry()V
    .locals 5
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 56
    invoke-static {}, Lorg/hamcrest/Matchers;->anything()Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onData(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v0

    sget v1, Lcom/example/thequizapp/R$id;->galleryList:I

    .line 57
    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/DataInteraction;->inAdapterView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v0

    .line 58
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroidx/test/espresso/DataInteraction;->atPosition(Ljava/lang/Integer;)Landroidx/test/espresso/DataInteraction;

    move-result-object v0

    const/4 v3, 0x1

    new-array v3, v3, [Landroidx/test/espresso/ViewAction;

    .line 59
    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v4

    aput-object v4, v3, v1

    invoke-virtual {v0, v3}, Landroidx/test/espresso/DataInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 62
    invoke-static {}, Lorg/hamcrest/Matchers;->anything()Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onData(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v0

    sget v1, Lcom/example/thequizapp/R$id;->galleryList:I

    .line 63
    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/DataInteraction;->inAdapterView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v0

    .line 64
    invoke-virtual {v0, v2}, Landroidx/test/espresso/DataInteraction;->atPosition(Ljava/lang/Integer;)Landroidx/test/espresso/DataInteraction;

    move-result-object v0

    .line 65
    invoke-static {}, Landroidx/test/espresso/assertion/ViewAssertions;->doesNotExist()Landroidx/test/espresso/ViewAssertion;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/DataInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 68
    const-string v0, "Entry deleted from database"

    invoke-static {v0}, Landroidx/test/espresso/matcher/ViewMatchers;->withText(Ljava/lang/String;)Lorg/hamcrest/Matcher;

    move-result-object v0

    invoke-static {v0}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v0

    .line 69
    invoke-static {}, Landroidx/test/espresso/matcher/ViewMatchers;->isDisplayed()Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/assertion/ViewAssertions;->matches(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewAssertion;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/test/espresso/ViewInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 70
    return-void
.end method
