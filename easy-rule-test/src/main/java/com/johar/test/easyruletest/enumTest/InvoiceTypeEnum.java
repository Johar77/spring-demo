package com.johar.test.easyruletest.enumTest;


import lombok.Getter;

/**
 *
 */
@Getter
public enum InvoiceTypeEnum {
    EMAIL("email", "电子邮箱"),
    PAPER("paper", "纸质"),

    ;

    private final String code;
    private final String desc;

    InvoiceTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static void main(String[] args) {
        InvoiceTypeEnum typeEnum = InvoiceTypeEnum.EMAIL;
        System.out.println(InvoiceTypeEnum.EMAIL.equals(typeEnum));
        System.out.println(InvoiceTypeEnum.PAPER.equals(typeEnum));
    }
}
