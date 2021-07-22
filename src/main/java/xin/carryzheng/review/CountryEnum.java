package xin.carryzheng.review;

import lombok.Getter;

/**
 * @author zhengxin
 * @date 2021-05-31 15:24:18
 */
public enum CountryEnum {

    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");


    @Getter
    private Integer code;
    @Getter
    private String message;

    CountryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CountryEnum forEach_Country(int index){
        CountryEnum[] array = CountryEnum.values();

        for (CountryEnum ce : array) {
            if (index == ce.getCode()){
                return ce;
            }
        }

        return null;
    }
}
