package patternsingleton.singleton06;

public class SingleTon6Test {

    public static void main(String[] args) {

    }

    private static final Singleton06<M> gDefault = new Singleton06<M>() {
        @Override
        protected M create() {
            return new M();
        }
    };

    static public M getDefault() {
        return gDefault.getInstance();
    }

    static class M {
        private M() {
        }
    }
}
