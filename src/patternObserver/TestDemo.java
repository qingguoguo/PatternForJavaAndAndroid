package patternObserver;

public class TestDemo {
    public static void main(String[] args) {

        Person person = new Person("张三");
        Person person1 = new Person("李四");
        Person person2 = new Person("王五");
        Person person3 = new Person("马六");

        HousingPrice housingPrice = new HousingPrice();
        housingPrice.addObserver(person);
        housingPrice.addObserver(person1);
        housingPrice.addObserver(person2);
        housingPrice.addObserver(person3);

        housingPrice.setPrice("每平米上涨了30");

//        马六收到了patternObserver.HousingPrice@4554617c更新:null
//        王五收到了patternObserver.HousingPrice@4554617c更新:null
//        李四收到了patternObserver.HousingPrice@4554617c更新:null
//        张三收到了patternObserver.HousingPrice@4554617c更新:null
    }
}
