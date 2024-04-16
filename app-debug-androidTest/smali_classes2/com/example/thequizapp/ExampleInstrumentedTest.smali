.class public Lcom/example/thequizapp/ExampleInstrumentedTest;
.super Ljava/lang/Object;
.source "ExampleInstrumentedTest.java"


# annotations
.annotation runtime Lorg/junit/runner/RunWith;
    value = Landroidx/test/ext/junit/runners/AndroidJUnit4;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public useAppContext()V
    .locals 3
    .annotation runtime Lorg/junit/Test;
    .end annotation

    .line 23
    invoke-static {}, Landroidx/test/platform/app/InstrumentationRegistry;->getInstrumentation()Landroid/app/Instrumentation;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Instrumentation;->getTargetContext()Landroid/content/Context;

    move-result-object v0

    .line 24
    .local v0, "appContext":Landroid/content/Context;
    const-string v1, "com.example.thequizapp"

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lorg/junit/Assert;->assertEquals(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 25
    return-void
.end method
