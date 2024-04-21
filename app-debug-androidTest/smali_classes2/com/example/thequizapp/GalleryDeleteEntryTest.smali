.class public Lcom/example/thequizapp/GalleryDeleteEntryTest;
.super Ljava/lang/Object;
.source "GalleryDeleteEntryTest.java"


# annotations
.annotation runtime Lorg/junit/runner/RunWith;
    value = Landroidx/test/runner/AndroidJUnit4;
.end annotation


# instance fields
.field private galleryActivityScenario:Landroidx/test/core/app/ActivityScenario;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/test/core/app/ActivityScenario<",
            "Lcom/example/thequizapp/GalleryActivity;",
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
    const-class v0, Lcom/example/thequizapp/GalleryActivity;

    invoke-static {v0}, Landroidx/test/core/app/ActivityScenario;->launch(Ljava/lang/Class;)Landroidx/test/core/app/ActivityScenario;

    move-result-object v0

    iput-object v0, p0, Lcom/example/thequizapp/GalleryDeleteEntryTest;->galleryActivityScenario:Landroidx/test/core/app/ActivityScenario;

    .line 33
    return-void
.end method

.method public tearDown()V
    .locals 1
    .annotation runtime Lorg/junit/After;
    .end annotation

    .line 37
    iget-object v0, p0, Lcom/example/thequizapp/GalleryDeleteEntryTest;->galleryActivityScenario:Landroidx/test/core/app/ActivityScenario;

    invoke-virtual {v0}, Landroidx/test/core/app/ActivityScenario;->close()V

    .line 38
    invoke-static {}, Landroidx/test/espresso/intent/Intents;->release()V

    .line 39
    return-void
.end method

.method public testDeletingEntry()V
    .locals 7
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 43
    invoke-static {}, Lcom/example/thequizapp/model/EntryStorage;->getImageList()Lcom/example/thequizapp/model/EntryList;

    move-result-object v0

    invoke-virtual {v0}, Lcom/example/thequizapp/model/EntryList;->getImageList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 45
    .local v0, "initialSize":I
    sget v1, Lcom/example/thequizapp/R$id;->galleryList:I

    invoke-static {v1}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/Espresso;->onView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewInteraction;

    move-result-object v1

    invoke-static {}, Landroidx/test/espresso/matcher/ViewMatchers;->isDisplayed()Lorg/hamcrest/Matcher;

    move-result-object v2

    invoke-static {v2}, Landroidx/test/espresso/assertion/ViewAssertions;->matches(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/ViewAssertion;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/test/espresso/ViewInteraction;->check(Landroidx/test/espresso/ViewAssertion;)Landroidx/test/espresso/ViewInteraction;

    .line 47
    invoke-static {}, Lorg/hamcrest/CoreMatchers;->anything()Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/Espresso;->onData(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v1

    sget v2, Lcom/example/thequizapp/R$id;->galleryList:I

    invoke-static {v2}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/test/espresso/DataInteraction;->inAdapterView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroidx/test/espresso/DataInteraction;->atPosition(Ljava/lang/Integer;)Landroidx/test/espresso/DataInteraction;

    move-result-object v1

    const/4 v4, 0x1

    new-array v5, v4, [Landroidx/test/espresso/ViewAction;

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->scrollTo()Landroidx/test/espresso/ViewAction;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-virtual {v1, v5}, Landroidx/test/espresso/DataInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 49
    invoke-static {}, Lorg/hamcrest/CoreMatchers;->anything()Lorg/hamcrest/Matcher;

    move-result-object v1

    invoke-static {v1}, Landroidx/test/espresso/Espresso;->onData(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v1

    sget v5, Lcom/example/thequizapp/R$id;->galleryList:I

    invoke-static {v5}, Landroidx/test/espresso/matcher/ViewMatchers;->withId(I)Lorg/hamcrest/Matcher;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroidx/test/espresso/DataInteraction;->inAdapterView(Lorg/hamcrest/Matcher;)Landroidx/test/espresso/DataInteraction;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroidx/test/espresso/DataInteraction;->atPosition(Ljava/lang/Integer;)Landroidx/test/espresso/DataInteraction;

    move-result-object v1

    new-array v3, v4, [Landroidx/test/espresso/ViewAction;

    invoke-static {}, Landroidx/test/espresso/action/ViewActions;->click()Landroidx/test/espresso/ViewAction;

    move-result-object v5

    aput-object v5, v3, v2

    invoke-virtual {v1, v3}, Landroidx/test/espresso/DataInteraction;->perform([Landroidx/test/espresso/ViewAction;)Landroidx/test/espresso/ViewInteraction;

    .line 52
    const/4 v1, 0x3

    if-le v0, v1, :cond_1

    .line 53
    invoke-static {}, Lcom/example/thequizapp/model/EntryStorage;->getImageList()Lcom/example/thequizapp/model/EntryList;

    move-result-object v3

    invoke-virtual {v3}, Lcom/example/thequizapp/model/EntryList;->getImageList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v3, v0, :cond_0

    move v3, v4

    goto :goto_0

    :cond_0
    move v3, v2

    :goto_0
    invoke-static {v3}, Lorg/junit/Assert;->assertTrue(Z)V

    .line 54
    invoke-static {}, Lcom/example/thequizapp/model/EntryStorage;->getImageList()Lcom/example/thequizapp/model/EntryList;

    move-result-object v3

    invoke-virtual {v3}, Lcom/example/thequizapp/model/EntryList;->getImageList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v5, v0, -0x1

    invoke-static {v3, v5}, Ljunit/framework/TestCase;->assertEquals(II)V

    .line 56
    :cond_1
    invoke-static {}, Lcom/example/thequizapp/model/EntryStorage;->getImageList()Lcom/example/thequizapp/model/EntryList;

    move-result-object v3

    invoke-virtual {v3}, Lcom/example/thequizapp/model/EntryList;->getImageList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lt v3, v1, :cond_2

    move v2, v4

    :cond_2
    invoke-static {v2}, Lorg/junit/Assert;->assertTrue(Z)V

    .line 57
    return-void
.end method
