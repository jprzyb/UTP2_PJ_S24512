/**
 *
 *  @author Przybylski Jakub S24512
 *
 */

package zad1;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calc {

    private final Map<String, BinaryOperator<BigDecimal>> operations = new HashMap<>();
    public Calc(){
        operations.put("+", BigDecimal::add);
        operations.put("-", BigDecimal::subtract);
        operations.put("*", BigDecimal::multiply);
        operations.put("/", BigDecimal::divide);
    }
    public String doCalc(String cmd) {
        cmd = cmd.replaceAll("\\s+","");
        String[] parts = cmd.split("");
        try{
            BigDecimal a = new BigDecimal(parts[0]);
            BigDecimal b = new BigDecimal(parts[2]);
            String op = parts[1];
            BinaryOperator<BigDecimal> operator = operations.get(op);
            return operator.apply(a,b).toString();
        }catch (Exception e){
            return "Invalid command to calc";
        }
    }
}
