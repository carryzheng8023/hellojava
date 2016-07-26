package com.zhengxin.database.mongodb;


import org.apache.commons.lang.StringUtils;

public enum EnumOperation {

	CREATE("c", "新增操作"),

	UPDATE("u", "修改操作"),

	PART_UPDATE("pu", "仅更新有值字段"),

	DELETE("d", "删除操作"),

	C("g", "新增"), D("t", "删除");
	private String code;

	private String name;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private EnumOperation(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static EnumOperation getEnum(String value) {
		if (StringUtils.isNotBlank(value)) {
			value = StringUtils.lowerCase(value);
			for (EnumOperation e : EnumOperation.values()) {
				if (value.equals(e.getCode())) {
					return e;
				}
			}
		}
		return null;
	}

	public Boolean isCreate() {
		return this.equals(CREATE) || this.equals(C);
	}

	public Boolean isUpdate() {
		return this.equals(UPDATE);
	}

	public Boolean isPartUpdate() {
		return this.equals(PART_UPDATE);
	}

	public Boolean isDelete() {
		return this.equals(DELETE) || this.equals(D);
	}

	public static String resetCode(String operation) {
		if (StringUtils.isNotBlank(operation)) {
			String ret = operation;
			if (C.getCode().equals(operation)) {
				ret = CREATE.getCode();
			} else if (D.getCode().equals(operation)) {
				ret = DELETE.getCode();
			}
			return ret.toLowerCase();
		}
		return null;
	}
}
