package net.toload.main;

interface ISearchService
{
		void initial();
		String getTablename();
		void setTablename(String tablename);
		List query(String code, boolean softkeyboard);
		void rQuery(String word);
		List queryUserDic(String code, String word);
		void updateMapping(String id, String code, String word, String pword, int score, boolean isDictionary);
		void addUserDict(String id, String code, String word, String pword, int score, boolean isDictionary);
		void updateUserDict();
		String hanConvert(String input);
		String keyToChar(String code);

}