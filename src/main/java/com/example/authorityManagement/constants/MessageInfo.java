package com.example.authorityManagement.constants;

public enum MessageInfo {
	
	CREATE_SUCCESSFUL("200", "新規登録に成功"),
	UPDATE_SUCCESSFUL("200", "データの更新に成功"),
	GET_ID_SUCCESSFUL("200", "IDの取得成功"),
	DELETE_SUCCESSFUL("200", "データの削除に成功"),
	DATA_IS_FOUND("200", "データ検索成功"),
	DATA_IS_NOT_FOUND("400", "データ見つからない"),
	
	NOT_ENTER_ERROR_001("400", "｛グループ名称/グループID｝を入力してください。"),
	NOT_ENTER_ERROR_002("400", "｛グループ名称/グループID｝を重複しないください。"),
	NAME_ERROR_001("400", "｛グループID｝をローマ字で入力してください。"),
	DELETE_CODE_001("400", "このデータを削除してよろしいですか？"),
	
	NAME_ERROR_002("400", "｛名前（英）/名前（中）｝の資料が間違い。"),
	NOT_ENTER_ERROR_003("400", "｛名前（英）/名前（中）｝を入力してください。"),

	MONTH_IS_INCORRECT_DATA("400", "支払月份は0ヶ月以下ではいけない");
		

	private String code;

	private String message;

	private MessageInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
