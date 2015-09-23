package e_exception;

public class ClassicDangerousConsumer {
    public void weConsumeVeryDangerousThings() {
        ClassicDangerousProducer.doSomethingDangerous();
    }
}
