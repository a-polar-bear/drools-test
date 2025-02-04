import org.example.dto.Order;
import org.junit.jupiter.api.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

public class StrTest {

    private static final String testRule1 = "package rules\n" +
            "\n" +
            "import org.example.dto.Order\n" +
            "\n" +
            "//规则2：100元-500元 加100积分\n" +
            "rule \"score_test1\"\n" +
            "when\n" +
            "    $s : Order(amount > 100 && amount <= 500)\n" +
            "then\n" +
            "    $s.setScore(100);\n" +
            "    $s.getResultList().add(\"1\");\n" +
            "    System.out.println(\"消费100元-500元 加test1积分 \");\n" +
            "end";

    private static final String testRule2 = "package rules\n" +
            "\n" +
            "import org.example.dto.Order\n" +
            "\n" +
            "//规则2：100元-500元 加100积分\n" +
            "rule \"score_test2\"\n" +
            "when\n" +
            "    $s : Order(amount > 100 && amount <= 500)\n" +
            "then\n" +
            "    $s.setScore(100);\n" +
            "    $s.getResultList().add(\"2\");\n" +
            "    System.out.println(\"消费100元-500元 加test2积分 \");\n" +
            "end";

    @Test
    public void strTest(){

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(testRule1, ResourceType.DRL);
        kieHelper.addContent(testRule2, ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();

        Order order = new Order();
        order.setAmount(200);

        kieSession.insert(order);
        kieSession.fireAllRules();

        System.out.println(order.getResultList());
    }
}
