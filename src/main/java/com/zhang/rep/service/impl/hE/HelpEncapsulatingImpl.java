package com.zhang.rep.service.impl.hE;



public class HelpEncapsulatingImpl implements HelpEncapsulating{


    @Override
    public String KeepSum(int max, int number) {

        StringBuilder result = new StringBuilder(String.valueOf(number));
        while (result.length() < max){
            result.insert(0, "0");
        }
        return result.substring(result.length() - 2);
    }
}
