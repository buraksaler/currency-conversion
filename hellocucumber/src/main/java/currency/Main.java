package currency;

import currency.Currency;
import currency.Rate;

import java.util.*;

public class Main {
    public static Double solveCurrency(ArrayList<Rate> rates, Rate wanted){
        Map<String, ArrayList<Currency>> map = new HashMap<String, ArrayList<Currency>>();
        Stack<Currency> stack = new Stack<Currency>();
        ArrayList<String> visited = new ArrayList<String>();
        for (Rate rate : rates){
            String from = rate.from;
            String to = rate.to;
            Double number = rate.number;
            Currency firstCur = new Currency(to, number);
            Currency secondCur = new Currency(from, 1/number);
            ArrayList<Currency> curList;
            if(map.containsKey(from)){
                curList = map.get(from);
            }else{
                curList = new ArrayList<>();
            }
            curList.add(firstCur);
            map.put(from, curList);

            if(map.containsKey(to)){
                map.get(to).add(secondCur);
            }else{
                curList = new ArrayList<>();
                curList.add(secondCur);
                map.put(to, curList);
            }
        }
        stack.push(new Currency(wanted.from, wanted.number));
        ArrayList<Currency> values;
        while(stack.size() > 0){
            Currency currency = stack.pop();
            visited.add(currency.name);
            values = map.get(currency.name);
            if(Objects.nonNull(values)) {
                for (Currency cur : values) {
                    if (!visited.contains(cur.name)) {
                        stack.push(new Currency(cur.name, cur.number * currency.number));
                        if (cur.name.equals(wanted.to)) {
                            return currency.number * cur.number;
                        }
                    }
                }
            }
        }
        return -1.0;
    }
}
