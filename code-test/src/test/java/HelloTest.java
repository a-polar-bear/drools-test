import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.example.ruleunits.HelloWorldUnit;
import org.junit.Test;

public class HelloTest {


    @Test
    public void test1(){

        HelloWorldUnit unit = new HelloWorldUnit();

        // 添加数据
//        unit.getStrings().add("Hello World");
//        unit.getInts().add(6);
        unit.getStrings().add("Apple");

        // 创建规则单元实例并执行规则
        RuleUnitInstance<HelloWorldUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(unit);
        instance.fire();

        // 输出结果
        System.out.println("Results: " + unit.getResults());
    }

    @Test
    public void test2(){
        HelloWorldUnit unit = new HelloWorldUnit();
        unit.getStrings().add("Hello World");

        RuleUnitProvider ruleUnitProvider = RuleUnitProvider.get();
        RuleUnitInstance<HelloWorldUnit> unitInstance = ruleUnitProvider.createRuleUnitInstance(unit);
        System.out.println(unitInstance.fire());
        System.out.println(unit.getResults());


        unit.getResults().clear();
        unit.getInts().add(11);
        System.out.println(unitInstance.fire());
        System.out.println(unit.getResults());

        unitInstance.close();
        System.out.println(1);
    }

}
