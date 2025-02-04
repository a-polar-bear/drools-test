package org.example.ruleunits;

import org.drools.model.DSL;
import org.drools.model.Variable;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.dsl.RuleUnitDefinition;
import org.drools.ruleunits.dsl.RulesFactory;
import org.example.dto.Person;

import java.util.ArrayList;
import java.util.List;

public class MyRuleUnit implements RuleUnitDefinition {
    private final DataStore<String> strings;
    private final DataStore<Integer> ints;
    private final List<String> results = new ArrayList<>();

    public MyRuleUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public MyRuleUnit(DataStore<String> strings, DataStore<Integer> ints) {
        this.strings = strings;
        this.ints = ints;
    }

    public DataStore<String> getStrings() {
        return strings;
    }

    public DataStore<Integer> getInts() {
        return ints;
    }

    public List<String> getResults() {
        return results;
    }


    @Override
    public void defineRules(RulesFactory rulesFactory) {
//        // 创建一个变量来表示 Person 对象
//        Variable<Person> personVar = DSL.declarationOf(Person.class);
//
//        rulesFactory.rule("Rule with two conditions")
//                .on(strings)
//                .filter(personVar, s -> s.length() > 5)
//                // 条件 a：年龄大于 18
//                .filter(personVar, p -> p.getAge() > 18)
//                // 条件 b：姓名以 "A" 开头
//                .pattern(personVar, p -> p.getName().startsWith("A"))
//                // 条件 b：姓名以 "A" 开头
//                .pattern(personVar, p -> p.getName().startsWith("A"))
//                .then(personVar, (p) -> {
//                    System.out.println(p.getName() + " is an adult and name starts with A.");
//                });
    }
}