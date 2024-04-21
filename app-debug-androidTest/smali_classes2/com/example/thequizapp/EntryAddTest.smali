.class public Lcom/example/thequizapp/EntryAddTest;
.super Ljava/lang/Object;
.source "EntryAddTest.java"


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

    iput-object v0, p0, Lcom/example/thequizapp/EntryAddTest;->newEntryActivityScenario:Landroidx/test/core/app/ActivityScenario;

    .line 33
    return-void
.end method

.method public tearDown()V
    .locals 1
    .annotation runtime Lorg/junit/After;
    .end annotation

    .line 37
    iget-object v0, p0, Lcom/example/thequizapp/EntryAddTest;->newEntryActivityScenario:Landroidx/test/core/app/ActivityScenario;

    invoke-virtual {v0}, Landroidx/test/core/app/ActivityScenario;->close()V

    .line 38
    invoke-static {}, Landroidx/test/espresso/intent/Intents;->release()V

    .line 39
    return-void
.end method

.method public testAddingEntry()V
    .locals 6
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 43
    invoke-static {}, Lcom/example/thequizapp/model/EntryStorage;->getImageList()Lcom/example/thequizapp/model/EntryList;

    move-result-object v0

    invoke-virtual {v0}, Lcom/example/thequizapp/model/EntryList;->getImageList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 44
    .local v0, "initialSize":I
    const-string v1, "android.intent.action.GET_CONTENT"

    invoke-static {v1}, Landroidx/test/espresso/intent/matcher/IntentMatchers;->hasAction(Ljava/lang/String;)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/intent/Intents;->intending(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/intent/OngoingStubbing;

    move-result-object v1

    new-instance v2, Landroid/app/Instrumentation$ActivityResult;

    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3}, Landroid/content/Intent;-><init>()V

    const/4 v4, -0x1

    invoke-direct {v2, v4, v3}, Landroid/app/Instrumentation$ActivityResult;-><init>(ILandroid/content/Intent;)V

    invoke-virtual {v1, v2}, Landroidx/test/espresso/intent/OngoingStubbing;->respondWith(Landroid/app/Instrumentation$ActivityResult;)V

    .line 46
    sget v1, Lcom/example/thequizapp/R$id;->button_add_image:I

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v1

    const/4 v2, 0x1

    new-array v3, v2, [Landroidx/test/espresso/ViewAction;

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v4

    const/4 v5, 0x0

    aput-object v4, v3, v5

    invoke-virtual {v1, v3}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 48
    sget v1, Lcom/example/thequizapp/R$id;->edit_text_name:I

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v1

    const/4 v3, 0x2

    new-array v3, v3, [Landroidx/test/espresso/ViewAction;

    const-string v4, "Sverige"

    invoke-static {v4}, Landroidx/test/espresso/action/ViewActions;->typeText(Ljava/lang/String;)Landroidx/test/espresso/ViewAction;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->closeSoftKeyboard()Landroidx/test/espresso/ViewAction;

    move-result-object v4

    aput-object v4, v3, v2

    invoke-virtual {v1, v3}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 50
    sget v1, Lcom/example/thequizapp/R$id;->button_save:I

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v1

    new-array v2, v2, [Landroidx/test/espresso/ViewAction;

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v1, v2}, Landroidx/test/espresso/ViewInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 52
    add-int/lit8 v1, v0, 0x1

    invoke-static {}, Lcom/example/thequizapp/model/EntryStorage;->getImageList()Lcom/example/thequizapp/model/EntryList;

    move-result-object v2

    invoke-virtual {v2}, Lcom/example/thequizapp/model/EntryList;->getImageList()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-static {v1, v2}, Ljunit/framework/TestCase;->assertEquals(II)V

    .line 53
    return-void
.end method
